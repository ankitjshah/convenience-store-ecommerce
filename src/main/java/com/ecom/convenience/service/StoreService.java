package com.ecom.convenience.service;

import com.ecom.convenience.config.Constants;
import com.ecom.convenience.domain.Store;
import com.ecom.convenience.repository.StoreRepository;
import com.ecom.convenience.service.dto.StoreDTO;
import com.ecom.convenience.service.mapper.PhoneNumberAlreadyUsedException;
import com.ecom.convenience.service.mapper.StoreMapper;
import io.github.jhipster.security.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class StoreService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final StoreMapper storeMapper;
    private final StoreRepository storeRepository;

    public StoreService(StoreMapper storeMapper, StoreRepository storeRepository){
        this.storeMapper = storeMapper;
        this.storeRepository = storeRepository;
    }
    public Store registerStore(StoreDTO storeDTO) {
        log.info("Store register service.");
        storeRepository
            .findOneByPhoneNumber(storeDTO.getPhoneNumber())
            .ifPresent(
                existingUser -> {
                        throw new PhoneNumberAlreadyUsedException();
                }
            );
        // Set static role for store admin
        Set<String> roles = new HashSet<>();
        roles.add(Constants.STORE_ADMIN);
        storeDTO.setRole(roles);

        storeDTO.setOtpCode(RandomUtil.generateRandomAlphanumericString().substring(4));
        Store store = storeMapper.StoreDtoToStore(storeDTO);
        this.storeRepository.save(store);
        return store;
    }

    public Optional<Store> activateStoreRegistration(String otpCode) {
        log.debug("Activating store for opt code {}", otpCode);
        return storeRepository
            .findOneByOtpCode(otpCode)
            .map(
                store -> {
                    // activate given store for the registration otp code.
                    store.setActivated(true);
                    store.setOtpCode(null);
//                    this.clearUserCaches(user);
                    log.debug("Activated store: {}", store);
                    return store;
                }
            );
    }

    @Transactional(readOnly = true)
    public Optional<Store> getAuthoritiesStoreById(String id) {
        log.debug("Get store by Store id {}", id);
        return storeRepository.findOneWithAuthoritiesById(id);
    }

}

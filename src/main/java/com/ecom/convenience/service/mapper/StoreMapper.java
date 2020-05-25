package com.ecom.convenience.service.mapper;

import com.ecom.convenience.config.Constants;
import com.ecom.convenience.domain.Role;
import com.ecom.convenience.domain.Store;
import com.ecom.convenience.service.dto.StoreDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StoreMapper {

    private final PasswordEncoder passwordEncoder;

    public StoreMapper(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    public Store StoreDtoToStore (StoreDTO storeDto) {
        if(storeDto == null){
            return  null;
        }else {
            Store store = new Store();
            if(storeDto.getStoreName() != null){
                store.setStoreName(storeDto.getStoreName().toLowerCase());
            }
            store.setStoreType(storeDto.getStoreType());
            store.setGstNumber(storeDto.getGstNumber());
            store.setCloseTime(storeDto.getCloseTime());
            store.setOpenTime(storeDto.getOpenTime());
            store.setCloseDays(storeDto.getCloseDays());
            String encryptedPassword = passwordEncoder.encode(storeDto.getPassword());
            store.setPassword(encryptedPassword);
            store.setFirstName(storeDto.getFirstName());
            store.setMiddleName(storeDto.getMiddleName());
            store.setLastName(storeDto.getLastName());
            if (storeDto.getEmail() != null){
                store.setEmail(storeDto.getEmail().toLowerCase());
            }
            store.setPhoneNumber(storeDto.getPhoneNumber());
            store.setCity(storeDto.getCity());
            store.setAddress(storeDto.getAddress());
            store.setPinCode(storeDto.getPinCode());
            store.setActivated(storeDto.isActivated());
            store.setImageUrl(storeDto.getImageUrl());
            if (storeDto.getLangKey() == null) {
                store.setLangKey(Constants.DEFAULT_LANGUAGE); // default language
            } else {
                store.setLangKey(storeDto.getLangKey());
            }
            store.setOtpCode(storeDto.getOtpCode());
            Set<Role> roles = this.roleFromStrings(storeDto.getRole());
            store.setRole(roles);
            return store;
        }
    }

    private Set<Role> roleFromStrings(Set<String> roleAsString) {
        Set<Role> roles = new HashSet<>();

        if (roleAsString != null) {
            roles =
                roleAsString
                    .stream()
                    .map(
                        string -> {
                            Role role = new Role();
                            role.setName(string);
                            return role;
                        }
                    )
                    .collect(Collectors.toSet());
        }

        return roles;
    }
}

package com.ecom.convenience.web.rest;

import com.ecom.convenience.domain.Store;
import com.ecom.convenience.domain.User;
import com.ecom.convenience.repository.StoreRepository;
import com.ecom.convenience.security.AuthoritiesConstants;
import com.ecom.convenience.service.StoreService;
import com.ecom.convenience.service.dto.StoreDTO;
import com.ecom.convenience.service.dto.UserDTO;
import com.ecom.convenience.web.rest.errors.InvalidPasswordException;
import com.ecom.convenience.web.rest.vm.ManagedUserVM;
import io.github.jhipster.web.util.HeaderUtil;
import netscape.javascript.JSObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class StoreController {

    private final Logger log = LoggerFactory.getLogger(StoreController.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private  final StoreService storeService;

    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository,StoreService storeService){
        this.storeRepository = storeRepository;
        this.storeService = storeService;
    }

    @PostMapping("/store")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Store> createStore(@Valid @RequestBody StoreDTO storeDTO) throws URISyntaxException {
        log.debug(" create store controller call.");
        if (!checkPasswordLength(storeDTO.getPassword())) {
            log.debug(" Incorrect password enter.");
            throw new InvalidPasswordException();
        }
        Store store = this.storeService.registerStore(storeDTO);
        return ResponseEntity
            .created(new URI("/api/store/" + store.getStoreName()))
            .headers(HeaderUtil.createAlert(applicationName, "storeManagement.created", store.getStoreName()))
            .body(store);
    }

    private static boolean checkPasswordLength(String password) {
        return (
            !StringUtils.isEmpty(password) &&
                password.length() >= ManagedUserVM.PASSWORD_MIN_LENGTH &&
                password.length() <= ManagedUserVM.PASSWORD_MAX_LENGTH
        );
    }
}

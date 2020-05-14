package com.ecom.convenience.repository;

import com.ecom.convenience.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findOneByPhoneNumber(String phoneNumber);
}

package com.ecom.convenience.repository;

import com.ecom.convenience.domain.Store;
import com.ecom.convenience.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findOneByPhoneNumber(String phoneNumber);

    Optional<Store> findOneByOtpCode(String otpCode);

    Optional<Store> findOneById(String id);

    @EntityGraph(attributePaths = "role")
    Optional<Store> findOneWithAuthoritiesById(String id);

    @EntityGraph(attributePaths = "role")
    Optional<Store> findOneWithAuthoritiesByPhoneNumber(String phoneNumber);
}

package com.ecom.convenience.service.dto;

import com.ecom.convenience.config.Constants;
import com.ecom.convenience.domain.Role;
import com.ecom.convenience.domain.Store;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public class StoreDTO {
    private Long id;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String storeName;

    @NotBlank
    @Size(max = 30)
    private String storeType;

    @Size(max = 15)
    private String gstNumber;

    @NotBlank
    @Size(max = 10)
    private String openTime;

    @NotBlank
    @Size(max = 10)
    private String closeTime;

    private String closeDays;

    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 10)
    private String phoneNumber;

    @Size(max = 20)
    private String city;

    @Size(max = 120)
    private String address;

    @Size(max = 20)
    private String pinCode;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String middleName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(max = 256)
    private String imageUrl;

    private boolean activated = false;

    @Size(min = 2, max = 10)
    private String langKey;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Set<String> role;

    private String optCode;

    public StoreDTO() {
        // Empty constructor needed for Jackson.
    }

    public StoreDTO(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.storeType = store.getStoreType();
        this.gstNumber = store.getGstNumber();
        this.openTime = store.getOpenTime();
        this.closeTime = store.getCloseTime();
        this.closeDays = store.getCloseDays();
        this.password = store.getPassword();
        this.firstName = store.getFirstName();
        this.middleName = store.getMiddleName();
        this.lastName = store.getLastName();
        this.email = store.getEmail();
        this.phoneNumber = store.getPhoneNumber();
        this.city = store.getCity();
        this.address = store.getAddress();
        this.pinCode = store.getPinCode();
        this.activated = store.isActivated();
        this.imageUrl = store.getImageUrl();
        this.langKey = store.getLangKey();
        this.createdBy = store.getCreatedBy();
        this.createdDate = store.getCreatedDate();
        this.lastModifiedBy = store.getLastModifiedBy();
        this.lastModifiedDate = store.getLastModifiedDate();
        this.optCode = store.getOptCode();
         this.role = store.getRole().stream().map(Role::getName).collect(Collectors.toSet());
    }

    public String getOptCode() {
        return optCode;
    }

    public void setOptCode(String optCode) {
        this.optCode = optCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseDays() {
        return closeDays;
    }

    public void setCloseDays(String closeDays) {
        this.closeDays = closeDays;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    @Override
    public String toString() {
        return (
            "StoreDTO{" +
                "storeName='" +
                storeName +
                '\'' +
                ", firstName='" +
                firstName +
                '\'' +
                ", middelName='" +
                middleName +
                '\'' +
                ", lastName='" +
                lastName +
                '\'' +
                ", email='" +
                email +
                '\'' +
                ", imageUrl='" +
                imageUrl +
                '\'' +
                ", activated=" +
                activated +
                ", langKey='" +
                langKey +
                '\'' +
                ", createdBy=" +
                createdBy +
                ", createdDate=" +
                createdDate +
                ", lastModifiedBy='" +
                lastModifiedBy +
                '\'' +
                ", lastModifiedDate=" +
                lastModifiedDate +
                ", authorities=" +
                role +
                "}"
        );
    }
}

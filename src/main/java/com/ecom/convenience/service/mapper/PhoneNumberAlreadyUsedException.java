package com.ecom.convenience.service.mapper;

public class PhoneNumberAlreadyUsedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PhoneNumberAlreadyUsedException() {
        super("Phone Number is already in use!");
    }
}

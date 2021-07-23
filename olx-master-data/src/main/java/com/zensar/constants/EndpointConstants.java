package com.zensar.constants;

public enum EndpointConstants {

    // Login Service Helper
    LOGIN_VALIDATE("http://OLX-API-GATEWAY/api/users/validate-token");

    private String value;
    EndpointConstants(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }

}

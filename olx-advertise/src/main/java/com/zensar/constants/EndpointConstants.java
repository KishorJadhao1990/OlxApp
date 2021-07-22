package com.zensar.constants;

public enum EndpointConstants {

    // Login Service Helper
    LOGGED_IN_USER("http://OLX-LOGIN/api/users/{id}"),
    LOGIN_VALIDATE("http://OLX-LOGIN/api/users/validate-token"),

    // Category Service Helper
    FETCH_CATEGORY("http://OLX-MASTER-DATA/api/advertise/category/{id}");

    private String value;
    EndpointConstants (String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }

}

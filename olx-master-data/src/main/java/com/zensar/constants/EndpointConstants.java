package com.zensar.constants;

public enum EndpointConstants {

    // Login Service Helper
    LOGGED_IN_USER("http://localhost:8080/api/users/{id}"),
    LOGIN_VALIDATE("http://localhost:8080/api/users/validate-token"),

    // Category Service Helper
    FETCH_CATEGORY("http://localhost:8082/api/advertise/category/{id}");

    private String value;
    EndpointConstants(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }

}

package com.zensar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/")
public class AdminController {

    @GetMapping(value = "/admin/fetch", produces = "application/json")
    public String fetchAdminUser (Principal principal) {
        return principal.getName()+" is admin user.";
    }
    @GetMapping(value = "/user/fetch", produces = "application/json")
    public String fetchUser (Principal principal) {
        return principal.getName()+" is user.";
    }
}

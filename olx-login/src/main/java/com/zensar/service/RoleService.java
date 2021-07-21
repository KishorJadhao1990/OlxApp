package com.zensar.service;

import com.zensar.model.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    Optional<Role> fetchByRoleCode(String roleCode);
    Optional<Role> fetchByRoleName(String roleName);
}

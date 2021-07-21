package com.zensar.service;

import com.zensar.model.Role;
import com.zensar.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> fetchByRoleCode(String roleCode) {
        return roleRepository.findByRoleCode(roleCode);
    }

    @Override
    public Optional<Role> fetchByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}

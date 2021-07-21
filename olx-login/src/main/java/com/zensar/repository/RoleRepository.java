package com.zensar.repository;

import com.zensar.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleCode(String roleCode);
    Optional<Role> findByRoleName(String roleName);
    @Query("FROM Role r where r.roleCode IN (:roleCodes)")
    List<Role> findAllByRoleCodes(@Param("roleCodes") List<String> roleCodes);
    
}

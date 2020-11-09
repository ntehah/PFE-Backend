package com.memoire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memoire.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
    public Role findByRoleName(String roleName);
}

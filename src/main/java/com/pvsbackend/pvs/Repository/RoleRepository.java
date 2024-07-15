package com.pvsbackend.pvs.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName (String name);

}


package com.pvsbackend.pvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}


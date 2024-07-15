package com.pvsbackend.pvs.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pvsbackend.pvs.Model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long>{
    Optional<UserAuth> findByEmail(String email);
    Optional<UserAuth> findByPhonenumber(String phonenumber);
    Optional<UserAuth> findByPhonenumberOrEmail(String email, String phonenumber);

    Boolean existsByEmail(String email);
    Boolean existsByPhonenumber(String phonenumber);




}

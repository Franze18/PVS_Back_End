package com.pvsbackend.pvs.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.DTO.LoginRequest;
import com.pvsbackend.pvs.DTO.RegistrationRequest;
import com.pvsbackend.pvs.Model.Role;
import com.pvsbackend.pvs.Model.UserAuth;
import com.pvsbackend.pvs.Repository.RoleRepository;
import com.pvsbackend.pvs.Repository.UserAuthRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        //check if username exist in DB
        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByPhonenumber(registrationRequest.getPhonenumber())){
            return new ResponseEntity<>("An account is already registered in this Number!", HttpStatus.BAD_REQUEST);
        }

        UserAuth user= new UserAuth(
            registrationRequest.getEmail(),
            registrationRequest.getFirstname(),
            registrationRequest.getMiddlename(),
            registrationRequest.getLastname(),
            registrationRequest.getPhonenumber(),
            registrationRequest.getAddress(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_CUSTOMER").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("UserAuth registered successfully", HttpStatus.OK);

    }
     @PostMapping("/register/user")
    public ResponseEntity<?> registeruser(@RequestBody RegistrationRequest registrationRequest){

        //check if username exist in DB
        if(userAuthRepository.existsByPhonenumber(registrationRequest.getPhonenumber())){
            return new ResponseEntity<>("Phonenumber is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email!", HttpStatus.BAD_REQUEST);
        }

        UserAuth user= new UserAuth(
            registrationRequest.getEmail(),
            registrationRequest.getFirstname(),
            registrationRequest.getMiddlename(),
            registrationRequest.getLastname(),
            registrationRequest.getPhonenumber(),
            registrationRequest.getAddress(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("UserAuth registered successfully", HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getPhonenumberOrEmail(), loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.UNAUTHORIZED);
        }
            
    }
    
}


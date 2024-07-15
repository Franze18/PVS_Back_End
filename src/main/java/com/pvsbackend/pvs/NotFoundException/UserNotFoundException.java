package com.pvsbackend.pvs.NotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Could not found User with " + id);

    }

}

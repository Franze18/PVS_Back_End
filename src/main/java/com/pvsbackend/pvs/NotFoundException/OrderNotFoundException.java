package com.pvsbackend.pvs.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id){
        super("Could not found Order Item with " + id);

    }

}

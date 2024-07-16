package com.pvsbackend.pvs.NotFoundException;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id){
        super("Could not found Product with " + id);

    }

}
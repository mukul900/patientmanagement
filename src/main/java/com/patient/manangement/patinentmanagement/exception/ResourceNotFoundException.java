package com.patient.manangement.patinentmanagement.exception;



public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}

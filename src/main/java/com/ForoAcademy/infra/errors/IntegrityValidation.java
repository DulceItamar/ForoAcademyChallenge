package com.ForoAcademy.infra.errors;

public class IntegrityValidation extends RuntimeException  {
    public  IntegrityValidation(String message){
        super(message);
    }
}

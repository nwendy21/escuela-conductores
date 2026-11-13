package com.galaxy.api_escuelaConductores.exceptions;

import org.springframework.validation.BindingResult;

public class CustomBadRequest extends RuntimeException{

    private BindingResult bindingResult;

    public CustomBadRequest(String message) {
        super(message);
    }

    public CustomBadRequest(BindingResult bindingResult) {
        this.bindingResult=bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

}

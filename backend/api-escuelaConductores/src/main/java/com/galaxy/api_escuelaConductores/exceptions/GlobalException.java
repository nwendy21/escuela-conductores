package com.galaxy.api_escuelaConductores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({ CustomBadRequest.class })
    public ResponseEntity<Object> handleGlobalException(CustomBadRequest exception) {
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(e->{
            errors.put(e.getField(),e.getDefaultMessage());
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

}

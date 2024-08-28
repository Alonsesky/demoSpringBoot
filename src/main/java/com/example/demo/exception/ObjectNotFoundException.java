package com.example.demo.exception;

import lombok.Getter;

@Getter
public class ObjectNotFoundException extends  RuntimeException{

    private  final String objectNotFoundName;
    private final Throwable cause;

    public ObjectNotFoundException(String objectNotFoundName) {
        this.objectNotFoundName = objectNotFoundName;
        this.cause = null;
    }

    public ObjectNotFoundException(String objectNotFoundName, Throwable cause) {
        this.objectNotFoundName = objectNotFoundName;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return super.getMessage().concat("Object not found")
                .concat(this.objectNotFoundName)
                .concat(")");
    }

    //Getter manejado con lombok

}

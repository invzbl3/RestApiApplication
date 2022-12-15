package com.test.application.exception;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(){
        super();
    }
    public EntityNotFoundException(String message){
        super(message);
    }
}

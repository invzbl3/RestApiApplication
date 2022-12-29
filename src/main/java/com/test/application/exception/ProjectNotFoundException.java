package com.test.application.exception;

/**
 * @author invzbl3 on 12/29/2022
 * @project RestApiApplication
 */
public class ProjectNotFoundException extends Exception {

    private String errorMessage;

    public ProjectNotFoundException(String message){
        super(message);
        this.errorMessage = message;
    }
}
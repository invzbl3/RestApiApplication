package com.test.application.exception;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public class BaseException extends Exception {

    public BaseException(){
        super();
    }

    public BaseException(String message){
        super(message);
    }
}
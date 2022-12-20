package com.test.application.exception;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public class CustomCheckedException extends Exception {

    CustomCheckedException() {
        super();
    }

    CustomCheckedException(String message) {
        super(message);
    }
}
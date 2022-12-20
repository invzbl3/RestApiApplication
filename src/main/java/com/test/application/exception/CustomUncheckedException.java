package com.test.application.exception;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException() {
        super();
    }

    CustomUncheckedException(String message) {
        super(message);
    }
}
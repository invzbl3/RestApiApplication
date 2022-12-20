package com.test.application.exception;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public class ErrorHandling extends BaseException {

    private String message;
    private String errorMessage;

    public ErrorHandling() {}

    public ErrorHandling( String message ) {
        this.message = message;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public final String getMessage() {
        return message;
    }


    public final void setMessage(String message) {
        this.message = message;
    }
}
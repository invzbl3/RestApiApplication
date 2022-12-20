package com.test.application.exception;

import java.util.Optional;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message)
            throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws Exception {
        throw new Exception();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message)
            throws Exception {
        throw new Exception(message);
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new RuntimeException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new RuntimeException(message);
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message)
            throws CustomCheckedException {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() throws CustomUncheckedException {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
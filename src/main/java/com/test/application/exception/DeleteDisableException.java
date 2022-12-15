package com.test.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@Slf4j
public class DeleteDisableException extends DataIntegrityViolationException {
    public DeleteDisableException(Class<?> clazz){
        super("Unable to delete " + clazz.getSimpleName().toLowerCase());
        log.warn("Unable to delete {}", clazz.getSimpleName().toLowerCase());
    }
}
package com.test.application.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * @author invzbl3 on 12/25/2022
 * @project RestApiApplication
 */
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleProductNotFoundException(HttpServletRequest request, Exception exception) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("exception/error");
        return mav;
    }
}
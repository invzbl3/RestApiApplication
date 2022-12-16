package com.test.application.data.payloads.response;

/**
 * @author invzbl3 on 12/16/2022
 * @project RestApiApplication
 */
public class MessageResponse {

    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
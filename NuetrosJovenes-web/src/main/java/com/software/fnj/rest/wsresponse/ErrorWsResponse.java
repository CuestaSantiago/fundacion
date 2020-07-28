/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.wsresponse;

/**
 *
 * @author AlterBios
 */
public class ErrorWsResponse {

    String code;
    String description;

    public ErrorWsResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }        

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
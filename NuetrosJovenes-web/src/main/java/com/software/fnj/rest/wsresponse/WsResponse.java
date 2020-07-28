/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.wsresponse;

import java.util.List;

/**
 *
 * @author AlterBios
 */
public class WsResponse {
    private Boolean success;
    private Object content;
    private List<ErrorWsResponse> errors;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public List<ErrorWsResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorWsResponse> errors) {
        this.errors = errors;
    }
       
}

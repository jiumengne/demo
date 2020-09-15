package com.common.base;

import lombok.Data;

@Data
public class ResponseDTO {
    private Integer status;

    private String msg;

    private Object data;

    public ResponseDTO ok(){
        this.status = ResponseConstants.SUCCESS;
        this.msg = ResponseConstants.SUCCESSMSG;
        return this;
    }

    public ResponseDTO ok(Object data){
        this.status = ResponseConstants.SUCCESS;
        this.msg =  ResponseConstants.SUCCESSMSG;
        this.data = data;
        return this;
    }

    public ResponseDTO fail(String msg){
        this.status = ResponseConstants.FAILURE;
        this.msg = msg;
        return this;
    }

    public ResponseDTO error(String msg){
        this.status = ResponseConstants.ERROR;
        this.msg = msg;
        return this;
    }
    public ResponseDTO warn(String msg,Object data){
        this.status = ResponseConstants.SUCCESS;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResponseDTO timeout(String msg,Object data){
        this.status = ResponseConstants.TIMEOUT;
        this.msg = msg;
        this.data = data;
        return this;
    }
}

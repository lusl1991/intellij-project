package com.softel.model.utils;

/**
 * 
 * @Project  : elogistics
 * @ClassName   Response
 * @Description   统一响应结构
 * {"data":{},"meta":{"message":"","code":"0"}}
 * @author   Administrator
 * @date   2016年11月15日
 * @Copyright: 2016 Softel Inc. All rights reserved.
 */
public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";
    private static final String CODE_SUCCESS="0";
    private static final String CODE_ERROR="1";

    private Meta meta;
    private Object data;

    public Response success() {
        this.meta = new Meta(CODE_SUCCESS, OK);
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(CODE_SUCCESS, OK);
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(CODE_ERROR, ERROR);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(CODE_ERROR, message);
        return this;
    }
    
    public Response failure(Object data) {
        this.meta = new Meta(CODE_ERROR, ERROR);
        this.data = data;
        return this;
    }
    
    public Response failure(String code,String message){
    	 this.meta = new Meta(code, message);
         return this;
    }
    
    public Response failure(String message,Object data) {
        this.meta = new Meta(CODE_ERROR, message);
        this.data = data;
        return this;
    }
    public Response failure(String code,String message,Object data) {
        this.meta = new Meta(code, message);
        this.data = data;
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public class Meta {

        private String code;
        private String message;

        public Meta(String code) {
            this.code = code;
        }

        public Meta(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}

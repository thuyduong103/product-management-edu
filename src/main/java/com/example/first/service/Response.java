package com.example.first.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.query.Meta;
import org.springframework.http.HttpStatus;

public class Response<T> {
	private final T data;
    private final Meta meta;
   

    public Response(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }
    public T getData() {
        return this.data;
    }
    public Meta getMeta() {
        return this.meta;
    }

    public static <T> Response<T> Success(T data) {
        HttpStatus status = HttpStatus.OK;
        String message = "Success";
        return new Response<>(data, new Meta(status, message));
    }

    public static <T> Response<T> SuccessWithSpecificMessage(T data, String msg) {
        HttpStatus status = HttpStatus.OK;
        return new Response<>(data, new Meta(status, msg));
    }

    public static Response Error(HttpStatus status, String message) {
        return new Response<>(null, new Meta(status, message));
    }

    public static Response BadRequest(String message) {
        return Error(HttpStatus.BAD_REQUEST, message);
    }

    public static class Meta {
        private final HttpStatus status;
        private final String message;

        public Meta(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        public HttpStatus getStatus() {
            return this.status;
        }

        public String getMessage() {
            return this.message;
        }

//        public Object getMeta() {
//            Map<String, Object> metaMap = new HashMap()<String, Object>();
//            metaMap.put("message", this.message);
//            metaMap.put("status", this.status.value());
//            return metaMap;
//        }

    }
}

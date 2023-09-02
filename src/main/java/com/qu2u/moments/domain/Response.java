package com.qu2u.moments.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Response<T> {

    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMsg("success");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMsg("success");
        return response;
    }

    public static <T> Response<T> error(Integer code, String msg) {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }


}

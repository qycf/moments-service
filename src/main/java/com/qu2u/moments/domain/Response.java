package com.qu2u.moments.domain;


import lombok.Data;

@Data
public class Response<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMsg("success");
        response.setData(data);
        return response;
    }


}

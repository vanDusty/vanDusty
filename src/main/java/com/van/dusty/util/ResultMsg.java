package com.van.dusty.util;

public class ResultMsg<T> {
    private static final String CODE_SUCCESS = "success";

    private static final String CODE_FAIL = "fail";

    private String code;

    private T data;

    private String msg;

    public ResultMsg(){
    }

    public ResultMsg(String code){
        this.code = code;
    }

    public ResultMsg(String code, T data){
        this.code = code;
        this.data = data;
    }

    public ResultMsg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ResultMsg success(){
        return new ResultMsg(CODE_SUCCESS);
    }

    public static ResultMsg success(Object data){
        return new ResultMsg(CODE_SUCCESS, data);
    }

    public static ResultMsg fail(String msg){
        return new ResultMsg(CODE_FAIL, msg);
    }

    public static ResultMsg widthCode(String errorCode) {
        return new ResultMsg(errorCode);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

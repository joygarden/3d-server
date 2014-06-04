package com.lzs.mobile.rest.resp;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/29 15:40 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class Result {
    private int code = 200;
    private String msg;
    private Object data;

    public static final int OK = 200;
    public static final int ERROR = 1001;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

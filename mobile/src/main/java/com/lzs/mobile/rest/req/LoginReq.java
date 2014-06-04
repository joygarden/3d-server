package com.lzs.mobile.rest.req;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 13:43 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class LoginReq {
    private String nickName;
    private String password;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

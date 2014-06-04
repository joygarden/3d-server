package com.lzs.mobile.rest.req;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 14:34 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class RegisterReq {
    private String nickName;
    private String password;
    private String email;
    private String mdn;
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

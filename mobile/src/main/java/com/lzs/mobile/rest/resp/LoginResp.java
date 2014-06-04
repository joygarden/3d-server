package com.lzs.mobile.rest.resp;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 14:29 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class LoginResp {
    private Long userId;
    private String nickName;
    private String email;
    private String mdn;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
}

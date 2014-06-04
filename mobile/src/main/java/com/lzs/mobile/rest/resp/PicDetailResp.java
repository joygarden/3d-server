package com.lzs.mobile.rest.resp;

import java.util.Date;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 15:18 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class PicDetailResp {
    private Long id;
    private Long userId;
    private String title;
    private Date time;
    private String picUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}

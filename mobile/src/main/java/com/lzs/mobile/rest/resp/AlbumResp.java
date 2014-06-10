package com.lzs.mobile.rest.resp;

import java.util.Date;

/**
 * Created on 6/11/14.
 *
 * @author liaozhisong.
 */
public class AlbumResp {
    private Long id;
    private String title;
    private Date time;
    private String picUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

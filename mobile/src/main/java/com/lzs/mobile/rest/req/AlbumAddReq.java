package com.lzs.mobile.rest.req;

/**
 * Created on 6/11/14.
 *
 * @author liaozhisong.
 */
public class AlbumAddReq {
    private String title;
    private Long userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

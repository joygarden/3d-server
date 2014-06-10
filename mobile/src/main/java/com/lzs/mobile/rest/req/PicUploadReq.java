package com.lzs.mobile.rest.req;

import org.springframework.web.multipart.MultipartFile;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 13:46 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class PicUploadReq {
    private Long userId;
    private String title;
    private Long albumId;
    private MultipartFile picData;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
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

    public MultipartFile getPicData() {
        return picData;
    }

    public void setPicData(MultipartFile picData) {
        this.picData = picData;
    }
}

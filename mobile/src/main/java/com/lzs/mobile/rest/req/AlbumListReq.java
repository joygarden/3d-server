package com.lzs.mobile.rest.req;

/**
 * Created on 6/11/14.
 *
 * @author liaozhisong.
 */
public class AlbumListReq {
    private int pageSize = 20;

    private int pageNo = 1;

    private Long userId;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

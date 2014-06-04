package com.lzs.mobile.rest.req;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 15:16 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class PicListReq {
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

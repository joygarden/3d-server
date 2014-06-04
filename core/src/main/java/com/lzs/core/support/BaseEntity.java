package com.lzs.core.support;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by liaozhisong on 3/22/14.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    protected Long id;
    protected Date createDate;
    protected Date updateDate;
    protected Integer deleted; //删除标记 0 删除，1正常

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @PreUpdate
    public void setUpdateField() {
        updateDate = new Date();
    }

    @PrePersist
    public void setCreateField() {
        deleted = 0;
        createDate = new Date();
    }
}

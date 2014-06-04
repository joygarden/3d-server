package com.lzs.core.entity;

import com.lzs.core.support.BaseEntity;
import com.lzs.core.support.Constant;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created on 5/29/14.
 *
 * @author liaozhisong.
 */
@Entity
public class Picture extends BaseEntity {

    private User user;
    private String title;
    private String url;

    private MultipartFile file;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    @Transient
    public String getFullPath() {
        return Constant.getPrefix() + url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Transient
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

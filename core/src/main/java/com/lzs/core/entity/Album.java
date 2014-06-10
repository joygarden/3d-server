package com.lzs.core.entity;

import com.lzs.core.support.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 6/11/14.
 *
 * @author liaozhisong.
 */
@Entity
public class Album extends BaseEntity {
    private String title;
    private List<Picture> pictures;
    private User user;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album",fetch = FetchType.LAZY)
    @OrderBy("createDate")
    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

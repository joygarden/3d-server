package com.lzs.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lzs.core.support.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 5/28/14.
 *
 * @author liaozhisong.
 */
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
    private String mdn;
    private String address;
    private String email;
    private String roles;


    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Transient
    @JsonIgnore
    public List<String> getRoleList() {
        return Arrays.asList(roles.split(","));
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

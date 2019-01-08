package com.ssy.app.enity;

public class User {
    private Long id;

    private byte[] loginName;

    private byte[] password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getLoginName() {
        return loginName;
    }

    public void setLoginName(byte[] loginName) {
        this.loginName = loginName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }
}
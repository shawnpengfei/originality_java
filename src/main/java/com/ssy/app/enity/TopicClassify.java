package com.ssy.app.enity;

public class TopicClassify {
    private Long id;

    private byte[] classify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getClassify() {
        return classify;
    }

    public void setClassify(byte[] classify) {
        this.classify = classify;
    }
}
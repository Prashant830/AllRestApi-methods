package com.example.jsonapi.models;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("userId")
    Integer userId;

    @SerializedName("title")
    String title;

    int id;
    @SerializedName("body")

    String body;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}

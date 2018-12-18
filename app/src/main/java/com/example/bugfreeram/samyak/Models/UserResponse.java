package com.example.bugfreeram.samyak.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    @SerializedName("results")
    private List<UserNew> userNewList;

    public List<UserNew> getUserNewList() {
        return userNewList;
    }

    public void setUserNewList(List<UserNew> userNewList) {
        this.userNewList = userNewList;
    }
}

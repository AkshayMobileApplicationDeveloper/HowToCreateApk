package com.example.howtocreateapk.Model;

import android.net.Uri;

public class ContactModel {
    private Object profileImage;
    private String name;
    private String phone;
    private String message;
    private String time;

    public ContactModel(Object profileImage, String name, String phone, String message, String time) {
        this.profileImage = profileImage;
        this.name = name;
        this.phone = phone;
        this.message = message;
        this.time = time;
    }

    public Object getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Object profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.mVision.myProject.Entities;

import java.util.Date;

public class Passport {
    int id;
    String image;
    Info info;
    Date date;

    public Passport(int id, String image, Info info, Date date) {
        this.id = id;
        this.image = image;
        this.info = info;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

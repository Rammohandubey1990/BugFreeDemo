package com.example.bugfreeram.samyak.Custom;

public class Product {
    private int id;
    private String title;
    private String shortdesc;

    private int image;
    private  int img_back;
    private String likes;
    private String coments;

    public Product(int id, String title, String shortdesc, int image, int img_back, String likes, String coments) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;

        this.image = image;
        this.img_back = img_back;
        this.likes = likes;
        this.coments = coments;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImg_back() {
        return img_back;
    }

    public void setImg_back(int img_back) {
        this.img_back = img_back;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }


    public int getImage() {
        return image;
    }
}
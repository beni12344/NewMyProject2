package com.example.newmyproject;

class Area {
    private int id;
    private String name;
    private String info;
    private String image;

    public Area(int id, String name, String info, String image) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

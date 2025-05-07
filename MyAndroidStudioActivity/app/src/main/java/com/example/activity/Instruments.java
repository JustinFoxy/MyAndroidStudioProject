package com.example.activity;

public class Instruments {
    private String name;
    private int imageId;
    public Instruments(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}

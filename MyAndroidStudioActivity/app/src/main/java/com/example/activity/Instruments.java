package com.example.activity;

//Instruments 类用于封装乐器对象，包含乐器的名称和图片资源 ID。
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

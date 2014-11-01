package com.example.nori.myapplication;

/**
 * Created by nori on 14/11/01.
 */
public class ActionObject {

    private String mActionName;
    private String mCurrentTime;
    private int mTime;
    private float mX1;
    private float mY1;
    private float mX2;
    private float mY2;

    public ActionObject() {
        mActionName = "";
        mCurrentTime = "";
        mTime = 0;
        mX1 = 0;
        mY1 = 0;
        mX2 = 0;
    }

    public void setName(String name){
        this.mActionName =name;
    }
    public String name(){ return this.mActionName;}

    public void setCurrentTime(String ctime){
        this.mCurrentTime=ctime;
    }
    public String currentTime(){return this.mCurrentTime;}
    public void setTime(int time){
        this.mTime =time;
    }
    public int time(){ return this.mTime;}
    public void setX1(float x1){
        this.mX1 = x1;
    }
    public float x1(){return this.mX1;}
    public void setY1(float y1){
        this.mY1 = y1;
    }
    public float y1(){
        return this.mY1;
    }
    public void setX2(float x2){
        this.mX2 = x2;
    }
    public float x2(){return this.mX2;}
    public void setY2(float y2){
        this.mY2 = y2;
    }
    public float y2(){
        return this.mY2;
    }


    
}

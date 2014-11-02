/**
 * Copyright norifumi kawamoto 2014/11/1
 *
 *
 */
package com.example.nori.myapplication;

/**
 * Created by nori on 14/11/01.
 */
public class XawalyActionObject {

    private String mActionType;
    private String mCurrentTime;
    private int mTime1;
    private int mTime2;
    private double mX1;
    private double mY1;
    private double mX2;
    private double mY2;

    public XawalyActionObject() {
        mActionType = "";
        mCurrentTime = "";
        mTime1 = 0;
        mTime2 = 0;
        mX1 = 0;
        mY1 = 0;
        mX2 = 0;
        mY2 = 0;
    }

    public XawalyActionObject(String type, String ctime, int t1, int t2, double x1, double y1, double x2, double y2) {
        mActionType = type;
        mCurrentTime = ctime;
        mTime1 = t1;
        mTime2 = t2;
        mX1 = x1;
        mY1 = y1;
        mX2 = x2;
        mY2 = y2;
    }

    public void setType(String name){
        this.mActionType =name;
    }
    public String type(){ return this.mActionType;}

    public void setCurrentTime(String ctime){
        this.mCurrentTime=ctime;
    }
    public String currentTime(){return this.mCurrentTime;}
    public void setTime1(int time){
        this.mTime1 =time;
    }
    public int time1(){ return this.mTime1;}
    public void setTime2(int time){
        this.mTime2 =time;
    }
    public int time2(){ return this.mTime2;}
    public void setX1(double x1){
        this.mX1 = x1;
    }
    public double x1(){return this.mX1;}
    public void setY1(double y1){
        this.mY1 = y1;
    }
    public double y1(){
        return this.mY1;
    }
    public void setX2(double x2){
        this.mX2 = x2;
    }
    public double x2(){return this.mX2;}
    public void setY2(double y2){
        this.mY2 = y2;
    }
    public double y2(){
        return this.mY2;
    }

}

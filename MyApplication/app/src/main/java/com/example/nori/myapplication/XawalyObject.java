package com.example.nori.myapplication;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nori on 14/11/01.
 */
public class XawalyObject extends JSONObject {
    private String mDate;
    private String mDevice;
    private String mOS;
    private String mName;
    private ArrayList<ActionObject>mAction;


    public XawalyObject(){
        mDate="";
        mDevice="";
        mOS="";
        mName="";
        mAction = new ArrayList<ActionObject>();

    }
}

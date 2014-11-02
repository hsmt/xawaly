package com.example.nori.myapplication;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nori on 14/11/01.
 */
public class XawalyJSONObject extends JSONObject {

    public static int mActionNumber;
    private String mDate;
    private String mDevice;
    private String mOS;
    private String mName;
    private JSONObject mTempAction;
    private ArrayList<XawalyActionObject>mAction;



    public XawalyJSONObject(){
        mActionNumber=0;
        mDate="";
        mDevice="";
        mOS="";
        mName="";
        mTempAction= new JSONObject();
        mAction = new ArrayList<XawalyActionObject>();
    }

    public XawalyJSONObject(JSONObject jsonObject){

        try {
            mDate = jsonObject.getString("date");
            mDevice = jsonObject.getString("device");
            mOS = jsonObject.getString("os");
            mName = jsonObject.getString("name");
            mAction = new ArrayList<XawalyActionObject>();
            setPlayActions(jsonObject);
        }catch (JSONException ex){
        }
    }

    public void setInfo(JSONObject jsonObject){
        try {
            mDate = jsonObject.getString("date");
            mDevice = jsonObject.getString("device");
            mOS = jsonObject.getString("os");
            mName = jsonObject.getString("name");
        }catch (JSONException ex){
        }
    }

    public void setDate(String date){
        this.mDate = date;
    }

    public void setDevice(String device){
        this.mDevice = device;
    }

    public void setOS(String os){
        this.mOS = os;
    }

    public void setmName(String name){
        this.mName = name;
    }

    public void setAction(JSONObject action){
        try {
            mTempAction.put("Action" + String.format("%04d", mActionNumber), action);
            mActionNumber++;
        }catch (JSONException ex){
            Log.e("setAction Error ",ex.getMessage());
        }
    }

    public JSONObject compileData(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",mName);
            jsonObject.put("date",mDate);
            jsonObject.put("os",mOS);
            jsonObject.put("device",mDevice);
            jsonObject.put("action",mTempAction);
        }catch (JSONException ex){
            Log.e("setAction Error ",ex.getMessage());
        }
        return jsonObject;
    }

    public void setPlayActions(JSONObject jsonObject)
    {
        try
        {
            JSONObject actions = jsonObject.getJSONObject("action");
            Log.d("XawalyObject",actions.toString());
            Log.d("Actions Lenght:", "" + actions.length());
            for(int i=0; i < actions.length(); i++)
            {
                JSONObject action = actions.getJSONObject("Action"+String.format("%04d",i));
                mAction.add(
                        new XawalyActionObject(action.getString("ActionType"),
                        action.getString("current-time"),
                        action.getInt("time1"), action.getInt("time2"),
                        action.getDouble("X1"), action.getDouble("Y1"),
                        action.getDouble("X2"), action.getDouble("Y2")));
            }
        }catch(JSONException ex){
            Log.e("JSONError",ex.getMessage());
        }
    }


}

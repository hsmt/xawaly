package com.example.nori.myapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;

import android.text.format.Time;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MyActivity extends Activity {

    private JSONObject mJsonObject;
    private JSONObject mActionObject;
    private GestureDetector mGesDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // GestureDetecotorクラスのインスタンス生成
        mGesDetect = new GestureDetector(this, onGestureListener);
        mJsonObject = new JSONObject();
        mActionObject = new JSONObject();
        Time time = new Time();
        time.setToNow();
        String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
        Log.v("Device","-------------------------");
        Log.d("Device", android.os.Build.MODEL);
        Log.v("Device", "-------------------------");


        try{
           mJsonObject.put("date",date);
           mJsonObject.put("device","Android");
           mJsonObject.put("os","Android");
           mJsonObject.put("name",Build.MODEL);
        }catch(JSONException error){
            Log.e("Error",error.getMessage());
        }



    }

    @Override
    protected void onPause() {
        super.onPause();
        try{
            mJsonObject.put("action",mActionObject);

            Log.v("Json",mJsonObject.toString());
        }catch(JSONException ex){
            Log.e("Error",ex.getMessage());
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    // TODO Auto-generated method stub
    // タッチイベントをGestureDetector#onTouchEventメソッドに
      mGesDetect.onTouchEvent(event);
      return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 複雑なタッチイベントを取得
    private final SimpleOnGestureListener onGestureListener = new SimpleOnGestureListener() {

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onDoubleTap");
            Log.v("Gesture",""+e.getEventTime()); //mm
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onDoubleTap",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onDoubleTapEvent");
            Log.v("Gesture",""+e.getEventTime());
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onDoubleTapEvent",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }

            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onDown");
            Log.v("Gesture",""+e.getEventTime());
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");
            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onDown",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }
            return super.onDown(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onFling");
            Log.v("Gesture", "" + e1.getEventTime());
            Log.v("Gesture", "X1:"+ e1.getX()+" Y1: "+e1.getY());
            Log.v("Gesture",""+e2.getEventTime());
            Log.v("Gesture", "X2:"+ e2.getX()+" Y2: "+e2.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e1.getEventTime());
                json.put("time2",e2.getEventTime());
                json.put("X1",e1.getX());
                json.put("Y1",e1.getY());
                json.put("X2",e2.getX());
                json.put("Y2",e2.getY());
                mActionObject.put("onFling",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onLongPress");
            Log.v("Gesture",""+e.getEventTime());
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onLongPress",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }

            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onScroll");
            Log.v("Gesture",""+e1.getEventTime());
            Log.v("Gesture", "X1:"+ e1.getX()+" Y1: "+e1.getY());
            Log.v("Gesture",""+e2.getEventTime());
            Log.v("Gesture", "X2:"+ e2.getX()+" Y2: "+e2.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e1.getEventTime());
                json.put("time2",e2.getEventTime());
                json.put("X1",e1.getX());
                json.put("Y1",e1.getY());
                json.put("X2",e2.getX());
                json.put("Y2",e2.getY());
                mActionObject.put("onScroll",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onShowPress");
            Log.v("Gesture",""+e.getEventTime());
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onShowPress",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }
            super.onShowPress(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onSingleTapConfirmed");
            Log.v("Gesture",""+e.getEventTime());
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onSingleTapConfirmed",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }

            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // TODO Auto-generated method stub
            Log.v("Gesture","-------------------------");
            Log.v("Gesture", "onSingleTapUp");
            Log.v("Gesture",""+e.getEventTime());
            Log.v("Gesture", "X:"+ e.getX()+" Y: "+e.getY());
            Log.v("Gesture","-------------------------");

            JSONObject json = new JSONObject();
            Time time = new Time();
            time.setToNow();
            String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
            try{
                json.put("current-time",date);
                json.put("time1",e.getEventTime());
                json.put("time2",-1);
                json.put("X1",e.getX());
                json.put("Y1",e.getY());
                json.put("X2",-1);
                json.put("Y2",-1);
                mActionObject.put("onSingleTapUp",json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }

            return super.onSingleTapUp(e);
        }
    };
}

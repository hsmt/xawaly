package com.example.nori.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.Time;
import android.util.Log;
import android.view.GestureDetector;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MyActivity extends Activity {

    AppController mApp;

    boolean mPlayFlag;
    int margin=60;
    private GestureDetector mGesDetect;// = new GestureDetector(this, onGestureListener);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mApp = (AppController)this.getApplication();
        // GestureDetecotorクラスのインスタンス生成
        mGesDetect = new GestureDetector(this, onGestureListener);
        Time time = new Time();
        time.setToNow();
        String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
        Log.v("Device", "-------------------------");
        Log.d("Device", android.os.Build.MODEL);
        Log.v("Device", "-------------------------");

        {
            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // TODO Auto-generated method stub
                    Log.v("Gesture","-------------------------");
                    Log.v("Gesture", "onSingleTapConfirmed");
                    Log.v("Gesture", "X:"+(v.getX()+margin)+" Y: "+(v.getY()+margin));
                    Log.v("Gesture","-------------------------");

                    JSONObject json = new JSONObject();
                    Time time = new Time();
                    time.setToNow();

                    String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
                    try{
                        json.put("current-time",date);
                        json.put("time1",1000);
                        json.put("time2",-1);
                        json.put("X1",v.getX()+margin);
                        json.put("Y1",v.getY()+margin);
                        json.put("X2",-1);
                        json.put("Y2",-1);
                        json.put("ActionType","onSingleTapConfirmed");
                        mApp.mXawalyJSONObject.setAction(json);
                    }catch(JSONException error){
                        Log.e("Error",error.getMessage());
                    }
                    v.setVisibility(View.INVISIBLE);
                    Log.e("button1", "button1");
                    Intent i = new Intent(MyActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            });
        }

        {
            ImageButton ib = (ImageButton) findViewById(R.id.imageButton2);
            ib.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // TODO Auto-generated method stub
                    Log.v("Gesture","-------------------------");
                    Log.v("Gesture", "onSingleTapConfirmed");
                    Log.v("Gesture", "X:"+(v.getX()+margin)+" Y: "+(v.getY()+margin));
                    Log.v("Gesture","-------------------------");

                    JSONObject json = new JSONObject();
                    Time time = new Time();
                    time.setToNow();
                    String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
                    try{
                        json.put("current-time",date);
                        json.put("time1",1000);
                        json.put("time2",-1);
                        json.put("X1",v.getX()+margin);
                        json.put("Y1",v.getY()+margin);
                        json.put("X2",-1);
                        json.put("Y2",-1);
                        json.put("ActionType","onSingleTapConfirmed");
                        mApp.mXawalyJSONObject.setAction(json);
                    }catch(JSONException error){
                        Log.e("Error",error.getMessage());
                    }
                    v.setVisibility(View.INVISIBLE);
                    Log.e("button2","button2");
                }
            });

        }

        {
            ImageButton ib = (ImageButton) findViewById(R.id.imageButton3);
            ib.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // TODO Auto-generated method stub
                    Log.v("Gesture","-------------------------");
                    Log.v("Gesture", "onSingleTapConfirmed");
                    Log.v("Gesture", "X:"+(v.getX()+margin)+" Y: "+(v.getY()+margin));
                    Log.v("Gesture","-------------------------");

                    JSONObject json = new JSONObject();
                    Time time = new Time();
                    time.setToNow();
                    String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
                    try{
                        json.put("current-time",date);
                        json.put("time1",1000);
                        json.put("time2",-1);
                        json.put("X1",v.getX()+margin);
                        json.put("Y1",v.getY()+margin);
                        json.put("X2",-1);
                        json.put("Y2",-1);
                        json.put("ActionType","onSingleTapConfirmed");
                        mApp.mXawalyJSONObject.setAction(json);
                    }catch(JSONException error){
                        Log.e("Error",error.getMessage());
                    }
                    v.setVisibility(View.INVISIBLE);
                    Log.e("button3", "button3");
                }
            });
        }

        {
            ImageButton ib = (ImageButton) findViewById(R.id.imageButton4);
            ib.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // TODO Auto-generated method stub
                    Log.v("Gesture","-------------------------");
                    Log.v("Gesture", "onSingleTapConfirmed");
                    Log.v("Gesture", "X:"+(v.getX()+margin)+" Y: "+(v.getY()+margin));
                    Log.v("Gesture","-------------------------");

                    JSONObject json = new JSONObject();
                    Time time = new Time();
                    time.setToNow();
                    String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
                    try{
                        json.put("current-time",date);
                        json.put("time1",1000);
                        json.put("time2",-1);
                        json.put("X1",v.getX()+margin);
                        json.put("Y1",v.getY()+margin);
                        json.put("X2",-1);
                        json.put("Y2",-1);
                        json.put("ActionType","onSingleTapConfirmed");
                        mApp.mXawalyJSONObject.setAction(json);
                    }catch(JSONException error){
                        Log.e("Error",error.getMessage());
                    }
                    v.setVisibility(View.INVISIBLE);
                    Log.e("button4","button4");
                }
            });
        }

       if( isPlay(getIntent()) )
       {
           Log.d("ISPLAY","HOGE");
           mApp.mIsPlayFlag=true;
           mApp.getPlayData();

       }else{
           mApp.mIsPlayFlag=false;
           mApp.mXawalyJSONObject.setDate(date);
           mApp.mXawalyJSONObject.setDevice("Android");
           mApp.mXawalyJSONObject.setOS("Android "+Build.VERSION.RELEASE);
           mApp.mXawalyJSONObject.setmName(Build.MODEL);
       }

    }

    private boolean isPlay(Intent intent){
        String action = intent.getAction();
        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = intent.getData();
            if (uri != null) {
                String session_id = uri.getQueryParameter("id");
                if(session_id!=null){
                    mApp.mTrackId = session_id;
                    Log.d("Id :::::", session_id);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(mGesDetect==null)mGesDetect = new GestureDetector(this, onGestureListener);
    }

    @Override
    protected void onResume(){
        super.onResume();

        if(mApp.mIsPlayFlag) {
            Thread trd = new Thread(new Runnable() {
                public void run() {

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    long downTime = SystemClock.uptimeMillis() + 5000;
                    long eventTime = SystemClock.uptimeMillis() + 5500;
                    pushButton3(downTime, eventTime);
                    try {
                        Thread.sleep(6000);
                    } catch (Exception e) {
                    }
                    long downTime2 = SystemClock.uptimeMillis() + 14000;
                    long eventTime2 = SystemClock.uptimeMillis() + 14500;
                    pushButton2(downTime2, eventTime2);

                    try {
                        Thread.sleep(6000);
                    } catch (Exception e) {
                    }
                    long downTime3 = SystemClock.uptimeMillis() + 24000;
                    long eventTime3 = SystemClock.uptimeMillis() + 24500;
                    pushButton1(downTime2, eventTime2);
                    //sampleFunc();
                }
            });
            trd.start();
        }
    }

    public void sampleFunc(){
        event();
    }


    public void pushButton4(long downTime,long eventTime){
        Log.d("pushButton4 ","Event");
        int margin=0;
        try{
            InputManager inputManager = (InputManager) getSystemService(Context.INPUT_SERVICE);
            Method injectInputEvent = InputManager.class.getDeclaredMethod("injectInputEvent", InputEvent.class, int.class);
            MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 670+margin, 180+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 670+margin, 180+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
        }catch (Exception ex){

        }
    }

    public void pushButton3(long downTime,long eventTime)
    {
        Log.d("pushButton3 ","Event");
        int margin=0;
        try{
            InputManager inputManager = (InputManager) getSystemService(Context.INPUT_SERVICE);
            Method injectInputEvent = InputManager.class.getDeclaredMethod("injectInputEvent", InputEvent.class, int.class);
            MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 120+margin, 160+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 120+margin, 160+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
        }catch (Exception ex){

        }
    }



    public void pushButton2(long downTime,long eventTime){
        Log.d("pushButton2 ","Event");
        int margin=0;
        try{
            InputManager inputManager = (InputManager) getSystemService(Context.INPUT_SERVICE);
            Method injectInputEvent = InputManager.class.getDeclaredMethod("injectInputEvent", InputEvent.class, int.class);
            MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 670+margin, 1050+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 670+margin, 1050+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
        }catch (Exception ex){

        }
    }
    public void pushButton1(long downTime, long eventTime)
    {
        Log.d("pushButton1 ","Event");
        int margin=0;
        try{
            InputManager inputManager = (InputManager) getSystemService(Context.INPUT_SERVICE);
            Method injectInputEvent = InputManager.class.getDeclaredMethod("injectInputEvent", InputEvent.class, int.class);
            MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 100+margin, 1050+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 100+margin, 1050+margin, 0);
            event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
            injectInputEvent.invoke(inputManager, event, 0);
        }catch (Exception ex){

        }

    }


    protected void event(){
       // long downTime = SystemClock.uptimeMillis()+5000;
      //  long eventTime = SystemClock.uptimeMillis() + 5500;
       //  pushButton1(downTime,eventTime);
     //   Log.v("MM",""+SystemClock.uptimeMillis());
       //   pushButton2(downTime, eventTime);
     //    pushButton3(downTime+(long)4000,eventTime+eventTime+(long)4100);
     //    pushButton4(downTime+(long)6000,eventTime+eventTime+(long)6100);
       // pushButton3(downTime+600,eventTime+600);
       // pushButton4(downTime+100,eventTime+100);
    }


    public synchronized void sleep(long msec)
    {
        try
        {
            wait(msec);
        }catch(InterruptedException e){}
    }

    @Override
    protected void onStop() {
        mGesDetect=null;
        JSONObject jsonObject = mApp.mXawalyJSONObject.compileData();
        mApp.sendActionDate(jsonObject);
        Log.d("SendJson"," "+jsonObject.toString());
        super.onStop();

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
    private final GestureDetector.SimpleOnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener() {

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
                json.put("ActionType","onDoubleTap");

                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onDoubleTapEvent");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onDown");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onFling");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onLongPress");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onScroll");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onShowPress");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onSingleTapConfirmed");
                mApp.mXawalyJSONObject.setAction(json);
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
                json.put("ActionType","onSingleTapUp");
                mApp.mXawalyJSONObject.setAction(json);
            }catch(JSONException error){
                Log.e("Error",error.getMessage());
            }

            return super.onSingleTapUp(e);
        }
    };
}

package com.example.nori.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {

    AppController mApp;
    private static com.android.volley.RequestQueue mQueue;
    private JSONObject mJsonObject;
    private JSONObject mActionObject;
    private GestureDetector mGesDetect;

    private String mSendURL="http://ec2-54-191-155-159.us-west-2.compute.amazonaws.com/getJson.php";
    private String mGetURL="http://ec2-54-191-155-159.us-west-2.compute.amazonaws.com/getJson.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mApp = (AppController)this.getApplication();
        // GestureDetecotorクラスのインスタンス生成
        mGesDetect = new GestureDetector(this, onGestureListener);
        mJsonObject = new JSONObject();
        mActionObject = new JSONObject();
        Time time = new Time();
        time.setToNow();
        String date = time.year + "-" + (time.month+1) + "-" + time.monthDay+" "+time.hour+":"+time.minute+":"+time.second;
        Log.v("Device", "-------------------------");
        Log.d("Device", android.os.Build.MODEL);
        Log.v("Device", "-------------------------");

        ImageButton ib = (ImageButton)findViewById(R.id.imageButton);
        ib.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

       if( isPlay(getIntent()) )
       {
           mApp.mIsPlayFlag=true;

       }else{
           mApp.mIsPlayFlag=false;

           try{
               mJsonObject.put("date",date);
               mJsonObject.put("device","Android");
               mJsonObject.put("os","Android");
               mJsonObject.put("name", Build.MODEL);
           }catch(JSONException error){
               Log.e("Error",error.getMessage());
           }

       }

    }

    private boolean isPlay(Intent intent){
        String action = intent.getAction();
        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = intent.getData();
            if (uri != null) {
                String session_id = uri.getQueryParameter("id");
                if(session_id!=null){
                    Log.d("Id :::::", session_id);

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onStop() {
        super.onStop();

        try{
            mJsonObject.put("action",mActionObject);
            Log.v("Json",mJsonObject.toString());
        }catch(JSONException ex){
            Log.e("Error",ex.getMessage());
        }
        if(!mApp.mIsPlayFlag)request(mSendURL,mJsonObject.toString());
    }


    public void request(String url,String Param){

        mQueue = Volley.newRequestQueue(getApplicationContext());
        // 送信したいパラメーター
        Map<String, String> params = new HashMap<String, String>();
        params.put("Json",mJsonObject.toString());
        // リクエストの初期設定
        MyRequest myRequest = new MyRequest(Request.Method.POST, url, myListener, myErrorListener);
        // リクエストのタイムアウトなどの設定
        myRequest.setRetryPolicy(new com.android.volley.DefaultRetryPolicy(
                10000,
                com.android.volley.DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                com.android.volley.DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        myRequest.setParams(params);
        // リクエストキューにリクエスト追加
        mQueue.add(myRequest);
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

    /**
     * レスポンス受信のリスナー
     */
    private Response.Listener<JSONObject> myListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

           // Log.d("TEST Success", response.toString());

            if(mApp.mIsPlayFlag)
            {
                try{
                    JSONObject jobject = new JSONObject(response.toString());

                }catch (JSONException ex){

                }

            }
        }
    };
    /**
     * リクエストエラーのリスナー
     */
    private com.android.volley.Response.ErrorListener myErrorListener = new com.android.volley.Response.ErrorListener() {
        @Override
        public void onErrorResponse(com.android.volley.VolleyError error) {
            Log.e("TEST", error.getMessage());
        }
    };

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

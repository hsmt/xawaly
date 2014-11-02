/**
 *  Copy right norifumi kawamoto 2014.11.2
 *
 */
package com.example.nori.myapplication;
import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by nori on 14/11/01.
 */
public class AppController extends Application {

    private static com.android.volley.RequestQueue mQueue;;
    public boolean mIsPlayFlag;
   // public int mActionNumber;
    public String mTrackId;

    private String mSendURL="http://ec2-54-191-155-159.us-west-2.compute.amazonaws.com/getJson.php";
    private String mGetURL="http://ec2-54-191-155-159.us-west-2.compute.amazonaws.com/sendJson.php";
    //private String mSendURL="http://172.16.30.6:8888/tracks/insert/";
    //  private String mGetURL="http://172.16.30.6:8888/tracks/record/1.json";

    public XawalyScheduleManager mXawalyScheduleManager;
    public XawalyJSONObject mXawalyJSONObject;

    public static final String TAG = AppController.class
            .getSimpleName();

    private RequestQueue mRequestQueue;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        mIsPlayFlag = false;
        mIsPlayFlag = false;
        mXawalyScheduleManager = XawalyScheduleManager.getInstance();
        mXawalyJSONObject = new XawalyJSONObject();
    }


    @Override
    public void onTerminate(){
        JSONObject jsonObject = mXawalyJSONObject.compileData();
        request(mSendURL,jsonObject.toString());
        Log.d("SendJson"," "+jsonObject.toString());
        super.onTerminate();
    }

    public void getPlayData(){
        request(mGetURL+mTrackId+".json","");
    }

    public void sendActionDate(JSONObject jo){ request(mSendURL,jo.toString());}

    public void request(String url,String Param){

        mQueue = Volley.newRequestQueue(getApplicationContext());
        // 送信したいパラメーター
        Map<String, String> params = new HashMap<String, String>();
        params.put("data", Param);
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

    /**
     * レスポンス受信のリスナー
     */
    private Response.Listener<JSONObject> myListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            Log.v("Request Success:",response.toString());
            if(mIsPlayFlag)
            {
                try{
                    JSONObject jobject = new JSONObject(response.toString());
                    XawalyJSONObject xo = new XawalyJSONObject(jobject);
                }catch (JSONException ex){
                    Log.v("JSONException", ex.getMessage());
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
            Log.e("Request Error", error.getMessage());
        }
    };



    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(JsonObjectRequest req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
/**
 *  Copy right norifumi kawamoto 2014.11.2
 *
 */
package com.example.nori.myapplication;

import java.util.ArrayList;

/**
 * Created by nori on 14/11/02.
 */
public class XawalyScheduleManager {

    private static XawalyScheduleManager mInstance;
    private ArrayList<XawalyActionTask> mActionTask;

    private XawalyScheduleManager(){
        mActionTask = new ArrayList<XawalyActionTask>();
    }

    public static XawalyScheduleManager getInstance(){
        if (mInstance==null){
            mInstance = new XawalyScheduleManager();
        }
        return mInstance;
    }
}

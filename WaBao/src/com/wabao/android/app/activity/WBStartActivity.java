package com.wabao.android.app.activity;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.wabao.android.app.R;
import com.wabao.android.app.entity.VersionInfo;
import com.wabao.android.app.util.AppUtils;
import com.wabao.android.app.util.Constants;
import com.wabao.android.app.util.SharedPreferencesManager;

public class WBStartActivity extends WBBaseActivity {

    private static final String KEY_VERSION_ID = "versionId";
    private static final String KEY_VERSION_DESCRIPTION = "description";
    private static final String KEY_VERSION_PUBLISH_DATE = "publishDate";

    private SharedPreferencesManager mPreManager;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPreManager = AppUtils.getSharedPreferencesManager();

        setContentView(R.layout.activity_loading);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                queryVersionInfo();

            }

        }, 1500);

    }

    private void queryVersionInfo() {
        String url = Constants.WEB_API_HOST + "/appversion/get/android";
        JsonObjectRequest versionRequest = new JsonObjectRequest(Method.GET,
                url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        /**
                         * {"versionId":"v2.0","description":"新增功能列表如下",
                         * "publishDate":123456789}
                         */
                        try {
                            String newVersionId = response
                                    .getString(KEY_VERSION_ID);
                            String description = response
                                    .getString(KEY_VERSION_DESCRIPTION);
                            long publishDate = response
                                    .getLong(KEY_VERSION_PUBLISH_DATE);

                            if (!TextUtils.isEmpty(newVersionId)) {
                                VersionInfo versionInfo = new VersionInfo(
                                        newVersionId, description, publishDate);

                                mPreManager.saveNewVersionInfo(versionInfo);
                            }

                        } catch (JSONException e) {
                            Log.e("VersionInfo", "parse version info failed");
                        }

                        loadingFinished();

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof NoConnectionError) {

                            Toast.makeText(mContext, "没有可用的网络",
                                    Toast.LENGTH_LONG).show();
                        }
                        loadingFinished();

                    }
                });

        AppUtils.getRequestQueue().add(versionRequest);
    }

    private void loadingFinished() {

        if (mPreManager.isFirstStart()) {
            jumpToActivity(WBIntroductionActivity.class);
            finish();
        } else {
            jumpToActivity(WBMainActivity.class);
            finish();
        }

    }

}

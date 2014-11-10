package com.wabao.android.app.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.wabao.android.app.R;

public class WBBaseActivity extends FragmentActivity {

    protected LinearLayout mContainer;
    protected ActionBar mActionBar;

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionBar = getActionBar();
        // 设置ActionBar左边默认的图标是否可用
        mActionBar.setDisplayShowHomeEnabled(false);

        mActionBar.setBackgroundDrawable(this.getResources().getDrawable(
                R.drawable.action_bar_bg));

        mContext = this;

    }

    protected void setTitle(String title) {

        if (title == null) {
            return;
        }
        mActionBar.setTitle(title);

    }

    protected void jumpToActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(mContext, cls);

        startActivity(intent);
    }

}

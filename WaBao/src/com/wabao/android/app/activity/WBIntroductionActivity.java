package com.wabao.android.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wabao.android.app.R;
import com.wabao.android.app.util.AppUtils;

public class WBIntroductionActivity extends WBBaseActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_introduction);

        mActionBar.hide();

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new IntroductionAdapter());
    }

    private class IntroductionAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 4;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ViewPager pager = (ViewPager) container;
            pager.removeView((View) object);
        }

        @Override
        public Object instantiateItem(View container, int position) {

            if (position == (getCount() - 1)) {

                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View view = inflater.inflate(R.layout.introduction_last_page,
                        null);

                Button button = (Button) view
                        .findViewById(R.id.introduction_end);

                button.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        AppUtils.getSharedPreferencesManager().setFirstStart(
                                false);
                        jumpToActivity(WBMainActivity.class);
                    }

                });

                ((ViewPager) container).addView(view);
                return view;

            } else {
                TextView tv = new TextView(mContext);
                tv.setText("introduction " + position);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(24);
                ((ViewPager) container).addView(tv);
                return tv;
            }

        }

    }
}

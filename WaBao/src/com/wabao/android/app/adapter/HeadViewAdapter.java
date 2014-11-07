package com.wabao.android.app.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class HeadViewAdapter extends PagerAdapter {

	private List<Integer> datas;
	private Context mContext;

	public HeadViewAdapter(Context ctx) {
		mContext = ctx;
	}

	public void setDatas(List<Integer> data) {
		datas = data;
	}

	@Override
	public int getCount() {
		if (datas != null) {
			return datas.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		ViewPager pager = (ViewPager) container;
		ImageView child = (ImageView) object;
		pager.removeView(child);
	}

	@Override
	public Object instantiateItem(View container, int position) {

		ImageView imageView = new ImageView(mContext);
		imageView.setBackgroundResource(datas.get(position));
		((ViewPager) container).addView(imageView);
		return imageView;

	}
}

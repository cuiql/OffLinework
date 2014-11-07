package com.wabao.android.app.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wabao.android.app.R;
import com.wabao.android.app.adapter.HeadViewAdapter;
import com.wabao.android.app.widget.HeadViewPager;
import com.wabao.android.app.widget.LinePageIndicator;

public class WBFragmentInProgress extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_inprogress, null);

		HeadViewPager viewPager = (HeadViewPager) rootView
				.findViewById(R.id.view_pager);

		List<Integer> datas = new ArrayList<Integer>();

		datas.add(R.drawable.content);
		datas.add(R.drawable.content);
		datas.add(R.drawable.content);
		datas.add(R.drawable.content);
		datas.add(R.drawable.content);

		HeadViewAdapter adapter = new HeadViewAdapter(getActivity());

		adapter.setDatas(datas);
		viewPager.setAdapter(adapter);
		LinePageIndicator indicator = (LinePageIndicator) rootView
				.findViewById(R.id.indicator);
		indicator.setViewPager(viewPager);

		ListView listView = (ListView) rootView.findViewById(R.id.list_view);

		listView.setAdapter(new ListViewAdapter());

		return rootView;
	}

	private class ListViewAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder;

			if (convertView != null) {
				viewHolder = (ViewHolder) convertView.getTag();

			} else {

				convertView = LayoutInflater.from(getActivity()).inflate(
						R.layout.item_inprogress_list, null);
				viewHolder = new ViewHolder();

				viewHolder.mThumbnail = (ImageView) convertView
						.findViewById(R.id.thumbnail);
				viewHolder.mTitle = (TextView) convertView
						.findViewById(R.id.title);

				viewHolder.mContent = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(viewHolder);
			}

			return convertView;
		}
	}

	private class ViewHolder {
		public ImageView mThumbnail;
		public TextView mTitle;
		public TextView mContent;
	}

}

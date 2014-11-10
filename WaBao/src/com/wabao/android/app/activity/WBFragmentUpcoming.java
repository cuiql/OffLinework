package com.wabao.android.app.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
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
import com.wabao.android.app.widget.CirclePageIndicator;
import com.wabao.android.app.widget.HeadViewPager;

public class WBFragmentUpcoming extends Fragment {

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
        CirclePageIndicator indicator = (CirclePageIndicator) rootView
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
						R.layout.item_upcoming_list, null);
				viewHolder = new ViewHolder();

				viewHolder.mThumbnail = (ImageView) convertView
						.findViewById(R.id.thumbnail);
				viewHolder.mTitle = (TextView) convertView
						.findViewById(R.id.title);

				viewHolder.mContent = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(viewHolder);
			}

			convertView.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					intent.setClass(getActivity(),
							WBQuestionnaireActivity.class);

					getActivity().startActivity(intent);

				}
			});

			return convertView;
		}
	}

	private class ViewHolder {
		public TextView mTime;
		public ImageView mThumbnail;
		public TextView mTitle;
		public TextView mContent;
	}
}
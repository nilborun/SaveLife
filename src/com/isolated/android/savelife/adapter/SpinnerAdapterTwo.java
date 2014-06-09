package com.isolated.android.savelife.adapter;

import com.isolated.android.savelife.util.BloodUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpinnerAdapterTwo extends ArrayAdapter<String> {

	private Context mContext;
	private int mTextViewResourceId;
	private String[] mBloods;

	public SpinnerAdapterTwo(Context context, int textViewResourceId,
			String[] bloodarray) {
		super(context, textViewResourceId);
		mContext = context;
		mTextViewResourceId = textViewResourceId;
		mBloods = bloodarray;

	}

	@Override
	public int getCount() {
		return mBloods.length;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mContext);
		textView.setText(mBloods[position]);
		return textView;
	}

	@Override
	public String getItem(int position) {
		return mBloods[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mContext);
		textView.setText(mBloods[position]);
		return textView;
	}
}

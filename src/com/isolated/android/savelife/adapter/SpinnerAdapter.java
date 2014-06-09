package com.isolated.android.savelife.adapter;

import com.isolated.android.savelife.util.BloodUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<BloodUtil> {
	private Context mContext;
	private int mTextViewResourceId;
	private BloodUtil[] mBloodUtils;

	public SpinnerAdapter(Context context, int textViewResourceId,
			BloodUtil[] bloodarray) {
		super(context, textViewResourceId);
		mContext = context;
		mTextViewResourceId = textViewResourceId;
		mBloodUtils = bloodarray;

	}

	@Override
	public int getCount() {
		return mBloodUtils.length;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mContext);
		textView.setText(mBloodUtils[position].getBloodGroup());
		return textView;
	}

	@Override
	public BloodUtil getItem(int position) {
		return mBloodUtils[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mContext);
		textView.setText(mBloodUtils[position].getBloodGroup());
		return textView;
	}

}

package com.isolated.android.savelife.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.util.RegistrationUtil;
import com.isolated.android.savelife.util.SaveLiftUtil;

public class DonarAdapter extends ArrayAdapter<RegistrationUtil>{
	private ArrayList<RegistrationUtil> mDonars;
	private Context mContext;
	private String mPhone;

	public DonarAdapter(Context context,ArrayList<RegistrationUtil> donars) {
		super(context, 0,donars);
		mDonars=donars;
		mContext=context;

	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView=inflater.inflate(R.layout.list_donar, parent,false);
		}
		TextView nameTextView=(TextView)convertView.findViewById(R.id.list_donarNameTextView);
		TextView addressTextView=(TextView)convertView.findViewById(R.id.list_donaraddressTextView);
		TextView mobileTextView=(TextView) convertView.findViewById(R.id.list_donarMobileTextView);
		RegistrationUtil donar=getItem(position);
		nameTextView.setText(donar.getDonarName());
		addressTextView.setText(donar.getAddress());
		mPhone=donar.getCompulsoryMobileNo();
		mobileTextView.setText(mPhone);
		
		return convertView;
	}

}

package com.isolated.android.savelife.activity;

import java.util.ArrayList;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.adapter.DonarAdapter;
import com.isolated.android.savelife.httpcommunication.AsyntaskFinished;
import com.isolated.android.savelife.httpcommunication.DonarSearch;
import com.isolated.android.savelife.httpcommunication.GetAllBloodGroups;
import com.isolated.android.savelife.httpcommunication.JsonParser;
import com.isolated.android.savelife.util.Constants;
import com.isolated.android.savelife.util.RegistrationUtil;
import com.isolated.android.savelife.util.SaveLiftUtil;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class BloodGroupFragment extends ListFragment implements
		AsyntaskFinished {
	private static RegistrationUtil mLoginUser;
	private static String mBloodGroup;
	
	public static BloodGroupFragment newInstance(RegistrationUtil user,String bloodGroup) {
		Bundle args = new Bundle();
		mLoginUser = user;
		mBloodGroup=bloodGroup;
		args.putSerializable(Constants.EXTRA_PARAM, mLoginUser);
		args.putString(Constants.EXTRA_BLOODGROUP, mBloodGroup);
		BloodGroupFragment bloodgroupFragment = new BloodGroupFragment();
		bloodgroupFragment.setArguments(args);
		return bloodgroupFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.donar_list_fragment, container,
				false);
		
		ListView listview=(ListView)view.findViewById(android.R.id.list);
		String url=SaveLiftUtil.createUrl(mLoginUser.getAddress(),mBloodGroup);
		new DonarSearch(getActivity(), url, this).execute();
		return view;
	}

	@Override
	public void finishAsyntask(String result) {
		if (null == result) {

		} else {
			ArrayList<RegistrationUtil> donars = JsonParser
					.getDonarList(result);
			DonarAdapter adapter = new DonarAdapter(getActivity(), donars);
			setListAdapter(adapter);
		}

	}

}

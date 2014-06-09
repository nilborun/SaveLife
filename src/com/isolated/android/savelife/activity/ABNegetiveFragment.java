package com.isolated.android.savelife.activity;

import java.util.ArrayList;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.adapter.DonarAdapter;
import com.isolated.android.savelife.httpcommunication.AsyntaskFinished;
import com.isolated.android.savelife.httpcommunication.DonarSearch;
import com.isolated.android.savelife.httpcommunication.JsonParser;
import com.isolated.android.savelife.util.Constants;
import com.isolated.android.savelife.util.RegistrationUtil;
import com.isolated.android.savelife.util.SaveLiftUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class ABNegetiveFragment extends ListFragment implements AsyntaskFinished {
	private static RegistrationUtil mLoginUser;
	private Button mCountButton;

	public static ABNegetiveFragment newInstance(RegistrationUtil user) {
		Bundle args = new Bundle();
		mLoginUser = user;
		args.putSerializable(Constants.EXTRA_PARAM, mLoginUser);
		ABNegetiveFragment abNegetiveFragment = new ABNegetiveFragment();
		abNegetiveFragment.setArguments(args);
		return abNegetiveFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.donar_list_fragment, container,
				false);
		ListView listview=(ListView)view.findViewById(android.R.id.list);
		String url=SaveLiftUtil.createUrl(mLoginUser.getAddress(),Constants.BLOOD_AB_NEGETIVE);
		new DonarSearch(getActivity(), url, this).execute();
		return view;
	}
	
	

	@Override
	public void finishAsyntask(String result) {
		if(null==result){
			
		}else{
			ArrayList<RegistrationUtil> donars=JsonParser.getDonarList(result);
			DonarAdapter adapter=new DonarAdapter(getActivity(), donars);
			setListAdapter(adapter);
		}
		
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		RegistrationUtil donar = ((DonarAdapter) getListAdapter())
				.getItem(position);
		FragmentManager fm = getActivity().getSupportFragmentManager();
		OptionDialog optionDialog = OptionDialog.newInstanc(donar
				.getCompulsoryMobileNo());
		optionDialog.setTargetFragment(ABNegetiveFragment.this, 0);
		optionDialog.show(fm, "option");

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == Constants.EXTRA_REQUEST_FOR_DIAL) {
			String phone = (String) data
					.getSerializableExtra(Constants.EXTRA_PHONENO);
			SaveLiftUtil.dialNumber(phone, getActivity());

		}
		if (requestCode == Constants.EXTRA_REQUEST_FOR_SMS) {
			String phone = (String) data
					.getSerializableExtra(Constants.EXTRA_PHONENO);
			SaveLiftUtil.smsNumber(phone, getActivity());
		}

	}

}

package com.isolated.android.savelife.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.adapter.SpinnerAdapterTwo;
import com.isolated.android.savelife.httpcommunication.AsyntaskFinished;
import com.isolated.android.savelife.httpcommunication.GetAllBloodGroups;
import com.isolated.android.savelife.httpcommunication.JsonParser;
import com.isolated.android.savelife.httpcommunication.LoginDonar;
import com.isolated.android.savelife.util.BloodUtil;
import com.isolated.android.savelife.util.Constants;
import com.isolated.android.savelife.util.RegistrationUtil;

public class MainPlaceHolderFragment extends Fragment implements
		AsyntaskFinished {
	public static final String TAG = "LoginFragment";
	private Spinner mBloodSpinner;
	private EditText mMobileNoEditText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		mBloodSpinner = (Spinner) view.findViewById(R.id.login_blood_group);
		Button registerButton = (Button) view
				.findViewById(R.id.register_button);
		Button loginButton = (Button) view.findViewById(R.id.login_button);
		mMobileNoEditText = (EditText) view.findViewById(R.id.login_mobile_no);

		initializeSpinner();
		registerButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				startActivity(new Intent(getActivity(),
						RegistrationActivity.class));
			}
		});

		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String mobileNo = mMobileNoEditText.getText().toString();
				String bloodGroup = mBloodSpinner.getSelectedItem().toString();
				String urlSegment = "mobileNo=" + mobileNo + "& bloodgroup="
						+ bloodGroup;
				doLogin(urlSegment);
			}
		});
		return view;
	}

	private void doLogin(String urlSegment) {
		new LoginDonar(getActivity(), Constants.LOGIN_URL + urlSegment, this)
				.execute();

	}

	private void initializeSpinner() {
		String[] bloodarray = BloodUtil.getAllBloodGroups();
		SpinnerAdapterTwo spinnerAdapter = new SpinnerAdapterTwo(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, bloodarray);
		mBloodSpinner.setAdapter(spinnerAdapter);
	}

	@Override
	public void finishAsyntask(String result) {
		if (null == result) {
			Toast.makeText(getActivity(), "please check internet connection",
					Toast.LENGTH_LONG).show();
		} else {
			boolean doLogin = JsonParser.getServerResponseForLogin(result);
			if (doLogin) {
				ArrayList<RegistrationUtil> users=JsonParser.getDonarList(result);
				RegistrationUtil user=users.get(0);
				
				Intent intent=new Intent(getActivity(), TabActivity.class);
				intent.putExtra(TabActivity.EXTRA_LOGIN_USER, user);
				startActivity(intent);
			} else {
				Toast.makeText(getActivity(),
						"please provide valid information", Toast.LENGTH_LONG)
						.show();
			}
		}

	}

}

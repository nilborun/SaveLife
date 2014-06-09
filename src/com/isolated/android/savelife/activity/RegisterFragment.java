package com.isolated.android.savelife.activity;

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
import com.isolated.android.savelife.httpcommunication.JsonParser;
import com.isolated.android.savelife.httpcommunication.RegisterDonar;
import com.isolated.android.savelife.util.BloodUtil;
import com.isolated.android.savelife.util.Constants;
import com.isolated.android.savelife.util.RegistrationUtil;

public class RegisterFragment extends Fragment implements AsyntaskFinished {
	EditText mNameEditText, mMobileNoOneEditText, mMobileNoTwoEditText,
			mAddressEditText, mPasswordEditText;
	Spinner mBloodSpinner;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_registration, container,
				false);
		mBloodSpinner = (Spinner) view.findViewById(R.id.register_blood_group);
		initializaSpinner();
		Button registerOkButton = (Button) view
				.findViewById(R.id.registerOk_button);
		mNameEditText = (EditText) view
				.findViewById(R.id.register_donarName_EditText);
		mMobileNoOneEditText = (EditText) view
				.findViewById(R.id.register_donarMobileNoOne_EditText);
		mAddressEditText = (EditText) view
				.findViewById(R.id.register_donarAddress_EditText);
		mPasswordEditText = (EditText) view
				.findViewById(R.id.register_donarPassword_EditText);
		registerOkButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String name = mNameEditText.getText().toString();
				String mobNoOne = mMobileNoOneEditText.getText().toString();
				String address = mAddressEditText.getText().toString();
				String password = mPasswordEditText.getText().toString();
				String blood = mBloodSpinner.getSelectedItem().toString();
				RegistrationUtil donar = new RegistrationUtil(name, mobNoOne,address, password, blood);
				createDonar(donar);

			}
		});
		return view;
	}

	private void createDonar(RegistrationUtil donar) {
		new RegisterDonar(getActivity(), Constants.ADD_DONAR_URL, donar, this)
				.execute();
	}

	private void initializaSpinner() {
		String[] bloodarray = BloodUtil.getAllBloodGroups();
		SpinnerAdapterTwo spinnerAdapter = new SpinnerAdapterTwo(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, bloodarray);
		mBloodSpinner.setAdapter(spinnerAdapter);
	}

	@Override
	public void finishAsyntask(String result) {
		if (null == result) {
			Toast.makeText(getActivity(), "Please check internet connection",
					Toast.LENGTH_LONG).show();
		} else {
			String message = JsonParser.getServerResponsForAddingDonar(result);
			Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
		}

	}

}

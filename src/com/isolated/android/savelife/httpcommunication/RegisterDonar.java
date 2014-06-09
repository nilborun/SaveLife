package com.isolated.android.savelife.httpcommunication;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;

import com.isolated.android.savelife.util.RegistrationUtil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class RegisterDonar extends AsyncTask<String, Integer, String> {

	private Context mContext;
	private String mUrl;
	private AsyntaskFinished mAsyntaskFinished;
	private String mRespons;
	private RegistrationUtil mRegistrationUtil;
	private ProgressDialog mProgressDialog;

	public RegisterDonar(Context context, String url, RegistrationUtil donar,
			AsyntaskFinished asyntaskFinished) {
		mContext = context;
		mUrl = url;
		mAsyntaskFinished = asyntaskFinished;
		mRegistrationUtil = donar;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		mProgressDialog=ProgressDialog.show(mContext, "","please wait...");
	}

	@Override
	protected String doInBackground(String... arg0) {
		if (ConnectionManager.hasInternetConnection(mContext)) {
			ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			params.add(new BasicNameValuePair("name", mRegistrationUtil
					.getDonarName()));
			params.add(new BasicNameValuePair("mobileNoOne", mRegistrationUtil
					.getCompulsoryMobileNo()));
			params.add(new BasicNameValuePair("address", mRegistrationUtil
					.getAddress()));
			params.add(new BasicNameValuePair("upassword", mRegistrationUtil
					.getPassword()));
			params.add(new BasicNameValuePair("bloodGroup", mRegistrationUtil
					.getBlood()));

			mRespons = ConnectionManager.postRequestToServer(mUrl, params);

		} else {
			mRespons = null;
		}
		return mRespons;

	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		mProgressDialog.dismiss();
		mAsyntaskFinished.finishAsyntask(result);
	}

}

package com.isolated.android.savelife.httpcommunication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class DonarSearch extends AsyncTask<String, Integer, String> {

	private Context mContext;
	private String mUrl;
	private AsyntaskFinished mAsyntaskFinished;
	private String mRespons;
	private ProgressDialog mProgressDialog;

	public DonarSearch(Context context, String url,
			AsyntaskFinished asyntaskFinished) {
		mContext = context;
		mUrl = url;
		mAsyntaskFinished = asyntaskFinished;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		mProgressDialog = ProgressDialog.show(mContext, "", "please wait...");
	}

	@Override
	protected String doInBackground(String... params) {
		if (ConnectionManager.hasInternetConnection(mContext)) {
			mRespons = ConnectionManager.getRequestFromServer(mUrl);
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

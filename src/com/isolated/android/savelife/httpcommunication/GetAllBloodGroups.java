package com.isolated.android.savelife.httpcommunication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class GetAllBloodGroups extends AsyncTask<String, Integer, String> {
	private Context mContext;
	private String mUrl;
	private AsyntaskFinished mAsyntaskFinished;
	private String mRespons;
	

	public GetAllBloodGroups(Context context, String url,
			AsyntaskFinished asyntaskFinished) {
		mContext = context;
		mUrl = url;
		mAsyntaskFinished = asyntaskFinished;
	}
	

	@Override
	protected String doInBackground(String... params) {
		if(ConnectionManager.hasInternetConnection(mContext)){
			mRespons=ConnectionManager.getRequestFromServer(mUrl);
		}else{
			mRespons=null;
		}
		return mRespons;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		mAsyntaskFinished.finishAsyntask(result);
	}

}

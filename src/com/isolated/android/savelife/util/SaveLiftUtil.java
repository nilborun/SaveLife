package com.isolated.android.savelife.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class SaveLiftUtil {

	public static String createUrl(String address, String bloodGroup) {
		String url = Constants.SEARCH_DONAR_URL + "address=" + address
				+ "& bloodgroup=" + bloodGroup;
		return url;
	}

	public static void dialNumber(String mobileNo, Context context) {
		Uri number = Uri.parse("tel:" + mobileNo);
		Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
		context.startActivity(callIntent);
	}

	public static void smsNumber(String mobileNo, Context context) {

		Intent smsIntent = new Intent(Intent.ACTION_VIEW);
		smsIntent.setType("vnd.android-dir/mms-sms");
		smsIntent.putExtra("address", mobileNo);
		smsIntent.putExtra("sms_body", "I have a patient. We need blood.");
		context.startActivity(smsIntent);

	}
}

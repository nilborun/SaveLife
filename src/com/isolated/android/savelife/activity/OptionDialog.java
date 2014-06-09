package com.isolated.android.savelife.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.util.Constants;
import com.isolated.android.savelife.util.SaveLiftUtil;

public class OptionDialog extends DialogFragment {
	private static String mPhone;
	
	public static OptionDialog newInstanc(String phoneNo) {
		Bundle bundle = new Bundle();
		mPhone = phoneNo;
		bundle.putString(Constants.EXTRA_PHONNO_DIALOG_PARAM, mPhone);
		OptionDialog optionDialog = new OptionDialog();
		optionDialog.setArguments(bundle);
		return optionDialog;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		View view = getActivity().getLayoutInflater().inflate(
				R.layout.choice_option, null);
		LinearLayout callerLayout = (LinearLayout) view
				.findViewById(R.id.caller_layout);
		LinearLayout smsLayout = (LinearLayout) view
				.findViewById(R.id.sms_layout);
		callerLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sendResult(Activity.RESULT_OK,Constants.EXTRA_REQUEST_FOR_DIAL);
				
				
			}
		});
		smsLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sendResult(Activity.RESULT_OK,Constants.EXTRA_REQUEST_FOR_SMS);

			}
		});
		return new AlertDialog.Builder(getActivity()).setView(view)
				.setTitle("Choose an option")
				.setPositiveButton("OK", new OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {

					}
				}).create();
	}

	public void sendResult(int resultCode,int requestCode) {
		if (getTargetFragment() == null)
			return;
		Intent intent = new Intent();
		intent.putExtra(Constants.EXTRA_PHONENO, mPhone);
		getTargetFragment().onActivityResult(requestCode,
				resultCode, intent);
	}

}

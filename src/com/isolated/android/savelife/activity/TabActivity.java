package com.isolated.android.savelife.activity;

import com.isolated.android.savelife.util.RegistrationUtil;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class TabActivity extends SingleFragmentActitvity {
	public static final String EXTRA_LOGIN_USER="extraloginuser";
	RegistrationUtil mUser;

	@Override
	public Fragment creatFragment() {
		if(getIntent().hasExtra(EXTRA_LOGIN_USER)){
			 mUser=(RegistrationUtil) getIntent().getSerializableExtra(EXTRA_LOGIN_USER);
		}
		//return new TabFragment();
		return TabFragment.newInstance(mUser);
	}

}

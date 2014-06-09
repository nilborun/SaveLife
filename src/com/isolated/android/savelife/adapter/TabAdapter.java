package com.isolated.android.savelife.adapter;

import com.isolated.android.savelife.activity.ABNegetiveFragment;
import com.isolated.android.savelife.activity.ABPositiveFragment;
import com.isolated.android.savelife.activity.ANegetiveFragment;
import com.isolated.android.savelife.activity.APositiveFragment;
import com.isolated.android.savelife.activity.BNegetiveFragment;
import com.isolated.android.savelife.activity.BPositveFragment;
import com.isolated.android.savelife.activity.BloodGroupFragment;
import com.isolated.android.savelife.activity.ONegetiveFragment;
import com.isolated.android.savelife.activity.OPositiveFragment;
import com.isolated.android.savelife.util.Constants;
import com.isolated.android.savelife.util.RegistrationUtil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

	private static final int TOTAL_FRAGMENT=8;
	private RegistrationUtil mLoginUser;
	public TabAdapter(FragmentManager fm,RegistrationUtil user) {
		super(fm);
		mLoginUser=user;
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return APositiveFragment.newInstance(mLoginUser);
		case 1:
			return ANegetiveFragment.newInstance(mLoginUser);
		case 2:
			return BPositveFragment.newInstance(mLoginUser);
		case 3:
			return BNegetiveFragment.newInstance(mLoginUser);
		case 4:
			return ABPositiveFragment.newInstance(mLoginUser);
		case 5:
			return ABNegetiveFragment.newInstance(mLoginUser);
		case 6:
			return OPositiveFragment.newInstance(mLoginUser);
		case 7:
			return ONegetiveFragment.newInstance(mLoginUser);

		default:
			return null;
		}


	}
	
	/*@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_A_POSITIVE);
		case 1:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_A_NEGETIVE);
		case 2:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_B_POSITIVE);
		case 3:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_B_NEGETIVE);
		case 4:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_AB_POSITIVE);
		case 5:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_AB_NEGETIVE);
		case 6:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_O_POSITIVE);
		case 7:
			return BloodGroupFragment.newInstance(mLoginUser, Constants.BLOOD_O_NEGETIVE);

		default:
			return null;
		}

	}*/

	@Override
	public int getCount() {
		return TOTAL_FRAGMENT;
	}

}

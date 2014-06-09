package com.isolated.android.savelife.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.adapter.TabAdapter;
import com.isolated.android.savelife.util.RegistrationUtil;

public class TabFragment extends Fragment implements ActionBar.TabListener {
	private ViewPager mViewPager;
	private ActionBar mActionBar;
	private TabAdapter mTabAdapter;
	private String[] mBloodArray = new String[] { "A+", "A-", "B+", "B-",
			"AB+", "AB-", "O+", "O-" };
	private static RegistrationUtil mUser;
	public static final String LOGIN_USER="loginuser";
	
	public static TabFragment newInstance(RegistrationUtil user){
		Bundle args=new Bundle();
		mUser=user;
		args.putSerializable(LOGIN_USER, mUser);
		TabFragment tabFragment=new TabFragment();
		tabFragment.setArguments(args);
		return tabFragment;
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tab_swaipe, container,
				false);
		mViewPager = (ViewPager) view.findViewById(R.id.pager);
		mActionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
		mTabAdapter = new TabAdapter(
				((ActionBarActivity) getActivity()).getSupportFragmentManager(),mUser);
		mViewPager.setAdapter(mTabAdapter);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mActionBar.setHomeButtonEnabled(true);
		for (String tab : mBloodArray) {
			mActionBar.addTab(mActionBar.newTab().setText(tab)
					.setTabListener(this));
		}
		
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				mActionBar.setSelectedNavigationItem(position);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		return view;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

	}

}

package com.isolated.android.savelife.util;

public class BloodUtil {
	private int mId;
	private String mBloodGroup;
	private static String[] mBloods=new String[]{"A+","A-","B+","B-","O+","O-","AB+","AB-"};
	public BloodUtil(){}
	public BloodUtil(int id,String mBloodGroup) {
		this.mId=id;
		this.mBloodGroup = mBloodGroup;
	}
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getBloodGroup() {
		return mBloodGroup;
	}
	public void setBloodGroup(String mBloodGroup) {
		this.mBloodGroup = mBloodGroup;
	}
	
	public static String[] getAllBloodGroups(){
		return mBloods;
	}

}

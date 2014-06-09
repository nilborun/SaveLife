package com.isolated.android.savelife.util;

import java.io.Serializable;

public class RegistrationUtil implements Serializable {
	private int mId;
	private String mDonarName;
	private String mCompulsoryMobileNo;
	private String mAddress;
	private String mPassword;
	private String mBlood;

	public String getDonarName() {
		return mDonarName;
	}

	public void setDonarName(String mDonarName) {
		this.mDonarName = mDonarName;
	}

	public int getId() {
		return mId;
	}

	public void setId(int mId) {
		this.mId = mId;
	}

	public String getCompulsoryMobileNo() {
		return mCompulsoryMobileNo;
	}

	public void setCompulsoryMobileNo(String mCompulsoryMobileNo) {
		this.mCompulsoryMobileNo = mCompulsoryMobileNo;
	}

	public String getAddress() {
		return mAddress;
	}

	public void setAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getPassword() {
		return mPassword;
	}

	public void setPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getBlood() {
		return mBlood;
	}

	public void setBlood(String mBlood) {
		this.mBlood = mBlood;
	}

	public RegistrationUtil() {
	}

	public RegistrationUtil(String mDonarName, String mCompulsoryMobileNo,
			String mAddress, String mPassword, String mBlood) {
		super();
		this.mDonarName = mDonarName;
		this.mCompulsoryMobileNo = mCompulsoryMobileNo;
		this.mAddress = mAddress;
		this.mPassword = mPassword;
		this.mBlood = mBlood;
	}

}

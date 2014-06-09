package com.isolated.android.savelife.httpcommunication;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.isolated.android.savelife.util.BloodUtil;
import com.isolated.android.savelife.util.RegistrationUtil;

public class JsonParser {

	public static ArrayList<BloodUtil> getAllBloodsgroup(String result) {
		ArrayList<BloodUtil> bloodGroups = new ArrayList<BloodUtil>();
		try {
			JSONObject jsonObj = new JSONObject(result);
			String success = jsonObj.getString("success");
			if (success.equals("1")) {
				JSONArray bloodsArray = jsonObj.getJSONArray("bloodgroups");
				for (int i = 0; i < bloodsArray.length(); i++) {
					JSONObject bloodObject = bloodsArray.getJSONObject(i);
					int id = Integer.parseInt(bloodObject.getString("id")
							.toString());
					String bloodGroup = bloodObject.getString("group");
					BloodUtil blood = new BloodUtil(id, bloodGroup);
					bloodGroups.add(blood);
				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bloodGroups;
	}

	public static String getServerResponsForAddingDonar(String result) {
		String responseMessage = null;
		JSONObject jsonbObj;
		try {
			jsonbObj = new JSONObject(result);
			String success = jsonbObj.getString("success");
			if (success.equals("1")) {
				responseMessage = "Registration is complete. Now It is need admin aproval.";
			} else {
				responseMessage = "Registration is not complete.";
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseMessage;
	}

	public static boolean getServerResponseForLogin(String result) {
		String responseMessage = null;
		JSONObject jsonbObj;
		try {
			jsonbObj = new JSONObject(result);
			String success = jsonbObj.getString("success");
			if (success.equals("1")) {
				responseMessage = "Log in success";
				return true;
			} else {
				responseMessage = "please provide correct information.";
				return false;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public static ArrayList<RegistrationUtil> getDonarList(String result){
		ArrayList<RegistrationUtil> donars = new ArrayList<RegistrationUtil>();
		try {
			JSONObject jsonObj = new JSONObject(result);
			String success = jsonObj.getString("success");
			if (success.equals("1")) {
				JSONArray donarsArray = jsonObj.getJSONArray("donars");
				for (int i = 0; i < donarsArray.length(); i++) {
					JSONObject donaObject = donarsArray.getJSONObject(i);
					int id=Integer.parseInt(donaObject.getString("id"));
					String name=donaObject.getString("name").toString();
					String mobNoOne=donaObject.getString("mobileNoOne").toString();
					String address=donaObject.getString("address");
					String blood=donaObject.getString("bloodgroup");
					RegistrationUtil donar=new RegistrationUtil();
					donar.setId(id);
					donar.setDonarName(name);
					donar.setCompulsoryMobileNo(mobNoOne);
					donar.setAddress(address);
					donar.setBlood(blood);
					donars.add(donar);
				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donars;
	}

}

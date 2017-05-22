/**
 * 
 */
package com.ciii.police.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ciii.police.buffer.OldPeopleInfo;
import com.ciii.police.database.operator.CommunitiesMapOperator;
import com.ciii.police.database.operator.EldersMapOperator;
import com.ciii.police.database.operator.UsernameIdMapOperator;
import com.ciii.police.http.HttpUtil;
import com.ciii.police.model.database.InputOldPeoples;
//import com.ciii.police.model.database.OldPeopleMapOperator;
import com.ciii.police.model.request.oldpeople.InputAlarm;
import com.ciii.police.model.request.oldpeople.InputLocation;
import com.ciii.police.model.request.oldpeople.InputNanGongCommunityIdElders;
import com.ciii.police.model.request.oldpeople.InputNanGongUserLogin;
import com.ciii.police.model.request.oldpeople.InputNanGongUsernameID;
import com.ciii.police.model.request.oldpeople.InputTrack;
import com.ciii.police.model.response.oldpeople.OutputAlarms;
import com.ciii.police.model.response.oldpeople.OutputLocation;
import com.ciii.police.model.response.oldpeople.OutputTrack;
import com.ciii.police.trans.JsonToOldPeopleOutput;
import com.ciii.police.trans.TimeTransfer;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
public final class OldPeopleManager {
	private static final String OldPeopleURL1 = "http://dw.paznyl.cn:50404";
	private static final String OldPeopleURL2 = "http://dev.zxbhome.com/app";
	private static final String param = "UTF-8";
	//private static final Integer sendTimes = 3;
	
	/**
	 * 
	 */
	public boolean getAllCommunities(){
		String subURL = "/communities/all";
		
		//InputNanGongCommunitiesAll in = new InputNanGongCommunitiesAll();
		//in.setSkip(0);
		//in.setTake(50);
		
		String url = OldPeopleURL2+subURL;
		String retAlarmInfo = HttpUtil.sendGet(url, param);
		
		OldPeopleInfo.setOutputNanGongCommunitiesAll(JsonToOldPeopleOutput.JsonToOutputNanGongCommunitiesAll(retAlarmInfo));
		
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public boolean getUserName() throws SQLException{
		String subURL = "/username/";
		
		InputNanGongUsernameID in = new InputNanGongUsernameID();
		ArrayList<String> id = CommunitiesMapOperator.getManager();
		for(int index = 0; index < id.size(); index++){
			in.setId(id.get(index));
			String url = OldPeopleURL2+subURL+in.toString();
			String retUsernameInfo = HttpUtil.sendGet(url, param);
			OldPeopleInfo.addOutputNanGongUsernameIDList(JsonToOldPeopleOutput.JsonToOutputNanGongUsernameID(retUsernameInfo));
		}
		
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public boolean getUserLogin() throws SQLException{
		String subURL = "/user/login";
		
		InputNanGongUserLogin in = new InputNanGongUserLogin();
		ArrayList<String> result = UsernameIdMapOperator.getResult();
		for(int index = 0; index < result.size(); index++){
			in.setEmail(result.get(index));
			String url = OldPeopleURL2+subURL;
			String param = in.toString();
			String retUsernameInfo = HttpUtil.sendPostUrl(url, param);
			OldPeopleInfo.addOutputNanGongUserLoginList(JsonToOldPeopleOutput.JsonToOutputNanGongUserLogin(retUsernameInfo, result.get(index)));
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	public boolean getCommunityIdElders() throws SQLException{
		String subURL = "/community/";
		InputOldPeoples in = new InputOldPeoples();
		UsernameIdMapOperator.getResultTokenUid(in);
		CommunitiesMapOperator.getGidTitleByManager(in);
		for(int index = 0; index < in.getData().size(); index++){
			for(int i = 0; i < in.getData().get(index).getGidArr().size(); i++){
				InputNanGongCommunityIdElders communityIdElder = new InputNanGongCommunityIdElders();
				communityIdElder.setId(in.getData().get(index).getGidArr().get(i));
				communityIdElder.setAccess_token(in.getData().get(index).getToken());
				communityIdElder.setUid(in.getData().get(index).getUid());
				String url = OldPeopleURL2+subURL+communityIdElder.toString();
				String retCommunityIdElderInfo = HttpUtil.sendGet(url, param);
				OldPeopleInfo.addOutputNanGongCommunityIdEldersList(JsonToOldPeopleOutput.JsonToOutputNanGongCommunityIdElders(retCommunityIdElderInfo, in.getData().get(index).getTitleArr().get(i)));
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	public boolean getAlarmInfo(String userid, String endTime) throws ParseException, java.text.ParseException{
		String subURL = "/alarms";
		
		OutputAlarms out = new OutputAlarms();
		String retAlarmInfo = "";
		String url = "";
		Integer limit = 50;
		Integer skip = 0 - limit;
		
		InputAlarm in = new InputAlarm();
		in.setUserId(userid);
		in.setAlarmType(0);
		in.setLimit(limit);
		in.setTime(TimeTransfer.dateToStamp(endTime));
		
		JsonToOldPeopleOutput.initTotalDesiredAlarmNum();
		
		do{
			skip += limit;
			in.setSkip(skip);
			url = OldPeopleURL1+subURL+in.toString();
			retAlarmInfo = HttpUtil.sendGet(url, param);
		}while(JsonToOldPeopleOutput.JsonToOutputAlarms(retAlarmInfo, out, limit, skip));
		
		OldPeopleInfo.addOutputAlarmsList(out);
		
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public boolean getLocationInfo(String oldpeoplephone) throws SQLException{
		String subURL = "/location";
		
		InputLocation in = new InputLocation();
		String userId = EldersMapOperator.GetUserIdByphone(oldpeoplephone);
		if(userId.equals("")){
			return false;
		}
		in.setUserId(userId);
		in.setLocateType(-1);
		
		String url = OldPeopleURL1+subURL+in.toString();
		String retLocationInfo = HttpUtil.sendGet(url, param);
		
		OutputLocation out = JsonToOldPeopleOutput.JsonToOutputLocation(retLocationInfo);
		
		OldPeopleInfo.setOutputLocation(out);
				
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public boolean getTrackInfo(String startTime, String endTime, String oldpeoplephone) throws ParseException, java.text.ParseException, SQLException{
		String subURL = "/track";
		
		OutputTrack outputTrack = new OutputTrack();
		String retTrackInfo = "";
		String url = "";
		Integer limit = 50;
		Integer skip = 0 - limit;
		
		InputTrack trackInput = new InputTrack();
		String userId = EldersMapOperator.GetUserIdByphone(oldpeoplephone);
		if(userId.equals("")){
			return false;
		}
		trackInput.setUserId(userId);
		trackInput.setLocateType(1);
		trackInput.setLimit(50);
		trackInput.setSkip(0);
		trackInput.setStart(TimeTransfer.dateToStamp(startTime));
		trackInput.setEnd(TimeTransfer.dateToStamp(endTime));
		
		do{
			skip += limit;
			trackInput.setSkip(skip);
			url = OldPeopleURL1+subURL+trackInput.toString();
			retTrackInfo = HttpUtil.sendGet(url, param);
		}while(JsonToOldPeopleOutput.JsonToOutputTrack(retTrackInfo, outputTrack, limit, skip));
		
		OldPeopleInfo.setOutputTrack(outputTrack);
		
		return true;
	}
}

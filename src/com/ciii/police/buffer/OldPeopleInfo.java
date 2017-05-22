/**
 * 
 */
package com.ciii.police.buffer;

import java.util.ArrayList;

import com.ciii.police.model.response.oldpeople.OutputAlarms;
import com.ciii.police.model.response.oldpeople.OutputLocation;
import com.ciii.police.model.response.oldpeople.OutputNanGongCommunitiesAll;
import com.ciii.police.model.response.oldpeople.OutputNanGongCommunityIdElders;
import com.ciii.police.model.response.oldpeople.OutputNanGongUserLogin;
import com.ciii.police.model.response.oldpeople.OutputNanGongUsernameID;
import com.ciii.police.model.response.oldpeople.OutputTrack;
import com.ciii.police.model.web.oldpeople.AlarmMessageInfo;
import com.ciii.police.model.web.oldpeople.AlarmPositionInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
public final class OldPeopleInfo {
	private static OutputNanGongCommunitiesAll outputNanGongCommunitiesAll;
	private static ArrayList<OutputNanGongUsernameID> outputNanGongUsernameIDList;
	private static ArrayList<OutputNanGongUserLogin> outputNanGongUserLoginList;
	private static ArrayList<OutputNanGongCommunityIdElders> outputNanGongCommunityIdEldersList;
	private static ArrayList<OutputAlarms> outputAlarmsInfoList;
	private static OutputLocation outputLocation;
	private static OutputTrack outputTrack;
	private static long totalOldPeople;
	private static long onlineOldPeople;
	private static long Untreatedalarm;
	private static long totalalarm;
	private static ArrayList<AlarmPositionInfo> alarmPositionInfoList = new ArrayList<AlarmPositionInfo>();
	private static ArrayList<AlarmMessageInfo> alarmMessageInfoList = new ArrayList<AlarmMessageInfo>();
	
	/**
	 * @return 
	 * 
	 */
	public static final void initOldPeopleInfo(){
		outputNanGongCommunitiesAll = new OutputNanGongCommunitiesAll();
		outputNanGongUsernameIDList = new ArrayList<OutputNanGongUsernameID>();
		outputNanGongUserLoginList = new ArrayList<OutputNanGongUserLogin>();
		outputNanGongCommunityIdEldersList = new ArrayList<OutputNanGongCommunityIdElders>();
		outputAlarmsInfoList = new ArrayList<OutputAlarms>();
		outputLocation = new OutputLocation();
		outputTrack = new OutputTrack();
		totalOldPeople = 0;
		onlineOldPeople = 0;
		Untreatedalarm = 0;
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongCommunitiesAll(){
		outputNanGongCommunitiesAll = new OutputNanGongCommunitiesAll();
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongUsernameID(){
		outputNanGongUsernameIDList = new ArrayList<OutputNanGongUsernameID>();
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongUserLogin(){
		outputNanGongUserLoginList = new ArrayList<OutputNanGongUserLogin>();
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongCommunityIdElders(){
		outputNanGongCommunityIdEldersList = new ArrayList<OutputNanGongCommunityIdElders>();
	}
	
	/**
	 * 
	 */
	public static final void initOutputAlarmsInfoList(){
		outputAlarmsInfoList = new ArrayList<OutputAlarms>();
	}
	
	/**
	 * 
	 */
	public static final void initOutputLocation(){
		outputLocation = new OutputLocation();
	}
	
	/**
	 * 
	 */
	public static final void initOutputTrack(){
		outputTrack = new OutputTrack();
	}
	
	/**
	 * 
	 */
	public static final void initAlarmPositionInfo(){
		alarmPositionInfoList = new ArrayList<AlarmPositionInfo>();
	}
	
	/**
	 * 
	 */
	public static final void initAlarmMessageInfo(){
		alarmMessageInfoList = new ArrayList<AlarmMessageInfo>();
	}
	
	/**
	 * 
	 */
	public static final void initTotalOldPeople(){
		totalOldPeople = 0;
	}
	
	/**
	 * 
	 */
	public static final void initOnlineOldPeople(){
		onlineOldPeople = 0;
	}
	
	/**
	 * 
	 */
	public static final void initUntreatedAlarm(){
		Untreatedalarm = 0;
	}
	
	/**
	 * 
	 */
	public static final void initTotalalarm(){
		totalalarm = 0;
	}
	
	/**
	 * 
	 */
	public static final OutputNanGongCommunitiesAll getOutputNanGongCommunitiesAll() {
		return outputNanGongCommunitiesAll;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongCommunitiesAll(OutputNanGongCommunitiesAll outputNanGongCommunitiesAll) {
		OldPeopleInfo.outputNanGongCommunitiesAll = outputNanGongCommunitiesAll;
	}

	/**
	 * 
	 */
	public static final ArrayList<OutputNanGongUsernameID> getOutputNanGongUsernameIDList() {
		return outputNanGongUsernameIDList;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongUsernameIDList(
			ArrayList<OutputNanGongUsernameID> outputNanGongUsernameIDList) {
		OldPeopleInfo.outputNanGongUsernameIDList = outputNanGongUsernameIDList;
	}
	
	/**
	 * 
	 */
	public static final void addOutputNanGongUsernameIDList(OutputNanGongUsernameID out){
		OldPeopleInfo.outputNanGongUsernameIDList.add(out);
	}

	/**
	 * 
	 */
	public static final ArrayList<OutputNanGongUserLogin> getOutputNanGongUserLoginList() {
		return outputNanGongUserLoginList;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongUserLoginList(ArrayList<OutputNanGongUserLogin> outputNanGongUserLoginList) {
		OldPeopleInfo.outputNanGongUserLoginList = outputNanGongUserLoginList;
	}
	
	/**
	 * 
	 */
	public static final void addOutputNanGongUserLoginList(OutputNanGongUserLogin out) {
		OldPeopleInfo.outputNanGongUserLoginList.add(out);
	}

	/**
	 * 
	 */
	public static final ArrayList<OutputNanGongCommunityIdElders> getOutputNanGongCommunityIdEldersList() {
		return outputNanGongCommunityIdEldersList;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongCommunityIdEldersList(
			ArrayList<OutputNanGongCommunityIdElders> outputNanGongCommunityIdEldersList) {
		OldPeopleInfo.outputNanGongCommunityIdEldersList = outputNanGongCommunityIdEldersList;
	}
	
	/**
	 * 
	 */
	public static final void addOutputNanGongCommunityIdEldersList(OutputNanGongCommunityIdElders outputNanGongCommunityIdElders) {
		OldPeopleInfo.outputNanGongCommunityIdEldersList.add(outputNanGongCommunityIdElders);
	}

	/**
	 * 
	 */
	public static final long getUntreatedalarm() {
		return Untreatedalarm;
	}

	/**
	 * 
	 */
	public static final void setUntreatedalarm(long untreatedalarm) {
		Untreatedalarm = untreatedalarm;
	}

	/**
	 * 
	 */
	public static final long getTotalalarm() {
		return totalalarm;
	}

	/**
	 * 
	 */
	public static void addOutputAlarmsList(OutputAlarms alarmsOut){
		outputAlarmsInfoList.add(alarmsOut);
	}
	
	/**
	 * 
	 */
	public static OutputAlarms getOutputAlarmsInfoList(Integer index){
		return outputAlarmsInfoList.get(index);
	}
	
	/**
	 * 
	 */
	public static void releaseOutputAlarmsInfoList(){
		outputAlarmsInfoList.clear();
	}
	
	/**
	 * 
	 */
	public static final JSONObject getOutputLocation() {
		JSONObject json;
		json = JSONObject.fromObject(outputLocation.getData());
		return json;
	}

	/**
	 * 
	 */
	public static final void setOutputLocation(OutputLocation tempOutputLocation) {
		outputLocation = tempOutputLocation;
	}
	/**
	 * 
	 */
	public static final JSONArray getTrackList() {
		JSONArray jsonArray = JSONArray.fromObject(outputTrack.getData().getData());
		return jsonArray;
	}
	
	/**
	 * 
	 */
	public static final OutputTrack getOutputTrack() {
		return outputTrack;
	}

	/**
	 * 
	 */
	public static final void setOutputTrack(OutputTrack tempOutputTrack) {
		OldPeopleInfo.outputTrack = tempOutputTrack;
	}
	
	/**
	 * 
	 */
	public static final long getTotalOldPeople(){
		return totalOldPeople;
	}
	
	/**
	 * 
	 */
	public static final void setTotalOldPeople(long num){
		totalOldPeople = num;
	}
	
	/**
	 * 
	 */
	public static final void addTotalOldPeople(){
		++totalOldPeople;
	}
	
	/**
	 * 
	 */
	public static final long getOnlineOldPeople(){
		return onlineOldPeople;
	}
	
	/**
	 * 
	 */
	public static final void setOnlineOldPeople(long num){
		onlineOldPeople = num;
	}
	
	/**
	 * 
	 */
	public static final void addOnlineOldPeople(){
		++onlineOldPeople;
	}
	
	/**
	 * 
	 */
	public static final long getUntreatedAlarm(){
		return Untreatedalarm;
	}
	
	/**
	 * 
	 */
	public static final void setUntreatedAlarm(long num){
		Untreatedalarm = num;
	}
	
	/**
	 * 
	 */
	public static final void addUntreatedAlarm(){
		++Untreatedalarm;
	}
	
	/**
	 * 
	 */
	public static final long getTotalAlarm(){
		return totalalarm;
	}
	
	/**
	 * 
	 */
	public static final void setTotalalarm(long num){
		totalalarm = num;
	}
	
	/**
	 * 
	 */
	public static final void addTotalalarm(){
		++totalalarm;
	}

	/**
	 * 
	 */
	public static final ArrayList<OutputAlarms> getOutputAlarmsInfoList() {
		return outputAlarmsInfoList;
	}

	/**
	 * 
	 */
	public static final void setOutputAlarmsInfoList(ArrayList<OutputAlarms> outputAlarmsInfoList) {
		OldPeopleInfo.outputAlarmsInfoList = outputAlarmsInfoList;
	}
	
	/**
	 * 
	 */
	public static void addAlarmPositionInfo(AlarmPositionInfo alarmPositionInfo){
		alarmPositionInfoList.add(alarmPositionInfo);
	}
	
	/**
	 * 
	 */
	public static final ArrayList<AlarmPositionInfo> getAlarmPositionInfoList() {
		return alarmPositionInfoList;
	}

	/**
	 * 
	 */
	public static final JSONArray getAlarmPositionInfoListToJsonArr() {
		JSONArray jsonArray = JSONArray.fromObject(alarmPositionInfoList);
		return jsonArray;
	}

	/**
	 * 
	 */
	public static final void setAlarmPositionInfoList(ArrayList<AlarmPositionInfo> alarmPositionInfoList) {
		OldPeopleInfo.alarmPositionInfoList = alarmPositionInfoList;
	}
	
	/**
	 * 
	 */
	public static void addAlarmMessageInfo(AlarmMessageInfo alarmMessageInfo){
		alarmMessageInfoList.add(alarmMessageInfo);
	}

	/**
	 * 
	 */
	public static final ArrayList<AlarmMessageInfo> getAlarmMessageInfoList() {
		return alarmMessageInfoList;
	}
	
	/**
	 * 
	 */
	public static final JSONArray getAlarmMessageInfoListToJsonArr() {
		JSONArray jsonArray = JSONArray.fromObject(alarmMessageInfoList);
		return jsonArray;
	}

	/**
	 * 
	 */
	public static final void setAlarmMessageInfoList(ArrayList<AlarmMessageInfo> alarmMessageInfoList) {
		OldPeopleInfo.alarmMessageInfoList = alarmMessageInfoList;
	}
}

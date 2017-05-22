/**
 * 
 */
package com.ciii.police.buffer;

import java.util.ArrayList;

import com.ciii.police.model.response.student.*;
import com.ciii.police.model.web.student.AlarmMessageInfo;
import com.ciii.police.model.web.student.AlarmPositionInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
public final class StudentInfo {
	private static OutputNanGongSchools outputNanGongSchoolsInfo;
	private static OutputNanGongStudents outputNanGongStudentsInfo;
	private static ArrayList<OutputNanGongStudent> outputNanGongStudentListInfo;
	private static ArrayList<OutputAlarms> outputAlarmsInfoList;
	private static OutputLocation outputLocation;
	private static OutputTrack outputTrack;
	private static long totalStudent;
	private static long onlineStudent;
	private static long Untreatedalarm;
	private static long totalalarm;
	private static ArrayList<AlarmPositionInfo> alarmPositionInfoList = new ArrayList<AlarmPositionInfo>();
	private static ArrayList<AlarmMessageInfo> alarmMessageInfoList = new ArrayList<AlarmMessageInfo>();
	
	/**
	 * @return 
	 * 
	 */
	public static final void initStudentInfo(){
		outputNanGongSchoolsInfo = new OutputNanGongSchools();
		outputNanGongStudentsInfo = new OutputNanGongStudents();
		outputNanGongStudentListInfo = new ArrayList<OutputNanGongStudent>();
		outputAlarmsInfoList = new ArrayList<OutputAlarms>();
		outputLocation = new OutputLocation();
		outputTrack = new OutputTrack();
		totalStudent = 0;
		onlineStudent = 0;
		Untreatedalarm = 0;
		totalalarm = 0;
		//alarmPositionInfoList = new ArrayList<AlarmPositionInfo>();
		//alarmMessageInfoList = new ArrayList<AlarmMessageInfo>();
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongSchoolsInfo(){
		outputNanGongSchoolsInfo = new OutputNanGongSchools();
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongStudentsInfo(){
		outputNanGongStudentsInfo = new OutputNanGongStudents();
	}
	
	/**
	 * 
	 */
	public static final void initOutputNanGongStudentListInfo(){
		outputNanGongStudentListInfo = new ArrayList<OutputNanGongStudent>();
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
	public static final void initTotalStudent(){
		totalStudent = 0;
	}
	
	/**
	 * 
	 */
	public static final void initOnlineStudent(){
		onlineStudent = 0;
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
	public static final OutputNanGongSchools getOutputNanGongSchoolsInfo() {
		return outputNanGongSchoolsInfo;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongSchoolsInfo(OutputNanGongSchools tempOutputNanGongSchoolsInfo) {
		StudentInfo.outputNanGongSchoolsInfo = tempOutputNanGongSchoolsInfo;
	}
	
	/**
	 * 
	 */
	public static final OutputNanGongStudents getOutputNanGongStudentsInfo() {
		return outputNanGongStudentsInfo;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongStudentsInfo(OutputNanGongStudents tempOutputNanGongStudentsInfo) {
		StudentInfo.outputNanGongStudentsInfo = tempOutputNanGongStudentsInfo;
		setTotalStudent(StudentInfo.outputNanGongStudentsInfo.getData().size());
	}
	
	/**
	 * 
	 */
	public static final ArrayList<OutputNanGongStudent> getOutputNanGongStudentListInfo() {
		return outputNanGongStudentListInfo;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongStudentInfo(ArrayList<OutputNanGongStudent> tempOutputNanGongStudentListInfo) {
		outputNanGongStudentListInfo = tempOutputNanGongStudentListInfo;
	}
	
	/**
	 * 
	 */
	public static final void addOutputNanGongStudentListInfo(OutputNanGongStudent outputNanGongStudent) {
		outputNanGongStudentListInfo.add(outputNanGongStudent);
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
		StudentInfo.outputTrack = tempOutputTrack;
	}
	
	/**
	 * 
	 */
	public static final String GetUserIdByIEMI(String imei){
		for(int index = 0; index < outputNanGongStudentListInfo.size(); index++){
			if(outputNanGongStudentListInfo.get(index).getData().getDevice().getImei().equals(imei)){
				return outputNanGongStudentListInfo.get(index).getData().getId();
			}
		}
		return "";
	}
	
	/**
	 * 
	 */
	public static final long getTotalStudent(){
		return totalStudent;
	}
	
	/**
	 * 
	 */
	public static final void setTotalStudent(long num){
		totalStudent = num;
	}
	
	/**
	 * 
	 */
	public static final void addTotalStudent(){
		++totalStudent;
	}
	
	/**
	 * 
	 */
	public static final long getOnlineStudent(){
		return onlineStudent;
	}
	
	/**
	 * 
	 */
	public static final void setOnlineStudent(long num){
		onlineStudent = num;
	}
	
	/**
	 * 
	 */
	public static final void addOnlineStudent(){
		++onlineStudent;
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
		StudentInfo.outputAlarmsInfoList = outputAlarmsInfoList;
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
		StudentInfo.alarmPositionInfoList = alarmPositionInfoList;
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
		StudentInfo.alarmMessageInfoList = alarmMessageInfoList;
	}

	/**
	 * 
	 */
	public static final void setOutputNanGongStudentListInfo(ArrayList<OutputNanGongStudent> outputNanGongStudentListInfo) {
		StudentInfo.outputNanGongStudentListInfo = outputNanGongStudentListInfo;
	}
}

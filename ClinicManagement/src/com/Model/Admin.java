package com.Model;

import java.util.Date;

public class Admin {
	
	private int roleId;
	private String roleName;
	
	private int sId;
	private String sName;
	private Date sDOB;
	
	private String sGender;
	private String sAddr;
	private String sExp;
	private String sPhNo;
	private String sEmail;
	private String username;
	private String password;
	private String sisActive;
	private int misActive;
	private Date screatedDate;
	private Date mcreatedDate;
	
	private int consultDayId;
	private String sunday ;
	private String monday ;
	private String tuesday ;
	private String wednesday ;
	private String thursday ;
	private String friday ;
	private String saturday ;
	
	private int dId;
	private String dSpec;
	private String dQualification;
	private double consultFee;
	
	private int medId;
	private String medName;
	private double medPrice;
	private String manufacturer;
	
	private int labId;
	private String lName;
	private double lFee;
	private String description;
	
	//default constructor
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	
	public Admin(int roleId, String roleName, int sId, String sName, Date sDOB,
			String sGender, String sAddr, String sExp, String sPhNo,
			String sEmail, String username, String password, String sisActive,
			int misActive, Date screatedDate, Date mcreatedDate,
			int consultDayId, String sunday, String monday, String tuesday,
			String wednesday, String thursday, String friday, String saturday,
			int dId, String dSpec, String dQualification, double consultFee,
			int medId, String medName, double medPrice, String manufacturer,
			int labId, String lName, double lFee, String description) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.sId = sId;
		this.sName = sName;
		this.sDOB = sDOB;
		this.sGender = sGender;
		this.sAddr = sAddr;
		this.sExp = sExp;
		this.sPhNo = sPhNo;
		this.sEmail = sEmail;
		this.username = username;
		this.password = password;
		this.sisActive = sisActive;
		this.misActive = misActive;
		this.screatedDate = screatedDate;
		this.mcreatedDate = mcreatedDate;
		this.consultDayId = consultDayId;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.dId = dId;
		this.dSpec = dSpec;
		this.dQualification = dQualification;
		this.consultFee = consultFee;
		this.medId = medId;
		this.medName = medName;
		this.medPrice = medPrice;
		this.manufacturer = manufacturer;
		this.labId = labId;
		this.lName = lName;
		this.lFee = lFee;
		this.description = description;
	}

	//getters and setters
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getConsultDayId() {
		return consultDayId;
	}

	public void setConsultDayId(int consultDayId) {
		this.consultDayId = consultDayId;
	}

	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Date getsDOB() {
		return sDOB;
	}

	public void setsDOB(Date sDOB) {
		this.sDOB = sDOB;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getsExp() {
		return sExp;
	}

	public void setsExp(String sExp) {
		this.sExp = sExp;
	}

	public String getsPhNo() {
		return sPhNo;
	}

	public void setsPhNo(String sPhNo) {
		this.sPhNo = sPhNo;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSisActive() {
		return sisActive;
	}

	public void setSisActive(String sisActive) {
		this.sisActive = sisActive;
	}

	public int getMisActive() {
		return misActive;
	}

	public void setMisActive(int misActive) {
		this.misActive = misActive;
	}

	public Date getScreatedDate() {
		return screatedDate;
	}

	public void setScreatedDate(Date screatedDate) {
		this.screatedDate = screatedDate;
	}

	public Date getMcreatedDate() {
		return mcreatedDate;
	}

	public void setMcreatedDate(Date mcreatedDate) {
		this.mcreatedDate = mcreatedDate;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdSpec() {
		return dSpec;
	}

	public void setdSpec(String dSpec) {
		this.dSpec = dSpec;
	}

	public String getdQualification() {
		return dQualification;
	}

	public void setdQualification(String dQualification) {
		this.dQualification = dQualification;
	}

	public double getConsultFee() {
		return consultFee;
	}

	public void setConsultFee(double consultFee) {
		this.consultFee = consultFee;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public double getMedPrice() {
		return medPrice;
	}

	public void setMedPrice(double medPrice) {
		this.medPrice = medPrice;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getlFee() {
		return lFee;
	}

	public void setlFee(double lFee) {
		this.lFee = lFee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Admin [roleId=" + roleId + ", roleName=" + roleName + ", sId="
				+ sId + ", sName=" + sName + ", sDOB=" + sDOB + ", sGender="
				+ sGender + ", sAddr=" + sAddr + ", sExp=" + sExp + ", sPhNo="
				+ sPhNo + ", sEmail=" + sEmail + ", username=" + username
				+ ", password=" + password + ", sisActive=" + sisActive
				+ ", misActive=" + misActive + ", screatedDate=" + screatedDate
				+ ", mcreatedDate=" + mcreatedDate + ", consultDayId="
				+ consultDayId + ", sunday=" + sunday + ", monday=" + monday
				+ ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", thursday=" + thursday + ", friday=" + friday
				+ ", saturday=" + saturday + ", dId=" + dId + ", dSpec="
				+ dSpec + ", dQualification=" + dQualification
				+ ", consultFee=" + consultFee + ", medId=" + medId
				+ ", medName=" + medName + ", medPrice=" + medPrice
				+ ", manufacturer=" + manufacturer + ", labId=" + labId
				+ ", lName=" + lName + ", lFee=" + lFee + ", description="
				+ description + "]";
	}
	
	
	
	
}


package com.Model;

import java.util.Date;

public class Doctor {
	
	// cm_roleTable
	private int roleId;
	private String roleName;

	// cm_appoinmentTable
	private int appId;
	private int regId;
	private int dId;
	private Date dateOfApp;
	private String consultStatus;

	// cm_doctorTable
  
	private String dSpec;
	private String dQualification;
	private int consultFee;

	// cm_patientTable
	
	private String pFName;
	private String pLName;
	private String pGender;
	private Date pDOB;
	private String pAddr;
	private String pPhNo;
	private String pBloodGrp;
	private Date pcreatedDate;

	// cm_prescriptionTable
	private int prescId;
	// private int dId;
	//private int medId;
	private String medFreq;
	private int medDays;
	private Date prescDate;
	private String pharmacyStatus;

	// cm_doctorObsTable
	private int dObsId;
	private Date obserDate;
	private String obsNotes;
	//private int regId;
	//private int dId;

	// cm_assignLabTable
	private int assignLabId;
	
	private int labId;
	private Date assigLabDate;
	private String sampleStatus;
	private String testStatus;

	// cm_staffTable
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
	private int isSActive;
	private Date sCreatedDate;

	// cm_medicineTable
	private int medId;
	private String medName;
	private double medPrice;
	private int isMActive;
	private String manufacturer;
	private Date mCreatedDate;

	// cm_labTestTable
	
	private String lName;
	private double lFee;
	
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
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public Date getDateOfApp() {
		return dateOfApp;
	}
	public void setDateOfApp(Date dateOfApp) {
		this.dateOfApp = dateOfApp;
	}
	public String getConsultStatus() {
		return consultStatus;
	}
	public void setConsultStatus(String consultStatus) {
		this.consultStatus = consultStatus;
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
	public int getConsultFee() {
		return consultFee;
	}
	public void setConsultFee(int consultFee) {
		this.consultFee = consultFee;
	}
	public String getpFName() {
		return pFName;
	}
	public void setpFName(String pFName) {
		this.pFName = pFName;
	}
	public String getpLName() {
		return pLName;
	}
	public void setpLName(String pLName) {
		this.pLName = pLName;
	}
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}
	public Date getpDOB() {
		return pDOB;
	}
	public void setpDOB(Date pDOB) {
		this.pDOB = pDOB;
	}
	public String getpAddr() {
		return pAddr;
	}
	public void setpAddr(String pAddr) {
		this.pAddr = pAddr;
	}
	public String getpPhNo() {
		return pPhNo;
	}
	public void setpPhNo(String pPhNo) {
		this.pPhNo = pPhNo;
	}
	public String getpBloodGrp() {
		return pBloodGrp;
	}
	public void setpBloodGrp(String pBloodGrp) {
		this.pBloodGrp = pBloodGrp;
	}
	public Date getPcreatedDate() {
		return pcreatedDate;
	}
	public void setPcreatedDate(Date pcreatedDate) {
		this.pcreatedDate = pcreatedDate;
	}
	public int getPrescId() {
		return prescId;
	}
	public void setPrescId(int prescId) {
		this.prescId = prescId;
	}
	public String getMedFreq() {
		return medFreq;
	}
	public void setMedFreq(String medFreq) {
		this.medFreq = medFreq;
	}
	public int getMedDays() {
		return medDays;
	}
	public void setMedDays(int medDays) {
		this.medDays = medDays;
	}
	public Date getPrescDate() {
		return prescDate;
	}
	public void setPrescDate(Date prescDate) {
		this.prescDate = prescDate;
	}
	public String getPharmacyStatus() {
		return pharmacyStatus;
	}
	public void setPharmacyStatus(String pharmacyStatus) {
		this.pharmacyStatus = pharmacyStatus;
	}
	public int getdObsId() {
		return dObsId;
	}
	public void setdObsId(int dObsId) {
		this.dObsId = dObsId;
	}
	public Date getObserDate() {
		return obserDate;
	}
	public void setObserDate(Date obserDate) {
		this.obserDate = obserDate;
	}
	public String getObsNotes() {
		return obsNotes;
	}
	public void setObsNotes(String obsNotes) {
		this.obsNotes = obsNotes;
	}
	public int getAssignLabId() {
		return assignLabId;
	}
	public void setAssignLabId(int assignLabId) {
		this.assignLabId = assignLabId;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public Date getAssigLabDate() {
		return assigLabDate;
	}
	public void setAssigLabDate(Date assigLabDate) {
		this.assigLabDate = assigLabDate;
	}
	public String getSampleStatus() {
		return sampleStatus;
	}
	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
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
	public int getIsSActive() {
		return isSActive;
	}
	public void setIsSActive(int isSActive) {
		this.isSActive = isSActive;
	}
	public Date getsCreatedDate() {
		return sCreatedDate;
	}
	public void setsCreatedDate(Date sCreatedDate) {
		this.sCreatedDate = sCreatedDate;
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
	public int getIsMActive() {
		return isMActive;
	}
	public void setIsMActive(int isMActive) {
		this.isMActive = isMActive;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getmCreatedDate() {
		return mCreatedDate;
	}
	public void setmCreatedDate(Date mCreatedDate) {
		this.mCreatedDate = mCreatedDate;
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
	
	//parameterized constructor
	
	public Doctor(int roleId, String roleName, int appId, int regId, int dId, Date dateOfApp, String consultStatus,
			String dSpec, String dQualification, int consultFee, String pFName, String pLName, String pGender,
			Date pDOB, String pAddr, String pPhNo, String pBloodGrp, Date pcreatedDate, int prescId, String medFreq,
			int medDays, Date prescDate, String pharmacyStatus, int dObsId, Date obserDate, String obsNotes,
			int assignLabId, int labId, Date assigLabDate, String sampleStatus, String testStatus, int sId,
			String sName, Date sDOB, String sGender, String sAddr, String sExp, String sPhNo, String sEmail,
			String username, String password, int isSActive, Date sCreatedDate, int medId, String medName,
			double medPrice, int isMActive, String manufacturer, Date mCreatedDate, String lName, double lFee) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.appId = appId;
		this.regId = regId;
		this.dId = dId;
		this.dateOfApp = dateOfApp;
		this.consultStatus = consultStatus;
		this.dSpec = dSpec;
		this.dQualification = dQualification;
		this.consultFee = consultFee;
		this.pFName = pFName;
		this.pLName = pLName;
		this.pGender = pGender;
		this.pDOB = pDOB;
		this.pAddr = pAddr;
		this.pPhNo = pPhNo;
		this.pBloodGrp = pBloodGrp;
		this.pcreatedDate = pcreatedDate;
		this.prescId = prescId;
		this.medFreq = medFreq;
		this.medDays = medDays;
		this.prescDate = prescDate;
		this.pharmacyStatus = pharmacyStatus;
		this.dObsId = dObsId;
		this.obserDate = obserDate;
		this.obsNotes = obsNotes;
		this.assignLabId = assignLabId;
		this.labId = labId;
		this.assigLabDate = assigLabDate;
		this.sampleStatus = sampleStatus;
		this.testStatus = testStatus;
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
		this.isSActive = isSActive;
		this.sCreatedDate = sCreatedDate;
		this.medId = medId;
		this.medName = medName;
		this.medPrice = medPrice;
		this.isMActive = isMActive;
		this.manufacturer = manufacturer;
		this.mCreatedDate = mCreatedDate;
		this.lName = lName;
		this.lFee = lFee;
	}
	
	//tostring function
	
	@Override
	public String toString() {
		return "DoctorBean [roleId=" + roleId + ", roleName=" + roleName + ", appId=" + appId + ", regId=" + regId
				+ ", dId=" + dId + ", dateOfApp=" + dateOfApp + ", consultStatus=" + consultStatus + ", dSpec=" + dSpec
				+ ", dQualification=" + dQualification + ", consultFee=" + consultFee + ", pFName=" + pFName
				+ ", pLName=" + pLName + ", pGender=" + pGender + ", pDOB=" + pDOB + ", pAddr=" + pAddr + ", pPhNo="
				+ pPhNo + ", pBloodGrp=" + pBloodGrp + ", pcreatedDate=" + pcreatedDate + ", prescId=" + prescId
				+ ", medFreq=" + medFreq + ", medDays=" + medDays + ", prescDate=" + prescDate + ", pharmacyStatus="
				+ pharmacyStatus + ", dObsId=" + dObsId + ", obserDate=" + obserDate + ", obsNotes=" + obsNotes
				+ ", assignLabId=" + assignLabId + ", labId=" + labId + ", assigLabDate=" + assigLabDate
				+ ", sampleStatus=" + sampleStatus + ", testStatus=" + testStatus + ", sId=" + sId + ", sName=" + sName
				+ ", sDOB=" + sDOB + ", sGender=" + sGender + ", sAddr=" + sAddr + ", sExp=" + sExp + ", sPhNo=" + sPhNo
				+ ", sEmail=" + sEmail + ", username=" + username + ", password=" + password + ", isSActive="
				+ isSActive + ", sCreatedDate=" + sCreatedDate + ", medId=" + medId + ", medName=" + medName
				+ ", medPrice=" + medPrice + ", isMActive=" + isMActive + ", manufacturer=" + manufacturer
				+ ", mCreatedDate=" + mCreatedDate + ", lName=" + lName + ", lFee=" + lFee + "]";
	}
	
    //default constructor
	
	public Doctor() {
		super();
	}
	
	
	
}
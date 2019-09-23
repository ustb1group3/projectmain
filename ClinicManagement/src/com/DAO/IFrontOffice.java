package com.DAO;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

import com.Model.Admin;
import com.Model.Doctor;
import com.Model.FrontOffice;

public interface IFrontOffice {

	List<FrontOffice> viewPatientList();

	FrontOffice getPatientDetails(int regId, FrontOffice fob);

	Date getdob(int regId);

	int ageCalculation(Date s);

	// Get element using id
	FrontOffice getPatientdetails(String searchString);

	//Get patient info only required details
	FrontOffice getPatientById(int regId);

	// Insert new Patients
	int savePatient(FrontOffice fob);

	void dateConversion(FrontOffice fob);

	DayOfWeek getDay();

	List<FrontOffice> getAvailableDoctor(String now1);
	//update patient

	int update(FrontOffice fob);

	List<FrontOffice> getAvailableDoctors();

	List<FrontOffice> list(String searchString);

	List<FrontOffice> listApp();

	List<FrontOffice> getPatient(String searchString);

	DayOfWeek getToday();

	List<FrontOffice> getAvailableDoctor();

	FrontOffice getDoctorName(String sName);

	List<Doctor> lablist();

	List<Doctor> medicinelist();

	Integer doc_getLabId(String labName);

	int addLabTestRequest(Doctor doc_bean[]);

	int addPatientComments(Doctor doc_bean);

	List<Doctor> getDoctorsAppointment(int dId);

	int removemedicine(int medId);

	Integer d_getMedicineId(String medName);

	int saveDoctorPrescription(Doctor doc);

	List<Doctor> getAllPrescription(int regId, int dId);

	//history
	List<Doctor> listHistory(int regId);

	//LabDetails
	//@Override
	List<Doctor> presListHistory(int regId);

	//
	//@Override
	List<Doctor> lablistHistory(int regId);

	//@Override
	List<Doctor> obsHistory(int regId);

	//age calculation
	int ageCalculationNew(Date s);

	// disable medicine
	int disableMedicine(Admin ad);

	List<Doctor> getDoctorsAppointments(int dId);

	Admin RoleChecker(String username, String password);

	Integer d_getLabId(String lName);

	// add lab request
	int getAddLabRequest(Doctor dr);

	// get all test
	List<Doctor> getAllTest();

	List<Doctor> getAlllabPrescription(int regId, int dId);

	Integer lab_delete(int assignLabId);

}
package com.DAO;

import java.util.List;

import com.Model.Admin;
import com.Model.FrontOffice;

public interface IAdmin {

	//VIEW STAFF
	List<Admin> viewStaffById(int sId);

	int getRoleId(String role);

	int insertStaff(Admin aBean);

	//viewStaff
	List<Admin> getStaff();

	//update staff
	int updateStaff(Admin ab);

	List<Admin> role();

	//view medicine
	List<Admin> list();

	Admin getMedicineById(int medId);

	long savemed(Admin ad);

	int update(Admin ad);

	//Disable Medicine
	int disableMedicine(String medId);

	//view doc
	List<Admin> listDoc();

	//disable staff
	int disableStaff(int sId);

	List<Admin> getDoctorById(int sId);

	int insertDoctorStaff(Admin aBean);

	int insertDoctor(Admin aBean);
	//update doctor

	Integer updateDoctor(Admin ds);

	/*****************************************/

	//update
	int insertAvailableDays(Admin aBean);

	int disableStaff(Admin ad);

	int insertAppointment(FrontOffice fob);

}
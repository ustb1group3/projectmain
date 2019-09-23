package com.DAO;

import java.util.List;

import com.Model.Admin;

public interface IAdmins {

	long savemed(Admin ad);

	int update(Admin ad);

	int disableMedicine(String medName);

	Admin get(String medName);

	List<Admin> list();

	/***************************************doctor*******************************/

	//add doctor ..not multiple table
	int savedoc(Admin ad);
	//insert doctor

	Admin getRoleName(String roleName);
	//insert doctor

	int saveDoctor(Admin doc, String roleName);

	//view docs
	List<Admin> list1();

	/****************************************staffs***********************************/

	//get staff by name

	/* public Admin getstaffByName(String sName )
	 {
	  String sl="select * from cm_stafftable where sName=?";
	  return template.queryForObject(sl, new Object[] { sName },new BeanPropertyRowMapper<Admin>(Admin.class));
	  
	 }*/
	Admin getstaffByName(String sName);

	Integer getRoleId(String roleName);

	int insertStaff(Admin ad);

	int updateStaff(Admin ab);

	List<Admin> getStaff();

	//View Staff by Id
	Admin getStaffById(int sId);

}
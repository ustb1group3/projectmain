package com.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Admin1DAO;

import com.DAO.IAdmin;
import com.Model.Admin;
import com.Model.Doctor;
import com.Model.FrontOffice;


@RestController
public class Admin1Controller {
	
	@Autowired
	IAdmin adms;
	
/*********************************************** STAFFS**********************************************************/
	
//view all staffs as a list
	
	@RequestMapping(value= "/api/viewstaff", method = RequestMethod.GET)
	public List<Admin> getAllStaff()
	{
		List list = adms.getStaff();
		return list;
	}
	
//insert Staff along with edit
	
	@RequestMapping(value = "/api/insertStaff",method = { RequestMethod.POST,RequestMethod.PUT })
	public void staffInsert(@RequestBody Admin aBean)
	{
	if(aBean.getsId()==0)	
	{
		 adms.insertStaff(aBean);
	}
	else
	{
		adms.updateStaff(aBean);
	}
			
	}
	
//get staff by id
	
	@RequestMapping(value = "/api/getstaffbyid/{sId}", method = RequestMethod.GET , produces = "application/json")
	public Admin getStaff(@ModelAttribute("ad") Admin ad,@PathVariable("sId") int sId) 
	{
	List staff=(List) adms.viewStaffById(sId);
	ad=(Admin) staff.get(0);
	return  ad;
	}

//get staffs by rolename
	
	@RequestMapping(value="/api/viewrole",headers="Accept=application/json",method=RequestMethod.GET)
	public List viewRole(@ModelAttribute("ad") Admin ad)
	{
		List rolelist=adms.role();
		return rolelist;
	}
	
//disable staffs
	
	@RequestMapping(value = "/api/disablestaff/{sId}", method = RequestMethod.PUT)
	public void staffDisable(@PathVariable("sId") int sId) 
	{
	adms.disableStaff(sId);
	}
	
/*******************************************************MEDICINES******************************************************/
	
//list all medicines
	
	@RequestMapping(value="/api/medicines",method=RequestMethod.GET)
	  
	  public List<Admin> getAllMedicines()
	  {
		  List list=adms.list();
		  return list;
	  }
	
//get medicine by id
	
	@RequestMapping(value="/api/medicine/{medId}",method=RequestMethod.GET)
	  
	  public Admin getMedicineById(@PathVariable("medId") int medId)
	  {
		  return adms.getMedicineById(medId);
	  }
	
	
//insert medidne
	
		@RequestMapping(value="/api/insertmedicine",method={RequestMethod.POST,RequestMethod.PUT})
		  public void insertMedicine(@RequestBody Admin ad)
		  {
			System.out.println(ad.getMedId());
			if(ad.getMedId()==0)
			{
				adms.savemed(ad);
			}
			else
			{
			  adms.update(ad);
			}
			  
		  }
		
		
/************************************************DOCTOR********************************************************************************/
		
//view doctors
		
		@RequestMapping(value="/api/viewdoctor",method=RequestMethod.GET)
	    
		public List<Admin> getViewDoctor(){
			List list1=adms.listDoc();
			return list1;
		}
		
//doctor by Id
		
		@RequestMapping(value = "/api/getdoctorbyid/{sId}", method = RequestMethod.GET , produces = "application/json")
		public Admin getDoctor(@ModelAttribute("ad") Admin ad,@PathVariable("sId") int sId) {
		List doctor=(List) adms.getDoctorById(sId);
		ad=(Admin) doctor.get(0);
		return  ad;
		}
		
//insert doctor
		
		 @RequestMapping(value = "/api/savedoc",method = {RequestMethod.POST,RequestMethod.PUT})
		  	public void savedoctor(@RequestBody Admin ad)
		  	{
		  		adms.insertDoctorStaff(ad);
		  	}
		 
//update doctor
		 

	    	@RequestMapping(value = "/api/updatedoctor/{sId}", method = RequestMethod.PUT)
	    	public void updateDoctor(@RequestBody Admin ds) {
	    	adms.updateDoctor(ds);
	    	}

		
//add appointment
	    	
			@RequestMapping(value="/api/insertAppointment",method=RequestMethod.POST)
			public void insertAppointmentTable(@RequestBody FrontOffice fob) 
			{
				
					adms.insertAppointment(fob);
			
			}	
			
//disable medicine
			
			@RequestMapping(value = "/api/disablemedicine/{medId}", method = RequestMethod.PUT)
			void disableMedicine(@PathVariable("medId") String medName) {
				adms.disableMedicine(medName);

			}
}

package com.Controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.IFrontOffice;
import com.Model.Admin;
import com.Model.Doctor;
import com.Model.FrontOffice;

	@RestController
	public class FrontOfficeController {

		@Autowired
		IFrontOffice fos;
		
		
/****************************Login part*****************************************************************/	
		
//login service
				@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
				public Admin getRole(@PathVariable("username") String username,@PathVariable("password") String password)
				{
					System.out.println("Role");
					return fos.RoleChecker(username, password);
					
				}
				
//list all patients
		
		@RequestMapping(value="/patients",headers="Accept=Application/json",method = RequestMethod.GET)
		 public List<Admin> getAllPatients()
		  {
			  List list=fos.viewPatientList();
			  return list;
		  }
		
//Patient required details  ---search by id and phone
		
			
			@RequestMapping(value="/patientdetails/{searchString}",headers="Accept=Application/json",method = RequestMethod.GET)
			public FrontOffice patientsDetails(@PathVariable("searchString")String searchString) 
			{
			 FrontOffice fob=fos.getPatientdetails(searchString);
			 fos.dateConversion(fob);
			return fob;
			}
		
		
//front office add new patient
			
		@RequestMapping(value="/savepat",method={RequestMethod.POST,RequestMethod.PUT})
		public void insertnewPatient(@RequestBody FrontOffice fob) 
		{
			fos.savePatient(fob); 
		
		}
		
//get available doctors of the day
		
		@RequestMapping(value = "/api/getAvailableDoctor", method = RequestMethod.GET)
		public List<FrontOffice> getAvailableDoctors() 
		{

			List list = fos.getAvailableDoctors();
			return list;
		}

		
//Search by patient id
		
		
		@RequestMapping(value="/searchbyid/{regId}",
						produces="application/json",
						method=RequestMethod.GET)
		public FrontOffice getPatientById(@PathVariable("regId") int regId)
		{
			FrontOffice fob=fos.getPatientById(regId);
			System.out.println("Reached Bean");
			System.out.println(fob);
			return fob;
		}
		

		
//update patient
		
		@RequestMapping(value="/api/updatepatient",method=RequestMethod.PUT)
		
		  public void updatepatient(@RequestBody FrontOffice fob)
		{
			fos.update(fob);
		}
		
//to fetch appointment by date
		
		@RequestMapping(value="/api/appointment/{date}",method=RequestMethod.GET)
		
		public List getappointmentstoday(@ModelAttribute("fosd") FrontOffice fosd,@PathVariable("date")String date)
		{
		List list=fos.list(date);
		return list;
		}
		
//to get all appointments
		
		@RequestMapping(value="/api/appointment",method=RequestMethod.GET)
		
		public List getappointmentstoday(@ModelAttribute("fosd") FrontOffice fosd)
		{
		List list=fos.listApp();
		return list;
		}
		
// search patient by name and phone number
		
		@RequestMapping(value = "/api/patient/{searchString}", method = RequestMethod.GET)
		@ResponseBody
		public List<FrontOffice> getPatient(
		@PathVariable("searchString") String searchString) {
		System.out.println(searchString);
		List list = fos.getPatient(searchString);
		System.out.println(list);
		return list;
		}
		
//to get available doctors
		
		@RequestMapping(value="/api/apvail",method=RequestMethod.GET)
	
		public List getdoctorstoday(@ModelAttribute("fosd") FrontOffice fosd)
		{
		List list=fos.getAvailableDoctor();
		return list;
		}
		
//search doctor by name
		
		@RequestMapping(value = "/api/searchDoctorByName/{sName}", method = RequestMethod.GET)
		public FrontOffice getDoctorByName(@PathVariable("sName") String sName) {
		return fos.getDoctorName(sName);

		}
		
//get all tests
		
		@RequestMapping(value = "/api/doctor/test", method = RequestMethod.GET)
		public List getAllTest() {

		List testlist = fos.getAllTest();
		return testlist;
		}

//insert lab Request
		
		@RequestMapping(value="/api/doctor/insertlab",method= RequestMethod.POST)
		public void getAddLabRequest(@RequestBody Doctor d )
		{
		fos.getAddLabRequest(d);

		}
		
//getall lab prescription
		
		@RequestMapping(value = "/api/alllabpreslist/{regId}/{dId}", method = RequestMethod.GET)
		 public List<Doctor> getAllLabPrescription(@PathVariable("regId") int regId ,@PathVariable("dId") int dId )
		 {
		    List presList=fos.getAlllabPrescription(regId , dId);
		return presList;
		 }
		
//delete lab prescription
		
		@RequestMapping(value="/api/doctor/deletelab/{assignLabId}",headers="Accept=Application/json",method= RequestMethod.DELETE)
		public void deleteLab(@RequestBody Doctor  d,@PathVariable("assignLabId") int assignLabId )
		{
		fos.lab_delete(assignLabId);

		}
		
	}



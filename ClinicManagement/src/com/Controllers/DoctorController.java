package com.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.IFrontOffice;
import com.Model.Admin;
import com.Model.Doctor;

@RestController
public class DoctorController {
	
	@Autowired
	IFrontOffice docDao;
	
	
//Add medicine prescription
	
	@RequestMapping(value = "/api/insertpres",method = RequestMethod.POST)
	public void insertDoctorPrescription(@RequestBody Doctor doc )
	{
	System.out.println("insert prescr");
	docDao.saveDoctorPrescription(doc);

	}
	
//list all medicines
	
	  @RequestMapping(value = "/api/medlists", method = RequestMethod.GET)
	  public List<Doctor> getAllMedicineList()
	  {
	     List list=docDao.medicinelist();
	     return list;
	  }
	     
//get all prescriptions of patient corresponding to the doctor id
	  
	   @RequestMapping(value = "/api/allpreslist/{regId}/{dId}", method = RequestMethod.GET)
	   public List<Doctor> getAllPrescription(@PathVariable("regId") int regId ,@PathVariable("dId") int dId )
	  {
	     List presList=docDao.getAllPrescription(regId , dId);
	     return presList;
	  }
	     
	   
//get history of previous patient
	   
	     @RequestMapping(value="/patienthist/{regId}",headers="Accept=Application/json",method = RequestMethod.GET)
	     public List patientshist(@PathVariable("regId") int regId ) 
	     {
	     List listhis=docDao.listHistory(regId);
	     return listhis;
	     }
	     
//get medicine prescription of previous patients
	     
	     @RequestMapping(value="/preslisthist/{regId}",headers="Accept=Application/json",method = RequestMethod.GET)
	     public List presListHistory( @PathVariable("regId") int regId ) 
	     {
	     List preslist=docDao.presListHistory(regId);
	     return preslist;
	     }
	     
//get lab history previous patient
	     
	     @RequestMapping(value="/lablisthist/{regId}",headers="Accept=Application/json",method = RequestMethod.GET)
	     public List labListHistory(@PathVariable("regId") int regId )
	     {
	     List lablist=docDao.lablistHistory(regId);
	     return lablist;
	     }
	     
//get observation list according to regId
	     
	     @RequestMapping(value="/obslisthist/{regId}",headers="Accept=Application/json",method = RequestMethod.GET)
	     public List obsHistory(@PathVariable("regId") int regId ) {
	     List obslist=docDao.obsHistory(regId);
	     return obslist;
	     }

//get all lab tests 
	
		@RequestMapping(value = "/api/labtests", method = RequestMethod.GET)
		public List<Doctor> getAllLabTests() {
		List list = docDao.lablist();
		return list;
		}
		
//Assign lab test 
	
		@RequestMapping(value = "/api/assignLab",method=RequestMethod.POST)
		public void assignLabRequest(@RequestBody Doctor doc_bean[])
		{
			docDao.addLabTestRequest(doc_bean);
		}
			
		
//Add patient Observation notes
		
		@RequestMapping(value="/api/addPatientComment",method=RequestMethod.POST)
		public void insertObservation(@RequestBody Doctor doc_bean)
		{
			docDao.addPatientComments(doc_bean);
		}
		
		
// get the appointments of each doctor
		
		@RequestMapping(value = "/api/getdoctorsappointment/{dId}",method = RequestMethod.GET)
		public List<Doctor> getDoctorsApponintment(@PathVariable("dId") int dId) 
		{
		List list = docDao.getDoctorsAppointment(dId);
		return list;
		}

//function to remove the medicine
		@RequestMapping(value = "/api/removemedicine/{medId}",method = RequestMethod.DELETE)
		public void deleteBook(@PathVariable("medId") int medId)
		{
			docDao.removemedicine(medId);
		}
		
//disable medicine from the list
		
		@RequestMapping(value = "/api/disablemedicine", method = RequestMethod.PUT)
		public void disableMedicine(@RequestBody Admin ad)
		{
			docDao.disableMedicine(ad);
		}
		
//get doctors appointment
		
		@RequestMapping(value = "/api/getdoctorsappointments/{dId}",method = RequestMethod.GET)
		  public List<Doctor> getDoctorsApponintments(@PathVariable("dId") int dId) 
		  {
		  List list = docDao.getDoctorsAppointment(dId);
		  return list;
		  }
	      

}

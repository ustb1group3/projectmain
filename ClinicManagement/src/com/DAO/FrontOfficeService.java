package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Model.Admin;
import com.Model.Doctor;
import com.Model.FrontOffice;



public class FrontOfficeService implements IFrontOffice {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

// View Patient List
	
	@Override
	public List<FrontOffice> viewPatientList() {
		
		
		return template.query(
				"select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable",
				new RowMapper<FrontOffice>() {

			
					public FrontOffice mapRow(ResultSet rs, int row) throws SQLException {
						FrontOffice fob = new FrontOffice();

						fob.setRegId(rs.getInt(1));
						fob.setpFName(rs.getString(2));
						fob.setpLName(rs.getString(3));
						fob.setpGender(rs.getString(4));
						fob.setpDOB(rs.getDate(5));
						fob.setpAddr(rs.getString(6));
						fob.setpPhNo(rs.getString(7));
						fob.setpBloodGrp(rs.getString(8));
						fob.setPcreatedDate(rs.getDate(9));
						return fob;
					}
				});
	}
	
	
//to get patient details 
	
	@Override
	public FrontOffice getPatientDetails(int regId,FrontOffice fob)
	{
		Date dob=getdob(regId);
		int newAge=ageCalculation(dob);
		String sql="select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where regId="+regId+"";
		FrontOffice fob1=template.queryForObject(sql,new Object[]{regId}, new BeanPropertyRowMapper<FrontOffice>(FrontOffice.class));
	    fob1.setAge(newAge);
	    return fob1;
	}

//to get date of birth
	
    @Override
	public Date getdob(int regId)
     {
    	 String sql="select DOB from cm_patientTable where regId="+regId+"";
    	 Date dob=template.queryForObject(sql, new Object[] {},Date .class);
    	 return dob;
  
     }
	
//for age calculation
    
	@Override
	public int ageCalculation(Date s) {
			
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String sqlDate = ft.format(s);
			System.out.println(sqlDate);
			String s3=sqlDate.substring(0,4);
			int now1=Integer.parseInt(s3);
			System.out.println("year  "+now1);
			
			int now2 = s.getMonth();
			System.out.println(now2);
			
			int now3 = s.getDate();
			System.out.println(now3);
			
			LocalDate l = LocalDate.of(now1,now2,now3);
			System.out.println(l);
			LocalDate now4 = LocalDate.now(); //gets localDate
			Period diff = Period.between(l, now4); //difference between the dates is calculated
			System.out.println(diff);
			int age = diff.getYears();
			System.out.println("age  "+age);
			return age;
			
		}
	   
	   

// Get patient details by using id
	
	@Override
	public FrontOffice getPatientdetails(String searchString) {
		String sql = "select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where regId=? or pPhNo ='" + searchString + "'";
		return template.queryForObject(sql, new Object[] { searchString },
				new BeanPropertyRowMapper<FrontOffice>(FrontOffice.class));
	}

//Get patient info only required details
		
		@Override
		public FrontOffice getPatientById(int regId) {
			String sql = "select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where regId=?";
			return template.queryForObject(sql, new Object[] { regId },
					new BeanPropertyRowMapper<FrontOffice>(FrontOffice.class));
		}
	
	
// Insert new Patients
	
	@Override
	public int savePatient(FrontOffice fob) {
		SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd");
		String dob=sf.format(fob.getpDOB());
		String sql = "insert into cm_patientTable(pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate) values('"
		+ fob.getpFName() + "','" + fob.getpLName() + "','" + fob.getpGender() + "',"+"TO_DATE('"+dob+"','YYYY-MM-dd')"+",'"
		+ fob.getpAddr() + "','" + fob.getpPhNo() + "','" + fob.getpBloodGrp() + "',TO_DATE('"+java.time.LocalDate.now()+"','YYYY-MM-DD'))";
		return template.update(sql);
	}
	

//for date conversion

	@Override
	public void dateConversion(FrontOffice fob) {
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		System.out.println(now.getYear());
		System.out.println(fob.getpDOB());
		//int y=now.getYear(fob.getpDOB());
		
		
	}
	
// Getting available doctors
	
	@Override
	public DayOfWeek getDay()
	   {
			
			LocalDate now = LocalDate.now();
			DayOfWeek now1 = now.getDayOfWeek();
			System.out.println(now1);
			return now1;
		}
	
//to get available doctors
	
		@Override
		public List<FrontOffice> getAvailableDoctor(String now1) {
			return template.query(
					"select sName,dayName,consultFee,dSpec from cm_staffTable join cm_doctorTable on cm_staffTable.sId=cm_doctorTable.sId join cm_consultDayTable on cm_doctorTable.dId=cm_consultDayTable.dId join cm_dayTable on cm_consultDayTable.dayId=cm_dayTable.dayId where dayName='"+now1+"'",
					new RowMapper<FrontOffice>() {
				
						public FrontOffice mapRow(ResultSet rs, int row) throws SQLException {
							FrontOffice fob = new FrontOffice();

							fob.setsName(rs.getString(1));
							fob.setDayName(rs.getString(2));
							fob.setConsultFee(rs.getDouble(3));
							fob.setdSpec(rs.getString(4));
							
							return fob;
						}
					});
		}
		
//update patient
	
	@Override
	public int update (FrontOffice fob)
	  {
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate=ft.format(fob.getpDOB());
		String sql = "update cm_patientTable set pFName='" + fob.getpFName()+ "',pLName='" + fob.getpLName() + "',DOB=TO_DATE('"+sqlDate+"','yyyy-MM-dd')"+",pGender='"+fob.getpGender()+"',pAddr='"+fob.getpAddr()+"',pPhNo='"+fob.getpPhNo()+"',pBloodGrp='"+fob.getpBloodGrp()+"' where regId=" +fob.getRegId()+"";
		  return template.update(sql);
	  }
  
//get available doctors
	
	@Override
	public List<FrontOffice> getAvailableDoctors(){
		DayOfWeek today=getToday();
		
		String sql="select sName,cm_consultDaysTable.dId,dSpec from cm_doctorTable join cm_staffTable on cm_doctorTable.sId=cm_staffTable.sId join cm_consultDaysTable on cm_consultDaysTable.dId=cm_doctorTable.dId where "+today+"='true' and isActive='yes'";
		
		return template.query(sql,
				new RowMapper<FrontOffice>(){
			
				public FrontOffice mapRow(ResultSet rs,int row) throws SQLException{
					FrontOffice fb_bean=new FrontOffice();
					fb_bean.setsName(rs.getString(1));
					fb_bean.setdId(rs.getInt(2));
					fb_bean.setdSpec(rs.getString(3));
					
					return fb_bean;
				}
		});
	}
	
  
   
   
//to view the list
	
@Override
public List<FrontOffice> list(String searchString)
	{
		return template.query("select regId,pFName,pGender,appId,dId,sName from cm_patientTable join cm_appoinmentTable using (regId) join cm_doctorTable using (dId) join  cm_staffTable using (sId) where dateOfApp='"+searchString+"'",new RowMapper<FrontOffice>(){
				
			public FrontOffice mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				FrontOffice fos=new FrontOffice();
				fos.setRegId(rs.getInt(1));
				fos.setpFName(rs.getString(2));
				fos.setpGender(rs.getString(3));
				fos.setAppId(rs.getInt(4));
				fos.setdId(rs.getInt(5));
				fos.setsName(rs.getString(6));
				
				return fos;
			}

			
			});
				
	}

//to view the list of appointments

@Override
public List<FrontOffice> listApp()
	{
	   
		return template.query("select regId,pFName,pGender,appId,dId,sName from cm_patientTable join cm_appoinmentTable using (regId) join cm_doctorTable using (dId) join  cm_staffTable using (sId) where trunc(dateOfApp)=trunc(sysdate)",new RowMapper<FrontOffice>(){
				
			public FrontOffice mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				FrontOffice fos=new FrontOffice();
				fos.setRegId(rs.getInt(1));
				fos.setpFName(rs.getString(2));
				fos.setpGender(rs.getString(3));
				fos.setAppId(rs.getInt(4));
				fos.setdId(rs.getInt(5));
				fos.setsName(rs.getString(6));
				
				return fos;
			}

			
			});
				
	}

//to get the patient by reg id

@Override
public List<FrontOffice> getPatient(String searchString) {
	   return template
	   .query("select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where  regId = '"
	   + searchString + "' or pPhNo='" + searchString + "'",
	   new RowMapper<FrontOffice>() {
	   public FrontOffice mapRow(ResultSet rs, int row)
	   throws SQLException {

	   FrontOffice adm = new FrontOffice();
	   adm.setRegId(rs.getInt(1));
	   adm.setpFName(rs.getString(2));
	   adm.setpLName(rs.getString(3));
	   adm.setpGender(rs.getString(4));
	   adm.setpDOB(rs.getDate(5));
	   adm.setpAddr(rs.getString(6));
	   adm.setpPhNo(rs.getString(7));
	   adm.setpBloodGrp(rs.getString(8));
	   adm.setPcreatedDate(rs.getDate(9));

	   return adm;
	   }
	   });

	   }

//to get today's date

@Override
public DayOfWeek getToday(){
	   LocalDate date=LocalDate.now();
	   DayOfWeek now=date.getDayOfWeek();
	   return now;
	   }


//to get availabe doctors

	@Override
	public List<FrontOffice> getAvailableDoctor(){
	   DayOfWeek today=getToday();

	   String sql="select sName from cm_doctorTable join cm_staffTable on cm_doctorTable.sId=cm_staffTable.sId join cm_consultDaysTable on cm_consultDaysTable.dId=cm_doctorTable.dId where "+today+"='true' and isActive='yes'";

	   return template.query(sql,
	   new RowMapper<FrontOffice>(){

	   public FrontOffice mapRow(ResultSet rs,int row) throws SQLException{
	   FrontOffice fb_bean=new FrontOffice();
	   fb_bean.setsName(rs.getString(1));
	   return fb_bean;
	   }
	   });
	   }  
	   
	   
//to get doctor details
	
	@Override
	public FrontOffice getDoctorName(String sName) {
			FrontOffice fb;
			String sql = "select cm_doctorTable.dId,cm_staffTable.sName,cm_doctorTable.dSpec,cm_doctorTable.consultFee,cm_staffTable.sPhNo from cm_doctorTable join cm_staffTable on  cm_doctorTable.sId= cm_staffTable.sId where sName = ? and cm_staffTable.isActive='yes'";
			fb= template.queryForObject(sql, new Object[] { sName },
			new BeanPropertyRowMapper<FrontOffice>(FrontOffice.class));

			return fb;

			}
	
//to get lab list
	
	@Override
	public List<Doctor> lablist() {
			return template.query("select labId ,lName from cm_labTestTable", new RowMapper<Doctor>() {
				public Doctor mapRow(ResultSet rs, int row) throws SQLException {
					Doctor db = new Doctor();
					db.setLabId(rs.getInt(1));
					db.setlName(rs.getString(2));
					return db;
				}
			});
		}
		
//to get medicine list
	
		@Override
		public List<Doctor> medicinelist() {
			return template.query("select medId ,medName from cm_MedicineTable", new RowMapper<Doctor>() {
				public Doctor mapRow(ResultSet rs, int row) throws SQLException {
					Doctor db = new Doctor();
					db.setMedId(rs.getInt(1));
					db.setMedName(rs.getString(2));
					return db;
				}
			});
		}
		
//to get lab id using lab name
		
		@Override
		public Integer doc_getLabId(String labName) {
			String sql = "select labId from cm_labTestTable where lName=?";
			return template.queryForObject(sql, new Object[] { labName }, Integer.class);
		}
		
//to insert lab request
		@Override
		public int addLabTestRequest(Doctor doc_bean[]) {
			int arrayObjectLength = doc_bean.length;
			for (int i = 0; i < arrayObjectLength; i++) {
				Integer labId = doc_getLabId(doc_bean[i].getlName());
				String sql = "insert into cm_assignLabTable(regId,dId,labId,assigLabDate,sampleStatus,testStatus)"
						+ "values(" + doc_bean[i].getRegId() + "," + doc_bean[i].getdId() + ",?,TO_DATE('"
						+ java.time.LocalDate.now() + "', 'YYYY-MM-DD'),'Yes','Yes')";

				template.update(sql, new Object[] { labId });
			}
			return 1;
		}
		
//to add patient comments
		@Override
		public int addPatientComments(Doctor doc_bean) {

			String sql = "insert into cm_doctorObsTable(obserDate,obsNotes,regId,dId)values(TO_DATE('"
					+ java.time.LocalDate.now() + "', 'YYYY-MM-DD'),'" + doc_bean.getObsNotes() + "'," + doc_bean.getRegId()
					+ "," + doc_bean.getdId() + ")";

			return template.update(sql);
		}
		
//get doctor's appointment
		@Override
		public List<Doctor> getDoctorsAppointment(int dId) {
			return template.query(
					"select regId,pFName,appId,dId,consultStatus from cm_PatientTable join cm_AppoinmentTable using(regId) where dId = "
							+ dId + " and dateOfApp = TO_DATE('" + java.time.LocalDate.now() + "' ,'YYYY-MM-DD') ",
					new RowMapper<Doctor>() {
						public Doctor mapRow(ResultSet rs, int row) throws SQLException {
							Doctor db = new Doctor();
							db.setRegId(rs.getInt(1));
							db.setpFName(rs.getString(2));
							db.setdId(rs.getInt(4));
							//db.setpGender(rs.getString(3));
							db.setAppId(rs.getInt(3));
							db.setConsultStatus(rs.getString(5));
							return db;
						}
					});
		}
		
//to remove medicine
		@Override
		public int removemedicine(int medId) {
			String sql = "delete from cm_medicineTable where medId = " + medId + "";
			return template.update(sql);

		}
		
		
//to get medicine id by using medicine name
		@Override
		public Integer d_getMedicineId(String medName) {
			String sql = "select medId from cm_medicineTable where medName = ?";
			return template.queryForObject(sql, new Object[] { medName },
			Integer.class);
			

			}
			
//to insert prescription
			@Override
			public int saveDoctorPrescription(Doctor doc) {
			Integer medId = d_getMedicineId(doc.getMedName());
			String sql = "insert into cm_prescriptionTable(dId,medId,medFreq,medDays,prescDate,regId) values("+ doc.getdId() +",?,'"
			+ doc.getMedFreq()
			+ "',"
			+ doc.getMedDays()
			+ ",TO_DATE('"
			+ java.time.LocalDate.now()
			+ "', 'YYYY-MM-DD'),"+doc.getRegId()+")";
			return template.update(sql, new Object[] { medId });
			}
		
		
//to get all prescriptions
		@Override
		public List<Doctor> getAllPrescription(int regId , int dId) {
			return template
					.query("select p.dId,p.regId,p.prescdate,p.medDays , p.medFreq ,m.medName from cm_prescriptiontable p join cm_medicineTable m on p.medid=m.medid where trunc(prescdate) = trunc(sysdate) and regId = "
							+ regId+ "and dId="+dId+ " ",
							
							new RowMapper<Doctor>() {
								public Doctor mapRow(ResultSet rs, int row)
										throws SQLException {
									Doctor db = new Doctor();
									db.setdId(rs.getInt(1));
									db.setRegId(rs.getInt(2));
									db.setPrescDate(rs.getDate(3));
									db.setMedDays(rs.getInt(4));
									db.setMedFreq(rs.getString(5));
									db.setMedName(rs.getString(6));
									return db;
								}
							});
		}
		
		
// to get history
		
		@Override
		public List<Doctor> listHistory(int regId)
		{
		 
		return template.query("select regId,pFName,DOB from cm_patientTable where regId="+regId+"",new RowMapper<Doctor>(){

		public Doctor mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		Doctor db=new Doctor();
		db.setRegId(rs.getInt(1));
		db.setpFName(rs.getString(2));
		db.setpDOB(rs.getDate(3));
		
		return db;
		}
		});
		}

		   
		   
// To  get lab details
		
		@Override
		public List<Doctor> presListHistory(int regId) {
		   return template.query("select prescId,prescDate,medName,medDays,medFreq,sName from cm_PrescriptionTable join cm_MedicineTable using(medId) join cm_doctorTable using (dId) join cm_staffTable using (sId) where regId = "+regId+"", new RowMapper<Doctor>() {
		   public Doctor mapRow(ResultSet rs, int row) throws SQLException {
		 
		Doctor db = new Doctor();


		   db.setPrescId(rs.getInt(1));
		   db.setPrescDate(rs.getDate(2));
		   db.setMedName(rs.getString(3));
		   db.setMedDays(rs.getInt(4));
		   db.setMedFreq(rs.getString(5));
		   db.setsName(rs.getString(6));
		   return db;
		   }
		   });
		   }

		   
 //to get lab list history
		  
		@Override
		public List<Doctor> lablistHistory(int regId) {
		   return template.query("select labId,lName,sName from cm_assignLabTable join cm_LabTestTable using(labId)join cm_doctorTable using (dId) join cm_staffTable using (sId) where regId="+regId+"", new RowMapper<Doctor>() {
		   public Doctor mapRow(ResultSet rs, int row) throws SQLException {
		      Doctor db = new Doctor();

		      db.setLabId(rs.getInt(1));
		      db.setlName(rs.getString(2));
		      db.setsName(rs.getString(3));

		      return db;

		   }
		   });
		   }

//to get observation history
		@Override
		public List<Doctor> obsHistory(int regId) {
		 return template.query("select obserDate,obsNotes,sName from cm_doctorObsTable join cm_doctorTable using(dId) join cm_staffTable using(sId) join cm_patientTable using(regId) where regId="+regId+"", new RowMapper<Doctor>() {
		 public Doctor mapRow(ResultSet rs, int row) throws SQLException {

		   Doctor db = new Doctor();

		   db.setObserDate(rs.getDate(1));
		   db.setObsNotes(rs.getString(2));
		   db.setsName(rs.getString(3));
		   //db.setRegId(rs.getInt(4));
		   //db.setpFName(rs.getString(5));
		   //db.setpDOB(rs.getDate(6));


		   return db;
		   }
		   });
		   }


		   
//to age calculation

		@Override
		public int ageCalculationNew(Date s) {

		   SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		   String sqlDate = ft.format(s);
		   //System.out.println(sqlDate);
		   String s3=sqlDate.substring(0,4);
		   int now1=Integer.parseInt(s3);
		   //System.out.println("year  "+now1);

		   int now2 = s.getMonth();
		   //System.out.println(now2);

		   int now3 = s.getDate();
		   // System.out.println(now3);

		   LocalDate l = LocalDate.of(now1,now2,now3);
		   // System.out.println(l);
		   LocalDate now4 = LocalDate.now(); //gets localDate
		   Period diff = Period.between(l, now4); //difference between the dates is calculated
		   // System.out.println(diff);
		   int age = diff.getYears();
		   // System.out.println("age  "+age);
		   return age;

		   }

		
//to disable medicine
			
			@Override
			public int disableMedicine(Admin ad) {

				String sql = "update cm_medicineTable set isActive=0 where medId=?";

				return template.update(sql, new Object[] { ad.getMedId() });
			}
			
			
//to get doctor's appointments
			
			@Override
			public List<Doctor> getDoctorsAppointments(int dId) {
				return template
				.query("select appId,regId,pFName,consultStatus from cm_PatientTable join cm_AppoinmentTable using(regId) where dId = "
				+ dId
				+ " and dateOfApp = TO_DATE('"
				+ java.time.LocalDate.now() + "' ,'YYYY-MM-DD') ",
				new RowMapper<Doctor>() {
				public Doctor mapRow(ResultSet rs, int row)
				throws SQLException {
				Doctor db = new Doctor();
				db.setAppId(rs.getInt(1));
				db.setRegId(rs.getInt(2));
				db.setpFName(rs.getString(3));
				db.setConsultStatus(rs.getString(4));
				return db;
				}
				});
				}
			
//role checker
			
			@Override
			public Admin RoleChecker(String username, String password) {
				  
					String sql = "select roleId , username , password , sId  from cm_staffTable where username = ? and password = ?";
					Admin ad= template.queryForObject(sql,
							new Object[] { username, password },
							new BeanPropertyRowMapper<Admin>(Admin.class));
					
					
					int role=ad.getRoleId();
					System.out.println(role);
					if(role==3) {
						String sql2="select dId from cm_doctorTable where sId=?";
						Integer dId=template.queryForObject(sql2,
								new Object[] { ad.getsId() },
								Integer.class);
						ad.setdId(dId);
						System.out.println(dId);
					}
					System.out.println(ad);
					return ad;
				}

//to get lab id by using lab name
			
			@Override
			public Integer d_getLabId(String lName) {
				  String sql = "select labId from cm_labTestTable where lName =?";
				  return template.queryForObject(sql, new Object[] { lName },
				  Integer.class);

				  }


//to add lab reuest
				@Override
				public int getAddLabRequest(Doctor dr) {

				  Integer labId = d_getLabId(dr.getlName());
				  String sql = "insert into cm_assignLabTable(assigLabDate,regId,dId,labId)values(TO_DATE('"
				  + java.time.LocalDate.now()
				  + "','YYYY-MM-DD'),"
				  + dr.getRegId() + "," + dr.getdId() + "," + labId + ")";
				  return template.update(sql);
				  }
				
				
//to get all test
		
				@Override
				public List<Doctor> getAllTest() {
				  return template.query("select labId,lName from cm_labTestTable",
				  new RowMapper<Doctor>() {

				  @Override
				  public Doctor mapRow(ResultSet rs, int row)
				  throws SQLException {

				  Doctor doc = new Doctor();

				  doc.setLabId(rs.getInt(1));
				  doc.setlName(rs.getString(2));

				  return doc;

				  }
				  });

				  }


//to get all lab prescription

				
				@Override
				public List<Doctor> getAlllabPrescription(int regId , int dId) {
				  return template
				  .query("select labId,lName,assignLabId from cm_assignLabTable join cm_LabTestTable using(labId) join cm_doctorTable using (dId) where trunc(assigLabDate) = trunc(sysdate)and regId="+regId+" and dId="+dId+"",

				  new RowMapper<Doctor>() {
				  public Doctor mapRow(ResultSet rs, int row)
				  throws SQLException {
				  Doctor db = new Doctor();

				  db.setLabId(rs.getInt(1));
				  db.setlName(rs.getString(2));
				  db.setAssignLabId(rs.getInt(3));


				  return db;
				  }
				  });
				  }


//to delete lab using lab id
				@Override
				public Integer lab_delete(int assignLabId) {
				  String sql = "delete from cm_assignLabTable where assignLabId=?";
				  return template.queryForObject(sql, new Object[] { assignLabId },
				  Integer.class);
				  }
}

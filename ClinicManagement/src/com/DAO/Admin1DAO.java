package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Model.Admin;
import com.Model.FrontOffice;

public class Admin1DAO implements IAdmin {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;

	}
	
/********************************************************************************* STAFF ******************************************************************************/

// to view staff
	
	@Override
	public List<Admin> viewStaffById(int sId) {
		return template.query(
				"select sId,sName,password,username,sGender,DOB,sAddr,sPhNo,sEmail,sExp,roleName,roleId from cm_roletable join cm_staffTable using (roleId) where sId="
						+ sId + "",
				new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int row) throws SQLException {
						Admin ab = new Admin();
						ab.setsId(rs.getInt(1));
						ab.setsName(rs.getString(2));
						ab.setPassword(rs.getString(3));
						ab.setUsername(rs.getString(4));
						ab.setsGender(rs.getString(5));
						ab.setsDOB(rs.getDate(6));
						ab.setsAddr(rs.getString(7));
						ab.setsPhNo(rs.getString(8));
						ab.setsEmail(rs.getString(9));
						ab.setsExp(rs.getString(10));
						ab.setRoleName(rs.getString(11));
						ab.setRoleId(rs.getInt(12));
						return ab;
					}
				});
	}

//to get role id
	
	@Override
	public int getRoleId(String role) {
		// finding roleId using roleName
		String sqlRoleId = "select roleId from cm_roleTable where roleName=? ";
		return template.queryForObject(sqlRoleId, new Object[] { role }, Integer.class);

	}

//to add staff	
	
	@Override
	public int insertStaff(Admin aBean) {

		int id = getRoleId(aBean.getRoleName());

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values("
				+ id + ",'" + aBean.getsName() + "'," + "TO_DATE('" + sqlDate + "','yyyy-MM-dd')"

				// + aBean.getsDOB()
				+ ",'" + aBean.getsGender() + "','" + aBean.getsAddr() + "','" + aBean.getsExp() + "','"
				+ aBean.getsPhNo() + "','" + aBean.getsEmail() + "','" + aBean.getUsername() + "','"
				+ aBean.getPassword() + "','" + "yes" + "'," + "TO_DATE('" + java.time.LocalDate.now()
				+ "','yyyy/MM/dd'))";
		return template.update(sql, new Object[] {});
	}

// to view staff
	
	@Override
	public List<Admin> getStaff() {

		return template.query(
				"select * from cm_staffTable s join cm_roleTable r on s.roleId=r.roleId where isActive='yes' and s.roleId>3",

				new RowMapper<Admin>() {

					public Admin mapRow(ResultSet rs, int row) throws SQLException {

						Admin ad = new Admin();

						ad.setsId(rs.getInt(1));
						ad.setRoleId(rs.getInt(2));
						ad.setsName(rs.getString(3));
						ad.setsDOB(rs.getDate(4));
						ad.setsGender(rs.getString(5));
						ad.setsAddr(rs.getString(6));
						ad.setsExp(rs.getString(7));
						ad.setsPhNo(rs.getString(8));
						ad.setsEmail(rs.getString(9));
						ad.setSisActive(rs.getString(12));
						ad.setRoleName(rs.getString(15));

						return ad;

					}

				});

	}

// to update staff
	
	@Override
	public int updateStaff(Admin ab) {

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(ab.getsDOB());

		String sql = "update cm_staffTable set roleId=" + ab.getRoleId() + ",sName='" + ab.getsName()
				+ "',DOB= TO_DATE('" + sqlDate + "' ,'yyyy-MM-dd')" + ",sGender='" + ab.getsGender() + "',sAddr='"
				+ ab.getsAddr() + "',sExp='" + ab.getsExp() + "',sPhNo='" + ab.getsPhNo() + "',sEmail='"
				+ ab.getsEmail() + "',username='" + ab.getUsername() + "',password='" + ab.getPassword()
				+ "', isActive='yes' where sId=" + ab.getsId() + "";
		return template.update(sql);
	}


//to disable staff
		
		@Override
		public int disableStaff(int sId) {

			System.out.println("Hai");
			String sql = "update cm_staffTable set isActive = '0' where sId = " + sId + "";
			System.out.println("hai");
			return template.update(sql);
		}
	
//to view role
	
	@Override
	public List<Admin> role() {
		return template.query("select * from cm_roleTable", new RowMapper<Admin>() {
			public Admin mapRow(ResultSet rs, int row) throws SQLException {
				Admin ad = new Admin();
				ad.setRoleId(rs.getInt(1));
				ad.setRoleName(rs.getString(2));
				return ad;

			}
		});

	}
/********************************************************************** MEDICINE ********************************************************************/

// to view medicine
	
	@Override
	public List<Admin> list() {
		return template.query(
				"select medId,medName,medPrice,manufacturer,createdDate from cm_medicineTable where isActive=1",
				new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int row) throws SQLException {
						Admin ad = new Admin();
						ad.setMedId(rs.getInt(1));
						ad.setMedName(rs.getString(2));
						ad.setMedPrice(rs.getDouble(3));
						ad.setManufacturer(rs.getString(4));
						ad.setMcreatedDate(rs.getDate(5));
						return ad;

					}
				});
	}

//to get medicine details by using id 
	
	@Override
	public Admin getMedicineById(int medId) {
		String sql = "select * from cm_medicineTable where medId=?";
		return (Admin) template.queryForObject(sql, new Object[] { medId },
				new BeanPropertyRowMapper<Admin>(Admin.class));
	}

//to add medicines

	@Override
	public long savemed(Admin ad) {
		String sql = "insert into cm_medicineTable(medName,medPrice,isActive,manufacturer,createdDate)" + "values('"
				+ ad.getMedName() + "'," + ad.getMedPrice() + ",1,'" + ad.getManufacturer() + "',TO_DATE('"
				+ java.time.LocalDate.now() + "', 'YYYY-MM-DD'))";
		return template.update(sql);
	}

//to update medicines

	@Override
	public int update(Admin ad) {
		String sql = "update cm_medicineTable set medName='" + ad.getMedName() + "', medPrice=" + ad.getMedPrice()
				+ ",manufacturer='" + ad.getManufacturer() + "' where medId='" + ad.getMedId() + "'";
		return template.update(sql);
	}

//to disable medicine
	
	@Override
	public int disableMedicine(String medId) {

		String sql = "update cm_medicineTable set isActive = 0 where medId = '" + medId + "'";
		return template.update(sql);
	}

/********************************************************************************* DOCTOR ***************************************************************************/
	
//to view doctor
	
	@Override
	public List<Admin> listDoc() {
		return template.query(
				"select dId,sName,dSpec,sPhNo,s.sId from   cm_staffTable s join cm_doctorTable d on (d.sId=s.sId) where s.isActive!='0'",
				new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int row) throws SQLException {
						Admin ad = new Admin();
						ad.setsId(rs.getInt(5));
						ad.setsName(rs.getString(2));
						ad.setdId(rs.getInt(1));
						ad.setdSpec(rs.getString(3));
						ad.setsPhNo(rs.getString(4));
						return ad;

					}
				});
	}


//to get doctor details using id
	
	@Override
	public List<Admin> getDoctorById(int sId) {
		return template.query(
				"select sId,DOB,sGender,sAddr,sPhno,password,sEmail,username,dId,dSpec,dQualification,consultFee,sName,sExp,isActive,roleId,sunday,monday,tuesday,wednesday,thursday,friday,saturday from cm_doctorTable join cm_staffTable using (sId) join cm_consultDaysTable using (dId) where sId="
						+ sId + "",
				new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int row) throws SQLException {
						Admin ad = new Admin();

						ad.setsId(rs.getInt(1));
						ad.setsDOB(rs.getDate(2));
						ad.setsGender(rs.getString(3));
						ad.setsAddr(rs.getString(4));
						ad.setsPhNo(rs.getString(5));
						ad.setPassword(rs.getString(6));
						ad.setsEmail(rs.getString(7));
						ad.setUsername(rs.getString(8));
						ad.setdId(rs.getInt(9));
						ad.setdSpec(rs.getString(10));
						ad.setdQualification(rs.getString(11));
						ad.setConsultFee(rs.getDouble(12));
						ad.setsName(rs.getString(13));
						ad.setsExp(rs.getString(14));
						ad.setSisActive(rs.getString(15));
						ad.setRoleId(rs.getInt(16));
						ad.setSunday(rs.getString(17));
						ad.setMonday(rs.getString(18));
						ad.setTuesday(rs.getString(19));
						ad.setWednesday(rs.getString(20));
						ad.setThursday(rs.getString(21));
						ad.setFriday(rs.getString(22));
						ad.setSaturday(rs.getString(23));

						return ad;

					}
				});
	}

//to insert doctor into staff table

	@Override
	public int insertDoctorStaff(Admin aBean) {

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values(3,'"
				+ aBean.getsName() + "'," + "TO_DATE('" + sqlDate + "','yyyy-MM-dd')"

				// + aBean.getsDOB()
				+ ",'" + aBean.getsGender() + "','" + aBean.getsAddr() + "','" + aBean.getsExp() + "','"
				+ aBean.getsPhNo() + "','" + aBean.getsEmail() + "','" + aBean.getUsername() + "','"
				+ aBean.getPassword() + "','" + "yes" + "'," + "TO_DATE('" + java.time.LocalDate.now()
				+ "','yyyy/MM/dd'))";

		if (template.update(sql) != 0) {

			if (insertDoctor(aBean) != 0) {
				return insertAvailableDays(aBean);
			} else {
				return 0;
			}

		} else {
			return 0;
		}

	}

//to insert doctor into doctor table
	@Override
	public int insertDoctor(Admin aBean) {

		String sql = "select max(sId) from cm_staffTable";
		int sId = template.queryForObject(sql, Integer.class);

		String sql2 = "insert into cm_doctorTable(sId,dSpec,dQualification,consultFee) values(?,?,?,?)";

		return template.update(sql2,
				new Object[] { sId, aBean.getdSpec(), aBean.getdQualification(), aBean.getConsultFee() });
	}
	
//to update doctor

	@Override
	public Integer updateDoctor(Admin ds) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(ds.getsDOB());
		java.util.Date date = new java.util.Date();

		long t = date.getTime();

		//java.sql.Date sqlDate = new java.sql.Date(t);

		String sql = "update cm_staffTable set"

				+ " sName='" + ds.getsName()

				+ "',"

				+ "DOB=" + "TO_DATE('" + sqlDate + "','YYYY-MM-DD')"

				+ ","

				+ "sGender='" + ds.getsGender()

				+ "',"

				+ "sAddr='" + ds.getsAddr()

				+ "',"

				+ "sExp='" + ds.getsExp()

				+ "',"

				+ "sPhNo='" + ds.getsPhNo()

				+ "',"

				+ "sEmail='" + ds.getsEmail()

				+ "',"

				+ "username='" + ds.getUsername()

				+ "',"

				+ "password='" + ds.getPassword()

				+ "',"

				+ "isActive='" + ds.getSisActive() + "'"

				+ "where sId=" + ds.getsId() + "";

		template.update(sql);

		String sql1 = "update  cm_doctorTable set"

				+ " dSpec='" + ds.getdSpec()

				+ "',"

				+ "dQualification='" + ds.getdQualification()

				+ "'," + "consultFee=" + ds.getConsultFee() + "where dId=" + ds.getdId();

		template.update(sql1);

		String sql2 = "update cm_consultDaysTable set"

				+ " sunday='" + ds.getSunday()

				+ "',"

				+ "monday='" + ds.getMonday()

				+ "',"

				+ "tuesday='" + ds.getTuesday()

				+ "',"

				+ "wednesday='" + ds.getWednesday()

				+ "',"

				+ "thursday='" + ds.getThursday()

				+ "',"

				+ "friday='" + ds.getFriday()

				+ "',"

				+ "saturday='" + ds.getSaturday()

				+ "' where consultDayId=" + ds.getConsultDayId();

		return template.update(sql2);

	}


//to insert doctor availability
	@Override
	public int insertAvailableDays(Admin aBean) {

		String sql = "select max(dId) from cm_doctorTable";
		int dId = template.queryForObject(sql, Integer.class);

		String sql2 = "insert into cm_consultDaysTable(dId,sunday,monday,tuesday,wednesday,thursday,friday,saturday) values(?,?,?,?,?,?,?,?)";
		return template.update(sql2, new Object[] { dId, aBean.getSunday(), aBean.getMonday(), aBean.getTuesday(),
				aBean.getWednesday(), aBean.getThursday(), aBean.getFriday(), aBean.getSaturday() });
	}


//to insert appointments
	
	@Override
	public int insertAppointment(FrontOffice fob) {

		// SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		// String sqlDate = ft.format(fob.getpDOB());

		String sql1 = "insert into cm_appoinmentTable(regId,dId,dateOfApp,consultStatus) values(" + fob.getRegId() + ","
				+ fob.getdId() + ",TO_DATE('" + java.time.LocalDate.now() + "','yyyy-MM-dd'),'yes')";
		template.update(sql1);

		String sql2 = "insert into cm_frontOfficeBilling(regId,dId,billDate,admFee) values(" + fob.getRegId() + ","
				+ fob.getdId() + ",TO_DATE('" + java.time.LocalDate.now() + "','yyyy-MM-dd')," + fob.getAdmFee() + ")";
		return template.update(sql2);

	}

	@Override
	public int disableStaff(Admin ad) {
		// TODO Auto-generated method stub
		return 0;
	}

}

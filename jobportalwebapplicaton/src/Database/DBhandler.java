package Database;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import getter_setter.AppliedJobs;
import getter_setter.employe;
import getter_setter.jobs;
import getter_setter.linkendin;
import oracle.jdbc.pool.OracleDataSource;
import oracle.net.aso.e;
import oracle.net.aso.n;

public class DBhandler {
	Connection con=null;
	
	PreparedStatement stmt=null;
	ResultSet rSet=null;
	public Connection getDBcon()
	{
		try {
			OracleDataSource ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con=ods.getConnection("xe","icsd");
		    
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return con;
	}
	
	public boolean isUserEmailexist(String email)
	{
		boolean res=false;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from employe where email=?");
			stmt.setString(1, email);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				res=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return res;
	}
	
	public void deleteupdateprofile(int srno)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("delete from updateempprofile where empno=?");
			stmt.setInt(1, srno);
			stmt.executeQuery();
			System.out.println("updateempprofile also deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getEmailByEmpSerialNumber(int empserialnumber)
	{
		String email="";
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select email from employe where empno=?");
			stmt.setInt(1, empserialnumber);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				email=rSet.getString("email");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return email;
	}
	
	public boolean isUserphoneexist(String phone)
	{
		boolean res=false;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from employe where enum=?");
			stmt.setString(1, phone);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				res=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return res;
	}
	
	
	public int getEmpnobyEmailId(String email_id)
	{
		int empno=0;
		con=getDBcon();
		try {
		stmt=con.prepareStatement("select empno from employe where email=?");
		stmt.setString(1, email_id);
		rSet=stmt.executeQuery();
		while(rSet.next())
		{
		   empno=rSet.getInt(1);
		   return empno;   
		}
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
		return empno;
	}
	
	public void updatejobs(int srno,String companyname,String jobtitle, String workexperience, String post, String location, String vacancy)
	{
		con=getDBcon();
		try {
//			SRNO         NOT NULL NUMBER(3)     
//			COMPANY_NAME          VARCHAR2(100) 
//			JOBREQ                VARCHAR2(50)  
//			WORKEXP               VARCHAR2(50)  
//			FIELD                 VARCHAR2(50)  
//			DESIGNATION           VARCHAR2(50)  
//			VACCANY               VARCHAR2(50) 
			stmt=con.prepareStatement("update jobs set company_name=? , jobreq=?, workexp=?, field=?, designation= ?, vaccany=? where srno=?");
			stmt.setString(1, companyname);
			stmt.setString(2, jobtitle);
			stmt.setString(3, workexperience);
			stmt.setString(4, post);
			stmt.setString(5, location);
			stmt.setString(6, vacancy);
			stmt.setInt(7, srno);
			stmt.executeQuery();
			System.out.println("jobs updated successfully");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public LinkedList<employe> getEmployesbyEmpemail(String Emailid)
	{
		LinkedList<employe> list=new LinkedList<>();
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from employe where email=?");
			stmt.setString(1, Emailid);
			rSet=stmt.executeQuery();
			//ENAME         VARCHAR2(30)  
			//EMAIL         VARCHAR2(30)  
			//PASS          VARCHAR2(15)  
			//DOB           VARCHAR2(15)  
			//SECTOR        VARCHAR2(5)   
			//EMPPHOTO      VARCHAR2(100) 
			//EMPNO         NUMBER(4)  

			if(rSet.next())
			{
			String strnm=rSet.getString("ename"),
					stremail=rSet.getString("email"),
					strpass=rSet.getString("pass"),
			strdob=rSet.getString("dob"),
			strsec=rSet.getString("sector"),
			
			
			strEnum=rSet.getString("enum");
			int strempno=rSet.getInt("empno");
			employe emp=new employe(strnm, stremail, strpass, strdob, strsec, strempno,strEnum);
			System.out.println("db work");
			list.add(emp);
			}	
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public boolean isValidUser(String Emailid,String pass)
	{
		boolean res=false;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from employe where Email=? and pass=?");
			stmt.setString(1, Emailid);
			stmt.setString(2, pass);
			rSet=stmt.executeQuery();
			
			if(rSet.next())
			{
				res=true;
			}
			else {
				res=false;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return res;
	}
	
	public LinkedList<jobs> getjobs()
	{
		LinkedList<jobs> linkedList = new LinkedList<>();
		
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from jobs");
			rSet=stmt.executeQuery();
			//SRNO         NOT NULL NUMBER(3)     
			//COMPANY_NAME          VARCHAR2(100) 
			//JOBREQ                VARCHAR2(20)  
			//WORKEXP               VARCHAR2(10)  
			//FIELD                 VARCHAR2(5)   
			//DESIGNATION           VARCHAR2(20)  
			//VACCANY               VARCHAR2(50)  
			//LOGO                  VARCHAR2(100)
			while(rSet.next())
			{
				int strSrno=rSet.getInt("srno");
				String strcmpnm=rSet.getString("company_name");
				String strjobreq=rSet.getString("jobreq");
				String strwrkexp=rSet.getString("workexp");
				String strfild=rSet.getString("field");
				String strdesi=rSet.getString("designation");
				String strvaccy=rSet.getString("vaccany");
				jobs objjobs=new jobs(strSrno, strcmpnm, strjobreq, strwrkexp, strfild, strdesi, strvaccy);
				linkedList.add(objjobs);
			}
		}
		
		catch (SQLException e) {
			// TODO: handle exception
		}
		
		return linkedList;
		
	}
	
	public void deletejob(int srno)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement(" delete from jobs where srno=?");
			stmt.setInt(1, srno);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	ENAME             VARCHAR2(30)  
//	EMAIL             VARCHAR2(30)  
//	PASS              VARCHAR2(15)  
//	DOB               VARCHAR2(15)  
//	SECTOR            VARCHAR2(15)  
//	EMPPHOTO          VARCHAR2(100) 
//	ENUM              VARCHAR2(20)  
//	EMPNO    NOT NULL NUMBER(4) 
	public LinkedList<employe> getemployes()
	{
		LinkedList<employe> list=new LinkedList<>();
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from employe");
			rSet=stmt.executeQuery();
			while(rSet.next()) {
	        String strEnm=rSet.getString("ename");
	        String strEemail=rSet.getString("email");
	        String strEpass=rSet.getString("pass");
	        String strEdao=rSet.getString("dob");
	        String strEsec=rSet.getString("sector");
	        String strEnum=rSet.getString("enum");
	        int strEno=rSet.getInt("empno");
	        
	        employe emp=new employe(strEnm, strEemail, strEpass, strEdao, strEsec,  strEno, strEnum);
	        list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateuserProfile(int empno,String linkedin,String skills,String certi)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into updateEmpProfile values(?,?,?,?)");
			stmt.setInt(1, empno);
			stmt.setString(2, linkedin);
			stmt.setString(3, skills);
			stmt.setString(4, certi);
			stmt.executeQuery();
			System.out.println("profile is updated ");
		}
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public boolean isProfileUpdated(String email)
	{
		int empno=getcurrentempno(email);
		
		boolean res=false;
		try {
		stmt=con.prepareStatement("select * from updateEmpProfile where empno=?");
		stmt.setInt(1, empno);
		rSet=stmt.executeQuery();
		if(rSet.next())
		{
			res=true;
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}
	
	public int getcurrentempno(String stremail)
	{
		int empno = 0;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select empno from employe where email=?");
			stmt.setString(1, stremail);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				 empno=rSet.getInt(1);
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return empno;
	}
	
	public void deleteUser(int srno)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("delete from employe where empno=?");
			stmt.setInt(1, srno);
			stmt.executeQuery();
		} catch (SQLException e) {
          e.printStackTrace();
		}
	}
	public LinkedList<employe> getempbySrno(int srno)
	{
		LinkedList<employe> list =new LinkedList<>();
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from employe where empno=?");
			stmt.setInt(1, srno);
			rSet=stmt.executeQuery();
			
			if(rSet.next()) {
			String strEnm=rSet.getString("ename");
	        String strEemail=rSet.getString("email");
	        String strEpass=rSet.getString("pass");
	        String strEdao=rSet.getString("dob");
	        String strEsec=rSet.getString("sector");
	        String strEnum=rSet.getString("enum");
	        int strEno=rSet.getInt("empno");
	        employe emp=new employe(strEnm, strEemail, strEpass, strEdao, strEsec,  strEno, strEnum);
	        list.add(emp);
			}
		}
			catch (SQLException e) {
			// TODO: handle exception
		}
				return list;
	}
//	ENAME             VARCHAR2(30)  
//	EMAIL             VARCHAR2(30)  
//	PASS              VARCHAR2(15)  
//	DOB               VARCHAR2(15)  
//	SECTOR            VARCHAR2(15)  
//	EMPPHOTO          VARCHAR2(100) 
//	ENUM              VARCHAR2(20)  
//	EMPNO    NOT NULL NUMBER(4) 
	
	public String getAdminOldPass(String userId)
	{
		String pass=null;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select pass from projectadmin where userid=?");
			stmt.setString(1, userId);
			rSet=stmt.executeQuery();
			if (rSet.next()) {
				pass=rSet.getString("pass");
			}
		} catch (SQLException e) {
             e.printStackTrace();
		}
		return pass;
	}
	
	public void changeAdminPass(String userid,String newPass)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("update projectadmin set pass=? where userid=?");
			stmt.setString(1, newPass);
			stmt.setString(2, userid);
			stmt.executeQuery();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void updateUserData(String strname,String strEmail,String strpass,String stdob,String Strsec,String strphnno,int srno)
	{
		con=getDBcon();
		try {
			
			stmt=con.prepareStatement("update employe set ename=?,email=?,pass=?,dob=?,sector=?,enum=? where empno=?");
			stmt.setString(1, strname);
			stmt.setString(2, strEmail);
			stmt.setString(3, strpass);
			stmt.setString(4, stdob);
			stmt.setString(5, Strsec);
			stmt.setString(6, strphnno);
			stmt.setInt(7, srno);
			stmt.executeQuery();
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public LinkedList<AppliedJobs> getapplyjobs()
	{
		LinkedList<AppliedJobs> list=new LinkedList<AppliedJobs>();
		AppliedJobs objapplyjob;
		
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from applyjobs");
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
				//JOBSRNO          NUMBER(4)    
				//USERNAME         VARCHAR2(40) 
				//EMAIL            VARCHAR2(40) 
				//PHONENUMBER      VARCHAR2(12) 
				//JOBTITLE         VARCHAR2(50) 
				//COMPANYNAME      VARCHAR2(50)
				
				int jobsrno=rSet.getInt(1);
				String username=rSet.getString("username");
				String email=rSet.getString("email");
				String phonenumber=rSet.getString("phonenumber");
				String jobtitle=rSet.getString("jobtitle");
				String companyname=rSet.getString("companyname");
				int empserialno=rSet.getInt("empno");
				objapplyjob =new AppliedJobs(jobsrno, username, email, phonenumber, jobtitle, companyname,empserialno);
				list.add(objapplyjob);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}
	
	public LinkedList<jobs> getjobsbycategory(String strfield)
	{
		LinkedList<jobs> list=new LinkedList<>();
		
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from jobs where field=?");
			stmt.setString(1, strfield);
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
				int strSrno=rSet.getInt("srno");
				String strcmpnm=rSet.getString("company_name");
				String strjobreq=rSet.getString("jobreq");
				String strwrkexp=rSet.getString("workexp");
				String strfild=rSet.getString("field");
				String strdesi=rSet.getString("designation");
				String strvaccy=rSet.getString("vaccany");
				
				jobs objjobs=new jobs(strSrno, strcmpnm, strjobreq, strwrkexp, strfild, strdesi, strvaccy);
                list.add(objjobs);
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public String getUserNameBySerialNumber(int srno)
	{
		String name = "";
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select ename from employe where empno=?");
			stmt.setInt(1, srno);
			rSet=stmt.executeQuery();
			
			while(rSet.next())
			{
				name=rSet.getString("ename");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return name;
	}
	
	public String getCompanynamebyjobserialnumber(int jobserialnumber)
	{
		String companyname="";
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select companyname from applyjobs where jobsrno=?");
			stmt.setInt(1, jobserialnumber);
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
				companyname=rSet.getString("companyname");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return companyname;
	}
	
	public void insertintodemoemploye(String name,String email,String pass,String dob,String sector,String phonenumber)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into demoemploye values(?,?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, pass);
			stmt.setString(4, dob);
			stmt.setString(5, sector);
			stmt.setString(6, phonenumber);
			stmt.executeQuery();
			System.out.println("demo inserted done");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void deleteuserfromappliedjob(int empserialnumber,int jobserialnumber)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("delete from applyjobs where empno=? and jobsrno=?");
			stmt.setInt(1, empserialnumber);
			stmt.setInt(2, jobserialnumber);
			stmt.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public String getJobTitlebyjobserialnumber(int jobserialnumber)
	{
		String jobtitle="";
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select jobtitle from applyjobs where jobsrno=?");
			stmt.setInt(1, jobserialnumber);
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
				jobtitle=rSet.getString("jobtitle");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return jobtitle;
	}
	
	
	public int getJobSerialNumberByEmpSerialNumber(int empserialnumber)
	{
		int jobserialnumber=0;
		con=getDBcon();
		try {
			
			stmt=con.prepareStatement("select jobsrno from applyjobs where empno=?");
			stmt.setInt(1, empserialnumber);
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
				jobserialnumber=rSet.getInt("jobsrno");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jobserialnumber;
	}
	
	public String getContactNumberBySerialNumber(int srno)
	{
		String contect="";
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select enum from employe where empno=?");
			stmt.setInt(1, srno);
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
				contect=rSet.getString("enum");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return contect;
	}
	
	public LinkedList<linkendin> getUserlinkedin(int empserialnumber)
	{
		LinkedList<linkendin> list=new LinkedList<>();
		
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from updateempprofile where empno=?");
			stmt.setInt(1, empserialnumber);
			rSet=stmt.executeQuery();
			while(rSet.next())
			{
//				EMPNO             NUMBER(4)     
//				LINKEDIN          VARCHAR2(50)  
//				SKILLS            VARCHAR2(100) 
//				CERTIFICATES      VARCHAR2(150) 
				String linkin=rSet.getString("linkedin");
				String skills=rSet.getString("skills");
				String certificates=rSet.getString("certificates");
				linkendin objlinkedin=new linkendin(empserialnumber, linkin, skills, certificates);
				list.add(objlinkedin);
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
    
	public void applyjob(int jobsrno,String Ename,String Email,String pnumber,String jobtitle,String companyname, int empserialnumber)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into applyjobs values(?,?,?,?,?,?,?)");
			stmt.setInt(1, jobsrno);
			stmt.setString(2, Ename);
			stmt.setString(3, Email);
			stmt.setString(4, pnumber);
			stmt.setString(5, jobtitle);
			stmt.setString(6, companyname);
			stmt.setInt(7, empserialnumber);
			stmt.executeQuery();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String FetchEmailfromApplyjobs(int srno)
	{
		String email="";
		System.out.println("fetch email work");
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select email from applyjobs where jobsrno=?");
			stmt.setInt(1, srno);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				email=rSet.getString("email");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return email; 
	}
	
	public LinkedList<jobs> getjobsBySrno(int srno)
	{
		LinkedList<jobs> list=new LinkedList<>();
		
		con=getDBcon();
		try {
			
			stmt=con.prepareStatement("select * from jobs where srno=?");
			stmt.setInt(1, srno);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				int strSrno=rSet.getInt("srno");
				String strcmpnm=rSet.getString("company_name");
				String strjobreq=rSet.getString("jobreq");
				String strwrkexp=rSet.getString("workexp");
				String strfild=rSet.getString("field");
				String strdesi=rSet.getString("designation");
				String strvaccy=rSet.getString("vaccany");
				
				jobs objjobs=new jobs(strSrno, strcmpnm, strjobreq, strwrkexp, strfild, strdesi, strvaccy);
				list.add(objjobs);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return list;
	}
//	EMPNM             VARCHAR2(100) 
//	EMPEMAIL          VARCHAR2(100) 
//	DAO               VARCHAR2(50)  
//	EMPPHN            VARCHAR2(50)  
//	CMPNM             VARCHAR2(50)  
//	JOBSRNO  NOT NULL NUMBER(5)     
//	JOBREQ            VARCHAR2(50)  
//	JOBFIELD          VARCHAR2(50)  
//	JOBDESI           VARCHAR2(50)  
//	RESUM             VARCHAR2(100) 
	public void applyJobsInsert(String StrEmpNm,String StrEmpEmail,String strDao,String Empphn,String StrCmpNm,int srno,
		String jobreq,String jobfield,String jobdesi,String resum)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into applyjobs values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, StrEmpNm);
			stmt.setString(2, StrEmpEmail);
			stmt.setString(3, strDao);
			stmt.setString(4, Empphn);
			stmt.setString(5, StrCmpNm);
			stmt.setInt(6, srno);
			stmt.setString(7, jobreq);
			stmt.setString(8, jobfield);
			stmt.setString(9, jobdesi);
			stmt.setString(10, resum);
			stmt.executeQuery();
			System.out.println("insert sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void userSignup(String name,String email, String pass, String dob, String Sector,String phonenumber,int empserialnumber)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into employe values(?,?,?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, pass);
			stmt.setString(4, dob);
			stmt.setString(5, Sector);
			stmt.setString(6, phonenumber);
			stmt.setInt(7, empserialnumber);
			stmt.executeQuery();
			System.out.println("inserted --");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void signup(int empno,String strnm,String stremail,String strpass,String strdao,String sector,String mnum)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into employe values(?,?,?,?,?,?,?)");
			System.out.println(strnm+" "+stremail);
//			ENAME           VARCHAR2(30) 
//			EMAIL           VARCHAR2(30) 
//			PASS            VARCHAR2(15) 
//			DOB             VARCHAR2(15) 
//			SECTOR          VARCHAR2(15) 
//			ENUM            VARCHAR2(20) 
//			EMPNO  NOT NULL NUMBER(4)  
			stmt.setString(1, strnm);
			stmt.setString(2, stremail);
			stmt.setString(3, strpass);
			stmt.setString(4, strdao);
			stmt.setString(5, sector);
			stmt.setString(6, mnum);
			stmt.setInt(7, empno);
			stmt.executeQuery();
			System.out.println("inserted ");
			
		} catch (SQLException e) {
			
		}
	}
	public int getmaxEmpno()
	{
		int max=0;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select max(empno) from employe");
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				max=rSet.getInt("max(empno)");
				System.out.println("max="+max);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return max;
				
	}
   
	public void updatePass(int eno,String newPass)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("update employe set pass=? where empno=?");
			stmt.setString(1, newPass);
			stmt.setInt(2, eno);
			stmt.executeQuery();
			
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}
//	SRNO         NOT NULL NUMBER(3)     
//	COMPANY_NAME          VARCHAR2(100) 
//	JOBREQ                VARCHAR2(20)  
//	WORKEXP               VARCHAR2(10)  
//	FIELD                 VARCHAR2(5)   
//	DESIGNATION           VARCHAR2(20)  
//	VACCANY               VARCHAR2(50)  
//	LOGO                  VARCHAR2(100) 

	public void insertIntoJobs(int srno,String strcnm,String strjreq,String wrkexp,String strfield,String strdesi,String vaccy)
	{
		con=getDBcon();
		try {
			stmt=con.prepareStatement("insert into jobs values(?,?,?,?,?,?,?)");
			stmt.setInt(1, srno);
			stmt.setString(2, strcnm);
			stmt.setString(3, strjreq);
			stmt.setString(4, wrkexp);
			stmt.setString(5, strfield);
			stmt.setString(6, strdesi);
			stmt.setString(7, vaccy);
			
			stmt.executeQuery();
			
			System.out.println("insert in database working");
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public boolean isValidAdmin(String struserid,String strpass)
	{
		boolean res=true;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select * from projectadmin where userid=? and pass=?");
			stmt.setString(1, struserid);
			stmt.setString(2, strpass);
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				res=true;
			}
			else {
				res=false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return res;
	}
	
	public int getMaxSrno()
	{
		int srno=0;
		con=getDBcon();
		try {
			stmt=con.prepareStatement("select max(srno) from jobs");
			rSet=stmt.executeQuery();
			if(rSet.next())
			{
				srno=rSet.getInt("max(srno)");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return srno;
	}
	
}

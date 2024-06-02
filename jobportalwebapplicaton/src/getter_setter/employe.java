package getter_setter;

//ENAME         VARCHAR2(30)  
//EMAIL         VARCHAR2(30)  
//PASS          VARCHAR2(15)  
//DOB           VARCHAR2(15)  
//SECTOR        VARCHAR2(5)   
//EMPPHOTO      VARCHAR2(100) 
//EMPNO         NUMBER(4)  

public class employe {

	public employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public employe(String strEname, String strEid, String strpass, String strdob, String strsec,int strempno,
			String strEnum) {
		super();
		this.strEname = strEname;
		this.strEid = strEid;
		this.strpass = strpass;
		this.strdob = strdob;
		this.strsec = strsec;
		
		this.strempno = strempno;
		this.strEnum=strEnum;
	}

	

	String strEname,strEid,strpass,strdob,strsec,strempphoto,strEnum;
    int strempno;
	@Override
	public String toString() {
		return "employe [strEname=" + strEname + ", strEid=" + strEid + ", strpass=" + strpass + ", strdob=" + strdob
				+ ", strsec=" + strsec + ", strempno=" + strempno + ", strEnum="
				+ strEnum + "]";
	}

	public String getStrEnum() {
		return strEnum;
	}

	public void setStrEnum(String strEnum) {
		this.strEnum = strEnum;
	}

	public String getStrEname() {
		return strEname;
	}

	public void setStrEname(String strEname) {
		this.strEname = strEname;
	}

	public String getStrEid() {
		return strEid;
	}

	public void setStrEid(String strEid) {
		this.strEid = strEid;
	}

	public String getStrpass() {
		return strpass;
	}

	public void setStrpass(String strpass) {
		this.strpass = strpass;
	}

	public String getStrdob() {
		return strdob;
	}

	public void setStrdob(String strdob) {
		this.strdob = strdob;
	}

	public String getStrsec() {
		return strsec;
	}

	public void setStrsec(String strsec) {
		this.strsec = strsec;
	}



	public int getStrempno() {
		return strempno;
	}

	public void setStrempno(int strempno) {
		this.strempno = strempno;
	}
	
}

package getter_setter;

//JOBSRNO          NUMBER(4)    
//USERNAME         VARCHAR2(40) 
//EMAIL            VARCHAR2(40) 
//PHONENUMBER      VARCHAR2(12) 
//JOBTITLE         VARCHAR2(50) 
//COMPANYNAME      VARCHAR2(50)

public class AppliedJobs {

	int jobsrno,empsrno;
	String username,email,phonenumber,jobtitle,companyname;
	public AppliedJobs(int jobsrno, String username, String email, String phonenumber, String jobtitle,
			String companyname,int empsrno) {
		super();
		this.jobsrno = jobsrno;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.jobtitle = jobtitle;
		this.companyname = companyname;
		this.empsrno=empsrno;
	}
	public int getJobsrno() {
		return jobsrno;
	}
	public void setJobsrno(int jobsrno) {
		this.jobsrno = jobsrno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public int getEmpsrno() {
		return empsrno;
	}
	public void setEmpsrno(int empsrno) {
		this.empsrno = empsrno;
	}
	@Override
	public String toString() {
		return "AppliedJobs [jobsrno=" + jobsrno + ", empsrno=" + empsrno + ", username=" + username + ", email="
				+ email + ", phonenumber=" + phonenumber + ", jobtitle=" + jobtitle + ", companyname=" + companyname
				+ "]";
	}
	
	
}

package getter_setter;

public class linkendin {
	
	int empserailnumber;
	String linkedin,skills,cerificate;
	public linkendin(int empserailnumber, String linkedin, String skills, String cerificate) {
		super();
		this.empserailnumber = empserailnumber;
		this.linkedin = linkedin;
		this.skills = skills;
		this.cerificate = cerificate;
	}
	public int getEmpserailnumber() {
		return empserailnumber;
	}
	public void setEmpserailnumber(int empserailnumber) {
		this.empserailnumber = empserailnumber;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCerificate() {
		return cerificate;
	}
	public void setCerificate(String cerificate) {
		this.cerificate = cerificate;
	}
	@Override
	public String toString() {
		return "linkendin [empserailnumber=" + empserailnumber + ", linkedin=" + linkedin + ", skills=" + skills
				+ ", cerificate=" + cerificate + "]";
	}
	

}

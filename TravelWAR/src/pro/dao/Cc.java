package pro.dao;

public class Cc {
	private String ccmail;
	private String ccpass;
	public String getCcmail() {
		return ccmail;
	}
	public void setCcmail(String ccmail) {
		this.ccmail = ccmail;
	}
	public String getCcpass() {
		return ccpass;
	}
	public void setCcpass(String ccpass) {
		this.ccpass = ccpass;
	}
	public Cc(String ccmail, String ccpass) {
		super();
		this.ccmail = ccmail;
		this.ccpass = ccpass;
	}
	public Cc() {
		super();
	}
	

}

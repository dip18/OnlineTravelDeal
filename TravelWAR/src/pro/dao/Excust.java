package pro.dao;

public class Excust {
	private String cmail;
	private String cpass;
	public String getCmail() {
		return cmail;
	}
	public void setCmail(String cmail) {
		this.cmail = cmail;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public Excust(String cmail, String cpass) {
		super();
		this.cmail = cmail;
		this.cpass = cpass;
	}
	public Excust() {
		super();
	}
	

}

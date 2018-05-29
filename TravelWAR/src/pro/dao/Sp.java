package pro.dao;

public class Sp 
{
	private String spmail;
	private String sppass;
	public String getSpmail() {
		return spmail;
	}
	public void setSpmail(String spmail) {
		this.spmail = spmail;
	}
	public String getSppass() {
		return sppass;
	}
	public void setSppass(String sppass) {
		this.sppass = sppass;
	}
	public Sp(String spmail, String sppass) {
		super();
		this.spmail = spmail;
		this.sppass = sppass;
	}
	public Sp() {
		super();
	}
	
	
	
}

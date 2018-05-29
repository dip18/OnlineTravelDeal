package pro.dao;

public class Mer {
	
	private int merid;
	private String mername;
	private String mermail;
	private String merpass;

	public int getMerid() {
		return merid;
	}
	public void setMerid(int merid) {
		this.merid = merid;
	}

	public String getMername() {
		return mername;
	}
	public void setMername(String mername) {
		this.mername = mername;
	}
	public String getMermail() {
		return mermail;
	}
	public void setMermail(String mermail) {
		this.mermail = mermail;
	}
	public String getMerpass() {
		return merpass;
	}
	public void setMerpass(String merpass) {
		this.merpass = merpass;
	}
	
	public Mer(String mermail, String merpass) {
		super();
		this.mermail = mermail;
		this.merpass = merpass;
	}
	
	public Mer(String mermail, int merid, String merpass) {
		super();
		this.mermail = mermail;
		this.merid = merid;
		this.merpass = merpass;
	}
	
	public Mer(String mername) {
		super();
		this.mername = mername;
	}
	public Mer() {
		super();
	}
	

}

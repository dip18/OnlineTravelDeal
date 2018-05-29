package pro.dao;

public class Customer
{
	private int custid;
	private String cname;
	private String cmail;
	private String cpass;
	
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
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
	public Customer(String cname, String cmail, String cpass) {
		super();
		this.cname = cname;
		this.cmail = cmail;
		this.cpass = cpass;
	}
	
	public Customer(int custid, String cname, String cmail, String cpass) {
		super();
		this.custid = custid;
		this.cname = cname;
		this.cmail = cmail;
		this.cpass = cpass;
	}
	
	
	public Customer(String cname, String cmail) {
		super();
		this.cname = cname;
		this.cmail = cmail;
	}
	public Customer(int custid) {
		super();
		this.custid = custid;
	}
	
	
	public Customer(int custid, String cname) {
		super();
		this.custid = custid;
		this.cname = cname;
	}
	public Customer() {
		super();
	}
	
	
	
	
}

package pro.dao;

public class CustOffer
{
	private int custid;
	private int offerid;
	private int status;
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getOfferid() {
		return offerid;
	}
	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public CustOffer(int custid, int offerid) {
		super();
		this.custid = custid;
		this.offerid = offerid;
	}
	
	public CustOffer(int status) {
		super();
		this.status = status;
	}
	public CustOffer() {
		super();
	}
	
}

package pro.dao;

public class Salesperson 
{
	private int offerid;
	private String description;
	private int price;
	private String validfrom;
	private String validto;
	private int merchantid;
	
	public int getOfferid() {
		return offerid;
	}
	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getValidfrom() {
		return validfrom;
	}
	public void setValidfrom(String validfrom) {
		this.validfrom = validfrom;
	}
	public String getValidto() {
		return validto;
	}
	public void setValidto(String validto) {
		this.validto = validto;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public Salesperson(String description, int price, String validfrom,
			String validto, int merchantid) {
		super();
		this.description = description;
		this.price = price;
		this.validfrom = validfrom;
		this.validto = validto;
		this.merchantid = merchantid;
	}
	public Salesperson() {
		super();
	}
	public Salesperson(int offerid,String description, int price, String validfrom,
			String validto) {
		super();
		this.offerid = offerid;
		this.description = description;
		this.price = price;
		this.validfrom = validfrom;
		this.validto = validto;
	}
	public Salesperson(String description, int price, String validfrom,
			String validto) {
		super();
		this.description = description;
		this.price = price;
		this.validfrom = validfrom;
		this.validto = validto;
	}
	
	
}

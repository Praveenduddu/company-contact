package de.zeroco.contact;

public class Contact {

	private int id;
	private String name;
	private String email;
	private long number;
	private String dateOfBirth;
	private String address;
	private int companyId;
	
	public Contact(int id, String name, String email, long number, String dateOfBirth, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Contact(String name, String email, long number, String dateOfBirth, String address, int companyId) {
		this.name = name;
		this.email = email;
		this.number = number;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.companyId = companyId;
	}
	
	public Contact() {
		
	}
}

package de.zeroco.company;

public class Company {

	private int id;
	private String name;
	private String email;
	private int number;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public Company(String name, String email, int number, String address) {
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
	}

	public Company(int id, String name, String email, int number, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Company() {
		
	}
	
}

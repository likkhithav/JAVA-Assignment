package com.dto;

public class CustomerOrderDto {
	
	private int id;
	private String firstName;
	private int total;
	
	public CustomerOrderDto() {}
	
	public CustomerOrderDto(int id, String firstName, int total) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.total = total;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "CustomerOrderDto [id=" + id + ", firstName=" + firstName + ", total=" + total + "]";
	}
	
	
}

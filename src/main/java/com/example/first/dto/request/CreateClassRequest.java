package com.example.first.dto.request;

public class CreateClassRequest {
	private String name;

	public CreateClassRequest() {
		super();
	}

	public CreateClassRequest(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

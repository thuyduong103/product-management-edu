package com.example.first.dto.response;

public class StudentDTO {
	private Long id;
	private String fname;
	private String phone;
	private String birth; 
	private double mathScore;
	private double engScore;
	private ClassDTO classes;
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(Long id, String fname, String phone, String birth, double mathScore, double engScore,
			ClassDTO classes) {
		super();
		this.id = id;
		this.fname = fname;
		this.phone = phone;
		this.birth = birth;
		this.mathScore = mathScore;
		this.engScore = engScore;
		this.classes = classes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public double getMathScore() {
		return mathScore;
	}

	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}

	public double getEngScore() {
		return engScore;
	}

	public void setEngScore(double engScore) {
		this.engScore = engScore;
	}

	public ClassDTO getClasses() {
		return classes;
	}

	public void setClasses(ClassDTO classes) {
		this.classes = classes;
	}
	
	
	
	
	
}

package com.example.first.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="fname")
	private String fullName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="birth")
	private String birth;
	
	@Column(name="math")
	private double mathScore;
	
	@Column(name="english")
	private String engScore;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	
	private ClassEntity classes;
	

	public ClassEntity getClasses() {
		return classes;
	}

	public void setClasses(ClassEntity classes) {
		this.classes = classes;
	}

	public StudentEntity() {
		super();
	}

	public StudentEntity(Long id, String fullName, String phone, String birth, double mathScore, String engScore) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.birth = birth;
		this.mathScore = mathScore;
		this.engScore = engScore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getEngScore() {
		return engScore;
	}

	public void setEngScore(String engScore) {
		this.engScore = engScore;
	}
	
	
	
	
}

package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.request.CreateStudentRequest;
import com.example.first.dto.response.StudentDTO;
import com.example.first.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService stdService;
	
	@GetMapping("/list")
//	public Page<StudentDTO> getList(@RequestParam(defaultValue = "0") int page,
//			@RequestParam(defaultValue="10") int pageSize){
//		Pageable pageable = PageRequest.of(page, pageSize, Sort.by("fname"));
//		return stdService.getListStudent(pageable);
//	}
	public List<StudentDTO> getList(){
		return stdService.getListStudent();
	}
	
	@PostMapping("/create")
	public StudentDTO createStudent(@RequestBody CreateStudentRequest bodyRequest) {
		StudentDTO newStudent = stdService.createStudent(bodyRequest);
		return newStudent;
	}
	
	@PutMapping("/update/{id}")
	public StudentDTO updateStd(@PathVariable Long id, @RequestBody CreateStudentRequest bodyRequest) {
		StudentDTO newStd = stdService.updateStudent(bodyRequest, id);
		return newStd;
	}
	
	@GetMapping("/detail/{id}")
	public StudentDTO getDetail(@PathVariable Long id) {
		return stdService.getDetai(id);
	}
	
	@DeleteMapping("delete/{id}")
	public boolean deleteStudent(@PathVariable Long id) {
		return stdService.deleteStudent(id);
	}
	
	@GetMapping("/listClass/{classId}")
	public List<StudentDTO> getListByClass(@PathVariable Long classId){
		return stdService.getListByClass(classId);
	}
	
	@GetMapping("/listMost")
	public List<StudentDTO> getListMost() {
		return stdService.getListMostStudent();
	}	
	
}

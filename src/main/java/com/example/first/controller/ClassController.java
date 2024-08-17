package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.request.CreateClassRequest;
import com.example.first.dto.response.ClassDTO;
import com.example.first.entity.ClassEntity;
import com.example.first.service.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
	@Autowired
	ClassService classService;
	
	@GetMapping("/list")
	public List<ClassDTO> getList() {
		return classService.getListClass();
	}
	
	@PostMapping("/create")
	public ClassDTO createClass(@RequestBody CreateClassRequest classRequest) {
		ClassEntity newClass = new ClassEntity();
		
		newClass.setName(classRequest.getName());
		
		return classService.saveCategory(newClass);
	}
	
	@PutMapping("/update/{id}")
	public ClassDTO createClass(@PathVariable Long id, @RequestBody CreateClassRequest classRequest) {
		ClassEntity newClass = new ClassEntity();
		
		newClass.setId(id);
		newClass.setName(classRequest.getName());
		
		return classService.saveCategory(newClass);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteClass(@PathVariable Long id) {
		return classService.deleteCategory(id);
	}
	
	@GetMapping("/detail/{id}")
	public ClassDTO getDetail(@PathVariable Long id) {
		return classService.getDetail(id);
	}
	
}

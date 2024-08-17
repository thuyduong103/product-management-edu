package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.response.ClassDTO;
import com.example.first.entity.ClassEntity;
import com.example.first.repository.ClassRepository;

@Service
public class ClassService {
	private final ClassRepository classRepository;

	public ClassService(ClassRepository classRepository) {
		super();
		this.classRepository = classRepository;
	}
	
	public List<ClassDTO> getListClass(){
		List<ClassEntity> classEntity = classRepository.findAll();
		List<ClassDTO> listClass = new ArrayList<ClassDTO>();
		
		for (ClassEntity classEn : classEntity) {
			ClassDTO dto = new ClassDTO(classEn.getId(), classEn.getName());
			
			listClass.add(dto);
			
		}
		return listClass;
	}
	
	public ClassDTO saveCategory(ClassEntity newClass) { 
		ClassEntity lop = classRepository.save(newClass); 
		
		ClassDTO dto = new ClassDTO();
		dto.setId(lop.getId());
		dto.setName(lop.getName());
		
		return dto;
	}
	
	public boolean deleteCategory(Long id) {
		boolean isExist = classRepository.existsById(id);
		 if(isExist) {
			 classRepository.deleteById(id);
			 return true;
		 }
		 return false;
	}
	
	public ClassDTO getDetail(Long id) {
		 ClassEntity lop = classRepository.findById(id).get();
		 ClassDTO dto = new ClassDTO();
		 
		 dto.setId(lop.getId());
		 dto.setName(lop.getName());
		 
		 return dto;
	 }
	
	
	
}

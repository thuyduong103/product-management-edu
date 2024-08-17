package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.first.dto.request.CreateStudentRequest;
import com.example.first.dto.response.ClassDTO;
import com.example.first.dto.response.StudentDTO;
import com.example.first.entity.ClassEntity;
import com.example.first.entity.StudentEntity;
import com.example.first.repository.ClassRepository;
import com.example.first.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository stdRepository;
	private final ClassRepository classRepository;
	
	public StudentService(StudentRepository stdRepository, ClassRepository classRepository) {
		super();
		this.stdRepository = stdRepository;
		this.classRepository = classRepository;
	}
	
	public StudentDTO createStudent(CreateStudentRequest newStd) {
		ClassEntity existClass = classRepository.findById(newStd.getClass_id()).get();
		
		if(existClass == null) {
			return null;
		}
		StudentEntity newStdEntity = new StudentEntity();
		
		newStdEntity.setClasses(existClass);
		newStdEntity.setFullName(newStd.getFname());
		newStdEntity.setPhone(newStd.getPhone());
		newStdEntity.setBirth(newStd.getBirth());
		newStdEntity.setMathScore(newStd.getMathScore());
		newStdEntity.setEngScore(newStd.getEngScore());
		
		StudentEntity createdStudent = stdRepository.save(newStdEntity);
		
		StudentDTO newDto = new StudentDTO();
		newDto.setId(createdStudent.getId());
		newDto.setFname(createdStudent.getFullName());
		newDto.setPhone(createdStudent.getPhone());
		newDto.setBirth(createdStudent.getBirth());
		newDto.setMathScore(createdStudent.getMathScore());
		newDto.setEngScore(createdStudent.getEngScore());
		newDto.setClasses(new ClassDTO(createdStudent.getClasses().getId(), createdStudent.getClasses().getName()));
		
		return newDto;
	}
	
//	public Page<StudentDTO> getListStudent(Pageable pageable){
//		Page<StudentEntity> result = stdRepository.findAll(pageable);
//		List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
//		for (StudentEntity stdEntity : result) {
//			StudentDTO dto = new StudentDTO();
//			
//			dto.setId(stdEntity.getId());
//			dto.setFname(stdEntity.getFullName());
//			dto.setPhone(stdEntity.getPhone());
//			dto.setBirth(stdEntity.getBirth());
//			dto.setMathScore(stdEntity.getMathScore());
//			dto.setEngScore(stdEntity.getEngScore());
//			dto.setClasses(new ClassDTO(stdEntity.getClasses().getId(), stdEntity.getClasses().getName()));
//			
//			listStudents.add(dto);
//		}
//		return new PageImpl<StudentDTO>(listStudents, pageable, result.getTotalElements());
//	}
	
	public List<StudentDTO> getListStudent(){
		List<StudentEntity> result = stdRepository.findAll();
		List<StudentDTO> listStudents = new ArrayList<>();
		for (StudentEntity stdEntity : result) {
			StudentDTO dto = new StudentDTO();
			
			dto.setId(stdEntity.getId());
			dto.setFname(stdEntity.getFullName());
			dto.setPhone(stdEntity.getPhone());
			dto.setBirth(stdEntity.getBirth());
			dto.setMathScore(stdEntity.getMathScore());
			dto.setEngScore(stdEntity.getEngScore());
			dto.setClasses(new ClassDTO(stdEntity.getClasses().getId(), stdEntity.getClasses().getName()));
			
			listStudents.add(dto);
		}
		return listStudents;
	
	}
	
	public StudentDTO updateStudent(CreateStudentRequest newStd, Long id) {
		ClassEntity existClass = classRepository.findById(newStd.getClass_id()).get();
		
		if(existClass == null) {
			return null;
		}
		StudentEntity newStdEntity = new StudentEntity();
		
		newStdEntity.setClasses(existClass);
		newStdEntity.setId(id);
		newStdEntity.setFullName(newStd.getFname());
		newStdEntity.setPhone(newStd.getPhone());
		newStdEntity.setBirth(newStd.getBirth());
		newStdEntity.setMathScore(newStd.getMathScore());
		newStdEntity.setEngScore(newStd.getEngScore());
		
		StudentEntity createdStudent = stdRepository.save(newStdEntity);
		
		StudentDTO newDto = new StudentDTO();
		newDto.setId(createdStudent.getId());
		newDto.setFname(createdStudent.getFullName());
		newDto.setPhone(createdStudent.getPhone());
		newDto.setBirth(createdStudent.getBirth());
		newDto.setMathScore(createdStudent.getMathScore());
		newDto.setEngScore(createdStudent.getEngScore());
		newDto.setClasses(new ClassDTO(createdStudent.getClasses().getId(), createdStudent.getClasses().getName()));
		
		return newDto;
	}
	
	public StudentDTO getDetai(Long id) {
		StudentEntity std = stdRepository.findById(id).get();
		
		StudentDTO dto = new StudentDTO();
		dto.setId(std.getId());
		dto.setFname(std.getFullName());
		dto.setPhone(std.getPhone());
		dto.setBirth(std.getBirth());
		dto.setMathScore(std.getMathScore());
		dto.setEngScore(std.getEngScore());
		dto.setClasses(new ClassDTO(std.getClasses().getId(), std.getClasses().getName()));
		
		return dto;
	}
	
	public boolean deleteStudent(Long id) {
		boolean isExist = stdRepository.existsById(id);
		if(isExist) {
			stdRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<StudentDTO> getListByClass(Long classId){
		List<StudentEntity> result = stdRepository.findByClass_Id(classId);
		List<StudentDTO> listStudents = new ArrayList<>();
		for (StudentEntity stdEntity : result) {
			StudentDTO dto = new StudentDTO();
			
			dto.setId(stdEntity.getId());
			dto.setFname(stdEntity.getFullName());
			dto.setPhone(stdEntity.getPhone());
			dto.setBirth(stdEntity.getBirth());
			dto.setMathScore(stdEntity.getMathScore());
			dto.setEngScore(stdEntity.getEngScore());
			dto.setClasses(new ClassDTO(stdEntity.getClasses().getId(), stdEntity.getClasses().getName()));
			
			listStudents.add(dto);
		}
		return listStudents;
	
	}
	
	public List<StudentDTO> getListMostStudent(){
		Long classId = stdRepository.findClassMostStudent();
		
		List<StudentEntity> result = stdRepository.findByClass_Id(classId);
		List<StudentDTO> listStd = new ArrayList<StudentDTO>();
		 for (StudentEntity stdEntity : result) {
		        StudentDTO dto = new StudentDTO();
		        dto.setId(stdEntity.getId());
		        dto.setFname(stdEntity.getFullName());
		        dto.setPhone(stdEntity.getPhone());
		        dto.setBirth(stdEntity.getBirth());
		        dto.setMathScore(stdEntity.getMathScore());
		        dto.setEngScore(stdEntity.getEngScore());
		        dto.setClasses(new ClassDTO(stdEntity.getClasses().getId(), stdEntity.getClasses().getName()));
		        
		        listStd.add(dto);
		 }
		return listStd;
	}
	
	
}

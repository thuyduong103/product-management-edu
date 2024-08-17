package com.example.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first.entity.StudentEntity;

public interface StudentRepository  extends JpaRepository<StudentEntity, Long> {
	@Query(value= "select * from students where class_id=?1", nativeQuery = true)
	public List<StudentEntity> findByClass_Id(Long classId);
	
	@Query(value = "select class_id from students group by class_id order by count(class_id) desc limit 1", nativeQuery = true)
	public Long findClassMostStudent();
}

package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.entity.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

}

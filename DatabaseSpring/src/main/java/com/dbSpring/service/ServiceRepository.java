package com.dbSpring.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbSpring.model.StudentModel;

public interface ServiceRepository extends JpaRepository<StudentModel, Integer>{

}

package com.example.main.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.model.StudentModel;

public interface StudentDaoServices extends JpaRepository<StudentModel, Long> {

}

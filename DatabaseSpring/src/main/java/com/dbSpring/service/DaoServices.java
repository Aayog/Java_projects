package com.dbSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dbSpring.model.StudentModel;

@Service
public class DaoServices {
	private ServiceRepository serviceRepository;
	
	public StudentModel insertStudent(StudentModel model) {
		return serviceRepository.save(model);
	}
	
	public void updateStudent(int id, StudentModel model) {
		serviceRepository.save(model);
	}
	
	public void deleteStudentById(int id) {
		serviceRepository.deleteById(id);
	}
	public void deleteStudent(StudentModel model) {
		serviceRepository.delete(model);
	}
	public List<StudentModel> findAllStudent(){
		List<StudentModel> students = new ArrayList<>();
		serviceRepository.findAll().forEach(students :: add);
		return students;
	}
	public StudentModel findStudent(int id) {
		return serviceRepository.findById(id).get();
	}
}

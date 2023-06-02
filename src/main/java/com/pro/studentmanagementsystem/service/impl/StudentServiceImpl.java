package com.pro.studentmanagementsystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pro.studentmanagementsystem.entity.Student;
import com.pro.studentmanagementsystem.repository.StudentRepository;
import com.pro.studentmanagementsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	StudentRepository repository;
	
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}
	
	public Student getStudentById(Long id) {
		return repository.findById(id).get();
	}

	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public Student updateStudent(Student student) {
		return repository.save(student);
	}
	
	public void deleteStudentById(Long id) {
		repository.deleteById(id);
	}
}

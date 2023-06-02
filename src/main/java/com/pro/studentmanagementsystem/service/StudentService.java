package com.pro.studentmanagementsystem.service;

import java.util.List;

import com.pro.studentmanagementsystem.entity.Student;

public interface StudentService {
	
	public Student getStudentById(Long id);
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudentById(Long id);

}

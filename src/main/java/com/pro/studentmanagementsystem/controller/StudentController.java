package com.pro.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pro.studentmanagementsystem.entity.Student;
import com.pro.studentmanagementsystem.service.StudentService;

@Controller
public class StudentController {

	StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", service.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		Student exStudent = service.getStudentById(id);
		exStudent.setFirstName(student.getFirstName());
		exStudent.setLastName(student.getLastName());
		exStudent.setEmail(student.getEmail());
		service.updateStudent(exStudent);

		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";

	}

}

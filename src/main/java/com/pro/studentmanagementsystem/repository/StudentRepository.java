package com.pro.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.studentmanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

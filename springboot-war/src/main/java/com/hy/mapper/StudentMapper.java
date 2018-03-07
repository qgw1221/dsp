package com.hy.mapper;

import java.util.List;

import com.hy.model.Student;



public interface StudentMapper {
	
	public List<Student> getAllStudent();

	public void update(Student user);
	public void add(Student user);
	public void delete(Student user);
}

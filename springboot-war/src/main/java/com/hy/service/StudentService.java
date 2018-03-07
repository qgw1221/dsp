package com.hy.service;
 
import java.util.List;

import com.hy.model.Student;
 

public interface StudentService {
 
     @SuppressWarnings("rawtypes")
	public List getList();
     
    public void update(Student user);
 	public void add(Student user);
 	public void delete(Student user);
}
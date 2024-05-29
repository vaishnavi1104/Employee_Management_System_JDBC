package com.project.dao;

import java.util.List;

import com.project.emp_entities.Emp;


public interface EmpDAO {

	void addEmployee(Emp emp);
	void updateEmployee(Emp emp);
	void deleteEmployee(int id);
	List<Emp> getAllEmployees();
}

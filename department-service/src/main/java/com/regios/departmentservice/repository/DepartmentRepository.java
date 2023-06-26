package com.regios.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.regios.departmentservice.model.Department;

@Repository
public class DepartmentRepository {

	private List<Department> departments = new ArrayList<>();
	
	public List<Department> getAllDepartments() {
		return departments;
	}
	
	public void addDepartment(Department department) {
		departments.add(department);
	}
	
	public Department findDepartmentById(Long id){
		return departments.stream().filter(match -> match.getId().equals(id)).findAny().orElseThrow();
	}
}

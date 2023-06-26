package com.regios.departmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regios.departmentservice.config.EmployeeClient;
import com.regios.departmentservice.model.Department;
import com.regios.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/add")
	public List<Department> addDepartment(@RequestBody Department department) {
		logger.info("Inside getAllEmployees:");
		departmentRepository.addDepartment(department);
		return departmentRepository.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public Department getById(@PathVariable("id") Long id) {
		logger.info("Inside getById for id {}:",id);
		Department department =  departmentRepository.findDepartmentById(id);
		department.setEmployees(employeeClient.getEmployeesFromDepartmentId(id));
		return department;
	}
	
	@GetMapping("/all")
	public List<Department> getAllDepartments(){
		logger.info("Inside getAllDepartments:");
		List<Department> departments = departmentRepository.getAllDepartments();
		departments.forEach(department -> department.setEmployees(
		     employeeClient.getEmployeesFromDepartmentId(department.getId())));
		return departments;
	}
}

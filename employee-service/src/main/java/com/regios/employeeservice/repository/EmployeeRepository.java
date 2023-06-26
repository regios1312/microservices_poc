package com.regios.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.regios.employeeservice.model.Employee;

@Repository
public class EmployeeRepository {

	List<Employee> employees = new ArrayList<>();
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	public Employee findByEmployeeId(Long id) {
		return employees.stream().filter(match -> match.employeeId().equals(id))
				.findAny().orElseThrow();
	}
	 public List<Employee> getEmployeesByDepartmentId(Long departmentId){
		 return employees.stream().filter(match -> match.departmenId().equals(departmentId)).collect(Collectors.toList());
	 }
}

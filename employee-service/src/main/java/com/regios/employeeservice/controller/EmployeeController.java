package com.regios.employeeservice.controller;

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

import com.regios.employeeservice.model.Employee;
import com.regios.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
   private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
   
   @Autowired
   private EmployeeRepository employeeRepository;
   
   @GetMapping("/allEmployees")
   public List<Employee> getAllEmployees(){
	   logger.info("Inside getAllEmployees:");
	   return employeeRepository.getAllEmployees();
   }
   
   @PostMapping("/add")
   public List<Employee> addEmployee(@RequestBody Employee employee){
	   logger.info("Inside addEmployee:");
	   employeeRepository.addEmployee(employee);
	   return employeeRepository.getAllEmployees();
   }
   
   @GetMapping("/department/{departmentId}")
   public List<Employee> getEmployeesFromDepartmentId(@PathVariable("departmentId") Long departmentId){
	   logger.info("Inside getEmployeesFromDepartmentId for id {}:",departmentId);
	   return employeeRepository.getEmployeesByDepartmentId(departmentId);
   }
   
   @GetMapping("/{employeeId}")
   public Employee getEmployeeFromEmployeeId(@PathVariable("employeeId") Long employeeId) {
	   logger.info("Inside getEmployeeFromEmployeeId for id {}:",employeeId);
	   return employeeRepository.findByEmployeeId(employeeId);
   }
}

package com.empPortal.Service;

import java.util.List;

import com.empPortal.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	Employee getEmployeeById(Long id);
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Long id, Employee employee);
	Employee deleteEmployee(Long id);
	
}

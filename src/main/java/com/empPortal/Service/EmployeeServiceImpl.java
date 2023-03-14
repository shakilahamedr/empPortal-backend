package com.empPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empPortal.repository.EmployeeRepository;
import com.empPortal.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee with the Id "+id+" does not exist"));
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if(!optEmp.isPresent()) {
			throw new RuntimeException("Employee with the Id "+id+"does not exist");
		}
		
		Employee emp = optEmp.get();
		
		if(employee.getEmpName()!=null && employee.getEmpName()!="") {
			emp.setEmpName(employee.getEmpName());
		}
		if(employee.getGender()!=null && employee.getGender()!="") {
			emp.setGender(employee.getGender());
		}
		if(employee.getEmail()!=null && employee.getEmail()!="") {
			emp.setEmail(employee.getEmail());
		}
		if(employee.getDept()!=null && employee.getDept()!="") {
			emp.setDept(employee.getDept());
		}
		if(employee.getAddress()!=null && employee.getAddress()!="") {
			emp.setAddress(employee.getAddress());
		}
		if(employee.getPhone()!=null && employee.getPhone()!="") {
			emp.setPhone(employee.getPhone());
		}
		if(employee.getUser().getUsername()!=null && employee.getUser().getUsername()!="") {
			emp.getUser().setUsername(employee.getUser().getUsername());
		}
		if(employee.getUser().getPassword()!=null && employee.getUser().getPassword()!="") {
			emp.getUser().setPassword(employee.getUser().getPassword());
		}
//		if(employee.getUser()!=null) {
//		emp.setUser(employee.getUser());
//	    }
		
		employeeRepository.save(emp);
		return getEmployeeById(id);
	}
	
	@Override
	public Employee deleteEmployee(Long id) {
		Employee emp = employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		return emp;
	}
	
}
package com.empPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empPortal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

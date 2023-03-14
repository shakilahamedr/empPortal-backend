package com.empPortal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.empPortal.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	@NotEmpty(message="Name cannot be null")
	private String empName;
	
	@NotEmpty(message = "Gender cannot be null")
	@Size(min = 4)
	private String gender;
	
	@Email(message = "email is not valid")
	private String email;
	
	@NotEmpty(message = "Dept cannot be null")
	@Size(min = 3, max = 20)
	private String dept;
	
	@NotEmpty(message = "Address cannot be null")
	@Size(min = 3, max =50)
	private String address;
	
	@NotEmpty(message = "phone cannot be null")
	@Size(min = 10, max = 10)
	private String phone;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	private User user;
}

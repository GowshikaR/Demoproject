package com.example.demo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Entity

@Table(name="Employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	@Pattern(regexp = "^[a-zA-Z]{6,12}$",message ="name is mandatory")
	@NotBlank(message="Name is mandatory")
    private String name;
	@Column
	@NotEmpty
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message="Password is Mandatory it sholud contain 8 character 1 capital letter 1 special character1 number")
    private String password; 
	@Column
	@NotNull
	//@Range(max = 10000,min = 999,message = "salary must be between 999 and 10000")
    private Double salary; 
	@Column
	@NotEmpty
	@Email(regexp = "[a-z A-Z 0-9._%+-]+@[a-z.-]+\\.[a-z]{2,3}",
			message="Enter Proper mail Id")
    private String email;
	public EmployeeEntity(Integer id, String name, String password, Double salary, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

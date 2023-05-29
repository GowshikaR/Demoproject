package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.EmployeeEntity;
import com.example.demo.service.Serviceclass;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/emp")
public class Controllerclass {
	Logger logger = LoggerFactory.getLogger(Controllerclass.class);

	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		logger.debug("Request {}", name);
		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Opps Exception raised....");
		}
		String response = "Hi " + name + " Welcome";
		logger.debug("Response {}", response);
		return response;
	}

	@Autowired
	private Serviceclass eservice;
 ;
	@PostMapping("/create") // create
	public String createEmployee(@RequestBody @Valid EmployeeEntity employee) {
		return eservice.createEmployee(employee);
	}

	@GetMapping("/get/{id}") // fetchbyid
	public EmployeeEntity findEmployee(@PathVariable("id") Integer eid) {
		boolean isEmployeeExist = eservice.isEmployeeExist(eid);
		

		{
			return eservice.findEmployee(eid);
		} 
	}

	@GetMapping("/getall") // fetchalll
	public List<EmployeeEntity> getEmployee() {
		return eservice.getemployee();
	}
}

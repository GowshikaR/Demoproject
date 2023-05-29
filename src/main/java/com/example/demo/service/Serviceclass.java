package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.example.demo.Repo.Repoclas;
import com.example.demo.bean.EmployeeEntity;


@Service
@Component
public class Serviceclass {
@Autowired
    private Repoclas repo;
      public String createEmployee(EmployeeEntity employee) {
           repo.save(employee);
           return "Employee details was created successfully";
      }
      public EmployeeEntity  findEmployee(Integer employeeid) {
          EmployeeEntity e =repo.findById(employeeid).get();
          EmployeeEntity employee = new EmployeeEntity();
  		employee.setId(e.getId());
  		employee.setName(e.getName());
  		employee.setPassword(e.getPassword());
  		employee.setSalary(e.getSalary());
  		employee.setEmail(e.getEmail());
  	
          return e;                
      }
     
      
      public String updateEmployee(EmployeeEntity employee) {
          repo.save(employee);
          
          return "Employee details was updated successfully";
     }
     public List<EmployeeEntity>getemployee(){
         List<EmployeeEntity>elist=new ArrayList<>();
         repo.findAll().stream()
        	        .sorted(Comparator.comparing(EmployeeEntity::getSalary, Comparator.reverseOrder()).thenComparing(Comparator.comparing(EmployeeEntity::getName))
        	        .thenComparing(Comparator.comparing(EmployeeEntity::getId)))
        	       .forEach(employee->elist.add(employee));
         return elist;
            }
     public String deleteEmployee(Integer eid) {
         repo.deleteById(eid);
         return "Employee details was deleted successfully";
     }
    public boolean isEmployeeExist(Integer eid) {
        return repo.existsById(eid);

    }
	
}
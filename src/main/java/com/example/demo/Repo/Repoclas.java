package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.bean.EmployeeEntity;



public interface Repoclas extends JpaRepository <EmployeeEntity, Integer> {

	EmployeeEntity findByName(String name);
}
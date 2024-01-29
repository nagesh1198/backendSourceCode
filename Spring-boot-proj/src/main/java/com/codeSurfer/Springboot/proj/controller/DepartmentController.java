package com.codeSurfer.Springboot.proj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeSurfer.Springboot.proj.entity.Department;
import com.codeSurfer.Springboot.proj.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	 
	private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/departments")
	public Department saveDepartment( @Valid @RequestBody Department department) {
		LOGGER.info("INSIDE THE SAVEDEPARTMENT");
		return departmentService.saveDepartment(department);	
	}
	
	@GetMapping("/departments")
	public List<Department> allNames(){
		return departmentService.FindAllDepartments();
	}
	
	@DeleteMapping("/departments/{id}")
	public String DeletById(@PathVariable("id") Long departmentId){
		LOGGER.info("INSIDE THE DELETEDEPARTMENT");
		 departmentService.DeleteById(departmentId);
		 return "Succesfully deleted the record";
	}
	
	@GetMapping("/departments/{id}")
	public Department GetDepartmentById(@PathVariable("id")Long departmentId){
		LOGGER.info("GOT THE DEPARTMENT NAMES");
		return departmentService.FetchById(departmentId);
		
	}
	
	@PutMapping("/departments/{id}")
	public Department GetUpdateDepartment(@PathVariable("id")Long departmentId,@RequestBody  Department department) {
		LOGGER.info("INSIDE THE UPDATEDEPARTMENT");
		return departmentService.Update(departmentId,department);
		
	}
	
		
	
	
}

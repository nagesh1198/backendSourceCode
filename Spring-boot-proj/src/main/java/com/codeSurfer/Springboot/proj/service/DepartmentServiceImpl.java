package com.codeSurfer.Springboot.proj.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeSurfer.Springboot.proj.entity.Department;
import com.codeSurfer.Springboot.proj.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> FindAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public void DeleteById(Long departmentId) {
		departmentRepository.deleteById(departmentId);	
	}

	@Override
	public Department FetchById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public Department Update(Long departmentId, Department department){
		Department dpid=departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			dpid.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			dpid.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dpid.setDepartmentAddress(department.getDepartmentAddress());
		}	
		
		return departmentRepository.save(dpid) ;
	}

	@Override
	public Department FetchByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}


	
	

}

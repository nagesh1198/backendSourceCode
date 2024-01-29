package com.codeSurfer.Springboot.proj.service;

import java.util.List;

import com.codeSurfer.Springboot.proj.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> FindAllDepartments();

	public void DeleteById(Long departmentId);

	public Department FetchById(Long departmentId);

	public Department Update(Long departmentId, Department department);

	public Department FetchByName(String departmentName);


}

package com.muke.emloyee.service;

import java.util.List;

import com.muke.emloyee.domain.Department;
import com.muke.emloyee.domain.PageBean;

public interface DepartmentService {
	
	
	PageBean<Department> findByPage(Integer currPage);
	
	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
	
}

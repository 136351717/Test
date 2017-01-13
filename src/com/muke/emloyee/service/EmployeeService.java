package com.muke.emloyee.service;

import com.muke.emloyee.domain.Employee;
import com.muke.emloyee.domain.PageBean;

//员工管理业务层接口
public interface EmployeeService {
	
	Employee login(Employee employee);

	PageBean<Employee> findAll(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);
	
	
	
}

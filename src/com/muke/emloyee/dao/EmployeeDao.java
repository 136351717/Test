package com.muke.emloyee.dao;

import java.util.List;

import com.muke.emloyee.domain.Employee;

public interface EmployeeDao {
	
	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int size);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

	
}

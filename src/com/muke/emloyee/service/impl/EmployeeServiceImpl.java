package com.muke.emloyee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.emloyee.dao.EmployeeDao;
import com.muke.emloyee.domain.Employee;
import com.muke.emloyee.domain.PageBean;
import com.muke.emloyee.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	
	
	/**
	 * 业务层登录方法
	 */
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findAll(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		int size = 3;
		pageBean.setPageSize(size);
		
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/size);
		pageBean.setTotalPage(totalPage.intValue());
		
		int begin = (currPage-1)*size;
		List<Employee> list = employeeDao.findByPage(begin,size);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
}

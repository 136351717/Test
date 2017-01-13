package com.muke.emloyee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.emloyee.dao.DepartmentDao;
import com.muke.emloyee.domain.Department;
import com.muke.emloyee.domain.PageBean;
import com.muke.emloyee.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	//分页查询部门方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		
		//封装pageBean
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		
		int begin = (currPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
	
	
	
}

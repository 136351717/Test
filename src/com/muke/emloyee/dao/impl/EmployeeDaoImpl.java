package com.muke.emloyee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.emloyee.dao.EmployeeDao;
import com.muke.emloyee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	
	/**
	 * �����û����������ѯ�û���¼�ʸ񷽷�
	 */
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Employee> findByPage(int begin, int size) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, size);
		return list;
	}

	@Override
	public int findCount() {
		String sql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}
	
	
	
	
}

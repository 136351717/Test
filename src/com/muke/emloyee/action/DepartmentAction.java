package com.muke.emloyee.action;

import com.muke.emloyee.domain.Department;
import com.muke.emloyee.domain.PageBean;
import com.muke.emloyee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 部门管理action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	private Department department = new Department();
	
	private DepartmentService departmentService;
	
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Department getModel() {
		return department;
	}
	
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		return "saveUI";
	}
	
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	
	
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);	//级联删除
		return "deleteSuccess";
	}
}

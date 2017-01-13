package com.muke.emloyee.action;

import java.util.List;

import com.muke.emloyee.domain.Department;
import com.muke.emloyee.domain.Employee;
import com.muke.emloyee.domain.PageBean;
import com.muke.emloyee.service.DepartmentService;
import com.muke.emloyee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理Action类
 * @author SJW
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private Employee employee = new Employee();
	
	
	private Integer currPage = 1;
	
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//登录执行方法
	public String login(){
		System.out.println("login执行");
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee==null){
			//登陆失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			//登陆成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS; 
		}
		
	}

	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	
	public String edit(){
		employee = employeeService.findById(employee.getEid());
		
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	
}

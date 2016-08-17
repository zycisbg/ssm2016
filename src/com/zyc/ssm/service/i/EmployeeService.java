package com.zyc.ssm.service.i;

import java.util.List;

import com.zyc.ssm.bean.Employee;

public interface EmployeeService {

	//获取所有emp对象
	List<Employee> getEmpList();
	
	void saveEmp(Employee employee);
	
	Employee getEmpById(Integer empId);
	
	void updateEmp(Employee employee);
	
	void deleteEmp(Integer empId);

}

package com.zyc.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyc.ssm.bean.Employee;
import com.zyc.ssm.mapper.EmployeeMapper;
import com.zyc.ssm.service.i.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Transactional
	public List<Employee> getEmpList() {
		
		List<Employee> empList = employeeMapper.getEmpList();
		
		return empList;
	}

	@Transactional
	public void saveEmp(Employee employee) {

		employeeMapper.saveEmp(employee);
	}

	@Transactional
	public Employee getEmpById(Integer empId) {
		
		
		return employeeMapper.getEmpById(empId);
	}

	@Transactional
	public void updateEmp(Employee employee) {

		employeeMapper.updateEmp(employee);
	}

	@Transactional
	public void deleteEmp(Integer empId) {

		employeeMapper.deleteEmp(empId);
	}

}

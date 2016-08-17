package com.zyc.ssm.mapper;

import java.util.List;




import com.zyc.ssm.bean.Employee;

public interface EmployeeMapper {

	List<Employee> getEmpList();

	void saveEmp(Employee employee);

	Employee getEmpById(Integer empId);

	void updateEmp(Employee employee);

	void deleteEmp(Integer empId);

}

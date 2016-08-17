package com.zyc.ssm.handler;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyc.ssm.bean.Department;
import com.zyc.ssm.bean.Employee;
import com.zyc.ssm.service.DepartmentServiceImpl;
import com.zyc.ssm.service.EmployeeServiceImpl;
import com.zyc.ssm.service.i.DepartmentService;
import com.zyc.ssm.service.i.EmployeeService;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("empId") Integer empId){
		
		employeeService.deleteEmp(empId);
		return "redirect:/emp/showList";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String updateEmp(Employee employee){
		
		employeeService.updateEmp(employee);
		
		return "redirect:/emp/showList";
	}
	
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.GET)
	public String toEditUI(@PathVariable("empId")Integer empId,Map<String,Object> map){
		
		Employee employee = employeeService.getEmpById(empId);
		map.put("employee", employee);
		
		List<Department> deptList = departmentService.getDeptList();
		map.put("deptList", deptList);
		
		return "updateEmp";
	}
	
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String saveEmp(Employee employee){
		
		employeeService.saveEmp(employee);
		
		return "redirect:/emp/showList";
	}
	
	@RequestMapping("/emp/toAdd")
	public String toAddUI(Map<String,Object> map){
		
		List<Department> deptList = departmentService.getDeptList();
		map.put("deptList", deptList);
		
		map.put("employee", new Employee());
		
		return "saveEmp";
	}
	
	@RequestMapping("/emp/showList")
	public String showList(Map<String,Object> map){
		List<Employee> empList = employeeService.getEmpList();
		
		map.put("empList", empList);
		
		return "showList";
	}
}

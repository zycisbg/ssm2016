package com.zyc.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyc.ssm.bean.Department;
import com.zyc.ssm.mapper.DepartmentMapper;
import com.zyc.ssm.service.i.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Transactional
	public List<Department> getDeptList() {
		
		List<Department> deptList = departmentMapper.getDeptList();
		
		return deptList;
	}

}

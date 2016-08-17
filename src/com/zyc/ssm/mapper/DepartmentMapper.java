package com.zyc.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zyc.ssm.bean.Department;

public interface DepartmentMapper {

	@Select("select deptid,deptname from depts")
	List<Department> getDeptList();

}

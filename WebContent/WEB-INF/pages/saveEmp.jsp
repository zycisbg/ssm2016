<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 不管是用于保存还是更新的表单，需要不需要回显，SpringMVC的from标签都需要提供一个和表达对应的模型对象  所遇需要用到modelAttribute-->
	<form:form action="${pageContext.request.contextPath }/emp"
			   method="post"
			   modelAttribute="employee"
	>
		
		<!-- 使用path属性声明 html中的name属性 -->
		姓名：<form:input path="empName"/><br>
		
		<%-- 
			from:select 的工作方式：
			1，path属性和其他一样
			2.使用items属性指定生成下拉列表的集合对象
			3.遍历items属性指定的集合
			4.遍历的目的是为了得到 <option value="5">行政部</option>
			5.使用itemValue属性指定department对象的某个属性，用来生成value中的值
			6.使用itemlable属性指定department对象的某个属性值，用来生成option标签体中的内容
		 --%>
		 
		部门: <form:select path="department.deptId"
			 			  items="${requestScope.deptList }"
			 			  itemValue="deptId"				
			 			  itemLabel="deptName"/>
		
		<br/>
		
		 
		 <input type="submit" value="添加">
		
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	//1.获取所有的超链接对应的元素节点对象，并绑定单击响应函数
	$(".remove").click(function(){
		 
		//2.获取空的form表单
		var $form = $("form");
		
		//3.把action属性的值设置为当前超链接的href的属性值
		$form[0].action = this.href;
		
		//4.提交空的form表单
		$form.submit(); 
		
		//取消默认行为
		return false;
	});
});
</script>
</head>
<body>

	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	
	<c:if test="${empty empList }">
		没有任何员工信息
	</c:if>
	
	<c:if test="${!empty empList }">
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>部门名称</td>
				<td>
					编辑
				</td>
				<td>
					删除
				</td>
			</tr>
			
			<c:forEach items="${empList }" var="emp">
			
			<tr>
				<td>${emp.empId }&nbsp;</td>
				<td>${emp.empName }</td>
				<td>${emp.department.deptName }</td>
				<td>
					<a href="${pageContext.request.contextPath }/emp/${emp.empId}">编辑</a>
				</td>
				<td>
					<a class="remove" href="${pageContext.request.contextPath }/emp/${emp.empId}">删除</a>
				</td>
			</tr>
			
			</c:forEach>
		</table>
		
		<a href="${pageContext.request.contextPath }/emp/toAdd">添加员工</a>
	</c:if>
</body>
</html>
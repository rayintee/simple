<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>employee crud测试页面</title>
<style type="text/css">
body,html{
	margin: 0;
	padding: 0;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 14px;
}

table{
	width:90%; 
	/* border:1px solid;  */
	margin:0 auto;
	cellpadding:0;
	cellspacing:0;
	border-radius: 5px;
}

td{
	text-align: center;
}

.navbar{
	width: 100%;
	margin:10px 0;
	height: 40px;
}

.navbar ul{
	margin: 0 auto;
	list-style-type:none;
	height: 40px;
}

.navbar ul li{ 
	/* width:120px;  */
	float:left;
	height: 40px;
	line-height: 40px;
}

.navbar ul li a{
	text-decoration: none;
}
</style>
</head>
<body>
	<h3>会员管理管理</h3>
	<div class="navbar">
		<ul>
			<li class="active">会员信息列表</li>
			<li><a href="${ctx}/employee/add">增加会员</a></li>
		</ul>
	</div>
	
	<table border="1">
		<thead>
			<tr>
				<th>编号ID</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>注册时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${employeeList eq null}">
					<tr>
						<td colspan="5">暂时没有会员信息，请添加</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.age}</td>
							<td>${employee.sex}</td>
							<td>${employee.createTime}</td>
							<td>
								<a href="${ctx}/employee/edit?id=${employee.id}">修改</a> 
								<a href="${ctx}/employee/del?id=${employee.id}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>
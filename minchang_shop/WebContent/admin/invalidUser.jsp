<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>无效会员管理</title>

</head>
<body>
<div class="row" style="width:98%;margin-left: 1%;margin-top: 5px;">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				已停用会员列表
			</div>
			<div class="panel-body">
				<table id="tb_list" style="font-size: 8pt" class="table table-striped table-hover table-bordered">
					<tr>
							<td>用户编号</td>
							<td>用户名称</td>
							<td>用户密码</td>
							<td>用户邮箱</td>
							<td>用户性别</td>
							<td>用户状态</td>
							<td>用户权限</td>
							<td>验证码</td>
							<td><a href="${pageContext.request.contextPath}/uinfo?action=invalidUser">查询</a></td>
					</tr>
				<c:forEach var="list" items="${requestScope.inli}">
					<tr>
						<td>${list.id}</td>
						<td>${list.username}</td>
						<td>${list.password}</td>
						<td>${list.email}</td>
						<td>${list.gender}</td>
						<td>${list.flag}</td>
						<td>${list.role}</td>
						<td>${list.code}</td>
						<td><a href="#">修改</a>&nbsp;&nbsp;<a href="#">删除</a></td>								
					</tr>
				</c:forEach>					
				</table>
				
			</div>
		</div>
	</div>
</div>
</body>
</html>
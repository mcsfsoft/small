<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>小米网后台主页-会员信息页面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	
	<div class="row" style="width: 100%;">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">会员列表</div>
					<div class="panel-body">
					<!-- 条件查询 -->
						<div class="row">
						<form action="${pageContext.request.contextPath}/uinfo?action=userList" method="post">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<div class="form-group form-inline">
									<span>用户姓名</span>
									<input type="text" name="username" class="form-control">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<div class="form-group form-inline">
									<span>性别</span>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<label class="radio-inline">
									  <input type="radio" name="gender" value="男"> 男&nbsp;&nbsp;&nbsp;&nbsp;
									</label>
									<label class="radio-inline">
									  <input type="radio"name="gender" value="女"> 女
									</label>
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<button type="submit" class="btn btn-primary" id="search"><span class="glyphicon glyphicon-search"></span></button>
							</div>
							</form>
						</div>
				<!-- 列表显示 -->
					<table id="tb_list" style="font-size: 2pt" class="table table-striped table-hover table-bordered">	
							<tr>
								<td>用户编号</td>
								<td>用户名称</td>
								<td>用户密码</td>
								<td>用户邮箱</td>
								<td>用户性别</td>
								<td>用户状态</td>
								<td>用户权限</td>
								<td>验证码</td>
								<td>用户操作</td>
							</tr>
					<c:forEach var="list"  items="${requestScope.lists}" >
							<tr>
								<td>${list.id}</td>
								<td>${list.username}</td>
								<td>${list.password}</td>
								<td>${list.email}</td>
								<td>${list.gender}</td>
								<td>${list.flag}</td>
								<td>${list.role}</td>
								<td>${list.code}</td>
								<td><a href="#">修改</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/uinfo?action=delete&id=${list.id}">删除</td>								
							</tr>
					</c:forEach>
							
							</table>		
					</div>
				</div>
			</div>
		</div>
</body>
</html>
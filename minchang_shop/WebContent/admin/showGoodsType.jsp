<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style type="text/css">
 body{
	font-size: 10pt;
}
</style>
<title>商品分类</title>
</head>
<body>
<div class="row" style="width:98%;margin-left: 1%;">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				商品类型
			</div>
			<div class="panel-body">
			<form action="${pageContext.request.contextPath }/shows?action=type" method="post">
				<div class="row">
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group form-inline">
							<span style="font-size:4pt">商品等级</span>
							<input type="text" name="username" class="form-control">
						</div>
					</div>
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group form-inline">
							<span style="font-size:4pt">商品名称</span>
							<input type="text" name="pubdate" class="form-control">
						</div>
					</div>
					<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
						<button type="submit" class="btn btn-primary" id="search"><span class="glyphicon glyphicon-search"></span></button>
					</div>
				</div>
				</form>
				<div style="height: 400px;overflow: scroll;">
				<table id="tb_list" style="font-size:4pt" class="table table-striped table-hover table-bordered">
					<tr>
						<td>序号</td><td>类型</td><td>等级</td><td>所属类型</td><td>操作</td>
					</tr>
					<c:forEach var="list" items="${requestScope.act}">
					<tr>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>${list.level}</td>
						<td>${list.name2}</td>
						<td>
							<button>修改</button>&nbsp;&nbsp;
							<button>删除</button>
						</td>
					</tr>
					</c:forEach>
					
					
				</table>
				</div>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>
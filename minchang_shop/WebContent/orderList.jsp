<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单列表</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js">
</script>

<script type="text/javascript">
/* 	$(function(){
	$("#details").click(function(){
		location.href = "orders?action=detail&oid="+$("#oids").val();
		})
	}) */
	function showOrder(id){
		location.href = "orders?action=detail&oid="+id;
}
	
	
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>我的订单列表&nbsp;&nbsp;
		<small>温馨提示：亲爱的${sessionScope.userInfo.username}先生,您有<font color="red"><c:if test="${requestScope.ordes.size()==0}" >&nbsp;0&nbsp;</c:if><c:if test="${requestScope.ordes.size()!=0}" >&nbsp;${requestScope.ordes.size()}&nbsp;</c:if></font>个订单</small></h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-12">
			<table id="tb_list" class="table table-striped table-hover table-bordered table-condensed">
			<tr>
				<th>序号</th>
				<th>订单编号</th>
				<th>总金额</th>
				<th>订单状态</th>
				<th>订单时间</th>
				<th>收货地址</th>
				<th>操作</th>
			</tr>
			<c:set var="id"></c:set>
			<c:forEach var="order" items="${requestScope.ordes}" varStatus="status">
				
				<tr>
					<th>${status.count}</th>
					<th>${order.id}</th>
					<th>${order.money}</th>
					<th>
						<font color="red">
						${order.status}
						</font>
					</th>
					<th>${order.time}</th>
					<th>${order.address}</th>
					<th>
					<input id="oids" value="${order.id}" type="hidden"/>
					<button type="button" id="details" class="btn btn-danger btn-sm" onclick="showOrder('${order.id}')">订单详情</button>
					<button type="button" class="btn btn-warning btn-sm" onclick="changeStatus('id')">确认收货</button>		
					</th>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>
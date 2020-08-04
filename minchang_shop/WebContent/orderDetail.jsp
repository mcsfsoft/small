<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情页</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<%@ include file="header.jsp" %>
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-equalizer"></span>&nbsp;&nbsp;订单详情</h3>
	</div>
	<div class="panel-body">
	<table cellpadding="0" cellspacing="0" align="center" width="100%" class="table table-striped table-bordered table-hover">

		<tr>
			<td>订单编号:</td>
			<td>${requestScope.details.oid}</td>
			<td>订单时间:</td>
			<td>${requestScope.details.time}</td>
		</tr>
		<tr>
			<td>收件人:</td>
			<td>${requestScope.details.name}</td>
			<td>联系电话:</td>
			<td>${requestScope.details.phone}</td>
		</tr>
		<tr>
			<td>送货地址:</td>
			<td>${requestScope.details.details}</td>
			<td>总价:</td>
			<td>${requestScope.details.money}</td>
		</tr>
		<tr>
			<td align="center">商品列表:</td>
			<td colspan="3">
				<table align="center" cellpadding="0" cellspacing="0" width="100%"  class="table table-striped table-bordered table-hover">
					<tr align="center"  class="info">
						<th>序号</th>
						<th>商品封面</th>
						<th>商品名称</th>
						<th>商品评分</th>
						<th>商品日期</th>
						<th>商品单价</th>
						<th>购买数量</th>
						<th>小计</th>
					</tr>
					<c:forEach var="goods" items="${requestScope.ugoods}" varStatus="status">				<!-- 商品 -->
						<tr align="center">
						
							<th>${status.count } <input type="hidden" name="oid" value="${requestScope.details.oid}"/></th>
							<th>
								<img src="${goods.picture}" width="50px" height="50px">
							</th>
							<th>${goods.name}</th>
							<th>${goods.star}</th>
							<th>${goods.pudbate}</th>
							<th>${goods.price}</th>
							<th>${goods.num}</th>
							<th>${goods.sum}</th>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="4" style="margin-right: 40px;">
				<a href="${pageContext.request.contextPath }/orders?action=addOrder&aid=${requestScope.details.aid}" class="btn btn-danger btn-sm">返回订单列表</a>
				&nbsp;&nbsp;
				<c:if test="${od.order.status eq 1 }">
					<button type="button" onclick="pay('${od.order.id}','${od.order.money}')" class="btn btn-warning btn-sm">易付宝支付</button>
						&nbsp;&nbsp;
					<button type="button" onclick="payWeiXin('${od.order.id}','${od.order.money}')" class="btn btn-success btn-sm">微信支付</button>
				</c:if>
			</td>
		</tr>
	</table>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
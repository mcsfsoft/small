<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>我的购物车<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small></h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
 					<th>序号</th>
 					<th>商品名称</th>
 					<th>价格</th>
 					<th>数量</th>
 					<th>小计</th>
 					<th>操作</th>
 				</tr>
 		 
 		<c:forEach var="cart" items="${sessionScope.cart}" varStatus="status">
	 			<c:if test="${not empty cart.value.goods.id}"> 	
	 				<tr>
	 	<!-- 序号 -->				<th>${status.count}</th>
	 <!-- 商品名称 -->				<th>${cart.value.goods.name}</th>
	 <!-- 价格 -->				<th>${cart.value.goods.price}</th>
	 			
 	<!-- 数量 -->				<th width="100px">
		 					<div class="input-group">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" >-</button>
		 						</span>
		 						<input type="text" class="form-control" id="num_count" value="${cart.value.num}" readonly="readonly" style="width:40px">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" ">+</button>
		 						</span>
	 						</div>
	 					</th>
	 <!-- 小计 -->		<th>&nbsp;${cart.value.num*cart.value.goods.price}</th>
	 					<th>
	 						<button type="button" class="btn btn-default" ><a href="cart2?action=delete&id=${cart.value.goods.id}">删除</a></button>
	 					</th>
	 				</tr>
	 	
			<c:set var="sum"  value="${sum+cart.value.num*cart.value.goods.price}"></c:set>
	 	</c:if>	
	 	</c:forEach>
		
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="pull-right" style="margin-right: 40px;">
			
	            <div>
	            <a id="rv" href="shows?action=types" class="btn btn-default btn-lg">返回购物</a>
	            	<a id="removeAllProduct" href="orders?action=clear" class="btn btn-default btn-lg">清空购物车</a>
	            	&nbsp;&nbsp;
	            	<a href="${pageContext.request.contextPath}/address?action=getOrderView" class="btn  btn-danger btn-lg">添加收货地址</a>
	            	
	            </div>
	            <br><br>
	            <div style="margin-bottom: 20px;">        		  
	            	商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;${sum}</b></span>
	            </div>
		</div>
	</div>
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>
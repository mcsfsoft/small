<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表页</title>

</head>
<body>
	<%@ include file="header.jsp"%>
	
   
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;商品列表</h3>
	</div>
	<div class="panel-body">
	   	   <!--列表开始-->
	   	   <input name="action" value="goodsList"  type="hidden"/>
	   	<c:forEach var="li" items="${requestScope.goods}" varStatus="status">
	    <c:if test="${status.count%4==1 }">
	    		<div class="row" style="margin: 0 auto;">
	    </c:if>
	    		<div class="col-sm-3">
				    <div class="thumbnail">
				     <!--图片--> <img src="image/${li.picture}" width="180" height="180"  alt="小米6" />
				      <div class="caption">
				        <h4>商品名称<a href="${pageContext.request.contextPath}/goodListServlet?action=findById&id=${li.id}">${li.name}</a></h4>
				        <p>热销指数
				        	<c:forEach var="a" begin="1" end="${li.star}">
				        		<img src="image/star_red.gif" alt="star"/>
				        	</c:forEach>
				        </p>
				         <p>上架日期:${li.pubdate}</p>
			             <p style="color:orange">价格:${li.price}</p>
				      </div>
				    </div>
				  </div>

		<c:if test="${status.count%4==0 }">	  
		</div>
		</c:if>
</c:forEach>
   	</div>
</div>
      <!-- 底部 -->
   <%@ include file="footer.jsp"%>
</body>
</html>
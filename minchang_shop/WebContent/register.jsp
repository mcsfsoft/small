<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
var xhr;
function user(){//用户名确认
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
		xhr.onreadystatechange=userdiao;
		var url="reg";
		xhr.open("POST",url,true);
		xhr.send();
}
function userdiao(){
	if(xhr.readyState==4&&xhr.status==200){
		var backJson=xhr.responseText;
		var objs=JSON.parse(backJson);
	}
	var d1 = document.getElementById("usernameMsg");
	var d2 = document.getElementById("username").value;
	if(objs==null)
		d1.innerHTML="用户名可用";	
	else if(d2==""){
		d1.innerHTML="用户名为空"
	}
	else{
			for(var i=0;i<objs.length;i++){
				if(objs[i].username==d2){
				 	d1.innerHTML="用户名已被使用";
				}
			}
		}
}
function pwd(){//密码确认
	var d1=document.getElementById("password").value;
	var d2=document.getElementById("helpBlock1");
	if(d1.length>6){
		d2.innerHTML="请不要输入6位以上的字符";
	}
}

function pwd(){//密码二次确认
	var d3=document.getElementById("password").value;
	var d1=document.getElementById("repassword").value;
	var flag=true;
		var d2=document.getElementById("helpBlock2");
		if(d1==d3){
			d2.innerHTML="密码正确";
			flag=true;
		}else if(d1!=d3){
			d2.innerHTML="两次密码不一致";
			flag=false;
		}
}
function gender1(){
		//var d1=docunment.getElementById("helpBlock3");
		helpBlock3.innerHTML="你是帅哥";
}
function gender2(){
		//var d1=docunment.getElementById("helpBlock3");
		helpBlock3.innerHTML="你是美女";
}
function relogin(){
		alert("提交的表单将重置,确认吗?");
	
}

</script>
<title>注册</title>
</head>
<body>
	<div class="regist">
		<div class="regist_center">
			<div class="regist_top">
				<div class="left fl"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;会员注册</div>
				<div class="right fr">
					<a href="index.jsp" target="_black">小米商城</a>
				</div>
				<div class="clear"></div>
				<div class="xian center"></div>
			</div>
			<div class="center-block" style="margin-top: 80px;">
				<form class="form-horizontal" action="userRegister" method="post">

					<div class="form-group">
						<label class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="text" id="username" name="username" class="form-control col-sm-10"
								placeholder="Username" onblur="user()" />
						</div>
						<div class="col-sm-2">
						<p class="text-danger"><span class="help-block " id="usernameMsg"></span></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">密码</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="password" name="password" id="password"
								class="form-control col-sm-10" placeholder="Password" onblur="pwd()" />
						</div>
						<div class="col-sm-2">
						<p class="text-danger"><span id="helpBlock1" class="help-block "></span></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="password" class="form-control col-sm-10"
								placeholder="Password Again" id="repassword" onblur="rpwd()"/>
						</div>
						<div class="col-sm-2">
						<p class="text-danger"><span id="helpBlock2" class="help-block "></span></p>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="text" name="email" class="form-control col-sm-10"
								placeholder="Email" />
						</div>
						<div class="col-sm-2">
						<p class="text-danger"><span id="helpBlock" class="help-block ">填写正确邮箱格式</span></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">性别</label>
						<div class="col-sm-8" style="width: 40%">
							<label class="radio-inline"> <input type="radio"
								name="gender" id="b_gender" onblur="gender1()" value="男"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="gender" id="g_gender" onblur="gender2()" value="女"> 女
							</label>
						</div>
						<div class="col-sm-2">
						<p class="text-danger"><span id="helpBlock3" class="help-block "></span></p>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<div class="col-sm-7 col-sm-push-2">
							<input id="registerBtn" type="submit" value="注册" class="btn btn-primary  btn-lg" style="width: 200px;" onclick="checkAll()" /> &nbsp; &nbsp;
							<input type="reset" value="重置" class="btn btn-default  btn-lg" style="width: 200px;"  />
						</div>
					</div>
					<div ><a class="col-sm-2 control-label" href="login.jsp" onclick="relogin()">返回登录</a></div>
				</form>

			</div>
		</div>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.regex.Pattern"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login</title>
</head>
<script>
function fcheck() {
	if (myform.id.value == "") {
		alert("���̵� �Է��ϼ���!");
		myform.id.focus();
	} else if (myform.pwd.value == "") {
		alert("��й�ȣ�� �Է��ϼ���!");
		myform.pwd.focus();
	} else {
		myform.submit();
	}
}
/*
	$(document).ready(function(){
		var loginCheck = ${loginCheck};
		if(loginCheck==0){
			alert("��ġ�ϴ� ȸ���� �����ϴ�.");
		}
	});
*/
</script>
<style>
#wrapper {
	margin: 0 auto;
	/*margin-top: 250px;*/
	/*width: 90%;*/
	background: #ffffff;
}

body {
	/*font-size: 12px;*/
}
#myform{
	margin-top:200px;
}
.form {
	width: 400px;
	height: 250px;
	border-radius: 25px;
	border: 5px double #999;
	margin: 30px auto;
}

.form2 {
	width: 380px;
	min-width: 320px;
	height: 200px;
	margin: 60px auto;
	margin-left: 20px;
}

.form3 {
	float: left;
	margin-right: 10px;
}

.form3 label {
	width: 100px;
	height: 20px;
	float: left;
}

.form4 {
	margin-top: 15px;
	padding-left: 100px;
}

#wrap {
	/*border: 1px solid #f00;*/
	/*width: 600px;
	height: 500px;*/
	/*margin: 0 auto;*/
}

.clear {
	clear: both;
}

input[type="submit"] {
	float: left;
	height: 50px;
	background: #FFBB00;
	border-radius: 5px;
	border: none;
}

input[type="button"] {
	height: 30px;
	background: #FFBB00;
	border-radius: 5px;
	border: none;
}
</style>
<body>
	<form id="myform" name="myform" method="post" action="login.do">
		<div id="wrapper">
			<div id="wrap">
				<div class="form">
					<div class="form2">
						<div class="form3">
							<label for="user">���̵�</label><input type="text" name="id" autofocus>
							<div class="clear"></div>
							<label for="user">��й�ȣ</label><input type="password" name="pwd">
						</div>
						<input type="button" value="�α����ϱ�" onClick="fcheck()" />
						<div class="clear"></div>
						<div class="form4">
							<div class="clear"></div>
							<!-- <label><input type="button" value="ȸ������"	onClick="location.href='T_MemIndex.jsp'"></label> -->
							<label>
								<input	type="button" value="���̵�ã��" 
									onclick=""/>
							</label> 
							<label>
								<input	type="button" value="��й�ȣã��" 
									onclick=""/>
							</label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>










<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="imagetoolbar" content="no"/>
    <meta name="description" content="" />
    <meta name="keywords" content=""/>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./css/login.css"/>
    <title>Login画面</title>
	<script>
		function goUserCreateAction(){
			document.getElementById('form').action = "UserCreateAction";
		}
	</script>

</head>
<body>
    <div id="header">
        <div id="pr">
        </div>
    </div>
    <div id="main">
        <div id="top">
             <div class="login">
			<h1>Login</h1>
    		<s:form  id="form" name="form" action="LoginAction">
    			<s:textfield name="loginUserId" placeholder="UserID" required="required" />
				<s:password name="loginPassword" placeholder="Password"  required="required" />
				<s:submit class="btn btn-primary btn-block btn-large" value="Let me in"/>
				<div><br>
					<s:submit class="btn btn-primary btn-block btn-large" value="新規ユーザー登録" onclick="goUserCreateAction();"/>
    			</div>
			</s:form>
		</div>
    </div>
	</div>

	 <div id="footer">
		<div id="pr">
      	</div>
	</div>
</body>
</html>
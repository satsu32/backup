<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="./css/passwordResettingConfirm.css">
<title>パスワード再設定確認画面</title>
<script type="text/javascript">
	history.forward();
</script>
</head>

<body text="#232323" link="##404040" vlink="#404040" alink="#404040">

	<div id="main">
		<br>
		<div class="pageback">
			<a href='<s:url action="GoHomeAction"/>'>TOP</a> &nbsp;>&nbsp; <a>確認画面</a>
		</div>
		<br>
		<div class="confirm">
			<h3>登録する内容は以下でよろしいですか。</h3>
			<s:form action="PasswordResetCompleteAction" theme="simple">
				<div id="box">
					<br> <label>ユーザーID:</label>
					<s:property value="loginUserId" escape="false" />
				</div>
				<div id="box">
					<br> <label>パスワード:</label>
					<s:property value="loginPassword" escape="false" />
				</div>
				<div id="box">
					<br> <label>再確認パスワード:</label>
					<s:property value="passwordConfirm" escape="false" />
				</div>

				<div class="confirm_btn">
					<br>
					<s:hidden name="loginPassword" value="%{loginPassword}" />
					<s:hidden name="passwordConfirm" value="%{passwordConfirm}" />
					<s:hidden name="loginUserId" value="%{loginUserId}" />
					<s:submit value="完了" />
				</div>
			</s:form>
		</div>
	</div>
	<div id="footer">
			</div>

</body>
</html>
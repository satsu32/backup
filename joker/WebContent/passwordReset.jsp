<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	$(document).ready(function() {
		$("#PasswordResetConfirmForm").validationEngine();
	});
</script>
<title>パスワード再設定画面</title>
</head>
	<div id="main">
		<h2>パスワード再設定画面</h2>
		<br>
		<div class="new_password">
			<h5>
				<s:iterator value="errorMessageList">
					<s:div>
						<s:property />
					</s:div>
				</s:iterator>
			</h5>
			<s:form action="PasswordResetConfirmAction" theme="simple">
				<div class="new_password_title">
					ユーザーID<br>
				</div>
				<div class="new_password_textbox">
					<s:textfield name="loginUserId"
						class="validate[required,minSize[1],maxSize[16],custom[onlyLetterNumber]]" />
					<br>
				</div>
				<br>
				<div class="new_password_title">
					パスワード<br>
				</div>
				<div class="new_password_textbox">
					<s:password name="loginPassword"
						class="validate[required,minSize[1],maxSize[16],custom[onlyLetterNumber]]" />
					<br>
				</div>
				<br>
				<div class="new_password_title">
					再確認パスワード<br>
				</div>
				<div class="new_password_textbox">
					<s:password name="passwordConfirm"
						class="validate[required,minSize[1],maxSize[16],custom[onlyLetterNumber]]" />
					<br>
				</div>
				<br>
				<div class="new_password_btn">
					<s:submit value="再設定" />
				</div>
			</s:form>
		</div>
	</div>
	<br>
	<div id="footer">
			</div>
</body>
</html>
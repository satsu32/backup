<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script>
function goIndexAction(){
	document.getElementById('form').action = "IndexAction";
}
function goBuyItemAction(){
	document.getElementById('form').action = "BuyItemAction";
}
function goUserCreateAction(){
	document.getElementById('form').action = "UserCreateAction";
}
function goLogoutAction(){
	document.getElementById('form').action = "LogoutAction";
}
function goMyPageAction(){
	document.getElementById('form').action = "MyPageAction";
}
function goPasswordResetAction(){
	document.getElementById('form').action = "PasswordResetAction";
}
</script>
<title>Joker</title>
</head>
<body>
<div class="login">
    <s:form id="form" name="form" action="LoginAction" method="post">


    <s:submit value="ホーム" onclick="goIndexAction();"/>
    <s:submit value="商品一覧" onclick="goBuyItemAction();"/>
    <s:submit value="ユーザー登録" onclick="goUserCreateAction();"/>
	<s:submit value="マイページ" onclick="goMyPageAction();"/>
	<s:submit value="パスワード変更" onclick="goPasswordResetAction();"/>

        <s:if test="#session.userName!=null">
        	<s:if test="#session.loginFlg!=true">
    	<s:textfield name="loginUserId" placeholder="UserID" size="5" required="required" />
        <s:password name="loginPassword" placeholder="Password" size="5" required="required" />
				<s:submit class="btn btn-primary btn-block btn-large" value="Let me in."/>
			</s:if>
			<s:if test="#session.loginFlg==true">
    	<s:textfield name="loginUserId" placeholder="UserID" size="5" />
        <s:password name="loginPassword" placeholder="Password" size="5" />
				<s:submit class="btn btn-primary btn-block btn-large" value="Sign out" onclick="goLogoutAction()" />
			</s:if>
        </s:if>
        <s:else>
            <s:textfield name="loginUserId" placeholder="UserID" size="5" required="required" />
        	<s:password name="loginPassword" placeholder="Password" size="5" required="required" />
        	<s:submit class="btn btn-primary btn-block btn-large" value="Let me in."/>
        </s:else>
        <br>
        <table>
        <tr>
                <s:if test="#session.userName!=null">
        	<td>ようこそ、<s:property value="#session.userName"/>さん</td>
        </s:if>
        <s:else>
        	<td><td>
        </s:else>
        </tr>
        </table>
    </s:form>
</div>
</body>
</html>
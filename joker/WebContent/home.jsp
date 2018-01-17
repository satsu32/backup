<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />


<title>Home画面</title>
<style type="text/css">
</style>
</head>
<body>
     <div class="example">
      <img src="./imgages/Lighthouse.jpg" alt="写真" width="193" height="130">

     </div>
     <div id="header">
        <div id="pr">
        </div>
     </div>
     <div id="main">
        <div id="top">
            <p>Home<p>
        </div>
          <h1>はじめまして、</h1>

     <div>
        <h3>ログイン</h3>
        <s:form action="LoginAction">
           <s:textfield name="loginUserId" />
           <s:password name="loginPassword"/>
           <s:submit value="ログイン"/>
        </s:form>
        <br/>
         <s:form action="MyPageAction">
				<s:submit value="マイページ"/>
			</s:form>
  </div>
  <div id="footer">
     <div id="pr">
     </div>
  </div>
</div>

</body>
</html>
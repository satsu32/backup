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
    <meta charset="utf-8">
<link rel="stylesheet" href="./css/userCreateComplete.css">
    <title>UserCreateComplete画面</title>

</head>
<body>
<!--<s:include value="header.jsp"/>-->

    <div id="header">
        <div id="pr">
        </div>
     </div>
     <div id="main">
        <div id="top">
            <p>UserCreateConfirm</p>
        </div>
        <div><br>
           <h3>ユーザーの登録が完了致しました。</h3>

           <div>
              <s:form  id="form" name="form" action="LoginAction">
                    <input type="submit"  class="btn btn-primary btn-block btn-large" value="ログインへ"/>
              </s:form><a href='login.jsp'>ログインへ</a>
           </div>
        </div>
    </div>
    <div id="footer">
        <div id="pr">
        </div>
    </div>
 </body>
 </html>
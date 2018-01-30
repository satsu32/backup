<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
<link rel="stylesheet" href="./css/userCreate.css">
<title>UserCreate画面</title>

</head>
<body>
<s:include value="header.jsp"/>

     <div id="header">
         <div id="pr">
         </div>
     </div>
     <div id="main">
         <div id="top">
            <p>ユーザー登録</p>
         </div>
         <div>
             <s:if test="errorMessage !=''">
                <h4><s:property value="errorMessage" escape="false"/></h4>
             </s:if>
             <table>
             <s:form id="form" name="form" action="UserCreateConfirmAction">
                <tr>
                   <td>
                    <p><label>ログインID:</label></p>
                   </td>
                   <td>
                       <input type="text" name="loginUserId" placeholder="UserID" required="required" value="" />
                   </td>
                </tr>
                <tr>
                   <td>
                     <p><label>ログインPASS:</label></p>
                   </td>
                   <td>
                       <input type="password" name="loginPassword" placeholder="Password" required="required" value=""/>
                   </td>
                 </tr>
                 <tr>
                    <td>
                        <p><label>ユーザー名:</label></p>
                    </td>
                    <td>
                        <input type="text" name="userName" placeholder="UserName" required="required" value=""/>
                    </td>
                  </tr>
                  <s:submit value="登録"/>
                </s:form>
                </table>
                </div>
             </div>
</body>
</html>
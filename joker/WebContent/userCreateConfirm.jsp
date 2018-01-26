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
<link rel="stylesheet" href="./css/userCreateConfirm.css">
    <title>UserCreateConfirm画面</title>

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
         <div>
             <h3>登録する内容は以下でよろしいですか??</h3>
             <table>
                 <s:form id="form" name="form" action="UserCreateCompleteAction">
                    <tr id="box">
                       <td>
                            <p><label>ログインID:</label></p>
                        </td>
                        <td>
                           <p><s:property value="loginUserId" escape="false"/></p>
                           <s:hidden name="loginUserId" value="%{loginUserId}"/>
                        </td>
                     </tr>
                     <tr id="box">
                         <td>
                         <p><label>ログインPASS:</label></p>
                         </td>
                         <td>
                           <p><s:property value="loginPassword" escape="false"/></p>
                           <s:hidden name="loginPassword" value="%{loginPassword}"/>
                         </td>
                      </tr>
                      <tr id="box">
                         <td>
                          <p><label>ユーザー名:</label></p>
                         </td>
                         <td>
                             <p><s:property value="userName" escape="false"/></p>
                             <s:hidden name="userName" value="%{userName}"/>
                          </td>
                       </tr>
                       <tr id="box">
                          <td>
                              <p><s:submit value="完了"/></p>
                          </td>
                       </tr>
                     </s:form>
                 </table>
               </div>
           </div>
         <div id="footer">
              <div id="pr">
              </div>
         </div>
 </body>
 </html>

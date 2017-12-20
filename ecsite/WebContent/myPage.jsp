<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="tetx/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content=""/>
    <meta charset="utf-8">
    <title>MyPage画面</title>
    <style type="text/css">


    body {
       margin:0;
       padding:0;
       line-height:1.6;
       letter-spacing:1px;
       font-family:Verdana, Helvetica, sans-serif;
       font-size:12px;
       color:#333;
       background:#fff;
      }

      table {
         text-align:center;
         margin:0 auto;
       }

      #top {
        width:780px;
        margin:30px auto;
        border:1px solid #333;
       }

       #header{
          width: 100%;
          height: 80px;
          background-color: black;
        }
       #footer {
          width: 100%;
          height:80px;
          background-color: black;
          clear:both;
        }

        #text-right {
            display: inline-block;
            text-align: right;
          }
      </style>
 </head>
 <body>
     <div id="header">
       <div id="pr">
       </div>
     </div>
     <div id="main">
         <div id="top">
         <p>MyPage</p>
      </div>
      <div>
      <s:if test="myPageList == null">
        <h3>ご購入情報はありません。</h3>
       </s:if>
      <s:elseif test="message == null">
        <h3>ご購入情報は以下になります。</h3>
        <table border="1">
        <tr>
            <th>商品名</th>
            <th>値段</th>
            <th>購入個数</th>
            <th>支払い方法</th>
            <th>購入日</th>
         </tr>
         <s:iterator value="myPageList">
            <tr>
            <td><s:property value="itemName" /></td>
            <td><s:property value="totalPrice " /><span>円</span>
            </td>
            <td><s:property value="totalCount" /><span>個</span>
            </td>
            </table></s:elseif></div></div></body></html>
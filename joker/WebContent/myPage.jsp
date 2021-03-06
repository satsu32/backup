<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta charset="utf-8">
	<title>マイページ画面</title>
</head>
<body>
<s:include value="header.jsp"/>

   <div id="header">
         <div id="pr">
         </div>
   </div>
   <div id="main">
      <div id="top">
         <h2>マイページ</h2>
             <img src="images/item/air.jpg"align="right"/>
      </div>
      <!--
      <div>
      <s:if test="myPageList == null">
         <h3>ご購入情報はありません。</h3>
      </s:if>
      <s:elseif test="message == null">
      -->
          <h3>ご購入情報は以下になります。</h3>
          <table border="1">
          <tr>
              <th>商品名</th>
              <th>商品画像</th>
              <th>値段</th>
              <th>購入個数</th>
              <th>支払い方法</th>
              <th>購入日</th>
          </tr>
          <s:iterator value="myPageList">
            <tr>

                 <tr>
                     <td><s:property value="itemName"/></td>

                     <td><img src='<s:property value="itemImage" />' width="30px" height="30px"/></td>

                     <td><s:property value="totalPrice"/>


                     <span>円</span>
                     </td>
                     <td><s:property value="totalCount"/>


                     <span>個</span>
                     </td>
                     <td><s:property value="payment"/></td>


                     <td><s:property value="insert_date"/></td>


                  </tr>

            </s:iterator>
            </table>
            <s:form action="MyPageAction">
            	<s:hidden name="loginUserId" value="%{loginUserId}"/>
            	<s:hidden name="deleteFlg" value="1"/>
                <s:submit value="削除"/>
             </s:form>
             <!--
          </s:elseif>
           -->
          <s:if test="message != null">
              <h3><s:property value="message"/></h3>

          </s:if>
            </div>
            <!--
        </div>
         -->
        <div id="footer">
            <div id="pr">
            </div>
        </div>
</body>
</html>
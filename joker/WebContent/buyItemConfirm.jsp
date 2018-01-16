<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./css/buyItem.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no"/>
    <meta name="description" content=""/>
    <meta name="keywords" content="" />
    <meta charset="utf-8">
<title>BuyItemConfirm画面</title>
<style type="text/css">
</style>
</head>
<body>
    <div id="header">
       <div id="pr">
       </div>
    </div>
    <div id="main">
        <div id="top">
        <p>BuyItem</p>
        </div>
        <div class="example">
      <img src="./images/Lighthouse.jpg" alt="写真" width="193" height="130">
    <div>
    <s:form action="BuyItemConfirmAction">
        <table>
          <tr>
             <td>
              </td>
              <td>
                 <span>商品名</span>
              </td>
               <td>
                 <span>商品画像</span>
              </td>
              <td>
                  <span>値段</span>
              </td>
              <td>
                   <span>在庫</span>
                </td>
          </tr>


          <s:iterator value="cartList">
          <s:if test="check==true">
          <tr>
              <td>
                 <s:property value="itemName" />
                 <s:hidden name="itemName" value="%{itemName}"/>
              </td>
              <td>
                 <img src='<s:property value="itemImage" />'/>
                 <s:hidden name="itemImage" value="%{itemImage}"/>
              </td>
              <td>
                 <s:property  value="itemPrice"/><span>円</span>
                 <s:hidden name="itemPrice" value="%{itemPrice}"/>
               </td>
                <td>
               	<s:property value="stock" />個
               	<s:hidden name="stock" value="%{stock}"/>
                  </td>
              </tr>
              </s:if>
          </s:iterator>
              </table>
              <tr>
                 <td>
                     <span>支払い方法</span>
                 </td>
                 <td>
                    <s:property value="payment"/>
                  </td>
                </tr>
                <tr>
                   <td>
                      <s:submit value="購入"/>
                   </td>
                </tr>

       </s:form>
            <div>
                <span>前画面に戻る場合は</span><a href='<s:url action="HomeAction"/>'>こちら</a>
            </div>
        </div>
      </div>
    </div>
</body>
</html>
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
<!---->
<link rel="stylesheet" href="./css/home.css">


 	<script>
function goBuyItemDetailAction(){
	document.getElementById('form').action = "BuyItemDetailAction";
}

</script>
<title>Home画面</title>

</head>
<body>
<s:include value="header.jsp"/>

   <div id="header">
         <div id="pr">
         </div>
   </div>
   <div id="main">
      <div id="top">
      </div>
      <div>
		<s:form id="form" name="form" action="BuyItemDetailAction">
          <table border="1">
          <!--
          <tr>
              <th>商品名</th>
              <th>値段</th>
              <th>購入個数</th>
              <th>支払い方法</th>
              <th>購入日</th>
          </tr>
          -->
          <s:iterator value="itemInfoTransactionList" status="stt">

          <s:url id="url" action="BuyItemDetailAction">
                 	<s:param name="id" value="%{id}"/>
                 	<s:param name="itemName" value="%{itemName}"/>
                 	<s:param name="itemImage" value="%{itemImage}"/>
                 	<s:param name="itemPrice" value="%{itemStock}"/>
                 	<s:param name="insertDate" value="%{insertDate}"/>
                 	<s:param name="updateDate" value="%{updateDate}"/>
		  </s:url>
			<s:a href="%{url}">
				<img src='<s:property value="itemImage"/>' width="100px" height="100px"/>
			</s:a>
		<s:if test="((#stt.count) % 5)==0">
		<br>
		</s:if>

            </s:iterator>
            </table>
            </s:form>
            </div>
        </div>
        <div id="footer">
            <div id="pr">
            </div>
        </div>
</body>
</html>
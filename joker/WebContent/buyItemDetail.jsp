<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 	<script>
function goBuyItemAction(){
	document.getElementById('form').action = "BuyItemAction";
}
function goSearchAction(){
	document.getElementById('form').action = "SearchAction";
}

</script>
<title>単一商品選択</title>
</head>
<body>

<s:include value="header.jsp"/>
<h1>商品詳細</h1>

	<s:form id="form" name="form" action="BuyItemAction">

			<div>
				<p>商品検索</p>
				<input type="search" name="search" placeholder="キーワードを入力">
				<s:submit id="searchsubmit" value="search" onclick="goSearchAction();"/>
			</div>
			<div>
				<s:if test="errorMessage!=null">
					<p><s:property value="errorMessage"/></p>
				</s:if>
				<s:hidden name="actionType" value="1"/><br>
				<s:hidden name="loginUserId" value="%{loginUserId}"/><br>
				<table>
				<tr>
					<td></td>
					<td><span>商品ID</span></td>
					<td><span>商品名</span></td>
					<td><span>商品画像</span></td>
					<td><span>値段</span></td>
					<td><span>在庫</span></td>
				</tr>
				<tr>
					<td><s:property value="id"/><s:hidden name="id" value="%{id}"/><td>
						<s:property value="itemName" /><s:hidden name="ItemName" value="%{ItemName}"/>
					</td>
					<td><img src='<s:property value="itemImage" />' width="200px" height="200px"/><s:hidden name="ItemImage" value="%{ItemImage}"/></td>
					<td><s:property  value="itemPrice"/><span>円</span><s:hidden name="itemPrice" value="%{itemPrice}"/>
					</td>
					<td><select name="stock">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option  value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						</select>
					</td>
				</tr>
				</table>
				<table>
				<tr>
				<td><span>支払い方法</span></td>
				<td><input type="radio" name="pay" value="1" checked="checked">現金払い
					<input type="radio" name="pay" value="2">クレジットカード
					<input type="radio" name="pay" value="3">代引き払い
				</td>
				</tr>
				<tr>
				<s:if test="#session.loginFlg==true">
				  <s:submit value="購入" onclick="goBuyItemAction();"/>
				</s:if>
				<s:else>
				   <input type="submit" value="購入" onclick="goBuyItemAction();" disabled="disabled" />
				</s:else>
				 </tr>
			</table>
			</div>
		</s:form>



</body>


</html>
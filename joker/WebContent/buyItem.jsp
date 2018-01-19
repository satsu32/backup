<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./css/buyItem.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="imagetoolbar" content="no"/>
    <meta name="description" content="" />
    <meta name="keywords" content=""/>
    <meta charset="utf-8">
<title>BuyItem画面</title>
<style type="text/css">

#searchsubmit {
     border: 1px solid #006489;
     background:#00acee;
     color: #fff;
     border-radius: 4px;
     -moz-border-radius: 4px;
     -webkit-border-radius: 4px;
     box-shadow:0 2px 0 #006E96;
     text-shadow: 1px 1px 2px #000000;
     text-decoration: none
     padding: 5px 10px;
     cursor: pointer;
     display: inline-block;
     }
p{ color:#FF0000;
   font-family: "Tsukushi A Round Gothic","筑紫A丸ゴシック"; font-weight: bold;
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
        <p>BuyItem</p>
        </div>
        <div class="example">
      <img src="./images/Lighthouse.jpg" alt="写真" width="193" height="130">
<div>
<form action="SearchAction" method="post">
      <p>商品検索</p>
  <input type="search" name="search" placeholder="キーワードを入力">
  <input type="submit" name="submit" id="searchsubmit" value="search">
</form>
</div>
    <div>
    <s:if test="errorMessage!=null">
    	<p><s:property value="errorMessage"/></p>
    </s:if>

    <s:form action="BuyItemAction">
        <s:hidden name="loginUserId" value="%{loginUserId}"/>
        <br>
        <table>
          <tr>
             <td>
              </td>
              <td>
                 <span>商品ID</span>
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


          <s:iterator value="buyItemList">
          <tr>
              <td>
                 <s:checkbox name="checkList" value="checked" fieldValue="%{id}" />
              </td>
              <td>
                <s:property value="id"/>
                <s:hidden name="id" value="%{id}"/>
              <td>
                 <s:property value="itemName" />
                 <s:hidden name="ItemName" value="%{ItemName}"/>
              </td>
              <td>
                 <img src='<s:property value="itemImage" />'/>
                 <s:hidden name="ItemImage" value="%{ItemImage}"/>
              </td>
              <td>
                 <s:property  value="itemPrice"/><span>円</span>
                 <s:hidden name="itemPrice" value="%{itemPrice}"/>
               </td>
                <td>
                   <select name="stock">
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
          </s:iterator>
              </table>
              <tr>
                 <td>
                     <span>支払い方法</span>
                 </td>
                 <td>
                    <input type="radio" name="pay" value="1" checked="checked">現金払い
                    <input type="radio" name="pay" value="2">クレジットカード
                    <input type="radio" name="pay" value="3">代引き払い
                  </td>
                </tr>
                <tr>
                   <td>
                      <s:submit value="購入"/>
                   </td>
                </tr>

       </s:form>
            <div>
                 <s:form action="MyPageAction">
				<s:submit value="マイページ"/>
			</s:form>
                <span>前画面に戻る場合は</span><a href='<s:url action="HomeAction"/>'>こちら</a>
            </div>
        </div>
      </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<sx:head />
<link rel="stylesheet" type="text/css" href="./css/addProduct.css">
</head>
<body text="#232323" link="##404040" vlink="#404040" alink="#404040">

	<!--ロゴここから-->
	<div id="header">
		<div class="logo">
			<a href="GoHomeAction"><img src="./image/logo1.jpg"></a>
		</div>
	</div>
	<!--ロゴここまで-->

	<!-- メインここから -->
	<div id="main">
		<h2 class="title">管理画面（新規商品登録）</h2>
		<div class="box">
			<s:iterator value="errorMessageList">
				<s:property />
			</s:iterator>
			<s:form action="AddProductAction" enctype="multipart/form-data"
				theme="simple">
				<s:div>
					<span>商品名</span>
					<br>
					<s:textfield name="productName" />
				</s:div>
				<s:div>
					<span>商品名かな</span>
					<br>
					<s:textfield name="productNameKana" />
				</s:div>
				<s:div>
					<span>商品詳細</span>
					<br>
					<s:textfield name="productDescription" />
				</s:div>
				<s:div>
					<span>カテゴリー</span>
					<br>
					<s:select name="categoryId" list="categoryMap" />
				</s:div>
				<s:div>
					<span>価格</span>
					<br>
					<s:textfield name="price" />
				</s:div>
				<s:div>
					<span>在庫</span>
					<br>
					<s:textfield name="stock" />
				</s:div>
				<s:div>
					<span>商品画像を選択</span>
					<br>
					<s:file property="uploadFile" name="imageFile" />
				</s:div>
				<s:div>
					<span>販売元会社</span>
					<br>
					<s:textfield name="releaseCompany" />
				</s:div>
				<s:div>
					<span>発売日</span>
					<br>
					<sx:datetimepicker name="releaseDate" displayFormat="yyyy-MM-dd" />
				</s:div>
				<br>
				<s:submit value="登録" />
			</s:form>
		</div>
		<div class="replenishstock">
			<s:a href="ReplenishStockAction">
				全商品の在庫を100個に補充
			</s:a>
		</div>
		<div class="gohome">
			<p>
				HOMEに<a href="GoHomeAction">戻る</a>
			</p>
		</div>
	</div>
</body>
</html>
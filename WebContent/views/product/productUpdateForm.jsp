<%@page import="org.shopping.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

	<form action="${pageContext.request.contextPath}/shopping" method="post" id="productForm">
		<input type="hidden" name="command" value="productUpdate"> 
		<input type="hidden" name="no" value="${requestScope.product.productNo}">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name" value="${requestScope.product.productName}"
					placeholder="상품명을 입력해주세요"></td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><input type="number" name="price" value="${requestScope.product.productPrice}"
					placeholder="상품가격을 입력해주세요"></td>
			</tr>
			<tr>
				<td>상품재고</td>
				<td><input type="number" name="count" value="${requestScope.product.productPossesionCount}"
					placeholder="재고량 입력해주세요" min=1;></td>
			</tr>
			<tr>
				<td>상품종류</td>
				<td><input type="text" name="kind" value="${requestScope.product.kinds}"
					placeholder="상품종류을 입력해주세요"></td>
			</tr>
			<tr>
				<td>상품내용</td>
				<td><textarea name="content" id="content" style="width: 100%;">${requestScope.product.productContent}</textarea></td>
			</tr>
			<tr>
				<td>대표이미지</td>
				<td>
					<div id="productMain"><img src="${pageContext.request.contextPath}/resources/img/product/main/${requestScope.product.productMainImg}"></div>
				</td>
			</tr>
		</table>
		<input type="button" value="상품등록" id="productBtn">
	</form>
	
	
	<form  id="productImgForm" enctype="multipart/form-data" >
		<input type="hidden" name="productNo" value="${requestScope.product.productNo}">
		<input type="file" name="productImg" id="productImg" accept="image/*">
		<input type="button" id="proudctImgBtn" value="변경">
	</form>
	
	
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/editor/js/HuskyEZCreator.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$(document).on("click","#proudctImgBtn",function(){
				if($("#productImg").val()==""){
					alert("변경될 상품을 등록해주세요.");
					return;
				}
				var formData = new FormData($("#productImgForm")[0]);
				
				$.ajax({
					type: "post",
					enctype: "multipart/form-data",
					url : "${pageContext.request.contextPath}/productImgUpdate",
					dataType : "text",
					data : formData,
					processData : false,
					contentType : false,
					success: function(data){
						$("#productMain img").attr("src","${pageContext.request.contextPath}/resources/img/product/main/"+data);
					}
				});
			});
			
			
			$(document).on("change", "#productImg", function() {
				var ext = $(this).val().split(".").pop().toLowerCase();

				if ($.inArray(ext, [ "gif", "jpg", "jpeg", "png" ]) == -1) {
					alert("gif,jpg,jpeg,png 파일만 업로드 해주세요.");
					$(this).val("");
					return;
				}
				//productFile();
			});
		$(document).on("click","#productBtn",function(){
			
			if($("#productForm input[name=name]").val()==""){
				alert("상품명을 입력해주세요.");
				return;
			}
			if($("#productForm input[name=price]").val()==""){
				alert("상품가격을 입력해주세요.");
				return;
			}
			if($("#productForm input[name=count]").val()==""){
				alert("상품 재고을 입력해주세요.");
				return;
			}
			if($("#productForm input[name=kind]").val()==""){
				alert("상품종류을 입력해주세요.");
				return;
			}
			
			oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			
			if($("#productForm textarea[name=content]").val()==""){
				alert("상세내용을 입력해주세요.");
				return;
			}
			$("#productForm").submit();
		});
	});
		function productFile() {
			document.getElementById("productMain").innerHTML = "";
			var reader = new FileReader();//파일 읽어오기
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);//img속성 중 src에 주소값 넣는다.
				document.querySelector("#productMain").appendChild(img);
			};
			reader.readAsDataURL(event.target.files[0]);
		}
		var oEditors = [];
		
			nhn.husky.EZCreator.createInIFrame({
						oAppRef : oEditors,
						elPlaceHolder : "content",
						//SmartEditor2Skin.html 파일이 존재하는 경로
						sSkinURI : "${pageContext.request.contextPath}/editor/SmartEditor2Skin.html",
						htParams : {
							// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseToolbar : true,
							// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseVerticalResizer : true,
							// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							bUseModeChanger : true,
							fOnBeforeUnload : function() {
							}
						},
						fOnAppLoad : function() {
							//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
							//oEditors.getById["PostContent"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
						},
						fCreator : "createSEditor2"
					});
	</script>
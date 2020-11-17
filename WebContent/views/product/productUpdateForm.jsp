<%@page import="org.shopping.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<div class="container">
	<div id="productInfo">
		<form action="${pageContext.request.contextPath}/shopping" id="productInfoForm" method="post">
			<input type="hidden" name="command" value="productUpdate"> <input type="hidden" name="no" value="${requestScope.product.productNo}">
			<table>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="name" value="${requestScope.product.productName}" placeholder="상품명을 입력해주세요"></td>
				</tr>
				<tr>
					<th>상품가격</th>
					<td><input type="number" name="price" value="${requestScope.product.productPrice}" placeholder="상품가격을 입력해주세요"></td>
				</tr>
				<tr>
					<th>상품재고</th>
					<td><input type="number" name="count" value="${requestScope.product.productPossesionCount}" placeholder="재고량 입력해주세요" min=1;></td>
				</tr>
				<tr>
					<th>상품종류</th>
					<td><input type="text" name="kind" value="${requestScope.product.kinds}" placeholder="상품종류을 입력해주세요"></td>
				</tr>
				<tr>
					<th>상품내용</th>
					<td><textarea name="content" id="content" style="width: 100%;">${requestScope.product.productContent}</textarea></td>
				</tr>
				<tr>
					<th>대표이미지</th>
					<td>
						<div class="productMainImg">
							<div id="productMain">
								<span>대표 이미지 수정</span>
								<img src="${pageContext.request.contextPath}/resources/img/product/main/${requestScope.product.productMainImg}">
							</div>
						</div>	
					</td>
				</tr>
			</table>
			<input type="button" value="상품변경" id="productBtn">
		</form>

		<div class="productChage">
			<div class="productChageHeader">
			<h1>변경할 상품 이미지를 등록해주세요</h1>
			</div>
		<div class="productChageBody">
			<form id="productImgForm" enctype="multipart/form-data">
				<input type="hidden" name="productNo" value="${requestScope.product.productNo}"> <input type="file" name="productImg" id="productImg" accept="image/*"> 
			</form>
				<div id="productMain" class="productChageMain">
					<img src="${pageContext.request.contextPath}/resources/img/product/main/${requestScope.product.productMainImg}">
				</div>
			</div>
			<%-- productChageBody --%>
			<div class="productChageBtn">
				<input type="button" id="proudctImgBtn" value="변경">
				<input type="button" value="취소">
			</div>
			<%-- productChageBtn --%>
		</div>
		<%-- productChage --%>
	
	</div>
	<%-- productInfo --%>
</div>
<%-- container --%>



<script type="text/javascript"
		src="${pageContext.request.contextPath}/editor/js/HuskyEZCreator.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			

			$(document).on("click",".productMainImg #productMain",function(){
				if($(".productChage").is(":animated"))return;
				$(".productChage #productMain img").attr("src",$(".productMainImg #productMain img").attr("src"));
				$(".productChage .productChageBody #productImgForm input[type=file]").val("");
				$(".productChage").css("display","block");
				$(".productChage").animate({
					top: "40%",
					opacity: 1
				},1000);
			});
			
			$(document).on("click",".productChage .productChageBtn input[value=취소]",function(){
				if($(".productChage").is(":animated"))return;
				$(".productChage").animate({
					top: "30%",
					opacity: 0
				},1000,function(){
					$(this).css("display","none");
				});
			});
			
			$(document).on("click","#proudctImgBtn",function(){
				if($(".productChage").is(":animated"))return;
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
						$(".productChage").animate({
							top: "30%",
							opacity: 0
						},1000,function(){
							$(this).css("display","none");
						});
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
				productFile();
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
			$("#productInfoForm").submit();
		});
	});
		function productFile() {
			document.getElementsByClassName("productChageMain")[0].innerHTML="";
			//document.getElementById("productMain").innerHTML = "";
			var reader = new FileReader();//파일 읽어오기
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);//img속성 중 src에 주소값 넣는다.
				document.querySelector(".productChage .productChageBody #productMain").appendChild(img);
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
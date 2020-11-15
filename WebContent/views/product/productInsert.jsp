<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<div class="container">
	<div id="productInfo">
		<form action="${pageContext.request.contextPath}/productInsert" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="name" required="required" maxlength="30" placeholder="상품명을 입력해주세요"></td>
				</tr>
				<tr>
					<th>상품가격</th>
					<td><input type="number" name="price" required="required" placeholder="상품가격을 입력해주세요">
					<span class="priceCheck"></span>
					</td>
				</tr>
				<tr>
					<th>상품재고</th>
					<td><input type="number" name="count" required="required" placeholder="재고량 입력해주세요" min=1;></td>
				</tr>
				<tr>
					<th>상품종류</th>
					<td>
						<input type="radio" name="kind" value="상의">상의
						<input type="radio" name="kind" value="아우터">아우터
						<input type="radio" name="kind" value="하의">하의
						<input type="radio" name="kind" value="신발">신발
					</td>
				</tr>
				<tr>
					<th>상품내용</th>
					<td><textarea name="content" id="content" style="width: 100%;"></textarea></td>
				</tr>
				<tr>
					<th>대표이미지</th>
					<td>
					<div class="productMainImg">
						<div id="productMain">
							
						</div> 
						</div><input type="file" id="productImg" name="imgPath" required="required" placeholder="이미지 입력해주세요">
					</td>
				</tr>
			</table>
		</form>
			<input type="button" value="상품등록" id="productBtn">
	</div>
	<%-- productInfo --%>
</div>
<%-- container --%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/editor/js/HuskyEZCreator.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var priceCheckCoin="";
			$(document).on("change", "#productImg", function() {
				var ext = $(this).val().split(".").pop().toLowerCase();

				if ($.inArray(ext, [ "gif", "jpg", "jpeg", "png" ]) == -1) {
					alert("gif,jpg,jpeg,png 파일만 업로드 해주세요.");
					$(this).val("");
					return;
				}
				productFile();
			});
		$(document).on("keyup","#productInfo input[name=price]",function(){
			var priceTextLength = document.getElementsByName("price");
			if($(this).val().length>9){
				$(".priceCheck").html("금액제한 범위에 초과혔습니다.").css("color","red");
				priceCheckCoin="1";
			}else{
				$(".priceCheck").html("");
				priceCheckCoin="";
			}
		});
			
		$(document).on("click","#productBtn",function(){
			
			if($("#productInfo input[name=name]").val()==""){
				alert("상품명을 입력해주세요.");
				return;
			}
			if($("#productInfo input[name=price]").val()==""){
				alert("상품가격을 입력해주세요.");
				return;
			}else if(priceCheckCoin !==""){
				alert("금액 일정 범위에 초과하셨습니다.")
				return;
			}
			if($("#productInfo input[name=count]").val()==""){
				alert("상품 재고을 입력해주세요.");
				return;
			}
			var radioCoin = false;
			$("#productInfo input[name=kind]").each(function(){
				if($(this).prop('checked') === true){
					radioCoin= true;
					return true;
				}	
			});
			if(radioCoin === false){
				alert("상품종류를 선택해주세요");
				return;
			}
			
			//alert($("#content").val());
			
			oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			
			//alert($("#content").val().length)
			if($("#content").val()=="<p>&nbsp;</p>"){
				alert("상세내용을 입력해주세요.");
				return;
			}
			
			if($("#productImg").val()==""){
				alert("대표이미지를 입력해주세요.");
				return;
			}
			
			
			$("#productInfo form").submit();
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
						//oEditors.getById["content"].exec("PASTE_HTML", [""]);
						},
						fCreator : "createSEditor2"
					});
	</script>
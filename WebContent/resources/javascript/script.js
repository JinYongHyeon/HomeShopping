$(function() {

});

function back() {
	location.href = "index.jsp"
}

function singUpCheck() {
	var flag = false;
	flag = telCheck();
	flag = passCheck();
	return flag;
}

function telCheck() {
	var tel = $("input[name=tel]").val().trim();

	if (!isNaN(tel)) {
		if (tel.length == 11) {
			flag = true;
		} else {
			alert("전화번호 11자리를 입력해주세요");
		}

	} else {
		alert("숫자만 입력해주세요");
	}

}
function passCheck() {
	var flag = false;
	var pass = $("input[name=password]").val().trim();
	var passCheck = $("input[name=passwordCheck").val().trim();
	if (pass === passCheck)
		flag = true;
	if (flag === false)
		alert("비밀번호가 맞지 않습니다");
	return flag;
}

/* 어드민 페이지 상품 삭제 체크박스체크 */
function productCheckbox(){
	var flag= false;
	var check = $("input[name=productCk]");
	
	for(var i=0;i<check.length;i++){
		if(check[i].checked === true){
			flag = true;
			break;
		}
	}
	if(!flag) alert("체크박스를 체크후 삭제를 해주십시시오.");
	
	return flag;
}

function produtNewCheck(){
	var flag =true;
	var a = $("select[name=productNew]").val();
	if(a==="--신상 유무를 선택해주세요--"){
		alert("신상 유무를 선택해주세요");
		flag =false;
	}
	return flag;
}


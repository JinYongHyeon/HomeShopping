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
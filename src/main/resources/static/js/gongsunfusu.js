$("#registerButton").click(function(){
	$(".register").hide();
	$(".login").show();
});
$("#loginButton").click(function(){
	$(".login").hide();
	$(".register").show();
});

function getPath() {
	//获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPath = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/ems
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return(localhostPath + projectName);
}


function chageVerify() {
	var img_src = getPath() + "/kaptcha?" + Math.floor(Math.random() * 100);
	$(".captcha_img").attr("src",img_src);
}
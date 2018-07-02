function checkMe() {//login.html
	 var no = document.getElementById('name').value;          
	    var pwd = document.getElementById('pwd').value;    
	    if(no == '') {
	        alert('请输入用户名!');
	        document.getElementById('name').focus();
	        return false;
	    }
	 
	if(pwd == '') {
	        alert('请输入密码!');
	        document.getElementById('pwd').focus();
	        return false;
	    }
document.login.submit();
	}

function checkpwd(){ //max.jsp
    var pwd = document.getElementById('pwd').value;    
    var pwd1 = document.getElementById('pwd1').value;   
    if(pwd != pwd1) {
        alert('两次输入密码不同!');
        document.getElementById('pwd').focus();
        return false;
    }
 
if(pwd1 == '') {
        alert('密码不能为空!');
        document.getElementById('pwd1').focus();
        return false;
    }
}


function hinttext() { // v3.0
	document.getElementById("this").values('22');
}
function MM_swapImgRestore() { // v3.0
	var i, x, a = document.MM_sr;
	for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
		x.src = x.oSrc;
}




function MM_swapImage() { // v3.0
	var i, j = 0, x, a = MM_swapImage.arguments;
	document.MM_sr = new Array;
	for (i = 0; i < (a.length - 2); i += 3)
		if ((x = MM_findObj(a[i])) != null) {
			document.MM_sr[j++] = x;
			if (!x.oSrc)
				x.oSrc = x.src;
			x.src = a[i + 2];
		}
}


function AddManage(){
	var x=event.clientX;
	var y=event.clientY;
	document.getElementById("pic").style.top=y+50;
	document.getElementById("pic").style.left=x;
	document.getElementById("pic").style.visibility="visible";
	var formDiv="<form action='#'>";
	formDiv+="用户名: <input type='text' name='user' /><br>";
	formDiv+="密码:    <input type='password' name='pass' /><br><br>";	 
		formDiv+="<input type='submit' value='提交' onclick='hide()' /></form>";	 
	document.getElementById("pic").innerHTML=formDiv;
}

function hide(){
	document.getElementById("pic").style.visibility="hidden";
}


function checktest(){ //max.jsp
				 var no = document.getElementById('name').value;          
				    var identity = document.getElementById('identity').value;
				    var phone = document.getElementById('phone').value;   
				    var pwd = document.getElementById('pwd').value;    
				    var pwd1 = document.getElementById('pwd1').value;   
				    if(no == '') {
				        alert('请输入用户名!');
				        document.getElementById('name').focus();
				        return false;
				    }
				    if(identity == '') {
				        alert('请输入身份证号!');
				        document.getElementById('name').focus();
				        return false;
				    }
				    if(phones == '') {
				        alert('请输入手机号!');
				        return false;
				    }
				    if(pwd == '') {
				        alert('请输入密码!');
				        document.getElementById('pwd').focus();
				        return false;
				    }
				 
				if(pwd1 == '') {
				        alert('请输入确认密码!');
				        document.getElementById('pwd1').focus();
				        return false;
				    }
			document.add.submit();
				
		}


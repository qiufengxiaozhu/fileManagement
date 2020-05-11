/*登录界面JS*/

//定义全局变量，表单验证通过其值为true
var flag = true;

//调用生成验证码方法
function loadimage(){

	//不缓存,如果2次请求，路径完全相同的时候,将会获取缓存中的数据,而不是重新调用服务器。
	document.getElementById("randImage").src = "ImageServlet?"+Math.random(); 
};

//表单验证
$(document).ready(function(){
	
	$("#check_span,#login_span").css("display","inline").fadeOut(3000);//持续起作用，主要看页面让不让它显现
	
	$("#user_text").focus(function () {
		loadimage();	//刷新验证码
		$("#pwd_text").val("");
	});
	
	$("#login").click(function () {
			
		flag = true;
		//判断用户名、密码、验证码是否为空
	    if($("#user_text").val()=='' && $("#pwd_text").val()=='' && $("#verify_text").val()==''){
	    	$("#user_span,#pwd_span,#verify_span").css("display","inline").fadeOut(3000);
	    	flag = false;
	    }
	    //判断用户名是否为空
	    else if ($("#user_text").val()==''){
	    	$("#user_span").css("display","inline").fadeOut(3000);
	    	flag = false;
	    }
	    //判断密码是否为空
	    else if($("#pwd_text").val()==''){
	    	$("#pwd_span").css("display","inline").fadeOut(3000);
	    	flag = false;
	    }
	    //判断验证码是否为空
	    else if($("#verify_text").val()==''){
	    	$("#verify_span").css("display","inline").fadeOut(3000);
	    	flag = false;
	    }
	    
	    //用户名只能是6-10位数字
	    var reg1=new RegExp(/^\d{6,10}$/);
		if(!reg1.test($("#user_text").val()) && $("#user_text").val()!=''){
			$("#reg1_span").css("display","inline").fadeOut(3000);
			flag = false;
		}
		
		//密码只能是3-10位字符
		var reg2=new RegExp(/^[a-zA-Z0-9]{3,10}$/);
		if(!reg2.test($("#pwd_text").val()) && $("#pwd_text").val()!=''){
			$("#reg2_span").css("display","inline").fadeOut(3000);
			flag = false;
		}
	    
	});
	
	//重置按钮
	$("#emptyAll").click(function () {
		$("#user_text,#pwd_text,#verify_text").val("");
	});
	
});

//表单验证通过返回true
function check(){

	return flag;
};


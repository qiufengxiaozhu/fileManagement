/**
 * 个人信息页面
 */

//定义全局变量，表单验证通过其值为true
var flag = true;

//按钮点击事件
$(document).ready(function(){
	
	//让文本框不可编辑
	//$("input[type='text']").attr("disabled","disabled");//不可编辑，不可复制，不可选择，不能接收焦点，后台也不会接收到传值。
	$("input[type='text']").attr("readonly","readonly");//不可编辑，不可复制，不可选择，不能接收焦点，但是后台可以接收到传值。
	
	//信息修改按钮点击事件
	$("#edit_btn").click(function () {		
		$("#edit_btn").css("cursor","not-allowed").css("background-color","#F16FB0");	//单击后不可点击
		$("#cancel_btn,#save_btn,#calendar_btn").css("display","inline");	//让取消与保存按钮显示出来
		$("input[type='text']").removeAttr("readonly");	//去除只读属性
		$("#num_text,#birthday_text").attr("readonly","readonly");//账号 生日始终不可编辑
	});
	
	//取消按钮点击事件
	$("#cancel_btn").click(function () {
		$("#edit_btn").css("cursor","pointer").css("background-color","#E8774D");
		$("#cancel_btn,#save_btn,#calendar_btn").css("display","none");	//让取消与保存按钮显示隐藏
		$("input[type='text']").attr("readonly","readonly");//文本框只读
	});
	

	
	//表单验证	
	$("#save_btn").click(function () {
				
		flag = true;
		//提交操作时给出确认
		if(confirm("确认要提交么？")){	
			
			//判断输入框是否为空
		    if($("#user_text").val()=='' || $("#pwd_text").val()=='' ){
		    	$("#empty_span").css("display","inline").fadeOut(3000);
		    	flag = false;
		    }
			
		    //判断用户名
			var reg1=new RegExp(/^[\u4E00-\u9FA5]{2,5}$/);
			if(!reg1.test($("#user_text").val()) && $("#user_text").val()!=''){
				$("#user_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
			
		    //判断密码
			var reg2=new RegExp(/^[a-zA-Z0-9]{3,10}$/);
			if(!reg2.test($("#pwd_text").val()) && $("#pwd_text").val()!=''){
				$("#pwd_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
			
		    //判断电话号码
			var reg3=new RegExp(/^\d{11}\s*$/);
			if(!reg3.test($("#tel_text").val()) && $("#tel_text").val()!=''){
				$("#tel_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
			
		    //判断邮箱
			var reg4=new RegExp(/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/);
			if(!reg4.test($("#mail_text").val()) && $("#mail_text").val()!=''){
				$("#mail_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
	    
		}
		else{
			alert("您已取消");
			flag = false;
		}
	    
	});
	
});

//表单验证通过返回true
function check(){
	if(flag)
		location.reload();
	return flag;
};
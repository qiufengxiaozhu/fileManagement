/*注册界面JS*/

//定义全局变量，表单验证通过其值为true
var flag = true;

//表单验证
$(document).ready(function(){
		
	$("#register").click(function () {
		
		
		//提交操作时给出确认
		if(confirm("确认要提交么？")){	
			flag = true;
			//判断输入框是否为空
		    if($("#num_text").val()=='' || $("#user_text").val()=='' 
		    	|| $("#pwd_text").val()=='' || $("#repwd_text").val()=='' 
		    		|| $("#birthday_text").val()=='' ){
		    	alert("除了电话与邮箱，其他均不可为空值！");
		    	flag = false;
		    }
		    var val=$("input[type='radio']:checked").val();
            if(val==null){
            	$("#sex_span").css("display","inline").fadeOut(3000);
                flag = false;
            }
            
            //账号只能是6-10位数字
    	    var reg1=new RegExp(/^\d{6,10}$/);
    		if(!reg1.test($("#num_text").val()) && $("#num_text").val()!=''){
    			$("#num_span").css("display","inline").fadeOut(3000);
    			flag = false;
    		}
		    //判断用户名
			var reg2=new RegExp(/^[\u4E00-\u9FA5]{2,5}$/);
			if(!reg2.test($("#user_text").val()) && $("#user_text").val()!=''){
				$("#user_span").css("display","inline").fadeOut(3000);
				flag = false;
			}

		    //判断密码
			var reg3=new RegExp(/^[a-zA-Z0-9]{3,10}$/);
			if(!reg3.test($("#pwd_text").val()) && $("#pwd_text").val()!=''){
				$("#pwd_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
			
			//判断确认密码
			if($("#pwd_text").val() != $("#repwd_text").val()){
				$("#repwd_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
			
		    //判断电话号码
			var reg4=new RegExp(/^\d{11}\s*$/);
			if(!reg4.test($("#tel_text").val()) && $("#tel_text").val()!=''){
				$("#tel_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
			
		    //判断邮箱
			var reg5=new RegExp(/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/);
			if(!reg5.test($("#mail_text").val()) && $("#mail_text").val()!=''){
				$("#mail_span").css("display","inline").fadeOut(3000);
				flag = false;
			}
	    
			//判断职称
			if($("#position option:selected").val() == '0'){
				$("#position_span").css("display","inline").fadeOut(3000);
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

	return flag;
};
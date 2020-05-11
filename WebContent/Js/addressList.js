/**
 * 通讯录
 */

function out_staff(){
	
	var id = document.getElementsByName('select');
	var value = new Array();
	for (var i = 0; i < id.length; i++) {
		if (id[i].checked) {
			value.push(id[i].value);
			if (confirm("确定要停用选中人员吗？")) {
				return true;
			} else {
				return false;
			}
			break;
		}
	}

	alert("你没有选中人员，不可停用！");
	return false;
}

//事件
$(document).ready(function(){
	
	//隔行换色，排除最后一行
	$("tr:not(:last):odd").css("background-color","aqua");
	
//	$("#checkPower").click(function(){
//		alert("您暂无此权限!");
//	});

});

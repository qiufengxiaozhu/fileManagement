/**
 * 停用人员信息
 */

function out_staff(){
	
	var id = document.getElementsByName('select');
	var value = new Array();
	for (var i = 0; i < id.length; i++) {
		if (id[i].checked) {
			value.push(id[i].value);
			if (confirm("确定要操作选中人员吗？")) {
				return true;
			} else {
				return false;
			}
			break;
		}
	}

	alert("你没有选中人员，不可执行此操作！");
	return false;
}

//事件
$(document).ready(function(){
	
	//隔行换色，排除最后一行
	$("tr:not(:last):odd").css("background-color","aqua");

});
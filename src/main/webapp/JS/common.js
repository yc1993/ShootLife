/**
 * 
 */
function addEvent(id, location) {
	document.getElementById(id).addEventListener('tap', function(){
		window.location = location;
	});
}

//url根据参数获取参数值
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) 
		return unescape(r[2]); 
	return null; 
} 
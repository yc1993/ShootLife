/**
 * 
 */
function addEvent(id, location) {
	document.getElementById(id).addEventListener('tap', function(){
		window.location = location;
	});
}
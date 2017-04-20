$(document).keyup(function(e) {     
	var currKey=0,e=e||event;
	currKey=e.keyCode||e.which||e.charCode;
	switch(currKey) {     
		case 37: // left
			showpic('pre');
			break;
		case 39: // up
			showpic('next');
			break;
		case 13: // enter
			var nextpicurl = $('#nextPicsBut').attr('href');
			if(nextpicurl !== '' || nextpicurl !== 'null') {
				window.location=nextpicurl;
			}
		break;
	}   
});

var favAction = function(id){
    var number=$('.click_text > .number'),hits=0;
    $.ajax({
        type: "POST",
        url: "/api.php?op=fav&contentid="+id+"&action=read&r=" + new Date().getTime(),
        data: "read=true",
        success: function(msg){
            if(msg > 0){
                hits = msg;
            }
            number.html(hits);
        }
    });
    $('.click_status').on('click',function(){
        $.ajax({
            type: "POST",
            url: "/api.php?op=fav&contentid="+id+"&action=write&r=" + new Date().getTime(),
            data: "read=true",
            success: function(msg){
                if(msg > 0){
                    hits = msg;
                }
                number.html(hits);
            }
        });
    });
	$('.click_text').on('click',function(){
        $.ajax({
            type: "POST",
            url: "/api.php?op=fav&contentid="+id+"&action=write&r=" + new Date().getTime(),
            data: "read=true",
            success: function(msg){
                if(msg > 0){
                    hits = msg;
                }
                number.html(hits);
            }
        });
    });
 }
 if($('.xgzp') != null){
    $('.xgzp').find('dd').each(function(){
        var dd  = this;
        $(dd).mouseover(function(){
            $(dd).find('.mask').animate({bottom: "0px"}, 100 );
            $(dd).find('.content').animate({ bottom: "0px"}, 100 );
        }).mouseleave(function(){
            $(dd).find('.mask').animate({bottom: "-50px"}, 100 );
            $(dd).find('.content').animate({bottom: "-50px"}, 100 );
        });
    });
 }
 if($('#tk_year') != null){
    var date = new Date();
    var year = date.getFullYear();
    $('#tk_year').html(year);
 }

function showpic(type, replay) {
	//隐藏重复播放div
	$("#endSelect").hide();
	//图集图片总数
	var totalnum = $("#pictureurls li").length;
	var picid = parseInt(_picid);
	if(type=='next' || type=='pre') {
		if(type=='next') {
			i = picid + 1;
			//如果是最后一张图片，指针指向第一张
			if(i > totalnum) {
				$("#endSelect").show();
				i=1;
				next_picid=1;
				//重新播放
				if(replay!=1) {
					return false;
				} else {
					$("#endSelect").hide();
				}
			} else {
				next_picid = parseInt(i) + 1;
			}

		} else if (type=='pre') {
			i = picid - 1;
			//如果是第一张图片，指针指向最后一张
			if(i < 1) {
				$("#endSelect").show();
				i = 1;
				next_picid=1;
				//重新播放
				if(replay!=1) {
					return false;
				} else {
					$("#endSelect").hide();
				}
			} else {
				next_picid = parseInt(i) - 1;
			}
		}
		//更新锚点
		if(i==1){
			window.location = _url+'.html';
		}else{
			window.location = _url+'_'+i+'.html';
		}
	} else if(type=='big') {
		url = $("#pictureurls li:nth-child("+picid+")").attr("rel");
		window.open(url);
	} else {
		window.location = _url+'_'+picid+'.html';
	}
}
//预加载图片
function loadpic(id) {
	url = $("#pictureurls li:nth-child("+id+")").attr("rel");
	$("#load_pic").html("<img src='"+url+"'>");
}
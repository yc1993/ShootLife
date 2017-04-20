    (function(){
        function getYear(){
            var year;
            var timer = document.getElementById('tk_year');
            var date = new Date();
            year = date.getFullYear();
            if(timer != null){
                timer.innerHTML = year;
            }
        }
        getYear();
    })();
    //mask style
    $(function(){
        $('.imagesWrapper').find('dd').each(function(){
            var dd  = this;
            $(dd).mouseover(function(){
                $(dd).find('.mask').animate({bottom: "0px"}, 100 );
                $(dd).find('.content').animate({ bottom: "0px"}, 100 );
            }).mouseleave(function(){
                        $(dd).find('.mask').animate({bottom: "-50px"}, 100 );
                        $(dd).find('.content').animate({bottom: "-50px"}, 100 );
                    });
        });
        /**
        $('#jumper').click(function(){
            var targetnumber = $('#targetnumber').val();
            var currentUrl = window.location.href;
            if(targetnumber>1){
                if(currentUrl.search('.html')<1){
                    currentUrl  = currentUrl+"index.html";
                }
                var targeturl = currentUrl.replace(/\d+/,targetnumber);
                window.location.href = targeturl;
            }else{
                $('#targetnumber').focus();
            }
        });
    	*/
        $('#jumper').click(function(){
            var targetnumber = $('#targetnumber').val();
            var currentUrl = window.location.href;
            if(targetnumber>1){
                if(currentUrl.search('index.html')>0){
                    var targeturl = currentUrl.replace('index.html',targetnumber+'.html');
                }else{
                    if(/\d/gi.test(currentUrl)){
                        var targeturl = currentUrl.replace(/\d+/,targetnumber);
                    }else{
                        var targeturl = currentUrl+targetnumber+'.html';
                    }
                }                
                window.location.href = targeturl;
            }else if(targetnumber == 1){
                var targeturl = currentUrl.replace(/\d+/,'index');
                window.location.href = targeturl;
            }else{
                $('#targetnumber').focus();
            }
        });
    });
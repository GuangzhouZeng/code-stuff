  var mov = false;
  var Swidth = screen.availWidth;
  var Sheight = screen.availHeight;
  var curPanel = 3;
  var autoSlide=1; //1 is on. 0 is off.
  var auto_slide_seconds = 5000;  // set the time period
  var hover_pause = 1; // if hover on the image, pause the slide. 1 pause, 0 do not pause
 // $(function() {  
$(document).ready(function(){
	if(autoSlide==1){ 
		var timer=setInterval(function(){ change(true); }, auto_slide_seconds);
	}
		
     $(".Spanel").css('width', Swidth*0.6).css('height' , Sheight*0.8);
 //    $(".text").html("<div class=\"imgtext\"> We were unable to determine whether you have used this"
 //                 +"browser or device with your account before.This can happen when you"
 //                  +" sign in for the first time on a new computer,phone or browser,when you" 
 //                  +" use you browser's incognitol </div>");
     $(".imgtext").hide();
     $(".car-list > li >img").mouseover(function(){
        bigImg(this);
      });
		$(".car-list > li").hover(function(){
			clearInterval(timer);
			if($(this.parentNode.parentNode).attr("id")=="panel_"+curPanel){
				$(".imgtext",this).slideToggle("fast");
			}
		},function(){  
            //and when mouseout start it again
			timer = setInterval(function(){ change(true); }, auto_slide_seconds);
			$(".imgtext").hide();
        });
      
      var $carousels = $('.carousel-indicators >li');
      $($carousels).click(function(){
        changeCarousel(this);
      });
      
      var totalPanels			= $(".scrollContainer").children().size();
      var $panels				= $('#slider .scrollContainer > div');
      var $container			= $('#slider .scrollContainer');
      var movingDistance	    = parseFloat($panels[0].offsetWidth,10);

      $("#slider").data("currentlyMoving", false);
      $container
        .css('width', (movingDistance * $panels.length) + 100 )
        .css('left', (-1.66)*movingDistance);
    
      $("#panel_"+(curPanel+1)).click(function(){ change(true); });
      $("#panel_"+(curPanel-1)).click(function(){ change(false); });
    
      //when the left/right arrows are clicked
      $(".right").click(function(){ change(true); });	
      $(".left").click(function(){ change(false); });
      
      //direction true = right, false = left
	  function change(direction) {
		 
        //if((direction && !(curPanel < totalPanels)) || (!direction && (curPanel <= 1))) { return false; }	
		if ($("#slider").data("currentlyMoving") == false) {
			$("#slider").data("currentlyMoving", true);
			var leftValue  = $(".scrollContainer").css("left");
			var movement;
			var newPanel=curPanel;
			
			//if rightmost or leftmost
			if((direction&&curPanel==totalPanels)||(!direction&&curPanel==1)){
				//alert('right most');
				movement=direction?parseFloat(leftValue,10)+movingDistance*(totalPanels-1):parseFloat(leftValue,10)-movingDistance*(totalPanels-1);
				newPanel=direction?1:totalPanels;
			}else {
				movement = direction ? parseFloat(leftValue, 10) - movingDistance : parseFloat(leftValue, 10) + movingDistance;
				newPanel=direction ? curPanel + 1 : curPanel - 1;
			}
          
        //if not currently moving
      
          $(".scrollContainer").stop()
            .animate({"left": movement}, function() {
              $("#slider").data("currentlyMoving", false);
            });
           
          $carousels[curPanel-1].removeAttribute("class");
          //curPanel = direction ? curPanel + 1 : curPanel - 1;
		  curPanel=newPanel;
          $carousels[curPanel-1].className = "active";
          
          $("#panel_"+(curPanel+1)).unbind();	
          $("#panel_"+(curPanel+1)).click(function(){ change(true); });												
          $("#panel_"+(curPanel-1)).unbind();
          $("#panel_"+(curPanel-1)).click(function(){ change(false); });
          $("#panel_"+curPanel).unbind();
        }
      }
	  
	  
      /*function change(direction) {
		 
        if((direction && !(curPanel < totalPanels)) || (!direction && (curPanel <= 1))) { return false; }	
		
          
        //if not currently moving
        if ($("#slider").data("currentlyMoving") == false) {
              
          $("#slider").data("currentlyMoving", true);
        
          var leftValue  = $(".scrollContainer").css("left");
          var movement	 = direction ? parseFloat(leftValue, 10) - movingDistance : parseFloat(leftValue, 10) + movingDistance;
      
          $(".scrollContainer").stop()
            .animate({"left": movement}, function() {
              $("#slider").data("currentlyMoving", false);
            });
            
          $carousels[curPanel-1].removeAttribute("class");
          curPanel = direction ? curPanel + 1 : curPanel - 1;;
          $carousels[curPanel-1].className = "active";
          
          $("#panel_"+(curPanel+1)).unbind();	
          $("#panel_"+(curPanel+1)).click(function(){ change(true); });												
          $("#panel_"+(curPanel-1)).unbind();
          $("#panel_"+(curPanel-1)).click(function(){ change(false); });
          $("#panel_"+curPanel).unbind();
        }
      }*/
    
      function changeCarousel(x){
        if ($("#slider").data("currentlyMoving") == false) {
           x.className = "active";
           $carousels[curPanel-1].removeAttribute("class");
           
           var i = parseFloat(x.getAttribute("data-slide-to"),10);
           $("#slider").data("currentlyMoving", true);
           
           var leftValue    = (1.44-i)*movingDistance;
           $(".scrollContainer").stop()
              .animate({"left": leftValue}, function() {
                $("#slider").data("currentlyMoving", false);
              });
           curPanel = i;
           $("#panel_"+(curPanel+1)).unbind();
           $("#panel_"+(curPanel+1)).click(function(){ change(true); });
           $("#panel_"+(curPanel-1)).unbind();
           $("#panel_"+(curPanel-1)).click(function(){ change(false); });
           $("#panel_"+curPanel).unbind();
        }
      }
  
  });
  
function bigImg(x){
    var s = x.parentNode;
    if (mov == true){
      return;
    }else if($(s.parentNode.parentNode).attr("id")!="panel_"+curPanel){
        return;
    }else if(parseFloat($(s).css("width"),10)>Swidth*0.4){
        return;
    }else{
      
      var liList = s.parentNode.getElementsByTagName("li");
      if(liList.length == 1){
        return;
      }
      curText = s;
      mov = true;
      
      var S_top = parseFloat($(s).css("top"),10);
      var S_left = parseFloat($(s).css("left"),10);
      var l_top = "67%";
      if(S_top != 0){
        S_top = "34%";
        l_top = "0";
      }
    
      for(i=0;i<liList.length;i++){
        var l = liList.item(i);
        if(l.className==s.className){
          $(l).animate({top:S_top,left:"5px",width:"98%",height:"65%"});
        }else if(parseFloat($(l).css("width"),10)>Swidth*0.3&S_left>5){
          $(l).animate({left:"50%",top:l_top,width:"48%",height:"32%"});
        }else{
          $(l).animate({top:l_top,width:"48%",height:"32%"});
        }
      }
      
      setTimeout(function(){mov = false;}, 500);
    }
}
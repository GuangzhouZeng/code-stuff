$(document).ready(function(){
  var move = true;
	var road = document.getElementById("road");
  var length = road.getTotalLength();

  // The start position of the drawing
  road.style.strokeDasharray = length;

  // Hide the triangle by offsetting dash. Remove this line to show the triangle before scroll draw
  road.style.strokeDashoffset = length;

  // Find scroll percentage on scroll (using cross-browser properties), and offset dash same amount as percentage scrolled

  $(window).scroll(function(){
    if(move == false){
      return;
    }else{
      var x = $(document).scrollTop()- $("#how_it_works").offset().top+document.documentElement.clientHeight*0.5;
      if(x>=2200){
        x = 2200;
        move = false;
      }
      if(x>0){
        $("#moving_car").css({"top":x});
        road.style.strokeDashoffset = length - x;
      }
    }
  });
});
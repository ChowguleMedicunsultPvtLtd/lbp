$(document).ready(function(){
		
		$(".loginBox img").click(function(){
			$(".idBox").show();
		});	
		
	 	$(".userlogo").click(function(){
			$(".logoutSec").show();
		});	  
	
	
	
	
$(document).mouseup(function (e)
                    {
  var container = $(".idBox, .logoutSec"); // YOUR CONTAINER SELECTOR

  if (!container.is(e.target) // if the target of the click isn't the container...
      && container.has(e.target).length === 0) // ... nor a descendant of the container
  {
    container.hide();
  }
});	

$(function()
	{ 
			$('.col_right, .col_left, .innerMasterBox') .css({'height': (($(window).height()) - 82)+'px'});
			

			$(window).bind('resize', function(){
				
				$('.col_right, .col_left, .innerMasterBox') .css({'height': (($(window).height()) - 82)+'px'});
				
			  /*  alert('resized'); */
			});
	});	
	
	
	
});


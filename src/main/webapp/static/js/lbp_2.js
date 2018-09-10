$(document).ready(function(){

$(function()
{ 
        $('.col_right, .col_left, .innerMasterBox') .css({'height': (($(window).height()) - 0)+'px'});
		 $('.innerMasterBox') .css({'height': (($(window).height()) - 100)+'px'});
        $(window).bind('resize', function(){
			
            $('.col_right, .col_left') .css({'height': (($(window).height()) - 0)+'px'});
			 $('.innerMasterBox') .css({'height': (($(window).height()) - 100)+'px'});
          /*  alert('resized'); */
        });
});
 


});/*        $(window).bind('resize', function(){
			alert('resized')
            $('.col_right, .col_left') .css({'height': (($(window).height()) - 0)+'px'});
        }); 
 		$(.col_right, .col_left).bind('resize', function(){
            $('.innerMasterBox') .css({'height': (($(window).height()) - 0)+'px'});
           ;   alert('resized')
        });  */
		
		/* $('.col_right, .col_left') .css({'height': (($(window).height()) - 150)+'px'});  
		$('.innerMasterBox') .css({'height': (($(window).height()) - 200)+'px'}); */
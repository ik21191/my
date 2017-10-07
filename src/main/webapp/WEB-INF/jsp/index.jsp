<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${abc}</title>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,600' rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<!--pop-start -->
<script type="text/javascript" src="js/jquery-1.6.min-popup.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>       
<!--pop-end -->        
<!-- FlexSlider --> 
<script src="js/jquery.min_slider.js" type="text/javascript"></script> 
<script type="text/javascript"><!--category_menu js -->
$(document).ready(function(){
$('.drop').click(function(){
$(".box-cat").slideToggle();
});
});
</script>
<script type="text/javascript"><!--product detail write review js -->
$(document).ready(function(){
$('#writeshow').click(function(){
$("#writehide").slideToggle();
});
});
</script>
<script type="text/javascript">
    function searchSubmit()
    {
        window.location="homesearch.htm";
    }
</script>
<script type="text/javascript">
    function checkEmpty()
    {
        if(document.forms['form1']['FIRSTNAME'].value==""){
            alert('First Name should not empty'); return false;}
        if(document.forms['form1']['LASTNAME'].value==""){
            alert('Last Name should not empty'); return false;}
        if(document.forms['form1']['MOBILENO'].value==""){
            alert('Mobile should not empty'); return false;}
        if(document.forms['form1']['EMAILADDRESS'].value==""){
            alert('Email should not empty'); return false;}
        
    }
</script>
<script type="text/javascript" src="js/header_fix.js" charset="utf-8"></script><!--fix header js used in category and international page -->
<script defer="defer" src="js/jquery.flexslider.js" type="text/javascript"></script> 
<script type="text/javascript">
    $(function(){
      SyntaxHighlighter.all();
    });
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });
  </script>
           
  
<!-- FlexSlider --> 
<!--navigation_js-start (js used in inddex page)-->
<script type="text/javascript" src="js/jquery-1_nav.js"></script> 
<script type="text/javascript" src="js/nav.js"></script> 
<script type="text/javascript">$(document).ready(function(){$(".vertical-nav").verticalnav({speed: 400,align: "left"});});</script> 
<link rel="stylesheet" href="css/vert-nav.css" type="text/css" media="screen"/>
<!--navigation_js-end-->

<script src="js/respond.src.js" type="text/javascript"></script> 

<!--accordion js start (js used in checkout page ) -->
<script src="js/SpryAccordion.js" type="text/javascript"></script>
<!--accordion js end -->

<!--tab js start (js used in checkout page and product page popup)-->
<script src="js/SpryTabbedPanels.js" type="text/javascript"></script>
<!--tab js end -->

<!--date picker calender js-->
<script type="text/javascript" src="js/jsDatePick.jquery.min.1.3.js"></script>
<script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"inputField",
			dateFormat:"%d-%M-%Y"
			
		});
	};
</script>
<!--date picker calender js-->

<!--home page div call js -->
<script type="text/javascript">
function changediv(){
	if(document.getElementById("dis1").style.display=='none'){
	   document.getElementById("dis1").style.display='block';
	   document.getElementById("dis2").style.display='none';
	   document.getElementById("dis3").style.display='none';
	}
}
	function changediv1(){
	if(document.getElementById("dis2").style.display=='none'){
	   document.getElementById("dis2").style.display='block';
	   document.getElementById("dis1").style.display='none';
	   document.getElementById("dis3").style.display='none';
	}
	}
	function changediv2(){
	if(document.getElementById("dis3").style.display=='none'){
	   document.getElementById("dis3").style.display='block';
	   document.getElementById("dis1").style.display='none';
	   document.getElementById("dis2").style.display='none';
	}
	}
	
var make_button_active = function()
{
  //Get item siblings
  var siblings =($(this).siblings());
  //Remove active class on all buttons
  siblings.each(function (index)
    {
      $(this).removeClass('active');
    }
  )
  //Add the clicked button class
  $(this).addClass('active');
}
//Attach events to menu
$(document).ready(
  function()
  {
    $(".popup_select_size li").click(make_button_active);
  }  
)
</script>
<!--home page div call js -->
<!--addressbook -->
<script>
$(document).ready(function(){
  $("#book_show").click(function(){
  $("#book_show").hide(500);
  $("#book_show1").hide(500);
});
});
</script>
<!--addressbook -->
</head>
<body>
		
        
<!--header start-->

<%@include file="header1.jsp" %>
<!--header end--> 

<!--middle start-->

<div id="main_container">
<div class="outer">

<!--baner & navigation start -->
<div class="banner">
<div class="navigation">
    <h2 id="allgroups" class="nav_display1"><a href="">Shop by Category</a></h2>
    <div id="dropdownmenu" class="box">
    <div class="box-category nav_display1">
        <%@include file="homecategories.jsp" %>
    </div>
    </div>
</div>
<div class="search_banner"><form action="homesearch.htm" method="post"><input name="val1" type="text" class="inp_banner" 
value="Search by Products, Cakes and Gifts" onfocus="if(this.value==this.defaultValue)this.value='';" 
onblur="if(this.value=='')this.value=this.defaultValue;"/><input name="" type="button" class="sub_lense"/></form>
</div>
            <div class="delv-sign-cart">
  <div class="delivery_today"><a href="#"><img title="Delivery Time" alt="Delivery Time" src="images/delivery-time.png"/>
    <span class="d_today-inn">Need Delivery <span>Today!</span></span>
    </a> </div>
                
<!--Sign in start Here-->                
  
<%@include file="signin.jsp" %>

<!--Sign in End Here-->                
  
                
<!--My Cart Start-->



<!--My Cart End-->
                
    
</div>
<div class="slider_banner">
    <div id="main">
    <div class="slider">
    <div class="flexslider">
    <ul class="slides">
        <li> <a class="mban-1" href=""><img src="banners/large1.jpg" alt="banner" /></a></li>
        <li> <a class="mban-1" href=""><img src="banners/large2.jpg" alt="banner" /></a> </li>
        <li> <a class="mban-1" href=""><img src="banners/large3.jpg" alt="banner" /></a></li>
    </ul>
    </div>
    </div>
    </div>
</div>
<div class="banner-right-top-s"> 
    <a href=""><img src="banners/small1.jpg" alt="banner" /></a>
    <a href=""><img src="banners/small2.jpg" alt="banner" class="mar_img"/></a>
    <a href=""><img src="banners/small3.jpg" alt="banner" /> </a> 
</div>
<!--banner & navigation end -->


<!--Quick-search $ date start -->

<%@include file="quicksearch.jsp" %>

<!--Quick-search $ date end -->


<!--product_information-start-->
<!--Widget Start-->

<%@include file="homewidget.jsp" %>

<!--Widget end-->
<!--product_information-end-->      

<!--subscribe-newleeter & fb-join and fnp news start -->

<!--subscribe-newleeter & fb-join and fnp news end -->     
</div>
</div>
</div>
<!--middle end--> 

<!--footer start-->

    
<!--footer end-->


</body>
</html>
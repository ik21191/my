<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My Cart</title>
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
function changeQuantity(obj) 
{
    var a=0;
	a=obj.value;
	if(a>0&&a<11)
	{
		//alert(obj.id);
		//alert(obj.name);
		//alert(obj.value);
		callAjax(obj);
	}
	else
	{
		alert('wrong value');
		return false;
	}
}
</script>
<script type="text/javascript">
function callAjax(obj)
{
	var price=0.0;
	price=obj.id;
	var cartid=obj.name;
	var quantity=0;
	var price_location='price-'+cartid;
	//alert(price_location);
	quantity=obj.value;
    $.ajax({
    type: 'POST',
    url: 'ajax-call.htm',
    data: 'cartid='+cartid+'&price='+price+'&quantity='+quantity,
    success: function(response){
    document.getElementById(price_location).innerHTML=response;
    }
 });
    updateCartValue();
 }
function updateCartValue()
{
	//alert('updateCartValue');
	$.ajax({
    type: 'POST',
    url: 'ajax-call.htm?',
    data: 'cartValue=update',
    success: function(response){
    document.getElementById("cartValue").innerHTML=response;
    }
 }); 
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

<!--div js selected start (js used in product page and index quick view popup)-->
<script language="JavaScript" type="text/javascript">
/*<![CDATA[*/
var Lst;

function CngClass(obj){
 if (Lst) Lst.className='';
 obj.className='selected';
 Lst=obj;
}
/*]]>*/
</script>
<!--div js selected end -->

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


<!--header end--> 

<!--middle start-->

<div class="outer">


<!--aboutus start -->
<s:set value="${fn:length(sessionScope.cartDetails)}" var="size" />
<s:choose>
<s:when test='${size>0}'>
<form action="usertype.htm">
<div class="thanku">

<s:forEach items="${sessionScope.cartDetails}" var="p">
<div class="thanku_summry_all">
<div class="thanku_heading_row">
<div class="thanku_row">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
 <th width="16%" align="center">Product Name</th>
 <th width="9%" align="center">Qty.</th>
 <th width="22%" align="right">Unit Amount</th>
    <th width="9%" class="thanknone">Sub Total</th>
    <th width="22%" class="thanknone1">Shipping City</th>
    <th width="22%" class="thanknone1">Shipping Details</th>
    <th width="22%" class="thanknone1">Action</th>

  </tr>
  <s:forEach items="${p.parentProduct}" var="pp">
  <tr>
    <td align="center" valign="top">
    <div class="thanku_row_inn">
      <img src="${pp.productSmallImage}" alt="flower" />
      
      <p>${pp.productName}</p>
      </div>
      </td>
    <td align="center" valign="top"><div class="than_qty_amt"><input id="${pp.productUnitPrice}" type="text" name="${pp.cartid}" value="${pp.productQty}" onchange="return changeQuantity(this);"/></div></td>
    <td align="center" valign="top"><div class="than_qty_amt">Rs <fmt:formatNumber value="${pp.productUnitPrice}" minFractionDigits="0"/></div></td>
      
      
    
    <td valign="top" class="thanknone">
<div id="price-${pp.cartid}"><fmt:formatNumber value="${pp.productSubTotal}" minFractionDigits="0"/></div>
</td>
    <td valign="top" class="thanknone1">
    <strong>${pp.SHIP_RECIPIENT}</strong><br />
<strong>${pp.SHIPP_MOBILE}</strong><br />
${pp.SHIPP_ADDRESS} <br />
					
<strong>City:</strong>    ${pp.cityName}<br />
    </td>
    <td valign="top" class="thanknone1">
    <strong>Date of Delivery</strong><br />
${pp.deliverydate}<br />
<br />

<strong>Time of Delivery</strong><br />
15:00 Hrs -16:00 Hrs<br />
<br />

<strong>Shipping Mode</strong><br />
${pp.shippingTitle}[${pp.shippingWp}] <br />

    </td>
    <td valign="top" class="thanknone1">
    <a href="remove-item.htm?product=${p.subOrderId}">X [Remove]</a>

    </td>
    
  </tr>
  </s:forEach>
</table>
</div>
</div>
</div>


<div class="thanku_summry_all">
<div class="thanku_heading_row">
<div class="thanku_row">
<s:set value="${fn:length(p.addonList)}" var="adSize" />
<s:choose>
<s:when test='${adSize>0}'>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
 <s:forEach items="${p.addonList}" var="ad">
 
  
  <tr>
    <td width="16%" align="center" valign="top">
    <div class="thanku_row_inn">
      <img src="${ad.productSmallImage}" alt="flower" />
      
      <p>${ad.productName}</p>
      </div>
      </td>
    <td width="9%" align="center" valign="top"><div class="than_qty_amt"><input id="${ad.productUnitPrice}" type="text" name="${ad.cartid}" value="${ad.productQty}" onchange="return changeQuantity(this);"/></div></td>
    <td width="22%" align="right" valign="top"><div class="than_qty_amt">Rs <fmt:formatNumber value="${ad.productUnitPrice}" minFractionDigits="0"/></div></td>
      
      
    
    <td width="9%" valign="top" class="thanknone">
 
<div id="price-${ad.cartid}"><fmt:formatNumber value="${ad.productSubTotal}" minFractionDigits="0"/></div>
</td>
    <td width="22%" valign="top" class="thanknone1">
    
    </td>
    <td width="22%" valign="top" class="thanknone1">
    
    </td>
    <td width="22%" valign="top" class="thanknone1">
    <a href="remove-item.htm?addon=${ad.cartid}">X [Remove]</a>
    </td>
    
  </tr>
  </s:forEach>
</table>
</s:when>
</s:choose>


</div>
</div>
</div>


</s:forEach>



</div>
<input type="submit" value="proceed to checkout"/>
</form>
</s:when>
<s:otherwise>
No item in your shopping cart, <a href="index.htm">Please click here for shopping</a>
</s:otherwise>
</s:choose>

<!--aboutus end -->

</div>

<!--middle end--> 

<!--footer start-->
<div id="footer_main">
<div class="outer">
<div class="footer">
</div>
</div>
</div>

<div id="footer_main2">
<div class="outer">
<div class="footer">

</div>
</div>
</div>
<!--footer end-->

</body>
</html>

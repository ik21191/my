<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Raleway:400,600' rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>


<!--pop-start -->
<script type="text/javascript" src="js/jquery-1.6.min-popup.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>       
<!--pop-end -->        

<!-- FlexSlider --> 
<script src="js/jquery.min_slider.js" type="text/javascript"></script> 
<script type="text/javascript">
    function getProductAmount(qty)
    {
        var a1=0;
        a1=document.getElementById("pp").value;var total=0;
        total=a1*qty.value;
        document.getElementById("productPrice").innerHTML=total;
    }
</script>
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
<script type="text/javascript">
	function addAmount()
        {
            var a1=0;var a2=0;
            a1=document.getElementById("pp").value;
            a2=document.getElementsByName("ap");
            var sum=0;
            var j=0;
            for(var i=0;i<a2.length;i++)
            {
                
                j=document.getElementsByName("ap")[i].value;
                sum=(+sum)+(+j);
            }
            var a3=0;
            a3=(+a1)+(+sum);
            document.getElementById("subTotal").innerHTML=a3;
            
        }
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
    <body onload="addAmount()">

<!--header start-->



<!--header end--> 

<!--middle start-->

<div id="main_container">
<div class="outer">


<!--bred_crum start -->
<!--aboutus start -->
<div class="thanku">
<div class="thanku_summry_all">
<form action="checkout.htm" method="post">
<div class="thanku_heading_row">
<div class="thanku_row">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
 <th width="16%" align="center">Product Name</th>
 <th width="9%" align="center">Qty.</th>
 <th width="9%" align="right">Amount</th>
    <th width="22%" class="thanknone">Delivery Location</th>
    <th width="22%" class="thanknone1">Delivery Detail</th>

  </tr>
  <tr>
    <td align="center" valign="top">
        <c:forEach items="${sessionScope.cartDetails}" var="p">
        <c:forEach items="${p.parentProduct}" var="pp">
            <input type="hidden" name="productid" value="${pp.productId}"/>
        <div class="thanku_row_inn">
            <img src="${pp.productSmallImage}" alt="flower" />
            <p>${pp.productName}</p>
        </div>
        </c:forEach>
        </c:forEach>
        <c:forEach items="${sessionScope.cartDetails}" var="ad">
        <c:forEach items="${ad.addonList}" var="add">
        <input type="hidden" name="addonsid" value="${add.productId}"/>
        <div class="thanku_row_inn">
            <img src='${add.productSmallImage}' alt="flower" />
            <p>${add.productName}</p>
        </div>
        </c:forEach>
        </c:forEach>
    </td>
    <td align="center" valign="top">
    <c:forEach items="${sessionScope.cartDetails}" var="p">
    <c:forEach items="${p.parentProduct}" var="pp">
    <div class="than_qty_amt">
    <select id="productQty" name="productqty" onchange="getProductAmount(this)">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                    </select>
    </div>
    </c:forEach>
    </c:forEach>
    <c:forEach items="${sessionScope.cartDetails}" var="ad">
    <c:forEach items="${ad.addonList}" var="add">
    <div class="than_qty_amt">
    <select id="addonQty" name="adonsqty">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                    </select>
    </div> </c:forEach>   </c:forEach>
    
    </td>
    <td align="right" valign="top">
    <c:forEach items="${sessionScope.cartDetails}" var="p">
    <c:forEach items="${p.parentProduct}" var="pp">
        <div id="productPrice" class="than_qty_amt">
        <input id="pp" type="hidden" value="${pp.productUnitPrice}"/>${pp.productUnitPrice}</div>
        </c:forEach>
    </c:forEach>
    <c:forEach items="${sessionScope.cartDetails}" var="ad">
    <c:forEach items="${ad.addonList}" var="add">
    <div id="addonPrice" class="than_qty_amt">
    <input name="ap" type="hidden" value="${ad.productUnitPrice}"/>${ad.productUnitPrice}</div>
    </c:forEach> 
    </c:forEach>   
    </td>
    <td valign="top" class="thanknone1">
        <strong><c:forEach items="${sessionScope.cityrelation}" var="city">${city.cityName}</c:forEach></strong><br />
    </td>
    <td valign="top" class="thanknone1">
    <strong>Date of Delivery</strong><br />
${deliverydate}<br />
<br />

<strong>Time of Delivery</strong><br />
15:00 Hrs -16:00 Hrs<br />
<br />

<strong>Shipping Mode</strong><br />
${shipping} <br />

    </td>
    
       </tr></form>
</table>
<div class="thank_bottom">
<div class="thank_subtotal">
<span class="stotal">Rs.</span> <span id="subTotal" class="rupp_padding">0</span></div>
<div class="thank_subtotal">
<span class="rupp_padding"><input type="submit" value="Proceed To checkout"/></span> </div>
</div>
</div></form>
</div>
</div>
</div>

<!--aboutus end -->
     
</div>
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

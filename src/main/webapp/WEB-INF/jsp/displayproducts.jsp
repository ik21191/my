<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>fnp</title>
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
<div id="ribbonWrapper">
  <div class="outer">
    <div class="ribbon">
      <div class="currenty_selection">
        <select name="" class="inp_currency">
          <option selected="selected" value="">INR</option>
          <option value="">USD - $</option>
        </select>
      </div>
      <div class="customer_support"> <a href="#">CUSTOMER SUPPORT</a> </div>
      <div class="track_order"> <a href="#">TRACK YOUR ORDER</a> </div>
    </div>
  </div>
</div>
<div id="main_header">
  <div class="outer">
    <div class="header">
   <div class="logo">
     <h1><a href="index.html"><img src="images/logo.png" alt="logo" border="0" /></a></h1></div>
         <div class="call_us">
            <p><a class="nubmer" href="tel:+91 92124 22000"><img class="flot-left" alt="" src="images/phone.png"/>NEED HELP, CALL US<br/>
              <span><strong>+91 92124 22000</strong></span></a></p>
          </div>
    </div>
  </div>
</div>

<!--header end--> 

<!--middle start-->

<div id="main_container">
<div class="outer">

<div class="banner_navigation border_bottom">
<!--navigation start-->
        <div class="navigation1">
            <h2 ><a href="#" class="drop">Shop by Category</a></h2>
            <div class="box-cat">
                      <div class="cate_box-category">
                          <ul >
 <li><a href="#">Father's Day - 16th june</a></li>
 <li><a href="#">Birthday</a></li>
 <li><a href="#">Anniversary</a></li>
 <li><a href="#" class="even">Flowers &amp; Best Sellers</a></li>
<li><a href="#">Cakes</a></li>
<li><a href="">Gifts</a></li>
<li><a href="#" >Gifting Occasions</a>
   <ul class="u-wit">
          <li>
          <ul>
<li><a href="#">Rakhi with Flowers</a></li>
<li><a href="#">Rakhi with Chocolates Combos</a></li>
<li><a href="#">Rakhi with Sweets Combos</a></li>
               </ul>
                  </li>
                 <li>
                 <ul>
<li><a href="#">Rakhi with Dryfruits Combos</a></li>
<li><a href="#">Rakhi with Fresh Fruit Combos </a></li>
<li><a href="#">Rakhi with Cake Combos</a></li>
                 </ul>
                 </li>
                      </ul>
                    </li>
<li><a href="#">Outside India</a>
         <ul class="u-wit-1">
                        <li>
                                  <ul>
<li><a href="#">Rakhi to USA </a></li>
<li><a href="#">Rakhi to UK </a></li>
<li><a href="#">Rakhi to Canada </a></li>
<li><a href="#">Rakhi to Australia</a></li>
                          </ul>
                                </li>
                        <li>

                           <ul>
<li><a href="#">Rakhi to Singapore</a></li>
<li><a href="#">Rakhi to Germany</a></li>
<li><a href="#">Rakhi to UAE </a></li>
<li><a href="#">Rakhi Worldwide</a></li>
                   </ul>
              </li>
                 </ul>
                                        </li>
                    
<li><a href="#">City Specials</a>
       <ul class="u-wit-1">
                        <li>
                                  <ul>
<li><a href="#">Fashion Accessories</a></li>
<li><a href="#">Cosmetic Hampers</a></li>
<li><a href="#">Green Gifts</a></li>
<li><a href="#">Gourmet Gift Baskets</a></li>
                          </ul>
                                </li>
                        <li>

                           <ul>
<li><a href="#">Fragrance</a></li>
<li><a href="#">Personalized Gifts</a></li>
<li><a href="#">Home Décor</a></li>
                 </ul>
                                </li>
                                
                      </ul>
                            </li>
<li><a href="#">Special Offers</a>
   <ul class="u-wit-3">
                        <li>
                                  <ul>
<li><a href="#">Men's Accessories </a></li>
<li><a href="#">Cosmetic &amp; Perfume Hampers</a></li>
<li><a href="#">Green Gifts</a></li>
<li><a href="#">Gourmet Gift Baskets</a></li>

                          </ul>
                                </li>
                        <li>

                           <ul>
<li><a href="#">Fragrance</a></li>
<li><a href="#">Personalized Gifts</a></li>
<li><a href="#">Home Décor</a></li>
                          </ul>
                                </li>                      </ul>
                            </li>
<li><a href="#">Corporate Gifts</a></li>
                  </ul>
                        </div>
                        
                    </div> 
      
          </div>
<!--navigation end-->   

<!--search-delivery-signin-mycart part start-->
    
            <div class="search_banner"><input name="" type="text" class="inp_banner" value="Search by typing the product name that you are looking for"/><input name="" type="button" class="sub_lense" /></div>
            <div class="delv-sign-cart">
  <div class="delivery_today"><a href="#"><img title="Delivery Time" alt="Delivery Time" src="images/delivery-time.png"/>
    <span class="d_today-inn">Need Delivery <span>Today!</span></span>
    </a> </div>
  <div class="signin"><a  onclick="document.getElementById('light2').style.display='block';document.getElementById('bg_black').style.display='block'" href="javascript:void(0)"><img class="delv-disblock" title="Sign In" alt="Sign In" src="images/sign-in.png"/>
    <span class="signin_inn">Hi, Sign In <br/>
      <span>Your Account</span></span>
    </a> 
                <div id="light2" class="pop_up_sixty_percent">
<div class="popup_login_main">
<div class="popup_login">
<div class="fac_google_login">
<a href="#">  <img src="images/facebook_popup.jpg" alt="google" /></a>
<a href="#">  <img src="images/google_popup.jpg" alt="google" /></a>

  </div>
<div class="popup_or"><img src="images/or_popup.jpg"  alt="or" /></div>
<div class="popup_login_form">
<h3>Already a member?</h3>
<h4>You can use FNP login id and password</h4>
<div class="popup_login_form_row">
<label>Email / Login*</label>
<input name="" type="text" value="Enter user id" class="pop_login_inp" />
<label>Password</label>
<input name="" type="text" value="Enter password" class="pop_login_inp" />
</div>
<div class="popup_login_form_row">
<p>Forgot password <a href="#">Click here</a></p>
</div>
<div class="popup_login_form_row">
<input name="" type="button"  class="button_signin_popup" value="LOGIN"/>
</div>
<div class="popup_login_form_row">
<p>Don't have an account? <a href="#">Create One!</a></p>
</div>

</div>
</div>
  <a class="cross1" href = "javascript:void(0)" onclick = "document.getElementById('light2').style.display='none';document.getElementById('bg_black').style.display='none'"><img src="images/close.png" alt="close" /></a>
</div>

</div>

<div id="bg_black" class="black_overlay"></div> 
    
    
    </div>
  <div class="mycart"><a href="#"><img title="My cart" alt="My cart" src="images/mycart.png" class="flot-left"/>
    <span class="mycart_inn">My Cart</span>
    </a> </div>
</div>
<!--search-delivery-signin-mycart part end-->
      </div>

<!--filter_by start-->


<div class="caterty_filter_by">
<div id="filter" class="default">

<span>FILTER BY :</span>
<select name="" class="inp_category_price_city_date"><option>PRICE</option></select>
<select name="" class="inp_category_price_city_date"><option>CITY</option></select>
<select name="" class="inp_category_price_city_date"><option>DATE OF DELIVERY</option></select>
</div>
	</div>
<!--filter_by end -->

<!--product_information-start-->
<div class="international_product_row">
<h2>Search Result</h2>
<c:forEach items="${list}" var="p">
<div class="hpag_product_colum">
<a href="<c:out value='${p.productURL}'/>"><img alt="flower" src='<c:out value="${p.productSmallImage}"/>'/>
<span class="product_name"><c:out value="${p.productName}"/></span>
<span class="product_rate"><c:out value="${p.productPrice}"/></span>  </a>      
        </div> 
</c:forEach>
</div>

<!--product_information-end-->      

<!--subscribe-newleeter & fb-join and fnp news start -->

            <div class="newsletter_fbjoin_fnp_news">
              <div class="sub_newsletter">
                <h2>Subscribe Newsletter</h2>
                <p>Be the first to be notified for our special </p>
                <p>offers and promotions</p>
                <p>
                  <input type="text" value="Enter your email id" class="inp_newsletter" name=""/>
                  <input type="button" class="submit_newsletter" value="Sign up" name=""/>
                </p>
              </div>
              <div class="join-fb">
                
                <p><img class="flot-left im-pad" alt="image" src="images/fnp-img.png"/><strong>Ferns N Petals</strong> <br/>
                  <img class="im-padt f-li" alt="image" src="images/f-like.png"/>
                  <img alt="facebook" src="images/fb-bottom.jpg" class="fb_like_image"/> </p>
              </div>
          
            <div class="fnp_news">
                <h2>FNP News</h2>
                <p>See what's blooming at FNP. Explore </p>
                <p>our world of flowers in the media</p>
                <p><a href="#">Click Here</a></p>
              </div>
          </div>
<!--subscribe-newleeter & fb-join and fnp news end -->     
</div>
</div>
<!--middle end--> 

<!--footer start-->
<div id="footer_main">
<div class="outer">
<div class="footer">
<div class="footer_row">
        <div class="footer_colum">
                  <h4>Send<br />
            Flowers to</h4>
                  <ul>
           <li><a href="http://www.fnp.com/flowers/flowers-to-delhi/--clI_2-cI_1194-.html" title="Send Flowers to Delhi">Delhi</a></li>
<li><a href="http://www.fnp.com/flowers/gifts-to-mumbai/--clI_2-cI_1193-.html" title="Send Gifts to Mumbai">Mumbai</a></li>
<li><a href="http://www.fnp.com/flowers/flowers-to-pune/--clI_2-cI_1197-.html" title="Send Flowers to Pune">Pune</a></li>
<li><a href="http://www.fnp.com/flowers/flowers-to-hyderabad/--clI_2-cI_1198-.html" title="Send Flowers to Hyderabad">Hyderabad</a></li>
<li><a href="http://www.fnp.com/flowers/flowers-to-bangalore/--clI_2-cI_1199-.html" title="Send Flowers to Bangalore">Bangalore</a></li>
<li><a href="http://www.fnp.com/flowers/gifts-to-chennai/--clI_2-cI_1200-.html" title="Send Flowers to Chennai">Chennai</a></li>
<li><a href="http://www.fnp.com/flowers/flowers-to-ahmedabad/--clI_2-cI_1205-.html" title="Send Flowers to Ahemdabad">Ahmedabad</a></li>
<li><a href="http://www.fnp.com/flowers/Cochin/--clI_2-cI_1334-.html" title="Send Flowers to Cochin India">Cochin</a></li>
<li><a href="http://www.fnp.com/flowers/flowers-to-chandigarh/--clI_2-cI_1204-.html" title="Send Flowers online to Chandigarh">Chandigarh</a></li>
<li><a href="http://www.fnp.com/flowers/flowers-to-gurgaon/--clI_2-cI_1202-.html" title="Send Flowers to Gurgaon India">Gurgaon</a></li>
<li><a href="http://www.fnp.com/flowers/send-flowers-to-noida/--clI_2-cI_1196.html" title="Send Flowers to Noida">Noida</a></li>
<li><a href="http://www.fnp.com/flowers/faces/jsp/serviceablecities.jsp" title="send flowers anywhere in India">View all Cities &gt;&gt;</a></li>

          </ul>
                </div>
        <div class="footer_colum footer_display1">
                  <h4>Shop by<br />
            Product</h4>
                  <ul>
            <li><a href="http://www.fnp.com/flowers/best-sellers/--clI_2-cI_1001-.html" title="Best Gifts and Fresh Flowers">Best Sellers</a></li> <li><a href="http://www.fnp.com/flowers/roses/--clI_2-cI_1343-.html" title="Send Roses to India">Roses</a></li> <li><a href="http://www.fnp.com/flowers/best-sellers/cake---chocolate/--clI_2-cI_1019-pCI_1001-.html" title="Birthday Cakes">Cakes</a></li> <li><a href="http://www.fnp.com/plant/" title="Plants Gifts to India">Plants</a></li> <li><a href="http://www.fnp.com/chocolate/" title="buy chocolate online ">Chocolates</a></li> <li><a href="http://www.fnp.com/flowers/sweets---meethai/--clI_2-cI_1013-.html" title="buy sweets online">Sweets</a></li> <li><a href="http://www.fnp.com/flowers/Best-Sellers/Dryfruits---Mewa/--clI_2-cI_1012-pCI_1001-.html" title="Dry Fruits and Mewa">DryFruits</a></li> <li><a href="http://www.fnp.com/flowers/Gift-Center/Soft-Toys/--clI_2-cI_1167-pCI_1007-.html" title="Soft Toys &amp; Teddy Bears">Soft Toys </a></li> <li><a href="http://www.fnp.com/flowers/Personalised-Photo-Gifts/--clI_2-cI_1663-.html" title="Personalised Photo Gifts">Photo Gifts</a></li> <li><a href="http://www.fnp.com/flowers/best-sellers/flower-bunches/--clI_2-cI_1020-pCI_1001-.html" title="Flower Bouquets">Flower Bouquets</a></li> <li><a href="http://www.fnp.com/flowers/Artificial-flowers/--clI_2-cI_1661-.html" title="Artificial Flowers">Artificial Flowers</a></li> <li><a href="http://www.fnp.com/flowers/Gourmet-Gifts/--clI_2-cI_1446-.html" title="Gourmet Gifts">Gourmet Gifts</a></li>
          </ul>
                </div>
        <div class="footer_colum footer_display2">
                  <h4>Flowers and Gifts<br />
            by Occasion</h4>
                  <ul>
           <li><a href="http://www.fnp.com/flowers/occasion/anniversaries/--clI_2-cI_1022-pCI_1004-.html" title="Anniversary Flowers and Gifts">Anniversary</a></li> <li><a href="http://www.fnp.com/flowers/occasion/birthday/--clI_2-cI_1023-pCI_1004.html" title="Send Birthday Flowers and Gifts to India">Birthday</a></li> <li><a href="http://www.fnp.com/flowers/occasion/congratulations/--clI_2-cI_1025-pCI_1004-.html" title="Congratulation Flowers">Congratulations</a></li> <li><a href="http://www.fnp.com/flowers/occasion/get-well-soon/--clI_2-cI_1026-pCI_1004-.html" title="Get Well Soon Flowers">Get Well</a></li> <li><a href="http://www.fnp.com/flowers/sentiments/i-am-sorry/--clI_2-cI_1036-pCI_1005-.html" title="I'm Sorry Flowers">I'm Sorry</a></li> <li><a href="http://www.fnp.com/flowers/best-sellers/flower-combo/--clI_2-cI_1123-pCI_1001-.html" title="Just Because Flower Combo">Just Because</a></li> <li><a href="http://www.fnp.com/flowers/occasion/love/--clI_2-cI_1028-pCI_1004-.html" title="Love and Romance Flowers Gift">Love &amp; Romance</a></li> <li><a href="http://www.fnp.com/flowers/occasion/new-born/--clI_2-cI_1029-pCI_1004-.html" title="New Baby Flowers and Gifts">New Baby</a></li> <li><a href="http://www.fnp.com/flowers/occasion/condolences/--clI_2-cI_1024-pCI_1004-.html" title="Sympathy/Funeral flowers and gifts">Sympathy &amp; Funeral</a></li> <li><a href="http://www.fnp.com/flowers/thank-you/--clI_208-cI_1545-.html" title="Thank You Flowers">Thank You</a></li> <li><a href="http://www.fnp.com/flowers/occasion/wedding/--clI_2-cI_1031-pCI_1004-.html" title="Wedding Flowers and Gifts">Wedding</a></li> <li><a href="http://www.fnp.com/flowers/occasion/house-warming/--clI_2-cI_1027-pCI_1004-.html" title="House Warming Flowers">House Warming</a></li>
          </ul>
                </div>
        <div class="footer_colum footer_display3">
                  <h4>Flower Type</h4>
                  <ul>
           <li><a href="http://www.fnp.com/flowers/roses/--clI_2-cI_1343-.html" title="Send Roses India">Roses</a></li> <li><a href="http://www.fnp.com/flowers/tulips/--clI_2-cI_1666-.html" title="Tulips Flowers">Tulips</a></li> <li><a href="http://www.fnp.com/flowers/lilies/--clI_2-cI_1667-.html" title="Buy Lilies Online">Lilies</a></li> <li><a href="http://www.fnp.com/flowers/orchids/--clI_2-cI_1668-.html" title="Blue Orchids Flowers Online">Orchids</a></li> <li><a href="http://www.fnp.com/flowers/Daisies/--clI_2-cI_1669-.html" title="Daisies Flowers">Daisies</a></li> <li><a href="http://www.fnp.com/flowers/hydrangeas/--clI_2-cI_1670-.html" title="Hydrangeas Flowers">Hydrangeas</a></li> <li><a href="http://www.fnp.com/flowers/sunflowers/--clI_2-cI_1671-.html" title="Sunflowers">Sunflowers</a></li> <li><a href="http://www.fnp.com/flowers/tropical-flowers/--clI_2-cI_1672-.html" title="Tropical Flowers">Tropical Flowers</a></li> <li><a href="http://www.fnp.com/flowers/carnations/--clI_2-cI_1673-.html" title="Carnations Flowers">Carnations</a></li> <li><a href="http://www.fnp.com/flowers/gerberas/--clI_2-cI_1674-.html" title="Gerberas Flowers">Gerberas</a></li> <li><a href="http://www.fnp.com/flowers/mixed-flowers/--clI_2-cI_1675-.html" title="Mixed Flowers">Mixed Flowers</a></li> <li><a href="http://www.fnp.com/flowers/designer-packing-bouquet/--clI_2-cI_1512-.html" title="Designer Bouquets">Designer Bouquets</a></li>
          </ul>
                </div>
        <div class="footer_colum footer_display4">
                  <h4>Gifts</h4>
                  <ul>
           <li><a href="http://www.fnp.com/gift-for-him/" title="Gifts For Him">Gifts For Him</a></li> <li><a href="http://www.fnp.com/gift-for-her/" title="Gifts For Her">Gifts For Her </a></li><li><a href="http://www.fnp.com/gift-for-kids/" title="Gifts For Kids">Gifts For Kids</a></li> <li><a href="http://www.fnp.com/flowers/Personalised-Photo-Gifts/--clI_2-cI_1715-.html" title="Personalized Gifts">Personalized Gifts </a></li><li><a href="http://www.fnp.com/flowers/Divinity/--clI_2-cI_1225-.html" title="Divinity Gifts">Divinity Gifts</a></li> <li><a href="http://www.fnp.com/flowers/occasion/wedding/--clI_2-cI_1031-pCI_1004-.html" title="Wedding Gifts">Wedding Gifts </a></li><li><a href="http://www.fnp.com/flowers/occasion/anniversaries/--clI_2-cI_1022-pCI_1004-.html" title="Anniversary Gifts">Anniversary Gifts </a></li><li><a href="http://www.fnp.com/flowers/occasion/birthday/--clI_2-cI_1023-pCI_1004.html" title="Birthday Gifts">Birthday Gifts</a></li> <li><a href="http://www.fnp.com/flowers/Home-Decor/--clI_2-cI_1656-.html" title="home decor gifts">Home Décor Gifts</a></li> <li><a href="http://www.fnp.com/valentine/" title="Valentine Gifts">Valentine Gifts</a></li> <li><a href="http://corporate.fnp.com" target="_blank">Corporate Gifts</a></li> <li><a href="http://www.fnp.com/gifts/" title="Gift Ideas">More Gifts &gt;&gt;</a></li>
          </ul>
                </div>
        <div class="footer_colum footer_display5">
                  <h4>International Delivery</h4>
                  <ul>
           <li><a href="http://www.fnp.com/international/us.html" title="send flowers to us">United States</a></li> <li><a href="http://www.fnp.com/international/uk.html" title="send flowers to uk">United Kingdom</a></li> <li><a href="http://www.fnp.com/international/canada.html" title="send flowers to canada">Canada</a></li> <li><a href="http://www.fnp.com/international/australia.html" title="send flowers to australia">Australia</a></li> <li><a href="http://www.fnp.com/international/uae.html" title="send flowers to uae/dubai">UAE</a></li> <li><a href="http://www.fnp.com/international/germany.html" title="send flowers to germany">Germany</a></li> <li><a href="http://www.fnp.com/flowers/philippines/--clI_4-cI_1106-.html" title="send flowers to Philippines">Philippines</a></li> <li><a href="http://www.fnp.com/international/singapore.html" title="send flowers to Singapore">Singapore</a></li> <li><a href="http://www.fnp.com/flowers/China/--clI_4-cI_1313-.html" title="send flowers to China">China</a></li> <li><a href="http://www.fnp.com/flowers/Indonesia/--clI_4-cI_1100-.html" title="send flowers to Indonesia">Indonesia</a></li> <li><a href="http://www.fnp.com/flowers/France/--clI_4-cI_1098-.html" title="send flowers to France">France</a></li> <li><a href="http://www.fnp.com/international/" title="send flowers to international">View More Countries &gt;&gt;</a></li>
          </ul>
                </div>
        <div class="footer_colum footer_display6">
                  <h4>Holiday &amp; <br />
            Seasons</h4>
                  <ul>
           <li><a href="http://www.fnp.com/flowers/parents-day-courier/--clI_2-cI_1234.html" title="Parents Day Gifts">Parents Day Gifts</a></li>

<li><a href="http://www.fnp.com/flowers/parent-day-express/--clI_2-cI_1233-.html" title="Parents Day Flowers">Parents Day Flowers</a></li>

<li><a href="http://www.fnp.com/friendship-day/" title="Friendship Day Gifts">Friendship Day Gifts</a></li>

<li><a href="http://www.fnp.com/friendship-day/" title="Friendship Day Flowers">Friendship Day Flowers</a></li>

<li><a href="http://www.fnp.com/flowers/friendship-gifts/--clI_2-cI_1121-.html" title="Friendship Day Gift Ideas">Friendship Day Gift Ideas</a></li>

<li><a href="http://www.fnp.com/friendship-day/" title="Gift Ideas For Friends">Gift Ideas For Friends</a></li>

<li><a href="http://www.fnp.com/flowers/fathers-day-express/--clI_2-cI_1229.html" title="Send Rakhi to India">Send Rakhi to India</a></li>

<li><a href="http://www.fnp.com/rakhi/" title="Send Rakhi Gifts to India">Send Rakhi Gifts to India</a></li>

<li><a href="http://www.fnp.com/rakhi/" title="Rakhi Gifts for Sister">Rakhi Gifts for Sister</a></li> 

<li><a href="http://www.fnp.com/flowers/gifts-for-brother/rakhi-express/--clI_2-cI_1232-pCI_1243-.html" title="Rakhi Gifts for Brother">Rakhi Gifts for Brother</a></li>

<li><a href="http://www.fnp.com/flowers/rakhi-%C2%A0with-flower/--clI_9-cI_1519-.html" title="Rakhi with Flowers ">Rakhi with Flowers</a></li>

<li><a href="http://www.fnp.com/flowers/rakhi-sweet-hamper/--clI_9-cI_1514-.html" title="Rakhi with Sweets">Rakhi with Sweets</a></li>

<li><a href="http://www.fnp.com/flowers/rakhi-chocolate-hamper/--clI_9-cI_1516-.html" title="Rakhi with Chocolates">Rakhi with Chocolates</a></li>


          </ul>
                </div>
      </div>
</div>
</div>
</div>

<div id="footer_main2">
<div class="outer">
<div class="footer">
<div class="footer-row1">

         <p class="right_reserved_display">&copy; 2011 fnp.com. All rights reserved</p>
          <p>Send Flowers to India, Send Gifts to India &amp; Send Cakes to India for all Occasions</p>
          <p>Ferns N Petals (FNP) was established in the year 1994 with a sole aim to provide fresh flowers and render exceptional flower arrangement services. FNP, with 141 stores in India, delivers flowers, gifts and cakes in 150 countries. It is the only Indian brand that stands parallel to international flowers brands in terms of quality as well as designs. Whether it is official functions, weddings, receptions, anniversaries or birthday parties, FNP can fulfill all types of flower and gifts requirements to make your special day even more special. Having physical as well as online presence, it makes sending flowers to India or abroad convenient and hassle-free. Understanding the importance of timely delivery, FNP keeps on strengthening its distribution system to send flowers to India or outside within the time.</p>
          <p>Having 19 years of experience in flower delivery and decorations, Ferns N Petals is considered an imperative part of every celebration. Being a one-stop solution for each of your floral needs, it strives to make available even the rarest of the rare flowers. No matter where you reside, FNP puts in sincere efforts to deliver flowers timely to your loved ones. FNP, a leading florist in India, gives you a choice to buy fresh or artificial flowers, in addition to a range of exotic chocolates, cakes and sweets. Our wide distribution network and strong physical &amp; online presence make us the best option to send gifts to India and across the globe.</p>
          <p>Ferns N Petals provides online flower delivery service all over India &amp; world. If you are looking for fresh flower delivery service in India, or you want to send flowers to Delhi, Mumbai, Bangalore, Hyderabad and any other part of India with same day delivery, then Ferns N Petals is your ideal destination. We send cakes to India for all occasions including birthdays, anniversaries, New Year, Valentine's Day, Mother's Day and Father's Day. With our help, you can also send flowers to India from USA, UK, Australia, Canada and various other parts of the world with same day delivery.</p>
          <p>Ferns N Petals, one the famous names in florist industry, offers you fresh flowers and gifts for all occasions. If you are planning to send birthday flowers, anniversary flowers, mother's day flowers and father's day flowers with same day delivery in Delhi, Mumbai, Bangalore, Pune, Noida, Faridabad, Gurgaon and any other place in India, visit Fnp.com and choose the type of flowers you want to send. We deliver flowers and gifts on the date and time mentioned by you. We also provide services for midnight, fix time, next day and same day delivery of flowers, gifts and cakes for all occasions. </p>

        
      </div>
</div>
</div>
</div>
<!--footer end-->

</body>
</html>

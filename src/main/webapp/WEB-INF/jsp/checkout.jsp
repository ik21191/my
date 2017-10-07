<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Raleway:400,600' rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.min-popup.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<!--pop-end -->

<!-- FlexSlider -->
<script src="js/jquery.min_slider.js" type="text/javascript"></script>
<script type="text/javascript">
function phonenumber(val)  
{  
  var phoneno = /^\d{10}$/;  
  if((val.value.match(phoneno)))  
  {
    return true;  
  }  
  else
      {alert("10 Digit Mobile Number Required.")
          return false;
      }
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
<link href="SpryAssets/SpryAccordion.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!--header start-->
<!--middle start--> 
<div id="main_header">
  
  <!--header end--> 
  
  <!--middle start-->
  
  <div id="main_container">
    <div class="outer"> 
      <div class="banner_navigation border_bottom">
<!--navigation start-->
        
<!--navigation end-->   

<!--search-delivery-signin-mycart part start-->
    
            <div class="search_banner"><input name="" type="text" class="inp_banner" value="Search by typing the product name that you are looking for"/><input name="" type="button" class="sub_lense" /></div>
            <div class="delv-sign-cart">
    <!--Sign in start-->
  
  <%@include file="signin.jsp" %>
  
  <!--Sign in end-->
  </div>
<!--search-delivery-signin-mycart part end-->
      </div>
      <!-- checkout-start -->
      <div class="checkout_main">
          
        <!--Checking Session Start-->
        
        <div id="Accordion1" class="Accordion" tabindex="0">
        
          <div class="AccordionPanel">
              
            <div class="AccordionPanelTab"><span>1</span> Login <img src="images/tickmart-checkout.png" alt="tickmart" class="flot-right mar-tick" /></div>
            <div class="AccordionPanelContent">
                <c:if test="${sessionScope.customerFirstName==null}">
                <form action="guestregister.htm" method="post">
              <!--login part start -->
              <div class="login_main">
                <!--Check out Login Section Start-->
                  <div class="login_email_add">
                  <div class="login_enter_email">
                    <label>Enter your email address<span>*</span></label>
                    <input type="text" name="email" class="inp_log" />
                  </div>
                  <div class="login-filed1">
                    <input type="radio" class="flot-left login_rad"/>
                    <p>Continue without password <span class="no_password">No password or registration required)</span> </p>
                  </div>
                  <div class="login-filed1">
                    <input type="radio" class="flot-left login_rad"/>
                    <p>I have an account and password <span class="no_password">(Sign in to your account for a faster checkout)</span> </p>
                  </div>
             <div class="login-filed2">
                 <label>Enter City</label><input name="cityName" type="text" class="inp_login3"/>
                 <a href="#" class="flot-right">Forgot your password?</a>
             </div>
                  
                  <input type="submit" class="button_ont" value="Next Level" />
                </div>
                <!--Check out Login Section End-->
                <div class="log_or"> <img src="images/checkout_or.png"  alt="or" /></div>
                <div class="login_fb_google">
                  <h3>Sign in with </h3>
                  <a href="#"><img src="images/check_log_fb.jpg" alt="fb"/></a> <a href="#"><img src="images/check_log_google.jpg" alt="google"/></a> </div>
                <div class="login_ordersummry_main">
                  <div class="login_ordersummry">
                    <h3>Order Summary</h3>
                    <div class="login_ordersummry_row">
                      <div class="login_ordersummry_colum"><strong>Product Name</strong></div>
                      <div class="login_ordersummry_colum1"><strong>Qnty</strong></div>
                      <div class="login_ordersummry_colum2"><strong>Amount</strong></div>
                    </div>
                    <c:forEach items="${sessionScope.cartDetails.parentProduct}" var="p">
                    <div class="login_ordersummry_row">
                      <div class="login_ordersummry_colum">${p.productName}</div>
                      <div class="login_ordersummry_colum1">1</div>
                      <div class="login_ordersummry_colum2">${p.productUnitPrice}</div>
                    </div>
                    </c:forEach>
                    <c:forEach items="${sessionScope.cartDetails.addonList}" var="ad">
                    <div class="login_ordersummry_row">
                      <div class="login_ordersummry_colum">${ad.productName}</div>
                      <div class="login_ordersummry_colum1">1</div>
                      <div class="login_ordersummry_colum2">${ad.addonUnitPrice}</div>
                    </div>
                    </c:forEach>
                    <div class="login_ordersummry_row border_top_bottom">
                      <div class="login_ordersummry_colum color_black"><strong>Sub Total</strong></div>
                      <div class="login_ordersummry_colum1 color_black"></div>
                      <div class="login_ordersummry_colum2 color_black"><strong>399</strong></div>
                    </div>
                    <div class="login_ordersummry_row">
                      <div class="login_ordersummry_colum color_green"><strong>Total Value</strong></div>
                      <div class="login_ordersummry_colum1 color_green"><strong></strong></div>
                      <div class="login_ordersummry_colum2 color_green"><strong>399</strong></div>
                    </div>
                  </div>
                </div>
              </div>
          </form></c:if>
              <!--login part end --> 
            </div>
            
          </div>
          
        
          <!--Checking Session Start-->   
          <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            <span>2</span> Shipping Details <img src="images/tickmart-checkout.png" alt="tickmart" class="flot-right mar-tick" />
            </div>
            <div class="AccordionPanelContent">
              <!--shipping details start -->
              <form action="purchase.htm" method="post">
              <div class="order_summ_main">
                <div class="order_summ_main_top">
                  <div class="order_product_qyt_amout">
                    <div class="pro_qyt_amout_row">
                      <div class="order_product_det_main">
                        <div class="order_det_product_det_colum">PRODUCT DETAILS</div>
                        <c:forEach items="${sessionScope.cartDetails.parentProduct}" var="p">
                        <div class="shipping_det_product_det_colum1"> <img src="${p.productSmallImage}" alt="flower" class="product_flower" />
                        <p>${p.productName}</p>
                        </c:forEach>
                      </div>
                      </div>
                      <div class="order_quantity_main">
                        <div class="order_quantity_main_colum">QUANTITY</div>
                        <div class="order_quantity_main_colum1">
                          <p>1</p>
                        </div>
                      </div>
                      <div class="order_amount_main">
                        <div class="order_amount_main_colum">Amount</div>
                        <div class="order_amount_main_colum1"> 
                        <img src="images/check_out_rupee.png" alt="rupee" />
                        <c:forEach items="${sessionScope.cartDetails.parentProduct}" var="p">${p.productUnitPrice}</c:forEach></div>
                      </div>
                    </div>
                    <c:forEach items="${sessionScope.cartDetails.addonList}" var="ad">
                    <div class="pro_qyt_amout_row">
                      <div class="order_product_det_main">
                      <div class="shipping_det_product_det_colum1"> <img src="${ad.productSmallImage}" alt="flower" class="product_flower" /> 
                        <p>${ad.productName}</p>
                      </div>
                      </div>
                      <div class="order_quantity_main">
                        <div class="order_quantity_main_colum noneborder_bg">&nbsp;</div>
                        <div class="order_quantity_main_colum1">
                          <p>1</p>
                        </div>
                      </div>
                      <div class="order_amount_main">
                        <div class="order_amount_main_colum noneborder_bg">&nbsp;</div>
                        <div class="order_amount_main_colum1"> <img src="images/check_out_rupee.png" alt="rupee" />${ad.productUnitPrice}</div>
                      </div>
                    </div>
                    </c:forEach>
                       
                  </div>
                  <div class="order_delivery_main">
                    <div class="order_delivery_main_colum">DELIVERY LOCATION</div>
                    <div class="shipping_delivery_main_colum">
                    <form action="purchase.htm" method="post">
                        
                        <c:forEach items="${sessionScope.cartDetails.parentProduct}" var="p">
                        <input type="hidden" name="productId" value="${p.productId}"/>
                        <input type="hidden" name="productName" value="${p.productName}"/>
                        <input type="hidden" name="productPrice" value="${p.productUnitPrice}"/>
                        </c:forEach>
                        
                    <div class="shipping_det_delivery_main_row">
                      <label>Name:<span>*</span></label>
                      <input type="text" name="shipname" class="inp_shipping" />
                    </div>
                    <div class="shipping_det_delivery_main_row">
                      <label>PIN Code: / Area:<span>*</span></label>
                      <input type="text" name="shippincode" class="inp_shipping" />
                    </div>
                    <div class="shipping_det_delivery_main_row">
                      <label>Address:<span>*</span></label>
                      <textarea name="shipaddress" cols="" rows="" class="inp_shipping"></textarea>
                    </div>
                    <div class="shipping_det_delivery_main_row">
                      <label>Country:<span>*</span></label>
                      <input type="text" value="" name="shipcountry" class="inp_shipping1" readonly/>
                          
                          
                      
                    </div>
                    <div class="shipping_det_delivery_main_row">
                      <label>State:<span>*</span></label>
                      <input type="text" value="" name="shipstate" class="inp_shipping1" readonly/>
                          
                          
                      
                    </div>
                    <div class="shipping_det_delivery_main_row">
                      <label>City:<span>*</span></label>
                      <input type="text" value="" name="shipcity" class="inp_shipping1" readonly/>
                          
                          
                    </div>
                    <div class="shipping_det_delivery_main_row">
                      <label>Mobile No.:<span>*</span></label>
                      <input type="text" name="shipmobile" class="inp_shipping" value="Recepient's Mobile Number" maxlength="10" onchange="phonenumber(this)" />
                    </div>
                  
                    </div>

                  </div>
                  <div class="order_giftcard_main">
                    <div class="order_giftcard_main_colum"></div>
                    <div class="order_giftcard_main_row">
                      <form action="" method="post">
                    <div class="shipping_det_giftcard_main_row">
                      <input type="text" class="inp_shipping3" value="${deliverydate}" readonly/>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                        <input type="text" class="inp_shipping3" value="${shipping}" readonly/>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                      <select name="occasionName" class="inp_shipping4">
                        <option>Birthday</option>
                        <option>Anniversary</option>
                        <option>Wedding</option>
                        <option>Just Because</option>
                      </select>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                      <textarea name="" cols="" rows="5" class="inp_shipping5">Message</textarea>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                      <input type="text" class="inp_shipping5" value="Sender's Name"/>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                      <input name="" type="checkbox" value="" class="flot-left chec_mar"/>
                      <p>Cake Message: check to Enter a Message on Cake. applicable only if you have a cake in your order.</p>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                      <textarea name="" cols="" rows="5" class="inp_shipping5">Message</textarea>
                    </div>
                    <div class="shipping_det_giftcard_main_row">
                      
                    </div>
                  </form>
                    </div>
                  </div>
                </div>
 <div class="full_widht"><input type="submit" class="button_shipping" value="proceed to pay" /></div>                   
                    
                    
                
              </div>
                </form>
              <!--shipping details end --> 
            </div>
          </div>
          <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            <span>3</span> Order Summary <img src="images/tickmart-checkout.png" alt="tickmart" class="flot-right mar-tick" />
            </div>
            <div class="AccordionPanelContent">
            <div class="order_summ_main">
                <div class="order_summ_main_top">
                  <div class="order_product_qyt_amout">
                      <div class="pro_qyt_amout_row">
                      <c:forEach items="${list}" var="p">  
                    
                      <div class="order_product_det_main">
                        <div class="order_det_product_det_colum">PRODUCT DETAILS</div>
                        <div class="order_det_product_det_colum1"> <img src="${p.productSmallImage}" alt="flower" class="order_product_flower" />
                          <p>${p.productName}</p>
                        </div>
                      </div>
                      <div class="order_quantity_main">
                        <div class="order_quantity_main_colum">QUANTITY</div>
                        <div class="order_quantity_main_colum1">
                          <p>1</p>
                        </div>
                      </div>
                      <div class="order_amount_main">
                        <div class="order_amount_main_colum">Amount</div>
                        <div class="order_amount_main_colum1"> <img src="images/check_out_rupee.png" alt="rupee" />${p.productPrice}</div>
                      </div>
                    
                      </c:forEach></div>
                      <c:forEach items="${addonList}" var="ad">
                    <div class="pro_qyt_amout_row">
                      <div class="order_product_det_main">
                        <div class="order_img_add_on"> <img src="${ad.addonSmallImage}" alt="flower" class="order_product_flower" />
                          <p>${ad.addonName}</p>
                        </div>
                      </div>
                      <div class="order_quantity_main">
                        <div class="order_quantity_main_colum noneborder_bg">&nbsp;</div>
                        <div class="order_quantity_main_colum1">
                          <p>1</p>
                        </div>
                      </div>
                      <div class="order_amount_main">
                        <div class="order_amount_main_colum noneborder_bg">&nbsp;</div>
                        <div class="order_amount_main_colum1"> <img src="images/check_out_rupee.png" alt="rupee" />${ad.addonPrice}</div>
                      </div>
                    </div>
                      </c:forEach>
                
                  </div>
                  <div class="order_delivery_main">
                    <div class="order_delivery_main_colum">DELIVERY LOCATION</div>
                    <div class="order_delivery_main_row">
                      <p><strong>Amit  Maini </strong></p>
                      <p>+91-8826620621 </p>
                      <br />
<br />

                    
                     <p>k-1 vishnu Garden, 2nd Floor</p>
                      <p>Vishanu Garden,</p>
                      <p>India, Delhi, Delhi - 110018 </p>
                    </div>

                  </div>
                  <div class="order_giftcard_main">
                    <div class="order_giftcard_main_colum">GIFT CARD MESSAGE</div>
                    <div class="order_giftcard_main_row">
                      <p>Delivery Date : 11/06/2013</p>
                      <p>Occasion : Anniversary </p><br />
<br />

                   
                      <p>Lorem ipsum dolor sit amet, 
                        consectetur adipisicing elit, sed
                        do eiusmod tempor</p><br />

                   
                      <p>Sender's Name : Mukesh</p>
                    </div>
                  </div>
                </div>
                    <div class="total_row">
                      <div class="order_quantity_main_colum2">Total</div>
                      <div class="order_amount_main_colum2"> <img src="images/check_out_rupee.png" alt="rupee" /> 1150.00</div>
                    </div>
                    <div class="total_row">
                      <div class="order_quantity_main_colum2">Discount Applied</div>
                      <div class="order_amount_main_colum2">20%</div>
                    </div>
                    <div class="total_row">
                      <div class="order_quantity_main_colum2">Total</div>
                      <div class="order_amount_main_colum2"> <img src="images/check_out_rupee.png" alt="rupee" /> 1120.00</div>
                    </div>
                <div class="haveacoupon">
                  <div class="order_coupon_row">
                    <h3>Have a Coupon code to redeem ?</h3>
                    <div class="order_gift_certificate">
                      <input type="radio" class="radio-order_summry" />
                      Gift Certificate / Discount Coupon </div>
                    <div class="order_jet">
                      <input type="radio" class="radio-order_summry" />
                      Jet Privilege </div>
                    
                  </div>
                  <div class="order_apply_code">
                    <input type="text" class="inp_coupon_code" value="Enter your coupon code" />
                    <input type="button" value="Apply Code" class="button_coupon_code"/> <div class="order_go_back_pro"> 
                    <a href="#" class="order_go_back_edit">Go back to edit</a> <a href="#" class="proceed_to_pay">PROCEED TO PAY</a> </div>
                  </div>
                  
                  
                </div>
                <div class="order_summ_main_bottom">                  <div class="order_confirmation_row"> <span>The order confirmation will be sent to</span>
                    <input name="" type="text" class="inp_order1" value="+91"/>
                    <input name="" type="text" class="inp_order2" value="Enter your mobile number"/>
                  </div>
                  <div class="order_summry_terms">
                    <input type="checkbox" class="checkbox_order_summry" />
                    *I hereby acknowledge that I have read and agreed to <a href="#" class="big-link" data-reveal-id="term_condition" data-animation="fade">Terms &amp; Condition</a>/<a href="#" class="big-link " data-reveal-id="dislaimer" data-animation="fade">Disclaimer </a>mentioned</div>
                </div>
              </div>
            </div>
          </div>
          <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            <span>4</span> Payment Option <img class="flot-right mar-tick" alt="tickmart" src="images/tickmart-checkout.png">           
            </div>
            <div class="AccordionPanelContent">
            <!--payment mode start -->
          <iframe frameborder="0" src="correctfinal.html" width="100%" height="1000"></iframe>
            <!--payment mode end -->
            </div>
          </div>
        </div>
      </div>
      <!-- checkout-end--> 
      
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
            <img class="im-padt f-li" alt="image" src="images/f-like.png"/> <img alt="facebook" src="images/fb-bottom.jpg" class="fb_like_image"/> </p>
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
</div>
<!--middle end--> 

<!--footer start-->
<!--footer end-->
<script type="text/javascript">
var Accordion1 = new Spry.Widget.Accordion("Accordion1",{duration:1050,useFixedPanelHeights: false, defaultPanel: 0 });
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>
</body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
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
<title>Test Cart Example</title></head>
<body>

<form action="userauth.jsp">
<table width="100%">
<tr><th>Cart ID</th><th>Product ID</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Product Type</th><th>Shipping City</th>
<th>Shipping Mode</th><th>Delivery Date</th></tr>
<s:forEach items="${sessionScope.cartDetails}" var="p">
<s:forEach items="${p.parentProduct}" var="pp">
<tr><td>${pp.cartid}</td><td>${pp.productId}</td><td>${pp.productName}[${pp.productUnitPrice}]</td><td><div id="price-${pp.cartid}">${pp.productUnitPrice}</div></td><td><input id="${pp.productUnitPrice}" type="text" name="${pp.cartid}" value="1" onchange="return changeQuantity(this);"/></td><td>${pp.productType}</td>
<td>${pp.cityName}</td><td>${pp.shippingTitle}[${pp.shippingWp}]</td><td>${pp.deliverydate}</td></tr>
</s:forEach>
<s:forEach items="${p.addonList}" var="ad">
<tr><td>${ad.cartid}</td><td>${ad.productId}</td><td>${ad.productName}[${ad.productUnitPrice}]</td><td><div id="price-${ad.cartid}">${ad.productUnitPrice}</div></td><td><input id="${ad.productUnitPrice}" type="text" name="${ad.cartid}" value="1" onchange="return changeQuantity(this);"/></td><td>${ad.productType}</td>
<td></td><td></td><td></td></tr>
</s:forEach>
<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</s:forEach>
</table>
<input type="submit" value="proceed to checkout"/>
</form>
<br />
<p id="dd"></p>
<h1>Cart Value</h1><div id="cartValue">${sessionScope.cartValue}</div>

</body>
</html>
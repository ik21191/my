<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head><title></title></head>
<body>

<form action="reviewcart.htm">
<table width="100%">
<tr><td>Product ID</td><td>Product Name</td><td>Product Price</td><td>Product Type</td><td>Shipping City</td>
<td>Shipping Mode</td><td>Delivery Date</td></tr>
<s:forEach items="${sessionScope.cartDetails}" var="p">
<s:forEach items="${p.parentProduct}" var="pp">
<tr><td>${pp.productId}</td><td>${pp.productName}</td><td>${pp.productUnitPrice}</td><td>${pp.productType}</td>
<td>${pp.cityName}</td><td>${pp.shipping}</td><td>${pp.deliverydate}</td></tr>
</s:forEach>
Recipient Name:<input type="text" name="rec_name-${p.subOrderId}"/><br/>
Recipient Address:<input type="text" name="rec_add-${p.subOrderId}"/><br/>
Recipient PinCode:<input type="text" name="rec_pin-${p.subOrderId}"/><br/>
Recipient Mobile:<input type="text" name="rec_mob-${p.subOrderId}"/><br/>
<s:forEach items="${p.addonList}" var="ad">
<tr><td>${ad.productId}</td><td>${ad.productName}</td><td>${ad.productUnitPrice}</td><td>${ad.productType}</td>
<td></td><td></td><td></td></tr>
</s:forEach>
</s:forEach>
</table>
<input type="submit" value="Review Cart Details"/>
</form>

</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <script>
            function calculate(val)
            {
                //alert("method called:"+val);
                var val1=0;
                val1=val;
                var total=0;
                var price=0;
                if(val1==0)
                    {alert("Quantity must be greater than zero.")}else{
                price=(document.getElementById('price').innerHTML);
                total=val1*price;
                document.getElementById("price").innerHTML=total;}
            }
        </script>
    </head>
    
    <body>
        
        <c:forEach items="${list}" var="p">

<b>Product Name</b>${p.productName}<br/>
<b>Quantity:</b><input id="quantity" type="text" value='${p.productQuantity}' name="quantity" onchange="calculate(this.value)"/>Press Enter<br/>

<b>Price: </b><b><p id="price">${p.productPrice}</p></b>
<br/>
#foreach($city in $session.getAttribute("cityInfo"))
<b>$city.cityName</b>
#end
session value is: $session.getAttribute("name")
<div id="checkout"><a href="#">Proceed To Check Out</a></div>

        </c:forEach>
        
    </body>
</html>

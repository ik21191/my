<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>
<script type="text/javascript">
    function getValue(target)
    {
        $.ajax({
        type: 'POST',
        url: 'getvalue.htm',
        data: 'ship='+target.value,
        success: function(response){
        document.getElementById("shipping").innerHTML=response;
        },
        error: function()
        {
            document.getElementById("shipping").innerHTML="There is an error.";
        }
        });
     } 
     
</script>
<script type="text/javascript">
function makeUrl()
     {
         var a1,a2,a3;
         a1=document.getElementById("select1").value;
         a2=document.getElementById("shipping").value;
         a3=document.getElementById("productId").value;
         
         var url="carthandler.htm?city="+a1+"&shipping="+a2+"&productId="+a3;
         window.location=url;
     }
     function callCity(c)
     {
         //var cityList=document.getElementById("select1").value;
         alert(c)
     }
</script>
<title>
</title>
</head>
<body>
<c:forEach items="${list}" var="p">
<input type="hidden" id="productId" value='<c:out value='${p.productId}'/>'/>
<b>Product ID</b><c:out value='${p.productId}'/><br/>
<b>Product SKU: </b><c:out value='${p.productSku}'/><br/>
<b>Product Name</b><c:out value='${p.productName}'/><br/>
<b>Short Description: </b><c:out value='${p.shortDescription}'/><br/>
<b>Long Description: </b><c:out value='${p.longDescription}'/><br/>
<b>Price: </b><c:out value='${p.productPrice}'/><br/>
<b>Image: </b><c:out value='${p.productLargeImage}'/><br/>
<b>City List:</b><c:set var="cityList" value='${p.cityList}'/><select onchange="getValue(this)">
<%
String cityList=(String)pageContext.getAttribute("cityList");
String arr[]=cityList.split(",");
for(int i=0;i<arr.length;i++)
{
    String arr1[]=arr[i].split(":");
    out.println("<option value="+arr1[0]+">"+arr1[1]+"</option>");
}

%>
</select>
</c:forEach>
<br/>
Select Delivery Option<div id="shipping">Ajax call value will be displayed here.</div>
<br/>
<a href="#" onclick="javascript:makeUrl()">Add To Cart</a>
</body>
</html>
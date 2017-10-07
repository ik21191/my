<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:forEach items="${sessionScope.cartDetails.parentProduct}" var="p">
<div>${p.productName}</div>
<div>1</div>
<div>${p.productPrice}</div>
</div>
</c:forEach>
<c:forEach items="${sessionScope.cartDetails.addonList}" var="ad">
<div>
<div>${ad.productName}</div>
<div>1</div>
<div>${ad.productUnitPrice}</div>
</div>
</c:forEach>
</body>
</html>
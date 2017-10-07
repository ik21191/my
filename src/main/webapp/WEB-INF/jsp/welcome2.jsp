<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${list}" var="p">
    <c:out value="${p.productId}"/>&nbsp;<c:out value="${p.productName}"/>
    <a href="<c:out value='${p.productURL}'/>">Product Detail</a>
</c:forEach>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<title>Test</title>
<body>
<b>Hello Test</b><br/>
<s:forEach items="${list}" var="l">
${l}<br />
</s:forEach><br/>
<s:forEach items="${sessionScope.list1}" var="l">
${l}::
</s:forEach>
<br />Displaying session value<br />
${sessionScope.cartDetails}<br /><br />
${fn:length(sessionScope.cartDetails)}<br />
<s:set value="${fn:length(sessionScope.cartDetails)}" var="size" />
<s:choose>
<s:when test='${size>0}'>
hello
</s:when>
<s:otherwise>
bye
</s:otherwise>
</s:choose>
<br/>
<img height="20%" width="20%" alt="" src="/var/lib/openshift/5554cf47fcf9333135000186/app-root/data/tempFile/i.jpg"/><br/>
</body>
</html>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Pay through PayPal: http://www.TestAccount.com</title>
</head>
<body >
Below information is received.<br/>
<%=response %>
<%
Enumeration<String> e=(Enumeration<String>)request.getParameterNames();
while(e.hasMoreElements())
{
	String param=e.nextElement();
	out.println("Parameter Name: "+param+"  Value:  "+request.getParameter(param));
}
%>
</body>
</html>
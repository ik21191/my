<html>
<head>
<title>Pay through PayPal: http://www.TestAccount.com</title>
</head>
<body >
<form name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
<input type="hidden" name="cmd" value="_xclick" />
<input type="hidden" name="business" value="ik21191@gmail.com" />
<input type="hidden" name="password" value="Ik78613524" />
<input type="hidden" name="custom" value="1123" />
<input type="text" name="item_name" value="Tshirt " />
<input type="text" name="amount" value="1.00"/>
<input type="hidden" name="rm" value="1" />
<input type="hidden" name="return" value="http://www.onlinegiftsncakes.com/pr.jsp" />
<input type="hidden" name="cancel_return" value="http://localhost:8080/PaypalGS/paypalResponseCancel.jsp" />
<input type="hidden" name="cert_id" value="API Singature" /><input type="Submit" value="Pay with Paypal"/>
</form>
</body>
</html>
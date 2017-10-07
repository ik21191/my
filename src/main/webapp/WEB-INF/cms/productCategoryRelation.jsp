<%-- 
    Document   : productApp
    Created on : Jan 24, 2014, 7:59:00 PM
    Author     : harish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Application</title>
    </head>
    <body><form method="post" action="insert.htm">
            <input type="hidden" name="t1" value="pcRelation"/>
        <table>
            <tr><td>Category ID:</td><td><input type="text" name="CATEGORYID"/></td></tr>
            <tr><td>Product ID:</td><td><input type="text" name="PRODUCTID"/></td></tr>
            <tr><td>Sequence:</td><td><input type="text" name="SEQUENCE"/></td></tr>
            <tr><td>Status</td><td><select name="STATUS"><option value="Yes">Yes</option><option value="Yes">No</option></select></tr>
            <tr align="center"><td><input type="submit" value="Submit"/></td></tr>
        </table></form>
    </body>
</html>

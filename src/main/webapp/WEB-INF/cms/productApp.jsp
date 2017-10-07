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
            <input type="hidden" name="t1" value="productApp"/>
        <table>
            <tr><td>Separate Sellable</td><td><select name="adl_string_1"><option value="Yes">Yes</option><option value="No">No</option></select></tr>
            <tr><td>Product Type:</td><td><input type="text" name="PRODUCTTYPE"/></td></tr>
            <tr><td>Product Weight:</td><td><input type="text" name="WEIGHT"/></td></tr>
            <tr><td>Product Shipping:</td><td><select name="SHIPPINGTYPE"><option value="Express">Express</option><option value="Courier">Courier</option></select></td></tr>
            <tr><td>Product Name:</td><td><input type="text" name="name"/></td></tr>
            <tr><td>Product Title:</td><td><input type="text" name="title"/></td></tr>
            <tr><td>Product SKU:</td><td><input type="text" name="sku"/></td></tr>
            <tr><td>Status</td><td><select name="status"><option value="Yes">Yes</option><option value="Yes">No</option></select></tr>
            <tr><td>Short Description:</td><td><textarea name="sdescription"></textarea></td></tr>
            <tr><td>Long Description:</td><td><textarea name="ldescription"></textarea></td></tr>
            <tr><td>Sell Price:</td><td><input type="text" name="wp"/></td></tr>
            <tr><td>Purchase Price:</td><td><input type="text" name="pp"/></td></tr>
            <tr><td>MRP:</td><td><input type="text" name="mrp"/></td></tr>
            <tr><td>Meta Title:</td><td><input type="text" name="metatitle"/></td></tr>
            <tr><td>Meta Keyword:</td><td><textarea name="metakeyword"></textarea></td></tr>
            <tr><td>Meta Description:</td><td><textarea name="metadescription"></textarea></td></tr>
            <tr><td>Small Image Name:</td><td><input type="text" name="simage"/></td></tr>
            <tr><td>Large Image Name:</td><td><input type="text" name="limage"/></td></tr>
            
            <tr align="center"><td><input type="submit" value="Submit"/></td></tr>
        </table></form>
    </body>
</html>

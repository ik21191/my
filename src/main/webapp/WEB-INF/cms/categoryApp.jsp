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
        <title>Category Application</title>
    </head>
    <body><form method="post" action="insert.htm">
        <input type="hidden" name="t1" value="categoryApp"/>
        <table>
            <tr><td>Category Name:</td><td><input type="text" name="TITLE"/></td></tr>
            <tr><td>Parent Category ID:</td><td><input type="text" name="PARENT_ID"/></td></tr>
            <tr><td>Status</td><td><select name="STATUS"><option value="Yes">Yes</option><option value="Yes">No</option></select></tr>
            <tr><td>Category Description:</td><td><textarea name="DESCRIPTION"></textarea></td></tr>
            <tr><td>Meta Title:</td><td><input type="text" name="META_TITLE"/></td></tr>
            <tr><td>Meta Keyword:</td><td><textarea name="META_KEYWORD"></textarea></td></tr>
            <tr><td>Meta Description:</td><td><textarea name="META_DESCRIPTION"></textarea></td></tr>
            <tr align="center"><td><input type="submit" value="Submit"/></td></tr>
        </table>
    </body></form>
</html>

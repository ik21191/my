<%-- 
    Document   : crmmenu
    Created on : Jan 25, 2014, 10:07:07 AM
    Author     : harish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    String user=request.getParameter("username");
    String pass=request.getParameter("password");
    if(user.equalsIgnoreCase("imran")&&pass.equalsIgnoreCase("333"))
    {
    	%>
        <a href="productApp-app.asp">Create Product</a><br/>
        <a href="bulkupload-app.asp?action=productBulkUpload">Product Bulk Upload</a><br/>
        <a href="bulkupload-app.asp?action=productAddonUpload">Product Addon Upload</a><br/>
        <a href="bulkupload-app.asp?action=countryUpload">Country Upload</a><br/>
        <a href="bulkupload-app.asp?action=stateUpload">State Upload</a><br/>
        <a href="bulkupload-app.asp?action=cityUpload">City Upload</a><br/>
        <a href="bulkupload-app.asp?action=cityGroupUpload">City Group Upload</a><br/>
        <a href="categoryApp-app.asp">Create Category</a><br/>
        <a href="productCategoryRelation-app.asp">Product Category Relation</a><br/>
        <a href="search-app.jsp">Search</a><br/>
        <%
    }else{out.println("Invalid User");}
        %>
    </body>
</html>

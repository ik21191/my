<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    
    <body>
	<h1>Please upload a file [File should not contains double quotes]</h1>
	<form method="post" action="fileUpload.do" enctype="multipart/form-data">
        <input type="hidden" name="action" value='<%=request.getParameter("action") %>'/>
        <input type="text" name="action" value='<%=request.getParameter("action") %>' readonly/><br/>
        <input type="file" name="fileUploaded" /> <input type="submit" />
	</form>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <B>Please search by ID or TITLE with required application</b><br/>
        <form action="search.htm" method="post">
        <table>
            
            <tr><td>ID:<input type="text" name="id" value=""/></td><td>TITLE:<input type="text" name="title" value=""/></td>
            <td><select name="application">
                    <option value="product">Product</option>
                    <option value="category">Category</option>
                </select>
            </td>
        </tr><tr><td><input type="submit" value="Search"/></td></tr>
        </table>
        </form>
    </body>
</html>

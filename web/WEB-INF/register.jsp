<%-- 
    Document   : Register
    Created on : Oct 18, 2017, 1:36:46 PM
    Author     : 684243
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Shopping List</h1>
        
        <p>
            <form action="Shoppinglist" method="POST">
                  <input type="hidden" name="action" value="register">
                Username: <input type="text" name="username"><br>
                <input type="submit"  value="submit">
            </form>
        </p>
        
    </body>
</html>

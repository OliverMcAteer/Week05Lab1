<%-- 
    Document   : ShoppingList
    Created on : Oct 18, 2017, 1:36:59 PM
    Author     : 684243
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            Hello, <c:out value="${username}" /> <a href="<c:url value='Shoppinglist?action=logout'/>">Logout</a>
        </p>

        <h1> List </h1>

        
        <form action="Shoppinglist" method="post">
            <p>
            <input type="hidden" name="action" value="add">
            Shopping list: <input type=text name="newItem">
            <input type="submit" value="add">
            </p>
        </form>
    

    
    <form action="Shoppinglist" method="POST">  
        <table>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>
                        
                        ${item} <input type="radio" name="listSelected" value="${item}">
                        
                    </td>
                </tr>
            </c:forEach>
        </table>          
        <p>
    
            <input type="hidden" value="delete" name="action">
            <input type="submit" value="delete">
    </form>
</p>





</body>
</html>

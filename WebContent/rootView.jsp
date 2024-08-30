<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Root page</title>
    </head>
    <body>

        <div align = "center">
            <form action = "initialize">
                <input type = "submit" value = "Initialize the Database"/>
            </form>
            <a href="login.jsp" target ="_self" > logout</a><br><br> 

            <h1>List All Users</h1>	
            <h2><%= request.getParameter("email") %></h2>	
            <div align="center">
                <table border="1" cellpadding="6">
                    <caption><h2>List of Users</h2></caption>
                    <td>
                        <a href="new">
                            <button> Add New User</button>
                        </a>
                        <tr>
                            <th>Email</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Address</th>
                            <th>Password</th>
                            <th>Birthday</th>
                            <th>cash_bal($)</th>
                            <th>PPS_bal</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="users" items="${listUser}">	            
                        <tr style="text-align:center">
                            <td><c:out value="${users.email}" /></td>
                            <td><c:out value="${users.firstName}" /></td>
                            <td><c:out value="${users.lastName}" /></td>
                            <td><c:out value= "${users.address_street_num} ${users.address_street} ${users.address_city} ${users.address_state} ${users.address_zip_code}" /></td>
                            <td><c:out value="************" /></td> <!-- To actually see variables value "${users.password}"  --->
                            <td><c:out value="${users.birthday}" /></td>
                            <td><c:out value="${users.cash_bal}"/></td>
                            <td><c:out value="${users.PPS_bal}" /></td>
                            <td><a href="edit?email=<c:out value='${users.email}' />">Update</a></td>
                            <td><a href="delete?email=${users.email}">Delete</a>
                        </tr>
                        </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Activity page</title>
    </head>

    <center><h1>Welcome! You have been successfully logged in</h1> </center>


    <body>
        <center>
            <a href="login.jsp"target ="_self" > logout</a><br><br> 
            <h1><%=request.getParameter("email")%></h1>
            <p> <%=request.getParameter("firstName")%></p>	


            <div align="center">
                <a href="my-profile?email=${user.email}">
                    <button> My Settings Page </button> 
                </a>
                <table border="1" cellpadding="6">
                    <caption><h2>My Info ${2 * 4}</h2></caption>

                    <tr>
                        <th>Email</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Address</th>
                        <th>Password</th>
                        <th>Birthday</th>
                        <th>cash_bal($)</th>
                        <th>PPS_bal</th>
                    </tr>

                    <tr style="text-align:center">
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.firstName}" /></td>
                        <td><c:out value="${user.lastName}" /></td>
                        <td><c:out value="${user.address_street_num} ${user.address_street} ${user.address_city} ${user.address_state} ${user.address_zip_code}" /></td>      
                        <td><c:out value="************" /></td> <!-- To actually see variables value "${users.password}"  --->
                        <td><c:out value="${user.birthday}" /></td>
                        <td><c:out value="${user.cash_bal}"/></td>
                        <td><c:out value="${user.PPS_bal}" /></td> 

                        <td><a href="Update.jsp?email=${users.email}">Update</a></td>
                        <td><a href=Update.jsp?email=${users.email}">Update_Orig</a>

                    </tr>
        </center>
    </body>
</html>

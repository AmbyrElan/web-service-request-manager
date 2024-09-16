<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
        <nav>
            <a href="login.jsp">Login</a>
            <a href="Register.jsp">Register</a>
            <a href="request-quote.jsp">Get a quote</a>
        </nav>
        <main>
            <center><h1>Service Request Manager</h1></center>
            <div align="center">
                <p> ${loginFailedStr} </p>
                <form action="login" method="post">
                    <table border="1" cellpadding="5">
                        <tr>
                            <th>Username: </th>
                            <td>
                                <input type="text" name="email" size="45" autofocus>
                            </td>
                        </tr>
                        <tr>
                            <th>Password: </th>
                            <td> 
                                <input type="password" name="password" size="45">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="login"/>
                            </td>
                        </tr>
                    </table>
                    <a href="register.jsp" target="_self">Register Here</a>
                </form>
            </div>
        </main>
    </body>
</html>

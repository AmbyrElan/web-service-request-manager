<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Request a quote.</title>
    </head>
    <body>
        <main>
            <h1>Service Request Manager</h1>
            <form action="quote">
                <table>
                    <caption>Quote request form</caption>
                    <thead>
                        <tr>
                            <th>Contact information</th>
                            <th>Service location</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" name="firstName" size="25" placeholder="Firstname" value="" onfocus="this.value=''" required></td>
                            <td><input type="text" name="street number" size="6" placeholder="Address" value="" onfocus="this.value=''" required></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="lastName" size="25" placeholder="Lastname" value="" onfocus="this.value=''" required></td>
                            <td><input type="text" name="street name" size="20" placeholder="Street name" value="" onfocus="this.value=''" required></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="email" size="25" placeholder="Email" value="" onfocus="this.value=''" required></td>
                            <td><input type="text" name="city" size="20" placeholder="City" value="" onfocus="this.value=''" required></td>				
                        </tr>
                        <tr>
                            <td><input type="tel" name="phone" size="13" placeholder="Phone number" value="" onfocus="this.value''" required></td>
                            <td><input type="text" name="state" size="2" placeholder="State" value="" onfocus="this.value=''" required></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><input type="text" name="zip" size="6" placeholder="Zip code" value="" onfocus="this.value=''" required></td>
                        </tr>
                        <tr>
                            <td colspan="5" style="center">
                                <input type="submit" value="Submit request">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <a href="login.jsp" target="_self">Return to Login Page</a>
        </main>
    </body>
</html>

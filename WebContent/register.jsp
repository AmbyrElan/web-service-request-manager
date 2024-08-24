<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="register">
			<table border="1" cellpadding="5">
				<tr>
					<th>Username: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Birthday: </th>
					<td align="center" colspan="3">
						<input type="text" name="birthday" size="45" value="YYYY-MM-DD" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>
						Street Address:
					</th>
					<td align="center" colspan="3">
						<input type="text" name="street number" size="45" value="1234" onfocus="this.value=''">
						<input type="text" name="street name" size="45" value="Street Name" onfocus="this.value=''">
						<input type="text" name="city" size="45" value="City" onfocus="this.value=''">
						<input type="text" name="state" size="45" value="State" onfocus="this.value=''">
						<input type="text" name="zip code" size="45" value="Zip" onfocus="this.value=''">
					</td>
				</tr>
				
				
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>
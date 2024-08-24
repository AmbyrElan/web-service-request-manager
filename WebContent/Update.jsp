<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information</title>
</head>
<body>
	<h1>User Data</h1>
		<div class="row" align="center">
		
			<li>
				<a href="<%=request.getContextPath()%>/list"
				class="nav-link">Users					
				</a>
			</li>

				<div class="card-body">
					<p><%= request.getParameter("email") %></p>
					
					<c:if test="${user != null}">
						<form action="<%=request.getContextPath()%>/update" method="post" >
					</c:if>
					<c:if test="${user == null}">
						<form action="insert" method="post">
					</c:if>
					
					<caption>
						<h2>
							<c:if test="${user.email != null}">
								Edit User
							</c:if>
							<c:if test="${user.email == null}">
								Add a User
							</c:if>
						</h2>
					</caption>
					<c:if test="${user != null}">
						<input type="hidden" name="email" value="<c:out value='${user.email}' />" />
					</c:if>
					<fieldset class="form-group">
						<label>Email</label>
						<input type="text" value="<c:out value='${user.email}' />" name="email"
							class="form-control" required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>First Name</label>
						<input type="text" value="<c:out value='${user.firstName}' />" name="firstName"
							class="form-control" required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>Last Name</label>
						<input type="text" value="<c:out value='${user.lastName}' />" name="lastName"
							class="form-control" required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>Address</label>
						<input type="text" value="<c:out value='${user.address_street_num}' />" name="street number"
							class="form-control" required="required" />
						<input type="text" value="<c:out value='${user.address_street}' />" name="street name"
							class="form-control" required="required" />
						<input type="text" value="<c:out value='${user.address_city}' />" name="city"
							class="form-control"  required="required" />
						<input type="text" value="<c:out value='${user.address_state}' />" name="state"
							class="form-control" required="required" />
						<input type="text" value="<c:out value='${user.address_zip_code}' />" name="zip code"
							class="form-control"  required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>Password</label>
						<input type="text" value="<c:out value='${user.password}' />" name="password"
							class="form-control" required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>Birthday</label>
						<input type="text" value="<c:out value='${user.birthday}' />" name="birthday"
							class="form-control" required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>Cash Balance</label>
						<input type="text" value="<c:out value='${user.cash_bal}' />" name="cash_bal"
							class="form-control" required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>PPS Balance</label>
						<input type="text" value="<c:out value='${user.PPS_bal}' />" name="PPS_bal"
							class="form-control" required="required" />
					</fieldset>
					
					<input type="submit" value="Save" />
					</form>
				</div>
			</div>
	

</body>
</html>
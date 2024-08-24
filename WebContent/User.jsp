<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<nav align="center">
	<a href="login.jsp" target ="_self" > logout</a><br><br> 
</nav>

<body>
	
   <div align="center">
       <table border="1" cellpadding="6">
           <caption><h2>My Settings</h2></caption>
           <a href="activitypage.jsp"> My Profile Page </a>
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
           
           <td><c:out value ="${user.email}" /></td>
           <td><c:out value="${user.firstName}" /></td>
           <td><c:out value="${user.lastName}" /></td>
           <td><c:out value="${user.address_street_num} ${user.address_street} ${user.address_city} ${user.address_state} ${user.address_zip_code}" /></td>
           <td><c:out value="${user.password}" /></td>
           <td><c:out value="${user.birthday}" /></td>
           <td><c:out value="${user.cash_bal}" /></td>
           <td><c:out value="${user.PPS_bal}" /></td>

         </table>
	</div>
	<div align="center" height="200px" width="10%" >
		<div class="user-button-selection-row" align="center">
			<div class="order-button" align="left">
				<a href="add-to-balance?email=${user.email}">
					<button>
						Add to Balance
					</button> 
				</a>
			</div>
			<div class="order-button" align="center">
				<button>
					<a href="">Place  Removal Order</a>
				</button> 
			</div>
			<div class="order-history-button" align="right">
				<button>
					<a href="">View Tree Removal Order(s)</a>
				</button> 
			</div>
		</div>
	</div>
</body>
</html>
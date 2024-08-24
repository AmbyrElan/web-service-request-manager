<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="balance-add-form?email=${user.email}" align="center">
		<h1>
			${user.email}
		</h1>
		<form action="updateClientBal?email=${user.email}" method="post">
			<fieldset class="form-group">
				<label>Cash Balance: ${user.cash_bal}</label>
			</fieldset>
			<fieldset class="form-group">
				<label>Amount To Add: </label>
				<input type="number" name="added_val"
					class="form-control" required="required" />
			</fieldset>
			
			<input type="submit" value="Add" />
		</form>
	</div>

</body>
</html>
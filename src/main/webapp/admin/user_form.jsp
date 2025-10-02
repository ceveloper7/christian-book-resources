<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center		">
		<h2>Create New User</h2>
	</div>
	
	<div align="center">
		<form action="create_user" method="post" onSubmit="return validateFormInput()">
			<table>
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email" size="20" /></td>
				</tr>	
				<tr>
					<td align="right">Full name:</td>
					<td align="left"><input type="text" id="fullname" name="fullname" size="45" /></td>
				</tr>	
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" size="20" 
						onclick="javascript:history.go(-1);" /></td>
				</tr>
				<tr><td>&nbsp;</td></tr>	
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save"/>
						<input type="button" value="cancel"/>
					</td>
				</tr>
		</table>
		</form>	
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	function validateFormInput(){
		const fieldEmail = document.getElementById("email");
		const fieldFullname = document.getElementById("fullname");
		const fieldPassword = document.getElementById("password");
		
		if(fieldEmail.value.length == 0){
			alert("Error: email is a required field");
			fieldEmail.focus();
			return false;
		}
		
		if(fieldFullname.value.length == 0){
			alert("Error: fullname is a required field");
			fieldFullname.focus();
			return false;
		}
		
		if(fieldPassword.value.length == 0){
			alert("Error: password is a required field");
			fieldPassword.focus();
			return false;
		}
		
		return true;
	}
</script>
</html>
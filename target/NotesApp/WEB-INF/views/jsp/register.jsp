<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<form name='registration' action="registerProcess" method="post"  onsubmit="return formValidation()">
			<table align="center" style="with: 50%" border="10">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr align="center">
				<td></td>
				<td align="center"><input type="submit" value="Submit"/></td>
				</tr>
				</table>
				</form>
				
				
<script type="text/javascript">
    function formValidation() {
    	
        var fname = registration.firstname.value;
        var lname = registration.lastname.value;
        var uname = registration.username.value;
        var pass = registration.password.value;
        var email = registration.email.value;
        
        if (fname == "" || lname == "" || uname == "" || pass == "" || email == "") {
        	window.alert("Please value in All fields");
            return false; 
            
        }
    }
</script>				
			




</body>
</html>
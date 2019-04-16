<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/main.css"
        rel="stylesheet">
</head>
<body>
<form:form action="save" modelAttribute="user">
<table>
<tr>
<td>Username</td>
<td><p><form:input path="Username" name="UseName"/></p></td>
</tr>
<tr>
<td>Password</td>
<td><p><form:input path="password" name="password"/></p></td>
</tr>
<tr>
<td>City</td>
<td><form:input path="city"  name="city" /></td>
</tr>
<tr>
<td>PhoneNumber</td>
<td><form:input path="phno" name="phno"/></td>
</tr>
<tr>
<td>
<input type="submit" value="login" class="btn btn-primary">
</td>
</tr>
</table>
</form:form>
</body>
</html>
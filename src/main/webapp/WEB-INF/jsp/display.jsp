<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
	<div class="container-fluid">
	 <ul class="nav navbar-nav">
      <li class="active"><a href="newbook">Add Book</a></li>
      </ul>
      </div>
      </div>
      </div>
      </nav>
		<div class="table-responsive" width="100%">
			<table border="1">

				<tr>
<h1>My Lists</h1>
					<th>Id</th>
					<th>UserName</th>
					<th>City</th>
					<th>Phone Number</th>
					<th>Actions</th>
				</tr>

				<c:forEach var="var" items="${listing}">
					<tr>
						<c:if test="${var.id==editing.bookId}">
							<form:form action="update" modelAttribute="user">
								<tr>
									<td><form:input path="id" value="${var.id}" /></td>
									<td><form:input path="Username"
											value="${var.Username}" /></td>
									<td><form:input path="city" value="${var.city}" /></td>
									<td><form:input path="phno" value="${var.phno}" /></td>
								    <td><input type="submit" value="update"></td>
								</tr>

							</form:form>
						</c:if>
						</tr>
					<tr>
						<c:if test="${var.id!=editing.id}">
							<td><c:out value="${var.id}" /></td>
							<td><c:out value="${var.Username}" /></td>
							<td><img src="${var.city}" /></td>
							<td><c:out value="${var.phno}" /></td>
							<td><a href="edit?id=${var.id}" />Edit</a> 
								<a href="delete?id=${var.id}"/>Delete</a></td>

						</c:if>
				</c:forEach>
				</tr>



			</table>
</body>
</html>
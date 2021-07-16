<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
h3
{
color: red;
}
</style>
</head>

<body>

<h3>${message}</h3>

<h2 align="center">User Registration</h2>
<form:form action="userProcess" method="post" modelAttribute="userCommand">
<table class="center">
<tr>
<td>First Name</td>
<td><form:input type="text" path="fname"/></td>
</tr>
<tr>
<td>Last Name</td>
<td><form:input type="text" path="lname"/></td>
</tr>
<tr>
<td>Email Address</td>
<td><form:input type="email" path="email"/></td>
</tr>



<tr>
<td>Mobile Number</td>
<td><form:input type="text" path="mobile"/></td>
</tr>

<tr>
<td>Username</td>
<td><form:input type="text" path="username"/></td>
</tr>

<tr>
<td>Password</td>
<td><form:input type="password" path="password"/></td>
</tr>
	
<tr>
<td>Address1</td>
<td><form:textarea  path="address1"/></td>
</tr>

<tr>
<td>Address2</td>
<td><form:textarea  path="address2"/></td>
</tr>

<tr>
<td>City Name</td>
<td><form:input type="text" path="city"/></td>
</tr>

<tr>
<td>State Name</td>
<td><form:input type="text" path="state"/></td>
</tr>

<tr>
<td>Gender</td>
<td><form:input type="text" path="Gender"/></td>
</tr>

<tr>
<td><input type="reset" value="Cancel" /></td>
<td><input type="submit" value="Submit" /></td>
</tr>

</table>

</form:form>
<a href="/springmvcflow/"><button>Home</button></a>

</body>
</html>
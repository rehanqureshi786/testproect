<!--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Username</th>
<th>Password</th>
<th>Address1</th>
<th>Address2</th>
<th>City</th>
<th>State</th>
<th>Gender</th>
</tr>
<c:forEach var="list" items="${list}" >
<tr>
<td><c:out value="${list.fname}"/></td>
<td><c:out value="${list.lname}"/></td>
<td><c:out value="${list.email}"/></td>
<td><c:out value="${list.mobile}"/></td>
<td><c:out value="${list.username}"/></td>
<td><c:out value="${list.password}"/></td>
<td><c:out value="${list.address1}"/></td>
<td><c:out value="${list.address2}"/></td>
<td><c:out value="${list.city}"/></td>
<td><c:out value="${list.state}"/></td>
<td><c:out value="${list.gender}"/></td>
</tr>
</c:forEach>
</table>
<a href="/springmvcflow/"><button>Home</button></a>
</body>
</html>
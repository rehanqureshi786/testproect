<%@page import="com.utils.DBConnection"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
try{
Connection con = DBConnection.getConnection();
Statement st=con.createStatement();

String resultAjax="",email="";

String sql="select email from student";
System.out.println("AjaxForEmail Jsp");

email=request.getParameter("email");



ResultSet rs=st.executeQuery(sql);

while(rs.next())
{
	resultAjax=resultAjax+"#"+rs.getString("email");
}

st.close();
rs.close();
out.print(resultAjax);
con.close();
resultAjax="";
}
catch(Exception e)
{
	e.printStackTrace();
}


%>


</body>
</html>
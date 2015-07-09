<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="employee.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="elist" class="java.util.ArrayList"
	type="java.util.ArrayList<employee.Employee>" scope="request" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DisplayEmployee.jsp</title>
</head>
<body>
	<p>DBからデータを取得して表示します</p>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>年齢</th>
			<th>住所</th>
		</tr>
		<%
			for (Employee e : elist) {
				out.println("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getAge() + "</td><td>"
						+ e.getAddress() + "</td></tr>");
			}
		%>
	</table>
</body>
</html>
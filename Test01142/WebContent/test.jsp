<%@page import="com.naver.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<%
		String id = (String)application.getAttribute("id");
		String name =(String)application.getAttribute("name");
		Integer age = (Integer)application.getAttribute("age");
		MemberDTO dto = (MemberDTO)application.getAttribute("dto");
		out.print(id);
		out.print("<br>");
		out.print(name);
		out.print("<br>");
		out.print(age);
		out.print("<br>");
		out.print(dto);
		
	
	
	%>
</body>
</html>
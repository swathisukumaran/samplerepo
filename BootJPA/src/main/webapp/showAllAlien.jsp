<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Show Alien</h4>
	<c:forEach items="${alienList}" var="alien" items="alienList">
	<c:out value = "${alienList}"/><br>
	<%-- AlienId : ${alien.aid}<br>
	AlienName : ${alien.aname}<br>
	AlienTech : ${alien.tech}<br> --%>
	</c:forEach>

</body>
</html>
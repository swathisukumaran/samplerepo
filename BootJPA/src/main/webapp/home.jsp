<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>Add Aliens Here</h4>

	<form action="addAlien">
		<label>Alien Id :</label> <input type="text" name="aid"
			placeholder="Alien ID"><br> <label>Alien Name :</label>
		<input type="text" name="aname" placeholder="Alien Name"><br>
		<label>Alien Tech :</label> <input type="text" name="tech"
			placeholder="Alien Technology"><br> <input type="Submit"><br>
	</form>

	<form action="getAlien">
		<label>Alien Id :</label> <input type="text" name="aid"
			placeholder="Alien ID"><br>
<!-- 			 <label>Alien Name :</label> -->
<!-- 		<input type="text" name="aname" placeholder="Alien Name"><br> -->
<!-- 		<label>Alien Tech :</label> <input type="text" name="tech" -->
<!-- 			placeholder="Alien Technology"><br>  -->
			<input type="Submit"><br>
	</form>
	
	<form action="getAllAlien">
		<input type="Submit" value="Get All Aliens"><br>
	</form>

</body>
</html>
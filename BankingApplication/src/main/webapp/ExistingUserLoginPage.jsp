<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Existing user login</h1>

<form action="ExistCustLogin">

User Id<input type="number" name="custId" required/> <br>
Pin <input type="text"  name="pin" maxlength="4" required/> <br>
<input type="submit">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New User Login Page</h1>

<form action="NewCustRegister">

<!-- <!-- Enter custId <input type="text" name="custId"> <br> --> 
First Name <input type="text" name="firstName"> <br>
Middle Name <input type="text" name="middleName"> <br>
Last Name <input type="text" name="lastName"> <br>
<!-- City <input type="text" name="city"> <br> -->

<label for="city">Choose a city:</label>

<select name="city">
  <option value="New delhi">New delhi</option>
  <option value="chennai">chennai</option>
  <option value="bangalore">bangalore</option>
  <option value="mumbai">mumbai</option>
  <option value="kolkata">kolkata</option>
</select>
<br>
Mobile number <input type="tel" name="mobileNo" pattern="[6-9]{1}[0-9]{9}"> <br>
Occupation <input type="text" name="occupation"> <br>
Date of birth<input type="date" name="dob"> <br><br>

<input type="submit">

</form>
</body>
</html>
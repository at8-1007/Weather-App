<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" http-equiv="Cache-control" content="no-cache">
<title>The Weather Reporter</title>
<link href="styles.css" rel="stylesheet" type ="text/css"/>
</head>
<body>
<form action="WeatherApp" method=POST name="weatherForm">
<center>
<h3>The Weather Reporter</h3>
<p/>
<select name="selection" onchange="this.form.submit();">
	<option value="">--Select a City--</option>
	<option value="1">Hong Kong</option>
	<option value="2">London</option>
	<option value="3">New York</option>
	<option value="4">San Francisco</option>
	<option value="5">Seattle</option>
</select>
</center>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Weather Reporter</title>
<link href="styles.css" rel="stylesheet" type ="text/css"/>
<jsp:useBean id="weather" class="com.weatherapp.WeatherBean" scope="request" />
</head>
<body>
<form action="WeatherApp" method=GET name="form">
<center>
<h3>The Weather Reporter</h3>
<p/>
<h4><u>${weather.city}</u></h4>
<img src="${weather.imgSrc}"/><br>
<span class="hi">Hi: ${weather.high} F</span><br>
<span class="low">Low: ${weather.low} F</span><br>
<span class="description">${weather.description}</span>
<br/><br/>
<a href="weather.jsp" style="font-size: 9px">(Not in ${weather.city}? Click to change city.)</a>
</center>
</form>
</body>
</html>
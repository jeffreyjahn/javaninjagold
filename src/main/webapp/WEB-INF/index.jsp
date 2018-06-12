<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jeff's new JSP File</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div id="tupac">
	<h3>Total gold: <c:out value="${ gold }"/></h3>
	<p><a href="reset"><button>Reset</button></a></p>
	<div class="events">
		<h3>Farm</h3>
		<h5>Earns 2-5 gold</h5>
		<form action="/gold/farm" method="POST">
			<input type="submit" value="Farm">
		</form>
	</div>
	<div class="events">
		<h3>Cave</h3>
		<h5>Earns 5-10 gold</h5>
		<form action="/gold/cave" method="POST">
			<input type="submit" value="Cave">
		</form>
	</div>
	<div class="events">
		<h3>House</h3>
		<h5>Earns 7-15 gold</h5>
		<form action="/gold/house" method="POST">
			<input type="submit" value="House">
		</form>
	</div>
	<div class="events">
		<h3>Casino</h3>
		<h5>Earn or lose up to 100 gold</h5>
		<form action="/gold/casino" method="POST">
			<input type="submit" value="Casino">
		</form>
	</div>
	<div id="logs">
		<c:forEach var ="logItem" items ="${ currLog }" >
			<p>${ logItem }</p>
		</c:forEach>
	</div>
</div>
</body>
</html>
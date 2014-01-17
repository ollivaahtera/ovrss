<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/style.css">
    <title>OvRSS</title>
</head>
<body>
<h1>
	Your RSS feeds
</h1>
	<c:forEach var="feed" items="${feeds}">
		<span class="feedTitle">${feed.name} (<a href="${feed.url}">rss</a>)</span>
	</c:forEach>

	<c:forEach var="entry" items="${entries}">
		<div class="entry">
    		<span class="title"><a href="${entry.link}">${entry.title}</a></span>
    		<span class="date">published <fmt:formatDate pattern="dd.MM.yyyy - HH:mm:ss" value="${entry.pubDate}" /> 
    		in ${entry.feedName}</span>
    		<span class="description">${entry.description}</span>
		</div>
	</c:forEach>
</body>
</html>

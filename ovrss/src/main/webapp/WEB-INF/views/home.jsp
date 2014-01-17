<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>OvRSS</title>
</head>
<body>
<h1>
	Rss-syötteet
</h1>

   <c:forEach var="entry" items="${entries}">
      <p><b><a href="${entry.link}">${entry.title}</a></b><br/>
      ${entry.pubDate}<br/>
      ${entry.description}<p/>
   </c:forEach>
</body>
</html>

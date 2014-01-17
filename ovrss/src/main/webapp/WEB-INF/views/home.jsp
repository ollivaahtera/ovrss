<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>OvRSS</title>
</head>
<body>
<h1>
	Your RSS feed
</h1>

   <c:forEach var="entry" items="${entries}">
      <p><b><a href="${entry.link}">${entry.title}</a></b><br/>
      <fmt:formatDate pattern="dd.MM.yyyy - hh:mm:ss" value="${entry.pubDate}" /><br/>
      ${entry.description}<p/>
   </c:forEach>
</body>
</html>

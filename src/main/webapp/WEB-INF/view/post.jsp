<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
		<title>Posts</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>	
		<c:forEach var="post" items="${allPost}">
			<article>
				<h1>${post.title}</h1>
				<p>${post.body}
					<br>
				${post.author.username} , ${post.date}
				</p>
			</article>
		
		</c:forEach>
	</body>

</html>
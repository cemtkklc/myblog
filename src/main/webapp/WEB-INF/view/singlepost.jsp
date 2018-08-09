<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<title>My Blog</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	
		<jsp:include page="header.jsp"></jsp:include>
	
	
	
		<article>
			<h1>${post.title}</h1>
			<p>${post.body}  <br> 
				${post.date}
				<br>
				Author: ${post.author.username}
			</p>
			
		</article>

	
	
</body>

</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
	<title>My Blog</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	
		<jsp:include page="header.jsp"></jsp:include>
	
	
	
	
    <div class="container" style="margin-top:30px">
		<div class="row">
			<c:forEach var ="post" items="${postList}">
				<div class="col-sm-4">
					<h2>${post.title}</h2>
					<h5>${post.author.username}, ${post.date}</h5>
					<p>${post.body}</p>
				</div>
				<!-- 
				<article>
					<h1>${post.title}</h1>
					<p>${post.body}</p>
				</article>
				 -->
			</c:forEach>
		</div>
	</div>
</body>

</html>
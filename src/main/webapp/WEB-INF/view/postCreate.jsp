<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
		<title>Create Post</title>
	</head>
	
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div class="text-center" style="padding:50px 0">
				<form:form action="createPost" method="post" modelAttribute="tempPost">
					<div class="row">
						<div class="cold-md-4 mx-auto">
							<div class="form-group">
								<label for="text"> Title:</label>
								<form:textarea  path="title"  class="form-control" rows="1" cols="50"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cold-md-4 mx-auto">
							<div class="form-group">
								<label for="text"> Body:</label>
								<form:textarea path="body"  class="form-control" rows="6" cols="50"/>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Post it!</button>
				</form:form>
			</div>
		</div>
		
		
		<!-- 
		<form:form action="createPost" method="post" modelAttribute="tempPost">
			
			Title: <form:input path="title" type="text"/><br>
			Body:  <form:input path="body" type="text"/><br>
			<input type="submit" value="Create Post"/>
		</form:form>
	 -->
	</body>

</html>
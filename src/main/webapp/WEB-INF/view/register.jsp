<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
	
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		
		<div class="container">
			<div class="text-center" style="padding:50px 0">
				<form:form action="registerAuth" method="post" modelAttribute="userForm">
					<div class="row">
						<div class="cold-md-4 mx-auto">
						
							<div class="form-group " >
								<label for="text"> Username:</label>
								<form:input path="username" type="text" class="form-control" />
								<form:errors path="username"></form:errors>
							</div>
							
						</div>
					</div>
					<div class="row">
						<div class="cold-md-4 mx-auto">
							<div class="form-group" >
								<label for="text"> Fullname:</label>
								<form:input path="fullName" type="text" class="form-control" />
								<form:errors path="username"></form:errors>
								
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cold-md-4 mx-auto">
							<div class="form-group" >
								<label for="text"> Password:</label>
								<form:input path="password" type="password" class="form-control" />
								<form:errors path="username"></form:errors>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
					
				</form:form>
			</div>
		</div>
		<!-- 
		<form:form  action="registerAuth" method="post" modelAttribute="userForm">
				UserName: <form:input path="username" type="text"/>
					<form:errors path="username" cssClass="error"></form:errors><br>
				FullName: <form:input path="fullName" type="text"/>
					<form:errors path="fullName" cssClass="error"></form:errors>
				<br>
				Password: <form:input path="password" type="password"/>
					<form:errors path="password" cssClass="error"></form:errors><br>
				<input type="submit"  value="Register" />
		
		</form:form>
	 -->
	
	
	
	</body>
	
</html>
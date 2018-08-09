<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html>
<head>
	<title>My Blog Login Page</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	
		<jsp:include page="header.jsp"></jsp:include>
	<security:authorize access="isAuthenticated()">
		<h2>You are already logged in!</h2>
	</security:authorize>
	<security:authorize access="!isAuthenticated()">
		<div class="continer"> 
		<div class="text-center" style="padding:50px 0">
		
		<form:form action="${pageContext.request.contextPath}/authUser"   method="POST" class="form-signin">
				<div class="row">
					<div class="cold-md-4 mx-auto">
						<div class="form-group">
							<label for="text">Username: </label>
							<input type="text" class="form-control"  name="username" placeholder="Username"/>		
						</div>
					</div>
				</div>
				<div class="row">
					<div class="cold-md-4 mx-auto">
						<div class="form-group">
							<label for="pwd">Password: </label>
							<input type="password" class="form-control" name="password" placeholder="Password" />		
						</div>
					</div>
				</div>
					<!-- UserName : <input name="username" type="text" /><br>
					Password: <input name="password" type="password"/>
							
						<br> 
						<input type="submit" value="login">
						-->
				<button type="submit" class="btn btn-primary">Login</button>
					
		</form:form>
		</div>
		</div>
	</security:authorize>
	
			
			
	
</body>

</html>
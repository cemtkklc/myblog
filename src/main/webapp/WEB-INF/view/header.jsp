<%@ page import="java.util.List"  %>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="com.jsptestwar.JspTestWar.service.NotificationServiceImpl.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<header>
	<!-- Blog Page start -->
	<div class ="jumbotron text-center " style="margin-bottom:0">
		<h1>My Blog</h1>
		<p>Spring Boot My Blog Example</p>
	</div>
	<!-- NavBar -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="/"> Home </a>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/login">Login</a>
				</li>
				<security:authorize access="!isAuthenticated()">
				<li class="nav-item">
					<a class="nav-link" href="/register">Register</a>
				</li>
				</security:authorize>
				<security:authorize access="hasAuthority('default')">
					<li class="nav-item">
						<a class="nav-link" href="/post/all">Posts</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/post/create">Create Post</a>
					</li>
					<li class="nav-item">
						<form:form method="post" action="/logout">
							<button type="submit" class="btn btn-link btn-logout"> Logout </button>
						</form:form>	
					</li>
					<!-- 					<div id="logged-in-info"> <span>Hello <b><security:authentication property="principal.username"/>  </b></span> 
						<form:form method="post" action="/logout">
							<input type="submit" value="logout"/>
						</form:form>
					</div>
					 -->
					
				</security:authorize>
				
			</ul>
		
		</div>			
		
		
	</nav>
	</header>
	<!-- 
<a href="/" ><img src="${pageContext.request.contextPath}/style/img/site-logo.png"  /></a>
<a href="/">Home</a>
<a href="/login"> Login</a>
<security:authorize access="!isAuthenticated()">
<a href="/register">Register</a>
</security:authorize>
<security:authorize access="hasAuthority('default')" >
<a href="/post/all">Posts</a>
<a href="/post/create">Create Post</a>

 
<div id="logged-in-info"> <span>Hello, <b><security:authentication property="principal.username"/></b></span>
	<form:form method="post" action="/logout">
		<input type="submit" value="Logout"/>
	</form:form>
	
</div>
</security:authorize>
</header>

 -->
<% 
List<NotificationMessage> listMessage = (List<NotificationMessage>)session.getAttribute("notificationMessage"); 
request.setAttribute("List",listMessage);
%>
<ul class="messages">
<c:forEach var="temp" items="${List}">
	
		<li  class="${temp.type}">${temp.msg}</li>
	

</c:forEach>
</ul>
<% session.removeAttribute("notificationMessage"); %>


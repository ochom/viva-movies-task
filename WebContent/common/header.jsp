 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <style>
 	body{
 		width:100vw; min-height:100vh; overflow-x:hidden;
	    background-image:linear-gradient(45deg, #1f3824, #024f11);
	    background-size:cover; 	background-repeat:no-repeat;
 	}
	.navbar {
	    background-image:linear-gradient(180deg, lime, green);
	    background-size:cover;
	}
	.navbar a,.navbar li{
		font-weight:bold;
		color:#fff;
	}
</style>

 <header>
  <nav class="navbar navbar-expand-lg navbar-dark">
   <div>
    <a href="<%=request.getContextPath()%>" class="navbar-brand"> Vivax</a>
   </div>

   <ul class="navbar-nav">
   		<c:if test="${sessionScope.user !=null && sessionScope.user.is_admin()}">	
    		<li><a href="<%=request.getContextPath()%>/movies"class="nav-link">View</a></li>
    		<li><a href="<%=request.getContextPath()%>/list"class="nav-link">Movies</a></li>
		</c:if>
   		<c:if test="${sessionScope.user ==null || !sessionScope.user.is_admin()}">	
    		<li><a href="<%=request.getContextPath()%>/movies"class="nav-link">Movies</a></li>
		</c:if>
   </ul>
	   <ul class="navbar-nav navbar-collapse justify-content-end">	
		<c:if test="${sessionScope.user !=null }">	
		    <li><a href="<%=request.getContextPath()%>/cart" class="nav-link">
		    Cart (0)
		    </a></li>
		    <li><a href="<%=request.getContextPath()%>/logout" class="nav-link">Logout</a></li>
		    <li><c:out value="${sessionScope.user.getUsername()}"></c:out></li>
		</c:if>
			<c:if test="${sessionScope.user == null }">	
			   <li><a href="<%= request.getContextPath() %>/login" class="nav-link">Login</a></li>
			   <li><a href="<%= request.getContextPath() %>/register" class="nav-link">Signup</a></li>
			</c:if>
	   </ul>
  </nav>
 </header>
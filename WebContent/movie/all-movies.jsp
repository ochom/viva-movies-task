<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Vivax - Top movies market</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 <style>
	 a{
	 	text-decoration:none;
	 }
	 
	 a:hover{
	 	text-decoration:none;
	 }
 	.card{
 		transition: 0.5s ease-out;
 		z-index:90;
 		cursor:pointer;
 	}
 	.description{
 		height:0px; margin-top:0px;
 		background-image:linear-gradient(300deg, lime,green);
 		transition: 0.5s ease-out;
 		color:#fff; text-align:center;
 		z-index:100; overflow:hidden;
 	}
 	
 	
 	.description b{
 		font-size:25px;
 	}
 	
 	.card:hover{
 		opacity:0.2;
 	}
 	
 	.card:hover + .description{
 		padding-top:50px;
 		height:250px; margin-top:-250px;
 		opacity:1;
 	}
 	
 	.movie-thumbnail{
 		height:250px; width:100%;
 	}
 </style>
</head>
<body> 
<jsp:include page="../common/header.jsp"></jsp:include>

 <div class="row col-12 mx-auto py-3">
     <c:forEach var="movie" items="${listMovie}">
	     <a href="movie?id=<c:out value='${movie.id}' />" class="col-md-3 col-lg-2">
		     <div class="card">
		     	<img class="movie-thumbnail" src="${movie.thumbnail}" alt="MOVIE_CAPTION"/>
		     </div>
		     <div class="description">
		     	<b>${movie.title}</b>
		     	<p>Episodes: ${movie.episodes}</p>
		     	<p>Release Date: ${movie.released}</p>
		     </div>
	     </a>
     </c:forEach>
  </div>
  
</body>
</html>
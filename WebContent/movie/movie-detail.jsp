<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title><c:out value="${movie.title}"/> - Vivax</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

 <div class="row col-md-8 mx-auto mt-3">
 	<div class="col-md-5">
 		<div class="card card-body p-0">
 			<img src="${movie.thumbnail}" alt="MOVIE THUMB"/>
 		</div>
 	</div>
 	<div class="col-md-7">
 		<h3 class="text-warning"><c:out value="${movie.title}"/> </h3>
 		<p class="p-0 m-0">
	 		<span class="fa fa-star text-light"></span>
			<span class="fa fa-star text-light"></span>
			<span class="fa fa-star text-light"></span>
			<span class="fa fa-star text-light"></span>
			<span class="fa fa-star-half"></span>
		</p>
 		<b class="text-light">Released: <c:out value="${movie.released}"/>, </b> &nbsp;&nbsp;&nbsp;
 		<b class="text-light">Episodes: <c:out value="${movie.episodes}"/> </b>
 		<p class="text-warning"><c:out value="${movie.description}"/> </p>
 		<button class="btn btn-outline-light"><i class="fa fa-shopping-cart"></i> ADD TO CART</button>
 	</div>
 </div>
</body>
</html>
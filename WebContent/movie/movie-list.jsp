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
 .thumbnail{
 	height:20px; width:20px;
 }
 </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

 <div class="row">
  <div class="container mt-3">
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Add Movie</a>
   </div>
   <br>
   <table class="table table-bordered bg-light">
    <thead class="bg-success text-light">
     <tr>
      <th class="text-center">#</th>
      <th>Title</th>
      <th>Description</th>
      <th>Released</th>
      <th>Episodes</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="movie" items="${listMovie}">
      <tr>
       <td class="text-center"><img class="thumbnail" src="${movie.thumbnail}"/></td>
       <td><c:out value="${movie.title}" /></td>
       <td><c:out value="${movie.description}" /></td>
       <td><c:out value="${movie.released}" /></td>
       <td><c:out value="${movie.episodes}" /></td>

       <td>
       <a href="edit?id=<c:out value='${movie.id}' />">Edit</a>
        &nbsp;&nbsp;
        <a class="text-danger" href="delete?id=<c:out value='${movie.id}' />">Delete</a></td>
      </tr>
     </c:forEach>
    </tbody>

   </table>
  </div>
 </div>
</body>
</html>
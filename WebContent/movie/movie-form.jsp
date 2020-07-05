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

</head>

</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

 <div class="container col-md-5 mt-3">
  <div class="card">
   <div class="card-body">
	    <c:if test="${movie != null}">
	     	<form action="update" method="post">
	    </c:if>
	    <c:if test="${movie == null}">
	     	<form action="insert" method="post">
	    </c:if>
    <caption>
	     <h2>
		      <c:if test="${movie != null}">Edit Movie </c:if>
		      <c:if test="${movie == null}">Add New Movie </c:if>
	     </h2>
    </caption>

    <c:if test="${movie != null}">
     <input type="hidden" name="id" value="<c:out value='${movie.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Movie Title</label> 
     <input type="text" value="<c:out value='${movie.title}' />" class="form-control form-control-sm"
      name="title" required="required" placeholder="movie title">
    </fieldset>

    <fieldset class="form-group">
     <label>Thumb nail</label>
     <input type="text" value="<c:out value='${movie.thumbnail}' />"  class="form-control form-control-sm"
     name="thumbnail"  placeholder="paste url">
    </fieldset>

    <fieldset class="form-group">
     <label>Movie Description</label> 
     <textarea class="form-control form-control-sm"
      name="description" required="required" placeholder="description..."><c:out value='${movie.description}' /></textarea>
    </fieldset>

    <fieldset class="form-group">
     <label>Episodes</label>
     <input type="number" min="0" value="<c:out value='${movie.episodes}' />"  class="form-control form-control-sm"
     name="episodes" required="required" placeholder="episodes released">
    </fieldset>
    
    <fieldset class="form-group">
     <label>Date Released</label> 
     <input type="date" value="<c:out value='${movie.released}' />" class="form-control"
      name="released" required="required">
    </fieldset>
    
    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
</body>
</html>
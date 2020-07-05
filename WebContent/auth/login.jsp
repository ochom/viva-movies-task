<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Register - Vivax Movies</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="container col-md-6 col-lg-4 mx-auto mt-2">
        <div class="card card-body py-5">
            	<h2 class="text-center">Login</h2>    
            <form action="<%=request.getContextPath()%>/login" method="post">

                <div class="form-group">
                    <label for="uname">Email:</label> <input type="text" class="form-control" id="email" placeholder="email" name="email" required>
                </div>

                <div class="form-group">
                    <label for="uname">Password:</label> <input type="password" class="form-control" id="password" placeholder="password" name="password" required>
                </div>


                <button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
        </div>
    </body>

    </html>
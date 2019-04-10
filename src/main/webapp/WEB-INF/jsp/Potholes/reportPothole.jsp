<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:url var="formAction" value="/Users/userDashboard" />
<form method="POST" action="${formAction}">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="address">Address: </label>
				<input type="text" id="address" name="address" placeHolder="Address" class="form-control" />
			</div>
			<div class="form-group">
				<label for="severity">Severity: </label>
				<input type="checkbox" name="1" value=""> 
				<input type="checkbox" name="2" value=""> 
				<input type="checkbox" name="3" value=""> 
				<input type="severity" id="severity" name="severity" placeHolder="Severity" class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />	
			</div>
			<div class="form-group">
				<h3>File Upload:</h3>
      			Select a file to upload: <br />
      			<form action = "UploadServlet" method = "post"
         		enctype = "multipart/form-data">
         		<input type = "file" name = "file" size = "50" />
         		<br />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>

</body>
</html>
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
<form method="POST" action="${formAction}" enctype="multipart/form-data">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="address">Address: </label>
				<input type="text" id="streetNumber" name="streetNumber" placeHolder="Street number" class="form-control" />
				<input type="text" id="streetName" name="streetName" placeHolder="Street name" class="form-control" />
				<input type="text" id="city" name="city" placeHolder="City" class="form-control" />
				<input type="text" id="state" name="state" placeHolder="State" class="form-control" />
				<input type="text" id="zipCode" name="zipCode" placeHolder="Zip code" class="form-control" />
				<input type="text" id="country" name="country" placeHolder="Country" class="form-control" />
			</div>
			<div class="form-group">
				<label for="severity">Severity: </label>
				<select name="select" id="slectboxid">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				</select>
			</div>
			<div class="form-group">
				<h3>Photo Upload:</h3>
      			Select a photo to upload: <br />
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
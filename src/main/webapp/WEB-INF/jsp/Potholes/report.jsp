<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="/WEB-INF/jsp/Common/header.jsp" />

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
				<input type="text" id="lat" name="lng" placeHolder="Latitude" class="form-control"/>
				<input type="text" id="lng" name="lng" placeHolder="Longitude" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="severity">Severity (1-least severe, 3-most severe): </label>
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

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />
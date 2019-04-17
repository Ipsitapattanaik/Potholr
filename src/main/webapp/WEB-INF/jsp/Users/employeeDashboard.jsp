<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />


<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 class="title">Employee Dashboard</h1>
		</div>
	</div>

	<style>
	body , html{

   background-image: url("../img/back10.jpg");
  

}
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 500px;
	align: "right";
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: orange;
}

nav ul li {
	background-color: white;
	border-radius: 8px;
	list-style: none;
	text-align: center;
	flex-grow: 1;
	padding-top: 5px;
	margin: 10px;
	padding: 4px;
}

#map {
	height: 300px;
	width: 30%;
	align: right;
} 

.employeeMap {
	position: absolute;
	right: 0px;
	width: 300px;
	padding: 10px;
	margin-right: 100px;
}

#mapPicture{
	width: 100px;
	}
	
</style>



	<br>

	<div class="employeeMap" id="map"></div>
<script>
var map;
function initMap() {
map = new google.maps.Map(document.getElementById('map'), {
center : new google.maps.LatLng(40.443360, -80.005557),
zoom : 11
});

    var markers = [];

    var iconBase = 'http://maps.google.com/mapfiles/ms/icons/';

    var icons = {
        reported : {
            icon : iconBase + 'red-dot.png'
        },
        inspected : {
            icon : iconBase + 'orange-dot.png'
        },
        repaired : {
            icon : iconBase + 'green-dot.png'
        }

    };


var features =${arrayOfPotholes};
    
    // Create markers.
    for (var i = 0; i < features.length; i++) {
        var marker = new google.maps.Marker({
            position : features[i].position,
            icon : icons[features[i].type].icon,
            map : map
        });

        markers.push(marker);

        var infoWindow = new google.maps.InfoWindow;

        console.log("Loop number: " + i);
        var infowincontent = document.createElement('div');

        var potholePicture = document.createElement('IMG');

console.log("Picture is " + features[i].picture);
potholePicture
.setAttribute("src", features[i].picture);
potholePicture.setAttribute("id", "mapPicture");

potholePicture.setAttribute("alt", "Pothole picture");
infowincontent.appendChild(potholePicture);

        infowincontent.appendChild(document.createElement('br'));

        var strong = document.createElement('strong');
        strong.textContent = "pothole id " + features[i].id;
        infowincontent.appendChild(strong);
        infowincontent.appendChild(document.createElement('br'));
        var text = document.createElement('text');
        text.textContent = "Address: " + features[i].address;
     	infowincontent.appendChild(text);
    
        infowincontent.appendChild(document.createElement('br'));

        var severity = document.createElement('severity');
        severity.textContent = "Severity: "+ features[i].severity;
        infowincontent.appendChild(severity);

        google.maps.event.addListener(marker, 'click', handleMarkerClick(
                marker, i, infoWindow, infowincontent));

    }

}
function handleMarkerClick(marker, index, infoWindow, infowincontent) {
    return function() {
        console.log("Clicked on " + index + "th pothole");
        infoWindow.setContent(infowincontent);
        infoWindow.open(map, marker)
    };
}
</script>
<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBPTaZLJruIiCmd0kEqPv7S05hN2nWAEU&callback=initMap">

</script>


	<c:forEach var="pothole" items="${potholes}">
		<table class="tableView">
			<tr>
				<th>Pothole Id</th>
				<th>Reported Date</th>
				<th>Street Name</th>
			</tr>
			<tr>
				<td><c:out value="${pothole.potholeId}" /></td>
				<td><c:out value="${pothole.reportDate}" /></td>
				<td><c:out value="${pothole.streetName}" /></td>
			</tr>
			<tr>
				<th>Severity</th>
				<th>Status</th>
				<th>Zip Code</th>
			</tr>
			<tr>
				<td><c:out value="${pothole.severity}" /></td>
				<td><c:out value="${pothole.statusCode}" /></td>
				<td><c:out value="${pothole.zipCode}" /></td>
			</tr>
		</table>
	</c:forEach>



	<br></br> <br></br>
	<c:url var="formAction" value="/Users/employeeDashboard"/>
	<form method="POST" action="${formAction}">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
		<div class="row">
			<div class="col-x-4">
				<label for="potholeId">Pothole ID:</label>
			</div>
			<div class="col-xs-8">
				<select name="PotholeId">
					<c:forEach var="pothole" items="${potholes}">
						<option value="${pothole.potholeId}">${pothole.potholeId}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
		<div class="col-xs-4">
			<label for="severity">Pothole Severity:</label>
		</div>
		<div class="col-xs-8">
			<select name="severity">
				<option value="${pothole.severity}" selected="selected"></option>
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>

			</select>
		</div>
</div>
<div class="row">
	<div class="col-xs-4">
		<label for="statusCode">Status Code:</label>
	</div>
	<div class="col-xs-8">
		<select name="statusCode">
			<option value="${pothole.status_Code}"></option>
			<option value="reported">Reported</option>
			<option value="inspected">Inspected</option>
			<option value="repaired">Repaired</option>
		</select>
	</div>
</div>
<br>
<!-- <button type="submit" class="btn btn-warning"><a href="/Users/employeeDashboard"> Update Pothole</a></button>
 --><button type="submit" class="btn btn-warning">Update Pothole</button>
</form>




</div>
</div>
</div>
<button id="Reportpotholetab" type="submit">
	<a href="/capstone/Potholes/report">Report a Pothole</a>
</button>



<c:import url="/WEB-INF/jsp/Common/footer.jsp" />


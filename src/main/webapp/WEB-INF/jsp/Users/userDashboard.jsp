<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<h1>Hello ${user.userName},<br> <h4>Welcome back to your dashboard !!</h4></h1>

<style>
body , html{

   background-image: url("../img/back8.jpg");
  

}
nav{
background-image: url("../img/crackedpothole.png");
}

table {

  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 500px;
  align:"right";
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

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
img {
  max-width: 100%;
  height: auto;
}

.userMap {
	position: absolute;
	right: 0px;
	/* width: 200px; */
	padding: 10px;
	margin-right: 100px;
}
#Reportpotholetab 
{ 
	
  /* background-image: url("../img/crackedpothole.png"); */
  background-position: center;
  border-radius: 4px;
  text-color: white;
  background-color: #ecaf22;
  font-size: 18px;
  height: 50px;
  width: 400px;
  margin: 10px;
  border: .5px solid black;
  box-shadow: 2px 2px #888888;
  cursor: pointer;
  
  
}


#mapPicture{
	width: 100px;
	}
	
.thank{
	text-size: 16px;
	}	
</style>


 
<div class = "userMap" id="map"></div>
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
    <br></br>
    <br>
    
<body>
<h4 class = "thank">${ThankYou}</h4>
<c:forEach var="pothole" items="${potholes}">
		<table class="tableView">
			<tr>
				<th>Pothole Id</th>
				<th>Reported Date</th>
				<th>Street Name</th>
				<th>Severity</th>
				<th>Status</th>
				<th>Zip Code</th>
			</tr>
			<tr>
				<td><c:out value="${pothole.potholeId}" /></td>
				<td><c:out value="${pothole.reportDate}" /></td>
				<td><c:out value="${pothole.streetName}" /></td>
				<td><c:out value="${pothole.severity}" /></td>
				<td><c:out value="${pothole.statusCode}" /></td>
				<td><c:out value="${pothole.zipCode}" /></td>
			</tr>
			
		</table>
	</c:forEach>

</body>

<br>
    <br></br>  
    
<a href="/capstone/Potholes/report" > <input id="Reportpotholetab" type="button" value="Report a Pothole (with a form)" class = "button"></a>

<a href="/capstone/Potholes/reportWithGeolocation" > <input id="Reportpotholetab" type="button" value="Report a Pothole (with geolocation)" class = "button"></a>

<!-- <button id="Reportpotholetab" type="submit"><a href="/capstone/Potholes/report" class = "button" >Report a Pothole (with a form)</a></button>

<button id="Reportpotholetab" type="submit"><a href="/capstone/Potholes/reportWithGeolocation" class = "button" >Report a Pothole (with geolocation)</a></button>
 -->
<c:import url="/WEB-INF/jsp/Common/footer.jsp" />


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<h1>Welcome to PotholeVania!</h1>


<br></br>
<!-- added pothole images -->

<a class="navbar-brand" href="#"> <c:url var="homePageHref"
		value="/" /> <c:url var="imgSrc" value="/img/crackedpothole.png" />
	<a href="${homePageHref}"><img src="${imgSrc}" class="img-fluid"
		style="height: 180px;" /></a>
</a>

<a class="navbar-brand" href="#"> <c:url var="homePageHref"
		value="/" /> <c:url var="imgSrc" value="/img/potholewithgrass.png" />
	<a href="${homePageHref}"><img src="${imgSrc}" class="img-fluid"
		style="height: 180px;" /></a>
</a>

<a class="navbar-brand" href="#"> <c:url var="homePageHref"
		value="/" /> <c:url var="imgSrc" value="/img/roadpothole.png" /> <a
	href="${homePageHref}"><img src="${imgSrc}" class="img-fluid"
		style="height: 180px;" /></a>
</a>
<br></br>
<!-- created Pothole Facts -->
<h4>Pothole Facts</h4>

<p>A pothole occurs when there is a small failure in the road
	surface, and if left unattended, it will start to degrade the road
	surface. Pothole patching is a year-round activity which is performed
	by the Maintenance Divisions. Each of the Area Divisions is responsible
	for handling all the pothole patching complaints and requests that are
	received in their respective areas. Each has one or two asphalt crews
	that perform the work.
<p>Some examples of the work crews perform include:</p>

<li>Pothole patching.</li>
<li>Roadway gutter installation and/or repair.</li>
<li>Windrow installation or repair.
	<ul>
		<li>A "Windrow" is an asphalt curb placed along the side of the
			street to aid in drainage.
	</ul>
</li>
<li>Small intersection installation.</li>
<li>Small alley paving
	<ul>
		<li>Paving of an alleyway or area too narrow for paving
			equipment.
	</ul>
</li>
</p>
<a href="https://www.publicsource.org/the-potholes-of-pittsburgh/"><h5>Visit for Potholes of Pittsburgh</h5></a>
<br></br>
<h4>Lets Point It!</h4>

<div id="map"></div>
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

		var features = [ {
			position : new google.maps.LatLng(40.455570, -80.019180),
			type : 'reported'
		}, {
			position : new google.maps.LatLng(40.451106, -79.934117),
			type : 'inspected'
		}, {
			position : new google.maps.LatLng(40.456961, -79.975467),
			type : 'repaired'
		} ];

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
			potholePicture
					.setAttribute("src",
							"http://www.overdriveonline.com/wp-content/uploads/sites/8/2014/02/pothole.jpg");
			potholePicture.setAttribute("height", "100");
			potholePicture.setAttribute("alt", "The Pulpit Rock");
			infowincontent.appendChild(potholePicture);

			infowincontent.appendChild(document.createElement('br'));

			var strong = document.createElement('strong');
			strong.textContent = "pothole " + i;
			infowincontent.appendChild(strong);
			infowincontent.appendChild(document.createElement('br'));
			var text = document.createElement('text');
			text.textContent = "Address: " + i
					+ "th street Name Pittsburgh 15206 PA";
			infowincontent.appendChild(text);
			console.log("text is " + text.textContent);

			infowincontent.appendChild(document.createElement('br'));

			var severity = document.createElement('severity');
			severity.textContent = "Severity: medium";
			infowincontent.appendChild(severity);

			google.maps.event.addListener(marker, 'click', handleMarkerClick(
					marker, i, infoWindow, infowincontent));

		}

	}
	function handleMarkerClick(marker, index, infoWindow, infowincontent) {
		return function() {
			console.log("Clicked on " + index + "th pothole");
			infoWindow.setContent(infowincontent);
			infoWindow.open(map, marker);

		};
	}
</script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBPTaZLJruIiCmd0kEqPv7S05hN2nWAEU&callback=initMap">
	
</script>


<c:import url="/WEB-INF/jsp/Common/footer.jsp" />
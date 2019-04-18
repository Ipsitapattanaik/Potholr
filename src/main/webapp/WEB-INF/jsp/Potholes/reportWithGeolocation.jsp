
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<form>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="form-group">
				<input type="text"
					id="severity" name="severity" placeHolder="Severity(1-3)"
					class="form-control" />
			</div>
	Check the location, enter the severity of the pothole and click "Submit"
	<br>
			<button type="submit" class="btn btn-primary" id="SubmitLocation">Submit</button>
   		
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>



	<div id="map"></div>
    <script>
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.
      var map, infoWindow;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 40.443360, lng: -80.005557},
          zoom: 14
        });
        infoWindow = new google.maps.InfoWindow;
		var lat= 0;
		var lng =0;
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            lat=position.coords.latitude;
            lng=position.coords.longitude;
            			
			let buttonSubmit = document.getElementById('SubmitLocation');
			buttonSubmit.addEventListener("click", function(event){
				let severity = document.getElementById('severity').value;
				console.log("Severity is " + severity);
				fetch("/capstone/Potholes/thankYouForReporting?latitude="+lat+"&longitude="+lng+"&severity="+severity)
				.then((response) => {
					window.location.pathname = '/capstone/Users/redirectAfterReport';
				});				
			});
            
			infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            infoWindow.open(map);
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
      }

      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                              'Error: The Geolocation service failed.' :
                              'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBPTaZLJruIiCmd0kEqPv7S05hN2nWAEU&callback=initMap">
    </script>
</body>
</html>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />
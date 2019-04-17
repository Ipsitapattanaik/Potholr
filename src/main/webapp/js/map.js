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


//var features =${arrayOfPotholes};
    
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

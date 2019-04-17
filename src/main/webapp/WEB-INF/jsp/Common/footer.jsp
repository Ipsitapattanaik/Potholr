<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		</div>
		
		<footer>
			<c:url var="about" value="/about"/>
			<h5><a href="${about}">About Us</a></h6>
			<c:url var="contact" value="/contact"/>
			<h5><a href="${contact}">Contact Us</a></h6>
			<c:url var="careers" value="/careers"/>
			<h5><a href="${careers}">Careers</a></h6>
			<h5>&copy 2019 - Team 404</h6>
		</footer>
	</body>
</html>
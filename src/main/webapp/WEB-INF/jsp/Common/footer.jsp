<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		</div>
		
		<footer>
			<c:url var="about" value="/about"/>
			<h6><a href="${about}">About Us</a></h6>
			<c:url var="contact" value="/contact"/>
			<h6><a href="${contact}">Contact Us</a></h6>
			<c:url var="careers" value="/careers"/>
			<h6><a href="${careers}">Careers</a></h6>
			<h6>&copy 2019 - Team 404</h6>
		</footer>
	</body>
</html>
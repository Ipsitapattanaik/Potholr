<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<style>
p {
	font-size: 16px;
}
</style>

<h1 class="page-title">About Us</h1>

<p class="about-paragraph">In spring 2019, our founder and CEO Caitie Zajko suffered three flat tires on her car due to the rampant potholes in the city of Pittsburgh. This inspired her to found Potholr, an app to crowdsource the locations of potholes and pressure municipalities to repair them. Since then, we have grown and our app now functions anywhere in the United States.</p>

<h2 class="page-subtitle">Meet the Team</h2>

<c:url var="GroupPicture" value="/img/GroupPicture.jpg"/>
<img src="${GroupPicture}" style="width:100%" id="group-picture"/>

<h3>Caitie Zajko</h3>

<h4>Founder, CEO</h4>

<c:url var="CaitieZajkoLinkedIn" value="https://www.linkedin.com/in/caitie-zajko/"/>
<c:url var="CaitieZajkoPicture" value="/img/CaitieZajkoPicture.jpg"/>
<a href="${CaitieZajkoLinkedIn}"> <img src="${CaitieZajkoPicture}" class="about-picture"  /></a>

<p class="about-paragraph">Originally from the Greater Philadelphia area, Caitie moved to Pittsburgh in 2009 to pursue an English/Education degree and swim for the Lady Dukes at Duquesne University. She loved the city so much that she decided to stay and hasn't left since!</p>
<p class="about-paragraph">Caitie has worked in the greater Pittsburgh area for the last four years. She began her career educating teenagers as a high school English teacher before moving into recruiting, where she helped people secure employment after completing their education. She enjoyed building long-standing relationships with candidates in order to best match them to their perfect role. Caitie is excited to bring her passion for education to Tech Elevator and help students find fulfilling careers in technology.</p>
<p class="about-paragraph">In her spare time, she enjoys travel, puppies, running marathons, baking, and trying new restaurants. She aspires to write a children's book one day.</p>

<h3>Tom Anderson</h3>

<h4>CTO</h4>

<c:url var="TomAndersonLinkedIn" value="https://www.linkedin.com/in/noctivagan/"/>
<c:url var="TomAndersonPicture" value="/img/TomAndersonPicture.jpg"/>
<a href="${TomAndersonLinkedIn}"><img src="${TomAndersonPicture}" class="about-picture"  /></a>

<p class="about-paragraph">Tom started his career with Microsoft Corporation where he was Program Manager on Windows 3.11, Windows for Workgroups, Windows 95, and Internet Explorer. After leaving Microsoft in 1995, Tom formed his first consulting company to work with the emerging internet technologies. His company consulted with firms like Microsoft, Heinz, and the Pittsburgh Pirates. Tom was also recruited by Research in Motion to help them evangelize the BlackBerry 10 platform and train application developers. During this time, he also assisted US Steel and the University of Pittsburgh Medical Center with high-security, HIPAA-compliant mobile applications.</p>
<p class="about-paragraph">In addition to development, Tom has a passion for teaching and mentoring. While at Microsoft, he was a frequent co-presenter with executive staff during the launch of Windows 3.1. He has been a guest lecturer at the University of Notre Dame, and at many conferences in Argentina, Brazil, Chile, China, Holland, Thailand, and throughout the United States and Canada. Through all this, he maintains his passion for technology, exploring new platforms, and creating solutions for real world problems.</p>

<h3>Arthur W Mueller</h3>

<h4>Developer</h4>

<c:url var="ArthurLinkedIn" value="https://www.linkedin.com/in/arthurwmueller/"/>
<c:url var="ArthurPicture" value="/img/ArthurMuellerPicture.png"/>
<a href="${ArthurLinkedIn}"><img src="${ArthurPicture}" class="about-picture"  /></a>

<p class="about-paragraph">After graduating from the University of Pittsburgh in 2018, Arthur enrolled in <a href="https://www.techelevator.com/" target="_blank">Tech Elevator</a> to learn about software development.</p>
<p class="about-paragraph">Arthur is a die-hard fan of the University of Pittsburgh, as well as the Portland Trail Blazers and the NTT IndyCar Series. In his free time he enjoys watching sports and action movies.</p>

<h3>Ipsita Pattanaik</h3>

<h4>Developer</h4>

<c:url var="IpsitaLinkedIn" value="https://www.linkedin.com/in/ipsitapattanaik/"/>
<c:url var="IpsitaPicture" value="/img/IpsitaPattanaikPicture.png"/>
<a href="${IpsitaLinkedIn}"><img src="${IpsitaPicture}" class="about-picture"  /></a>

<p class="about-paragraph">A self motivated individual who sees every challenge as an opportunity, well connected professional always believes in team play. Focused to keeps everything moving smoothly and makes sure all the deadlines are met and achieved highest standards. Looking for a software developer role upon graduation in April 2019</p>

<h3>Kaelin Kamzelski</h3>

<h4>Developer</h4>

<c:url var="KaelinLinkedIn" value="https://www.linkedin.com/in/kaelin-kamzelski/"/>
<c:url var="KaelinPicture" value="/img/KaelinKamzelskiPicture.png"/>
<a href="${KaelinLinkedIn}"><img src="${KaelinPicture}" class="about-picture"  /></a>

<p class="about-paragraph">Bio Goes Here</p>

<h3>Lise Bilhaut</h3>

<h4>Developer</h4>

<c:url var="LiseLinkedIn" value="https://www.linkedin.com/in/lisebilhaut/"/>
<c:url var="LisePicture" value="/img/pictureLise.jpg"/>
<a href="${LiseLinkedIn}"><img src="${LisePicture}" class="about-picture"  /></a>

<p class="about-paragraph">A self-starter and resourceful thinker who gets excited when facing complex problems. Career focused in research and web entrepreneurship, with passion for innovation and learning new technologies. Looking for a junior software development position that will support continued growth and lifelong learning.</p>

<h3>Louis Campana</h3>

<h4>Developer</h4>

<c:url var="LouisLinkedIn" value="https://www.linkedin.com/in/louisjohncampana/"/>
<c:url var="LouisPicture" value="/img/LouisCampanaPicture.png"/>
<a href="${LouisLinkedIn}"><img src="${LouisPicture}" class="about-picture"  /></a>

<p class="about-paragraph">Bio Goes Here</p>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />
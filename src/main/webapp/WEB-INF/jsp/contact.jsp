<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<h1 class="page-title">Contact Us</h1>

<form method="POST" >
    <div class="form-group">
        <input type="text" id="name" placeholder="Name" required/>
    </div>
    <div class="form-group">
        <input type="email" id="email" placeholder="Email" required/>
    </div>
    <div class="form-group">
        <textarea id="Message" autocomplete="off" placeholder="Please Enter Your Message" maxlength="512" required></textarea>
    </div>
    <button type="submit">Talk To Us</button>

</form>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />
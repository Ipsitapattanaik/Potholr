<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<h1 class="page-title">Contact Us</h1>

<form method="POST" >
    <div class="form-group">
        <input type="text" id="name" placeholder="Name" name="name" required/>
    </div>
    <div class="form-group">
        <input type="email" id="email" placeholder="Email" name="email" required/>
    </div>
    <div class="form-group">
            <input type="text" id="subject" placeholder="Subject" name="subject" required/>
        </div>
    <div class="form-group">
        <textarea id="message" autocomplete="off" placeholder="Please Enter Your Message" maxlength="512" name="message" required></textarea>
    </div>
    <button type="submit">Talk To Us</button>

</form>

<c:import url="/WEB-INF/jsp/Common/footer.jsp" />
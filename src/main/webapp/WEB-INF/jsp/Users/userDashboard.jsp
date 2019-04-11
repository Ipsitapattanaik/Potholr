<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp" />

<h1>User Dashboard</h1>
<h2>Welcome ${user.getUserName}</h2>

  

<c:import url="/WEB-INF/jsp/Common/footer.jsp" /> --%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/Common/header.jsp"/>
<h1>User Dashboard</h1>
<h2>Welcome ${user.userName}</h2>

<div class="">
<div class="">
<b>User Id: </b>
</div>
<div class="">
<c:out value="${user.userId}"/>
</div>
</div>
<div class="">
<div class="">
<b>User Name: </b>
</div>
<div class="">
<c:out value="${user.userName}"/>
</div>
</div>
<div class="">
<b>Phone: </b>
</div>
<div class="">
<c:out value="${user.phone}"/>
</div>
<div class="">
<div class="">
<b>Email: </b>
</div>
<div class="">
<c:out value="${user.email}"/>
</div>
<div class="">
<b>Is Emloyee: </b>
</div>
<div class="">
<c:out value="${user.employee}"/>
</div>
</div>

<c:import url="/WEB-INF/jsp/Common/footer.jsp"/>
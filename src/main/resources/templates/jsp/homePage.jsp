<a href="${pageContext.request.contextPath}/userPage">User</a> | <a href="${pageContext.request.contextPath}/adminPage">Admin</a> | <a href="javascript:document.getElementById('logout').submit()">Logout</a>

<h3>Welcome to Rest API Application</h3>


<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
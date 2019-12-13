<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="Ups..."/>
    </jsp:include>
</head>
<body class="has-navbar-fixed-top">
<header>
    <jsp:include page="/WEB-INF/views/fragments/main-menu.jsp"/>
</header>
<section class="section">
    <div class="container">
        <h1 class="title is-danger">
            <strong>Ups...</strong> coś poszło nie tak :(
        </h1>
        <h2 class="subtitle is-danger">
            Gdybyś potrzebował wskazówki, to:
        </h2>
        <div class="content">
            <p><i>${exception.message}<i/></p>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="content">
                <c:if test="${stackTrace != null}">
                    <pre>${stackTrace}</pre>
                </c:if>
            </div>
        </sec:authorize>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>

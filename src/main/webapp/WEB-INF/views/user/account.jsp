<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="Yout account"/>
    </jsp:include>
</head>
<body class="has-navbar-fixed-top">
<header>
    <jsp:include page="/WEB-INF/views/fragments/main-menu.jsp"/>
</header>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Welcome to your account
            </h1>
            <h2 class="subtitle">
                Hello, world!
            </h2>

        </div>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
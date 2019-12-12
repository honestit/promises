<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <s:message code="pages.login.head.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body class="has-navbar-fixed-top">
<header>
    <jsp:include page="/WEB-INF/views/fragments/main-menu.jsp"/>
</header>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title">
                    <s:message code="pages.login.form.title.main"/>
                </h1>
            </div>
            <div class="column">
                <c:if test="${param['error'] != null}">
                    <div class="notification is-danger">
                        <s:message code="pages.login.form.login-error"/>
                    </div>
                </c:if>
                <form method="post" action="/login">
                    <div class="field">
                        <label class="label" for="username"><s:message code="global.username"/></label>
                        <div class="control has-icons-left">
                            <input type="text" id="username" name="username" required
                                   class="input"/>
                            <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                            </span>
                            <p class="help"><s:message code="pages.login.form.help.username"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label" for="password"><s:message code="global.password"/></label>
                        <div class="control has-icons-left">
                            <input type="password" id="password" name="password" required
                                   class="input"/>
                            <span class="icon is-small is-left">
                                <i class="fas fa-lock"></i>
                            </span>
                            <p class="help"><s:message code="pages.login.form.help.password"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <button class="button is-success is-link" type="submit"><s:message code="pages.login.form.submit"/></button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form>
            </div>
            <div class="column"></div>
        </div>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
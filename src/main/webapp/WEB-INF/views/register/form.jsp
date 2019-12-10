<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <s:message code="pages.register.head.title" var="title"/>
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
        <h1 class="title">
            <s:message code="pages.register.form.title.main"/>
        </h1>
        <h2 class="subtitle">
            <s:message code="pages.register.form.title.sub"/>
        </h2>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form method="post" modelAttribute="registrationData">
                    <div class="field">
                        <form:label path="username" cssClass="label"><s:message code="global.username"/></form:label>
                        <div class="control has-icons-left">
                            <form:input path="username" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                            <p class="help"><s:message code="pages.register.form.helps.username"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="email" cssClass="label"><s:message code="global.email"/></form:label>
                        <div class="control has-icons-left">
                            <form:input path="email" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i
                                    class="fas fa-envelope"></i></span>
                            <p class="help"><s:message code="pages.register.form.helps.username"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="password" cssClass="label"><s:message code="global.password"/></form:label>
                        <div class="control has-icons-left">
                            <form:password path="password" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help"><s:message code="pages.register.form.helps.password"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="rePassword" cssClass="label"><s:message code="global.re-password"/></form:label>
                        <div class="control has-icons-left">
                            <form:password path="rePassword" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help"><s:message code="pages.register.form.helps.re-password"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="termsAcceptance"
                                    cssClass="checkbox">
                            <form:checkbox path="termsAcceptance"
                                           required="true"/> <s:message code="pages.register.form.helps.terms"/></form:label>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-success is-link" type="submit"><s:message code="pages.register.form.submit"/>
                            </button>
                        </div>
                        <div class="control">
                            <button class="button is-text" type="reset"><s:message code="pages.register.form.reset"/></button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form:form>
            </div>
            <div class="column">
            </div>
        </div>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>

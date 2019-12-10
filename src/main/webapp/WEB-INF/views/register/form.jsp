<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="Register your account"/>
    </jsp:include>
</head>
<body class="has-navbar-fixed-top">
<header>
    <jsp:include page="/WEB-INF/views/fragments/main-menu.jsp"/>
</header>
<section class="section">
    <div class="container">
        <h1 class="title">
            Registration
        </h1>
        <h2 class="subtitle">
            Register your account to make promises right now!
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
                        <form:label path="username" cssClass="label">Username</form:label>
                        <div class="control has-icons-left">
                            <form:input path="username" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                            <p class="help">Set your username</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="email" cssClass="label">Email</form:label>
                        <div class="control has-icons-left">
                            <form:input path="email" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i
                                    class="fas fa-envelope"></i></span>
                            <p class="help">Set your email</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="password" cssClass="label">Password</form:label>
                        <div class="control has-icons-left">
                            <form:password path="password" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set your password</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="rePassword" cssClass="label">Retype Password</form:label>
                        <div class="control has-icons-left">
                            <form:password path="rePassword" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set your password again</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="termsAcceptance"
                                    cssClass="checkbox">
                            <form:checkbox path="termsAcceptance"
                                           required="true"/> Accept terms and conditions</form:label>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-success is-link" type="submit">Register
                            </button>
                        </div>
                        <div class="control">
                            <button class="button is-text" type="reset">Reset</button>
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

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register yout account</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        Home
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>

                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            More...
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item">
                                Some link
                            </a>
                            <%-- Tutaj kolejne linki w menu dodatkowym --%>
                        </div>
                    </div>
                </div>

                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <a class="button is-primary" href="/register">
                                <strong>Register</strong>
                            </a>
                            <a class="button is-success" href="/login">
                                <strong>Login</strong>
                            </a>
                            <a class="button is-primary" href="/account">
                                <strong>Account</strong>
                            </a>
                            <form method="post" action="/logout">
                                <button class="button is-link" type="submit">Wyloguj</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
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
                                           required="true"/> Accept terms</form:label>
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
                    <form:errors path="*"/>
                </form:form>
            </div>
            <div class="column">
            </div>
        </div>
    </div>
</section>
<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">
            <p><strong>Promises</strong> by HonestIT Consulting&copy; All right reserved</p>
        </div>
    </div>
</footer>
</body>
</html>

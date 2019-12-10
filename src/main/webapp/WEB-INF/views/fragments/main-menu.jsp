<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<header>--%>
<nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <div class="navbar-item">
            <c:url var="homeURL" value="/"/>
            <a class="navbar-item button" href="${homeURL}">
                Home
            </a>
        </div>
    </div>
    <div class="navbar-menu">
        <div class="navbar-start">
            <sec:authorize access="hasRole('USER')">
                <div class="navbar-item">

                    <c:url var="accountURL" value="/user"/>
                    <a class="navbar-item button" href="${accountURL}">
                        Account
                    </a>

                </div>
            </sec:authorize>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <sec:authorize access="!isAuthenticated()">

                        <c:url var="registerURL" value="/register"/>
                        <a class="button is-primary" href="${registerURL}">
                            <strong>Register</strong>
                        </a>
                        <c:url var="loginURL" value="/login"/>
                        <a class="button is-success" href="${loginURL}">
                            <strong>Login</strong>
                        </a>

                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">

                        <c:url var="logoutURL" value="/logout"/>
                        <form method="post" action="${logoutURL}">
                            <button class="button is-link" type="submit">Logout</button>
                            <sec:csrfInput/>
                        </form>

                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</nav>
<%--</header>--%>
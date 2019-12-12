<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <spring:message code="pages.index.head.title" var="title"/>
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
            <spring:message code="pages.index.body.title.main"/>
        </h1>
        <h2 class="subtitle">
            <spring:message code="pages.index.body.title.sub"/>
        </h2>
    </div>
</section>
<sec:authorize access="hasRole('USER')">
    <section class="section">
        <div class="container">
            <div class="columns">
                <div class="column is-12">
                    <form:form modelAttribute="givenPromise" method="post" action="/promises">
                    <div class="field is-grouped">
                        <div class="field is-horizontal">
                            <div class="field-label is-normal">
                                <form:label path="whom" cssClass="label"><s:message
                                        code="pages.index.promise.whom"/></form:label>
                            </div>
                            <div class="field-body is-large">
                                <div class="control has-icons-left">
                                    <s:message code="pages.index.promise.whom.help"
                                               var="promiseWhomPlaceholder"/>
                                    <form:input path="whom" cssClass="input" required="true"
                                                placeholder="${promiseWhomPlaceholder}"/>
                                    <span class="icon is-small is-left"><i
                                            class="fas fa-user"></i></span>
                                    <p class="help is-danger"></p>
                                    <form:errors path="name" element="p" cssClass="help is-danger"/>
                                </div>
                            </div>
                        </div>
                        <div class="field is-horizontal">
                            <div class="field-label is-normal">
                                <form:label path="name" cssClass="label"><s:message
                                        code="pages.index.promise.name"/></form:label>
                            </div>
                            <div class="field-body is-large">
                                <div class="control has-icons-left">
                                    <s:message code="pages.index.promise.name.help"
                                               var="promiseWhomPlaceholder"/>
                                    <form:input path="name" cssClass="input" required="true"
                                                placeholder="${promiseWhomPlaceholder}"/>
                                    <span class="icon is-small is-left"><i
                                            class="fas fa-angle-right"></i></span>
                                    <p class="help is-danger"></p>
                                    <form:errors path="name" element="p" cssClass="help is-danger"/>
                                </div>
                            </div>
                        </div>
                        <div class="field is-horizontal" style="margin-left: 1em">
                            <div class="field-label is-normal">
                                <form:label path="deadlineDate" cssClass="label"><s:message
                                        code="pages.index.promise.deadlineDate"/></form:label>
                            </div>
                            <div class="field-body is-large">
                                <div class="control has-icons-left">
                                    <s:message code="pages.index.promise.deadlineDate.help"
                                               var="deadlineDatePlaceholder"/>
                                    <form:input path="deadlineDate" cssClass="input" required="true"
                                                placeholder="${deadlineDatePlaceholder}"
                                                type="date"/>
                                    <span class="icon is-small is-left"><i
                                            class="fas fa-calendar-day"></i></span>
                                    <p class="help is-danger"></p>
                                    <form:errors path="deadlineDate" element="p"
                                                 cssClass="help is-danger"/>
                                </div>
                            </div>
                        </div>
                        <div class="field is-horizontal" style="margin-left: 1em">
                            <div class="field-label is-normal">
                                <form:label path="deadlineTime" cssClass="label"><s:message
                                        code="pages.index.promise.deadlineTime"/></form:label>
                            </div>
                            <div class="field-body is-large">
                                <div class="control has-icons-left">
                                    <s:message code="pages.index.promise.deadlineTime.help"
                                               var="deadlineTimePlaceholder"/>
                                    <form:input path="deadlineTime" cssClass="input"
                                                placeholder="${deadlineTimePlaceholder}"
                                                type="time"/>
                                    <span class="icon is-small is-left"><i class="fas fa-clock"></i></span>
                                    <p class="help is-danger"></p>
                                    <form:errors path="deadlineTime" element="p"
                                                 cssClass="help is-danger"/>
                                </div>
                            </div>
                        </div>
                        <div class="field is-horizontal" style="margin-left: 1em">
                            <div class="control">
                                <button class="button is-success is-link" type="submit"><s:message
                                        code="pages.index.promise.submit"/></button>
                            </div>
                        </div>
                        <sec:csrfInput/>
                        </form:form>
                    </div>
                    <div class="column is-2"></div>
                </div>
            </div>
        </div>
    </section>
</sec:authorize>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
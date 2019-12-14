<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="columns">
            <div class="column is-6">
                <h1 class="title">
                    <spring:message code="pages.index.body.title.main"/>
                </h1>
                <h2 class="subtitle">
                    <spring:message code="pages.index.body.title.sub"/>
                </h2>
                <sec:authorize access="hasRole('USER')">
                    <c:if test="${param['youPromise'] != null}">
                        <div class="notification is-success">
                            You promise!
                        </div>
                    </c:if>
                    <form:form modelAttribute="givenPromise" method="post" action="/promises">
                        <div class="field is-grouped is-grouped-centered">
                            <div class="field">
                                <div class="field-label is-large has-text-left">
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
                                        <form:errors path="name" element="p"
                                                     cssClass="help is-danger"/>
                                    </div>
                                </div>
                            </div>
                            <div class="field" style="margin-left: 1em;">
                                <div class="field-label is-large has-text-left">
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
                                        <form:errors path="name" element="p"
                                                     cssClass="help is-danger"/>
                                    </div>
                                </div>
                            </div>
                            <div class="field" style="margin-left: 1em">
                                <div class="field-label is-large has-text-left">
                                    <form:label path="deadlineDate" cssClass="label"><s:message
                                            code="pages.index.promise.deadlineDate"/></form:label>
                                </div>
                                <div class="field-body is-large">
                                    <div class="control has-icons-left">
                                        <s:message code="pages.index.promise.deadlineDate.help"
                                                   var="deadlineDatePlaceholder"/>
                                        <form:input path="deadlineDate" cssClass="input"
                                                    required="true"
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
                            <sec:csrfInput/>
                        </div>
                        <div class="field is-grouped is-grouped-centered">
                            <div class="field ">
                                <div class="control">
                                    <button class="button is-success is-link is-large"
                                            type="submit">
                                        <s:message
                                                code="pages.index.promise.submit"/></button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </sec:authorize>
                <div class="column is-2"></div>
            </div>
            <div class="column is-6">
                <h1 class="title is-centered"><spring:message
                        code="pages.index.body.title2.main"/></h1>

                <sec:authorize access="hasRole('USER')">
                    <c:forEach items="${upcomingPromises}" var="promiseData">
                        <div class="box">
                            <div class="media">
                                <div class="media-content">
                                    <div class="content">
                                        <p><spring:message code="pages.index.body.promise.title"
                                                           arguments="${promiseData.givenAt}"/></p>
                                        <p>
                                            <spring:message code="pages.index.body.promise.body"
                                                            arguments="${promiseData.receiverName},${promiseData.name}"/>
                                        </p>
                                    </div>
                                    <div class="level">
                                        <div class="level-left"></div>
                                        <div class="level-right">
                                            <span class="level-item"><small><spring:message
                                                    code="pages.index.body.promise.deadline"
                                                    arguments="${promiseData.deadline}"/></small></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </sec:authorize>
            </div>
        </div>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
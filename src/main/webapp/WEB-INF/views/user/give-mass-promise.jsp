<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Masowe dodawanie obietnic</title>
</head>
<body>
<form method="post" action="">
    <p>
        Co:
        <input type="text" name="what" value="${givenPromises.what}"/>
    </p>
    <p>
        <c:choose>
            <c:when test="${not empty availableFriends}">
                Komu jeszcze?
                <select name="friendToAdd.name">
                    <c:forEach items="${availableFriends}" var="friend">
                        <option value="${friend.name}">${friend.name}</option>
                    </c:forEach>
                </select>
                Kiedy: <input type="date" name="friendToAdd.deadlineDate" value="${givenPromises.lastSetDate}"/>
                <button type="submit" name="addFriend">Dodaj</button>
            </c:when>
            <c:otherwise>
                Nie masz więcej przyjaciół, którym mógłbyś złożyć obietnicę :)
            </c:otherwise>
        </c:choose>
    </p>
    <p>
        Komu już:
    <ul>
        <c:forEach items="${givenPromises.friends}" var="friend">
            <li><b>${friend.name}</b>, ${givenPromises.what} do <i>${friend.deadlineDate}</i>
                <button type="submit" name="removeFriend" value="${friend.name}">Usuń</button>
            </li>
            <input type="hidden" value="${friend.name};${friend.deadlineDate}" name="friends"/>
        </c:forEach>
    </ul>
    </p>
    <p>
        <sec:csrfInput/>
        <button type="submit" name="givePromise">Złóż obietnice</button>
    </p>
</form>
</body>
</html>

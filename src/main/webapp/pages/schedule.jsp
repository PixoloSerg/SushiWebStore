<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="item" items="${scheduleList}" >
    <div class="inlineMiddle"><c:out value="${item}" /></div>
</c:forEach>

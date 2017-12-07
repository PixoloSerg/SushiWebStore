<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact to us</title>
    </head>
    <body>
        <%@include file="head.jsp" %>
        <%@include file="contactForm.jsp" %>
        
        <%@include file="menu.jsp" %>
        
        <c:set var="bandId" value="bandNew"></c:set>
        <%@include file="goodsCarusel.jsp" %>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="generalHead.jsp" %>
        <title>${title}</title>
    </head>
    <body>
	<div id="wrapper">
	    <div id="content">
		<%@include file="head.jsp" %>   
                <c:if test="${user == null}">
                <%@include file="becomeMember.jsp" %>
                </c:if>
                <c:if test="${user != null}">
                <%@include file="alreadyMember.jsp" %>
                </c:if>


                
                <%@include file="menu.jsp" %>
                
                <c:set var="bandCaption" value="POPULAR"></c:set>
                <c:set var="bandId" value="bandPopular"></c:set>
                <%@include file="goodsCarusel.jsp" %>
                
                <c:set var="bandCaption" value=""></c:set>
                <c:set var="bandId" value="bandRecommend"></c:set>
                <%@include file="goodsCarusel.jsp" %>   
                
                <c:set var="bandCaption" value=""></c:set>                
                <c:set var="bandId" value="bandSale"></c:set>
                <%@include file="goodsCarusel.jsp" %>
                
                <c:set var="bandCaption" value="NEW"></c:set>
                <c:set var="bandId" value="bandNew"></c:set>
                <%@include file="goodsCarusel.jsp" %>
                
                <%@include file="map.jsp" %>
                <%@include file="footer.jsp" %>
	    </div>
	</div>
    </body>
</html>

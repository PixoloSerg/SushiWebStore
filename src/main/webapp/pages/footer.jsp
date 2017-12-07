<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="band_Footer">
    <div class="band_Content">
        <ul>
            <li><a href="">Main</a></li>
            <li><a href="/about">About</a></li>
            <li><a href="/sales">Sales</a></li>
            <li><a href="/points">Points</a></li>
            <li><a href="/contact">Contact to us</a></li>
        </ul>
        <ul>
            <li>MAKE ORDER</li>
            <li><c:out value="${location.getPhone()}" ></c:out></li>
            <li><span></span>WORKING</li>
            <li><%@include file="/pages/schedule.jsp" %></li>            
        </ul>
        <ul>
            <li>Follow us</li>
            <li><span></span><span></span></li>
            <li><a href="">#SushiStore</a></li>
        </ul>
        <ul>
            <li>Download mobile app</li>
            <li><span></span><span></span></li>            
        </ul>
    </div>
</div>
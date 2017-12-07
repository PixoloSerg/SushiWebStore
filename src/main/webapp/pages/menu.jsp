<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="bandMenu">
    <div class="band_Content">
        <div class="band_Content_Caption">
            <span class="inlineMiddle"></span>
            <h1 class="inlineMiddle band_Content_Caption_Text">MENU</h1>
            <span class="inlineMiddle"></span>
        </div>
        <div id="bandMenu_Content_Items">
            <ul>
                <c:forEach items="${menuCategories}" var="item" varStatus="loop">
		    <li>
			<%@include file="/pages/menuItem.jsp" %>
		    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
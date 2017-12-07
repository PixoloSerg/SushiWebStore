<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bandHeadInfo_Element" id="bandHeadInfo_ShopStatus">
    <span class="inlineElement"></span>
    <a href=""><span class="grayIcon inlineMiddle fa fa-shopping-basket" style="position: relative">
	    <div class="bandHeadInfo_ShopStatus_Number" id="bandHeadInfo_ShopStatus_Amount">
		<c:out value="${shopCart.getLineItems().size()}" />
	    </div>
	</span></a>
    <c:if test="${user != null}">
        <div id="bandHeadInfo_ShopStatus_UserPoints">
            <img src="/images/goldStarPic.png" alt="Caption" />
            <div id="bandHeadInfo_ShopStatus_UserPoints_Block">
                <p>Your points</p>
                <p><c:out value="${user.getPoints()}" /></p>
            </div>
        </div>
    </c:if>
    <a href="">
        <span class="grayIcon inlineMiddle fa fa-gift" style="position: relative">
            <div class="bandHeadInfo_ShopStatus_Number" id="bandHeadInfo_ShopStatus_Point">
                <c:out value="0" />
            </div>
        </span>
    </a>
</div>  
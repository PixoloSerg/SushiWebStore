<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="bandHeadInfo">	
    <a>
    <div class="bandHeadInfo_Element" id="bandHeadInfo_MenuBtn">
	
        <%@include file="floatMenu.jsp" %>
        
	<span class="inlineElement"></span>
	<span class="grayIcon inlineMiddle fa fa-bars"></span>
	<span class="inlineMiddle" id="bandHeadInfo_MenuBtn_Text">MENU</span>	
    </div>
    </a>
    <div class="bandHeadInfo_Element" id="bandHeadInfo_Phone">
	<span class="inlineElement"></span>
	<span class="grayIcon inlineMiddle fa fa-mobile-phone"></span>
	<div class="inlineMiddle">
            <div id="bandHeadInfo_Phone_Number"><c:out value="${location.getPhone()}" /></div>
	    <div id="bandHeadInfo_Phone_Shedule">${schedule}</div>
	</div>
    </div>
    <div class="bandHeadInfo_Element" id="bandHeadInfo_Map">
	<span class="inlineElement"></span>
	<span class="grayIcon inlineMiddle fa fa-map-marker"></span>
	<div class="inlineMiddle">
	    <div id="bandHeadInfo_Map_Text">Your city:</div>
	    <div id="bandHeadInfo_Map_City"><c:out value="${location.getCity()}" /></div>
	</div>
    </div>
        
    <c:if test="${user == null}">
        <div class="bandHeadInfo_Element" id="bandHeadInfo_UserTools">
            <span class="inlineElement"></span>
            <span class="grayIcon inlineMiddle fa fa-lock"></span>
            <div class="inlineMiddle" id="bandHeadInfo_UserTools_SignIn">
                <a id="signIn" href="">Sign in</a>/<a id="register" href="">Register</a>
            </div>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="bandHeadInfo_Element" id="bandHeadInfo_UserInfo">
            <span class="inlineElement"></span>
            <span class="grayIcon inlineMiddle fa fa-lock"></span>            
            <span class="inlineMiddle"><c:out value="${user.getName()}" /></span>
            <a class="inlineMiddle" id="bandHeadInfo_UserInfo_SignOut" href="">Sign out</a>            
        </div>
    </c:if>
        
    <%@include file="CartStatus_bandHead.jsp" %>
        
</div>
	
<div id="bandHeadBanner">
    <div id="bandHeadBanner_Content">
	<div id="bandHeadBanner_Content_Phone"><c:out value="${location.getPhone()}" /></div>
	<div id="bandHeadBanner_Content_Logo">
	    <a href="/">
	    </a>
	</div>
	<div id="bandHeadBanner_Content_Slogan"><p><c:out value="${shopInfo.getShopSlogan()}" /></p></div>    
    </div>
</div>

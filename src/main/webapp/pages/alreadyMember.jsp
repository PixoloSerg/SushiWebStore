<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="band_Offer">
    <div class="inlineMiddle">        
        <h1>${shopInfo.getOffer().getTitle()}</h1>
        <img id="bandGiftLogin_UnderPic" src="/images/wavePic.jpg" />
        <p>${shopInfo.getOffer().getText()}</p>
        <form action="${shopInfo.getOffer().getPageUrl()}" method="GET">
            <input type="submit" value="Want more!">
        </form>
    </div>
</div>

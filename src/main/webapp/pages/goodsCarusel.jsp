<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="goodsList" value="null"></c:set>
<c:set var="moveList" value="null"></c:set>
    
<c:if test="${bandId == 'bandPopular'}">
    <c:set var="goodsList" value="${popularGoods}"></c:set>
    <c:set var="moveList" value="popularCarousel"></c:set>
</c:if>
<c:if test="${bandId == 'bandSale'}">
    <c:set var="goodsList" value="${saleGoods}"></c:set>
    <c:set var="moveList" value="saleCarousel"></c:set>
</c:if>
<c:if test="${bandId == 'bandNew'}">
    <c:set var="goodsList" value="${newGoods}"></c:set>
    <c:set var="moveList" value="newCarousel"></c:set>
</c:if>
<c:if test="${bandId == 'bandRecommend'}">
    <c:set var="goodsList" value="${recommendGoods}"></c:set>
    <c:set var="moveList" value="recommendCarousel"></c:set>
</c:if>

<div class="bandGoodsCarusel" id="${bandId}">
    <div class="band_Content">
        <c:if test="${bandId == 'bandPopular' || bandId == 'bandNew' }">
            <div class="band_Content_Caption">        
                <span class="inlineMiddle"></span>
                <h1 class="inlineMiddle band_Content_Caption_Text">
                    ${bandId == 'bandPopular' ? shopInfo.getPopularBandTitle() : shopInfo.getNewBandTitle()}
                </h1>
                <span class="inlineMiddle"></span>
            </div>
        </c:if>
        <div class="band_Content_Goods">
	    <c:set var="ulId" value="${bandId}_GoodsList" ></c:set>
            <span class="band_Content_Goods_Nav moveBack" onclick="${moveList}('${ulId}',-1)">  </span>
            <ul id="${ulId}" >
                <c:forEach items="${goodsList}" var="item" varStatus="loop">                    
                        <c:if test="${bandId == 'bandPopular' 
                                      || bandId == 'bandNew' 
                                      || loop.getIndex() != 1 }" >
                            <li class="goodsCard_li ${loop.getIndex() < 3 ? 'visible' : 'hide'} fade">                 
                                <%@include file="/pages/goodsCard.jsp" %>
                            </li>
                        </c:if>
                        <c:if test="${bandId == 'bandRecommend' && loop.getIndex() == 1}" >
                            <li class="goodsCard_li steady">
                                <%@include file="caruselBlock.jsp" %>
                            </li>
                        </c:if>
                        <c:if test="${bandId == 'bandSale' && loop.getIndex() == 1}" >
                            <li class="goodsCard_li steady">
                                <%@include file="caruselBlock.jsp" %>
                            </li>
                        </c:if>
                    
                </c:forEach>
            </ul>
            <span class="band_Content_Goods_Nav moveForward" onclick="${moveList}('${ulId}',1)">  </span>
        </div>        
    </div>
</div>
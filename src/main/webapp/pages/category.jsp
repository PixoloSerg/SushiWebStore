<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="generalHead.jsp" %>
        <title>${category.getCategoryName()}</title>
    </head>
    <body>
        <%@include file="/pages/head.jsp" %>
	
        <div id="bandCategoryBody">
                <div id="bandCategoryBody_Content">

                        <div id="bandCategoryBody_Content_Data_Goods" class="inlineMiddle">
                            <div id="bandCategoryBody_Content_Caption">
                                <h1>${category.getCategoryName()}</h1>
                            </div>
                            <ul>
                                <c:forEach items="${goodsList}" var="item">
                                    <li class="goodsCard_li">
                                        <%@include file="/pages/goodsCard.jsp" %>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="bandCategoryBody_Content_Data_Order" class="inlineMiddle">
                            <div id="bandCategoryBody_Content_Data_Order_Block">
                                <%@include file="orderColumn.jsp" %>       
                            </div>
                        </div>                                
                </div>                    
        </div>
                
        <c:set var="bandCaption" value="POPULAR"></c:set>
        <c:set var="bandId" value="bandPopular"></c:set>
        <%@include file="/pages/goodsCarusel.jsp" %>
        <%@include file="/pages/footer.jsp" %>
    </body>
</html>

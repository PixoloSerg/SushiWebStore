<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a>                            
    <div class="goodsCard_Pic">                    
        <img class="goodsCard_Pic_Image" src="${item.getImages()}" alt="Caption" />
        <img class="goodsCard_Pic_Tools_CartIcon" src="/images/goodsToolsCartIcon.png" alt="cart" 
	     onclick="addGoods(this, ${item.getId()})"></img> 
        
        <div class="goodsCard_Pic_Tools_CountBlock">
                <img class="goodsCard_Pic_Tools_AddBtn" src="/images/addBtn.png" alt="cart"
		     onclick="changeCount(this, 1)"></img>
                <div class="goodsCard_Pic_Tools_InpCount">1</div>
                <img class="goodsCard_Pic_Tools_DelBtn" src="/images/delBtn.png" alt="cart"
		     onclick="changeCount(this)"></img>            
        </div>
    </div>
</a>
<div class="goodsCard_Descr">
    <p class="goodsCard_Descr_Name">
        <c:out value="${item.getDescription()}" />
    </p>
    <div>
        <p class="goodsCard_Descr_Points">
            <c:out value="${item.getPoint()}" />
        </p>
        <p class="goodsCard_Descr_Price">
            <c:out value="${item.getPrice()}" /><span class="fa fa-rub"></span>
        </p>
    </div>
</div>
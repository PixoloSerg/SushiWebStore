<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="band_Content_Goods_Block">
    <span class="band_Content_Goods_Block_HeadPic"></span>
    <h1 class="band_Content_Goods_Block_Title">
        ${bandId == 'bandRecommend'? 
          shopInfo.getRecommendBlock().getTitle() 
          : shopInfo.getSaleBlock().getTitle()}        
    </h1>
    <img class="band_Content_Goods_Block_Wave" src="/images/wavePic.jpg" alt="Caption" />
    <p class="band_Content_Goods_Block_Msg">
        ${bandId == 'bandRecommend'? 
          shopInfo.getRecommendBlock().getText() 
          : shopInfo.getSaleBlock().getText()}        
    </p>
    <form method="GET" action="">
        <input type="submit" value="Want more!">
    </form>
</div>
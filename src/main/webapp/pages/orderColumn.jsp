<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        
<h1><span class="grayIcon fa fa-shopping-basket fa-fw"></span>Your order</h1>

<c:if test="${shopCart.getLineItems().size() != 0}" var="notEmpty">
    <table id="orderColumn_LineItems_Block">
        <c:forEach var="item" items="${shopCart.getLineItems()}" varStatus="loop">
            <tr>
                <td>
                    <div class="Order_LineItems_Block_Line">
                        <p class="lineItem_GoodsName inlineMiddle">
                            ${item.getGoods().getGoodsName()}
                        </p>
                        <p class="lineItem_GoodsPrice decimalValue inlineMiddle">
                            ${item.getGoods().getPrice()}<span class="fa fa-rub"></span>
                        </p>

                    </div>					    
                    <div class="Order_LineItems_Block_Line">
                        <div class="lineItem_GoodsQnt inlineMiddle">
                            <div class="lineItem_GoodsQnt_Btn inlineMiddle" 
                                onclick="changeItemCount(${item.getLineItem().getId()}, this)">-</div>
			    <div class="lineItem_GoodsQnt_Value inlineMiddle">${item.getLineItem().getAmount()}</div>
                            <div class="lineItem_GoodsQnt_Btn inlineMiddle"
                                 onclick="changeItemCount(${item.getLineItem().getId()}, this, 1)">+</div>
                        </div>
                        <p class="lineItem_GoodsSum decimalValue inlineMiddle">
                            ${item.getLineItem().getSumm()}<span class="fa fa-rub"></span>
                        </p>
                    </div>
                        
                        <div class="Order_LineItems_Block_Line_Number">
                            ${loop.getIndex() + 1}
                        </div>       
                        <div class="Order_LineItems_Block_Line_DelItem" onclick="deleteItem(${item.getLineItem().getId()}, this)">
                            <span class="fa fa-times"></span>
                        </div>                           
                        
                </td>
            </tr>
        </c:forEach>
            <tr>
                <td>
                    <p class="invoice_TotalSum decimalValue">
                        Total: <span>${shopCart.getInvoice().getInvoice().getTotalSum()}</span><span class="fa fa-rub"></span>
                    </p>
                <td>
            </tr>
    </table>
</c:if>
<c:if test="${!notEmpty}" >
    <p class="cartMsg">There is no items yet</p>
</c:if>
<form action="" method="POST">
    <input type="text" name="phoneNumber" placeholder="Your phone number" required>
    <input type="text" name="clientName" placeholder="Your name">
    <input type="text" name="orderStreet" placeholder="Street">
    <input type="text" name="orderHouseNumber" placeholder="House">
    <input type="text" name="orderAppartmentNumber" placeholder="Appartment">
    <input type="submit" value="Purchase">
</form>

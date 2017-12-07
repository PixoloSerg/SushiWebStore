<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="menuOverlay">

    <div id="floatMenuContent" class="fadeFloatManu">
        <div id="floatMenuContent_MenuItems">
            <div id="floatMenuContent_MenuItemsCaption">
		<div></div>
		<h1>Menu</h1>
		<div></div>
	    </div>
            <table id="floatMenuContent_MenuItemsTable">
                <c:forEach begin="0" end="3" varStatus="extLoop">
                    <tr>
                        <c:forEach begin="0" end="2" varStatus="intLoop">
                            <c:set var="idx" value="${intLoop.getIndex() + 3 * extLoop.getIndex()}" ></c:set>                            
                                <td>
                                    <c:if test="${idx < visibleCategories.size()}">
					<c:set var="item" value="${visibleCategories.get(idx)}"></c:set>
					<%@include file="/pages/menuItem.jsp" %>
                                    </c:if>
                                </td>                            
                        </c:forEach>
                    </tr>			
                </c:forEach>
            </table>
        </div>	
    </div>

</div>

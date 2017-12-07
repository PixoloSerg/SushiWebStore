<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <a class="menuItem" href="/category?id=${item.getId()}"> 
	<div>
	    <img src="${item.getIcon()}" alt="Caption" />                                    
	    <p>${item.getCategoryName()}</p>                            
	</div>
    </a>

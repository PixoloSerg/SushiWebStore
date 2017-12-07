<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/styles/main.css" />
	<link rel="stylesheet" 
	      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>${pageTitle}</title>
    </head>
    <body>
        <%@include file="head.jsp" %>
        
        <div id="band_About_Banner">
            <h1><c:out value="${shopInfo.getAbout().getTitle()}" /> </h1>
        </div>
        <div id="band_About_Msg">
            <div id="band_About_Msg_Content">
                <h1 id="band_About_Msg_Content_Title">SUSHI STORE</h1>
                <img src="/images/wavePic.jpg" alt="Caption" />
                <p id="band_About_Msg_Content_Text">
                    Need some text here.Need some text here.Need some text here.
                    Need some text here.Need some text here.Need some text here.
                    Need some text here.Need some text here.Need some text here.
                    Need some text here.Need some text here.Need some text here.
                    Need some text here.Need some text here.Need some text here.
                    Need some text here.Need some text here.Need some text here.
                </p>
            </div>
            <div id="band_About_Msg_Support">
                <div class="band_About_Msg_Support_Content">
                    <img src="/images/starsPic.jpg" alt="Caption" />
                    <h2 id="band_About_Msg_Support_Title">Support service and quality control</h2>
                    <img src="/images/wavePic.jpg" alt="Caption" />
                    <p id="band_About_Msg_Support_Phone"><c:out value="${shopInfo.getAbout().getServicePhone()}"/></p>
                    <p id="band_About_Msg_Support_Working"></p>
                </div>
            </div>
        </div>
            
        <%@include file="menu.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="bandContactForm">
    <div id="bandContactForm_Content">
        <img id="bandContactForm_Content_HeadPic" src="/images/giftPic.jpg" />
        <h1 id="bandContactForm_Content_Title">Contact to us</h1>
        <img id="bandContactForm_Content_UnderPic" src="/images/wavePic.jpg" />
        <form action="" method="POST">
            <div>
                <input type="text" placeholder="Your name"/>            
            </div>
            <div>
                <input type="text" placeholder="Enter your telephone number"/>
            </div>            
            <div>
                <input type="email" placeholder="Enter your telephone number"/>
            </div>
            <div>
                <input type="text" placeholder="Leave here your message" >
            </div>
            <div>
                <input type="checkbox">
                I confirm to proccess my data
            </div>
            <div>
                <input type="submit" value="Send">
            </div>            
        </form>
    </div>
</div>

<%-- 
    Document   : checkout
    Created on : Oct 28, 2018, 9:31:40 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!-- Website template by techcomsoft.vn -->
<html>

    <!-- Mirrored from www.techcomsoft.vn/websites/124/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:38 GMT -->
    <head>
        <meta charset="UTF-8">
        <title>Checkout - RubberNLaces Website Template</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style>
            #txtfield
            {
                width: 50px;
            }
            .plus .minus
            {
                text-decoration: none;
               
            }

        </style>
    </head>
    <body>
        <div id="background">
            <div id="page">
                <div id="header">
                    <div id="logo">
                        <a href="register.html"><img src="images/logo.png" alt="LOGO"></a>
                    </div>
                    <div id="navigation">
                        <ul id="primary">
                            <li class="selected">
                                <s:a href="home">Home</s:a>
                                </li>

                                <li>
                                <s:a href="men">Men</s:a>
                                </li>
                                <li>
                                <s:a href="women">Women</s:a>
                                </li>
                                <li>
                                <s:a href="sale">Sale</s:a>
                                </li>
                                <li class="highlight">
                                <s:a href="faq">Faq</s:a>
                                </li>
                            </ul>
                            <ul id="secondary">
                                <li>
                                <s:a href="checkout">Checkout</s:a>
                                </li>
                                <li>
                                <s:a href="login">Home</s:a> | <s:a href="signup">SignUp</s:a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div id="contents">
                        <div id="checkout">
                            <h4><span>Checkout</span></h4>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Order No <s:property value="#session.CURRENTORDER.orderId"/></th>
                                        <th>Quantity</th>
                                        <th>Size</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <s:form theme="simple">
                                    <s:iterator var="dto" value="listCart">
                                        <s:url action="minus" var="minus"> 
                                            <s:param name="quantity" value="%{#dto.quantity}"/>
                                              <s:param name="bootId" value="%{#dto.productId}"/>
                                        </s:url>
                                         <s:url action="plus" var="plus"> 
                                            <s:param name="quantity" value="%{#dto.quantity}"/>
                                              <s:param name="bootId" value="%{#dto.productId}"/>
                                        </s:url>
                                            <s:url action="deleteCart" var="delete"> 
                                            <s:param name="bootId" value="%{#dto.productId}"/>
                                        </s:url>
                                        <tr>
                                            <td> <img src="<%request.getContextPath();%>images/<s:property value="%{#dto.picture}"/>" alt="Img">
                                                <b><s:property value="%{#dto.productName}"/></b>
                                                <p>
                                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                    Nullam venenatis cursus gravida. Suspendisse ut ligula tristique velit 

                                                </p></td>
                                            <td>
                                                <s:textfield  value="%{#dto.quantity}" id="txtfield" readonly="true"/> 
                                            <s:a href="%{plus}" class="plus">+</s:a>
                                             <s:a href="%{minus}" class="minus">-</s:a>
                                            </td>
                                            <td>
                                                <s:textfield value="%{#dto.sizeName}" id="txtfield" readonly="true"/></td>
                                            <td class="last"><div>
                                                    $<s:property value="%{#dto.price*#dto.quantity}"/> <s:a href="%{delete}">Delete</s:a>
                                                </div></td>



                                        </tr>  
                                    </s:iterator>
                                </s:form>
                            </tbody>
                        </table>
                            
                                <s:if test="#session.ERRORCHECKOUT != null">
                                             <span color="red">
                                                 <s:property value="#session.ERRORCHECKOUT"/>
                                        </span>
                                        </s:if>
                        <a href="checkout" class="proceed-btn">Proceed to Checkout</a>
                    </div>
                </div>
                <div id="footer">
                    <div class="background">
                        <div id="connect">
                            <h5>Get Social With us!</h5>
                            <ul>
                                <li>
                                    <a href="http://techcomsoft.vn/go/facebook/" target="_blank" class="facebook"></a>
                                </li>
                                <li>
                                    <a href="http://techcomsoft.vn/go/twitter/" target="_blank" class="twitter"></a>
                                </li>
                                <li>
                                    <a href="http://www.techcomsoft.vn/go/googleplus/" target="_blank" class="linkin"></a>
                                </li>
                            </ul>
                        </div>
                        <ul class="navigation">
                            <li>
                                <h5>Mens</h5>
                                <a href="mens.html">Sneakers</a> <a href="mens.html">Boots</a> <a href="mens.html">Winter socks</a> <a href="mens.html">Lace-ups</a>
                            </li>
                            <li>
                                <h5>Womens</h5>
                                <a href="womens.html">Sneakers</a> <a href="womens.html">Boots</a> <a href="womens.html">Winter socks</a> <a href="womens.html">Lace-ups</a>
                            </li>
                            <li class="latest">
                                <h5>New Arrivals</h5>
                                <a href="new.html">Cheverlyn Zespax</a> <a href="new.html">Alta Ulterior</a> <a href="new.html">Mikee</a> <a href="new.html">Jeeroks Copy</a>
                            </li>
                            <li class="latest">
                                <h5>On Sale Items</h5>
                                <a href="sale.html">Cheverlyn Zespax</a> <a href="sale.html">Alta Ulterior</a> <a href="sale.html">Mikee</a> <a href="sale.html">Jeeroks Copy</a>
                            </li>
                        </ul>
                        <p class="footnote">
                            &copy; Copyirght &copy; 2011. <a href="register.html">Company name</a> all rights reserved.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <!-- Mirrored from www.techcomsoft.vn/websites/124/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:38 GMT -->
</html>

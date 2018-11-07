<%-- 
    Document   : search
    Created on : Oct 27, 2018, 11:51:25 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!-- Website template by techcomsoft.vn -->
<html>

<!-- Mirrored from www.techcomsoft.vn/websites/124/new.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:37 GMT -->
<head>
	<meta charset="UTF-8">
	<title>New Arrivals - RubberNLaces Website Template</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
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
						<li>
							<a href="register.html">Home</a>
						</li>
						<li class="selected">
							<a href="new.html">New Arrivals</a>
						</li>
						<li>
							<a href="mens.html">Mens</a>
						</li>
						<li>
							<a href="womens.html">Womens</a>
						</li>
						<li>
							<a href="faq.html">Faq</a>
						</li>
						<li class="highlight">
							<a href="sale.html">Sale Items</a>
						</li>
					</ul>
					<ul id="secondary">
						<li>
							<a href="checkout.html">Cart</a>
						</li>
						<li>
							<a href="register.html">Login</a> | <a href="register.html">Signup</a>
						</li>
					</ul>
				</div>
			</div>
			<div id="contents">
				
				<div class="footer">
					<h4><span>Top Search</span></h4>
                                       
					<ul class="items">
                                              <s:if test="listProduct.size == 0">
                                                <li>
                                                    Result Not Found
                                                </li>
                                            </s:if>
                                        
                                               <s:if test="listProduct != null">
                                            
                                      
                                            <s:iterator var="dto" value="listProduct">
                                             
                                                        <s:url action="detailProduct" var="detail"> 
                                                            <s:param name="bootId" value="%{#dto.Id}"/>
                                                        </s:url>
                                
							    <li>
                                                            <s:a href="%{detail}"> <img src="<%request.getContextPath();%>images/<s:property value="%{#dto.picture}"/>" alt="Img">
                                                                <span>$<s:property value="%{#dto.price}"/></span> 
                                                               <s:property value="%{#dto.name}"/> </s:a>
							</li>
						
                                                            </s:iterator>
                                                              </s:if>
                                                  
					
					</ul>
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

<!-- Mirrored from www.techcomsoft.vn/websites/124/new.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:38 GMT -->
</html>

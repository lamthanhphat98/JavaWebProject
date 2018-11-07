<%-- 
    Document   : index
    Created on : Oct 27, 2018, 10:42:43 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!-- Website template by techcomsoft.vn -->
<html>

<!-- Mirrored from www.techcomsoft.vn/websites/124/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:11 GMT -->
<head>
	<meta charset="UTF-8">
	<title>RubberNLaces Website Template</title>
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
                                        <s:if test="#session.CURRENTUSER == null">
                                            
                                    
						<li>
							<s:a href="viewCart">Checkout</s:a>
						</li>
						<li>
							<s:a href="login">Login</s:a> | <s:a href="signup">SignUp</s:a>
						</li>
                                                    </s:if>
                                                   <s:if test="#session.CURRENTUSER != null">
                                            
                                    
						<li>
							<s:a href="viewCart">Checkout</s:a>
						</li>
						<li>
							<s:a href="logout">Logout</s:a>
						</li>
                                                    </s:if>
					</ul>
				</div>
			</div>
			<div id="contents">
				<div id="adbox">
					<div id="search">
						<h3>Quick Search</h3>
						<p>
							Lorem ipsum dolor sit amet, consec tetur adipiscing elit, Praesent diam odio, commodo vittae sagittis vel,
						</p>
						<s:form action="searchBySelect" method="post">
							<ul>
								<li>
                                                                    <s:select name="selectSize" headerKey="-1" listKey="sizeId" listValue="sizeName" headerValue="Select Size" list="listSize">
                                                                        
                                                                    </s:select>
								</li>
								<li>
									<s:select name="selectColor" headerKey="-1" headerValue="Select Color" list="listColor" listKey="colorId" listValue="colorName">
                                                                               </s:select>
								</li>
                                                                <input type="submit" value="Find My Pair!" class="button">
							
							</ul>
							
						</s:form>
					</div>
					<img src="images/shop-now.jpg" height="355" width="618" alt="Promo"> <a href="home" class="button"></a> <span></span>
				</div>
				<div id="main">
                                    <div id="new">
						<h4><span>New Arrivals</span></h4>
						<ul class="items">
                                                    <s:iterator var="dto" value="newArrivals">
                                                        <s:url action="detailProduct" var="detail"> 
                                                            <s:param name="bootId" value="%{#dto.Id}"/>
                                                        </s:url>
                                                        <li>
                                                            <s:a href="%{detail}"> <img src="<%request.getContextPath();%>images/<s:property value="%{#dto.picture}"/>" alt="Img">
                                                                <span>$<s:property value="%{#dto.price}"/></span> 
                                                               <s:property value="%{#dto.name}"/> </s:a>
							</li>
                                                    </s:iterator>
							
							
						</ul>
					</div>
					
					<div id="sale">
						<h4><span>Sale Items</span></h4>
						<ul class="items">
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
							
							
						</ul>
					</div>
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

<!-- Mirrored from www.techcomsoft.vn/websites/124/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:16 GMT -->
</html>

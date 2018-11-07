<%-- 
    Document   : product
    Created on : Oct 27, 2018, 11:13:32 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!-- Website template by techcomsoft.vn -->
<html>

<!-- Mirrored from www.techcomsoft.vn/websites/124/product.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:38 GMT -->
<head>
	<meta charset="UTF-8">
	<title>Product - RubberNLaces Website Template</title>
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
				<div id="product">
                                    <s:iterator var="dto" value="listProduct">
                                        
                                   
					<div class="section">
						
						<div>
							 <img src="<%request.getContextPath();%>images/<s:property value="%{#dto.picture}"/>" alt="Img">
						</div>
					</div>
					<div class="section">
						<h2><span>$<s:property value="%{#dto.price}"/></span><s:property value="%{#dto.name}"/></h2>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam venenatis cursus gravida. 
                                                        Suspendisse ut ligula tristique velit blandit vel sit amet ipsum. Nam accumsan turpis id 
                                                        mauris fermentum pharetra. Cras interdum, risus et dictum bibendum, arcu tellus convallis libero, 
                                                        quis placerat urna erat et lorem. Phasellus inter dum turpis vestibulum ligula varius sit amet ultricies m
                                                        assa vulputate. Morbis vehicula, velit a faucibus cursus, turpis magna mattis mi, in ultrices totor nibh eu dui. 
                                                        Nam at ipsum in urna convallis accumsan. Nullam at
						</p>
						<form action="addToCart" method="post">
						<li>
                                                                    <s:select name="selectSize" headerKey="-1" listKey="sizeName" listValue="sizeName" headerValue="Select Size" list="listSize">                                                      
                                                                    </s:select>
                                                    <s:if test="#session.ERROR != null">
                                                        <span color="red">
                                                            <s:property value="#session.ERROR"/>
                                                        </span> 
                                                                    </s:if>
								</li>
                                                                   <s:hidden name="bootId" value="%{#dto.id}"/>
                                                                <s:hidden name="price" value="%{#dto.price}"/>
                                                                 <s:hidden name="picture" value="%{#dto.picture}"/>
                                                                    <s:hidden name="name" value="%{#dto.name}"/>
							<input type="submit" value="Add to Cart" class="btn-cart">
						
						</form>
					</div>
                                                         </s:iterator>
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

<!-- Mirrored from www.techcomsoft.vn/websites/124/product.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 27 Oct 2018 14:05:40 GMT -->
</html>

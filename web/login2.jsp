<%-- 
    Document   : login2
    Created on : Oct 28, 2018, 6:17:21 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
              <div class="form-bottom">
                                <s:form role="form" action="loginUser" method="post" class="login-form" theme="simple">
                                    <div class="form-group">
                                        <label class="sr-only" for="form-username">Username</label>
                                        <s:textfield name="txtUsername" placeholder="username.." class="form-first-name form-control" id="form-first-name"/>

                                        <!--<input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">-->
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="form-password">Password</label>
                                        <s:textfield name="txtPassword" type="password" placeholder="password.." class="form-first-name form-control" id="form-first-name"/>
                                        <!--<input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">-->
                                    </div>
                                        <input type="submit" value="Login in"/>
                                </s:form>
                                          <s:if test="#session.ERRORLOGIN != null">
                                             <span color="red">
                                                 <s:property value="#session.ERRORLOGIN"/>
                                        </span>
                                        </s:if>
                            </div>
    </body>
</html>

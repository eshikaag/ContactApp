<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login - Contact Application </title>
      <!-- <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/> --> 
         <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css" />" />
         
    </head>
   <!-- <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body background="${url_bg}"> --> 
        <table border="1">
            <tr>
                <td height="80px">
                    <%-- Header --%>
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Menu --%>
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                  
                    <c:if test="${err!=null}">
                        <p class="error"><c:out value = "${err}"/></p>
                    </c:if>
                    
                    
                     <c:if test="${param.act eq 'lo'}">
     <p class="success">Logout Successfully! Thanks for using contact application.</p>
                    </c:if>
                    <c:if test="${param.act eq 'reg'}">
     <p class="success">USER REGISTERED SUCESSFULLY.PLEASE LOGIN!.</p>
                    </c:if>
                    <h3>User Login</h3>
  
                <!--  <s:url var="url_login"  value="/login"/> -->  
                    
                    <f:form action="/Mavenfirst/login" method="POST" modelAttribute="command">
             
                    
                        <table border="1">
                            <tr>
                                <td>Username</td>
                                <td><f:input path="loginName" /> </td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><f:password path="password" /> </td>
                            </tr>
                            <tr>                                
                                <td colspan="2" align="right">
                                    <button>Login</button> <br/>
                                    <a href="#">New User Registration</a>
                                </td>
                            </tr>
                        </table>
                    </f:form>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
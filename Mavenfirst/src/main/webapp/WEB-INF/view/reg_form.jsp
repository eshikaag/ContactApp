<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registratiopn - Contact Application </title>
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
                    
                    
                     <
                    <h3>User Registration</h3>
  
                <!--  <s:url var="url_login"  value="/login"/> -->  
                    
                    <f:form action="/Mavenfirst/register" method="POST" modelAttribute="command">
             
                    
                        <table border="1">
                            <tr>
                                <td>Username</td>
                                <td><f:input path="user.loginName" /> </td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><f:password path="user.password" /> </td>
                            </tr>
                            
                            
                             <tr>
                                <td>Name</td>
                                <td><f:input path="user.name" /> </td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><f:input path="user.phone" /> </td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="user.email" /> </td>
                            </tr>
                              <tr>
                                <td>Address</td>
                                <td><f:textarea path="user.address" /> </td>
                            </tr>
                            
                            <tr>                                
                                <td colspan="2" align="right">
                                    <button>Submit</button> <br/>
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
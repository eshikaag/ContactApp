<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css"   />  
<!-- <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>-->
</head>
<!-- <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body background="${url_bg}">-->
<table border="1" width="80%" align="center">
<tr>

<td height="80px">
<%--header --%>
                    <jsp:include page="include/header.jsp"/>
</td>
</tr>
<tr>

<td height="100px">
<%--Menu --%>
                    <jsp:include page="include/menu.jsp"/>

</td>
</tr>
<tr>

<td height="350px" valign="top">
<%--page content --%>
<h1>Contact List</h1>
 <c:if test="${param.act eq 'sv'}">
                        <p class="success">Contact Saved Successfully</p>
                    </c:if>
                    
                    
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Contact Deleted Successfully</p>
                    </c:if>
                    
                   
          <table width="100%">
                        <tr>
                            <td align="right" >
                                <form action="<s:url value="/user/contact_search"/>">
                                    <input type="text" name="freeText" value="${param.freeText}">
                                    <button>Find</button>
                                </form>
                            </td>                           
                        </tr>
                    </table>
                    
                
                    
                               
 <table border="1" cellpadding="3"  width="100%">
                            <tr>
                                <th>SELECT</th>
                                <th>CID</th>
                                <th>NAME</th>
                                <th>PHONE</th>
                                <th>EMAIL</th>
                                <th>ADDRESS</th>
                                <th>REMARK</th>
                                <th>ACTION</th>
                                <c:if test="${empty contactList}">
                                <tr>
                                    <td align="center" colspan="8" class="error">No Records Present</td>
                                </tr>
                            </c:if>
                                
                            </tr>
                    <c:forEach var="ct" items="${contactList}" varStatus="st">
                                <tr>
                                
            <td>${st.count}</td>  
                                    <td><c:out value = "${ct.contactid}"/></td>
                                    <td><c:out value = "${ct.name}"/></td>
                                    <td><c:out value = "${ct.phone}"/></td>
                                    <td><c:out value = "${ct.email}"/></td>
                                    <td><c:out value = "${ct.address}"/></td>
                                    <td><c:out value = "${ct.remark}"/></td>
                                    
                    <c:url value="/user/del_contact" var="url_del">  
 <c:param name="cid" value="${ct.contactid}"/>  
 </c:url>     
 
 <c:url value="/user/edit_contact" var="url_edit">  
 <c:param name="cid" value="${ct.contactid}"/>  
 </c:url>  
 <td><a href='<c:out value="${url_edit}"/>'>EDIT</a>|<a href='<c:out value="${url_del}"/>'>Delete</a></td>

 <!-- <s:url var="url_del" value="/user/del_contact">
                                        <s:param name="cid" value="${c.contactId}"/>
                                    </s:url>  -->  
 <!--<td><a href="/user/del_contact?cid=${ct.contactid}">Delete</a></td>  NPOT WPORKING HERE-->

                <!-- NPOT WPORKING IN JSTL 1.0 VERSION     <td>EDIT| <a href="<c:url value="/user/del_contact"/>">Delete</a> </td>--> 
                    </tr> 
                            </c:forEach>
                        </table>   
</td>
</tr>

<tr>

<td height="50px">
<%--footer --%>
  <jsp:include page="include/footer.jsp"/>

</td>
</tr>
</table>
</body>
</html>
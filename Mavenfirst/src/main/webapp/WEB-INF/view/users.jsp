<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
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
<h1> List of users</h1>
<table border="1">
                        <tr>
                            <th>SR</th>
                            <th>USER ID</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>USERNAME</th>
                            <th>STATUS</th>
                        </tr>
                        <c:forEach var="u" items="${userList}" varStatus="st">
                            <tr>
                                <td>${st.count}</td>
                                
                                <td><c:out value = "${u.userId}"/></td>
                                
                                
                                
                                
                                
                                <td><c:out value = "${u.name}"/></td>
                                <td><c:out value = "${u.phone}"/></td>
                                <td><c:out value = "${u.email}"/></td>
                                <td><c:out value = "${u.address}"/></td>
                                <td><c:out value = "${u.loginName}"/></td>
                                <td><c:out value = "${u.loginStatus}"/></td>
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
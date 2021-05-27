
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!--  <s:url var="url_logout" value="/logout"/>-->

<c:if test="${sessionScope.userId==null}">
    <%-- User is not yet logged in : Guest Menu --%>
        <a href="#">Home</a> | <a href="#">Login</a> | <a href="<c:url value="/reg_form"/>">Register</a> | <a href="#">About</a> | <a href="#">Help</a>   
    </c:if>
    <c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
    <%-- Admin is logged in : Admin Menu --%>    
    <a href="#">Home</a> |  <a href="<c:url value="/admin/users"/>">User List</a> | <a href="${url_logout}">Logout</a> 
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
    <%-- General User is logged in : User Menu --%>
   
    <a href="<c:url value="/user/dashboard"/>">Home</a> | <a href="<c:url value="/user/contact_form"/>">Add Contact</a> | <a href="<c:url value="/user/clist"/>">Contact List</a> |     <a href="<c:url value="/logout"/>">logout</a>
 
</c:if>


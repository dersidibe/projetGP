<%-- 
    Document   : memberFound
    Created on : Jul 23, 2015, 9:44:14 PM
    Author     : lion
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h3 class="star"><span>Membres trouvé</span></h3>
<div class="clr"></div>
<ul class="ex_menu">
    <c:choose>
        <c:when test="${membersFound != null}">
            <c:forEach var="member" items="${membersFound}">
                <li><a href="http://www.dreamtemplate.com/">${member.username}</a><br>
                    Promotion: ${member.promotion} Email:${member.nationality}
                </li>
            </c:forEach>
        </c:when>
    </c:choose> 
</ul>

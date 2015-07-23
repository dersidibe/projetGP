<%-- 
    Document   : event_next_page
    Created on : Jul 24, 2015, 12:24:35 AM
    Author     : lion
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:forEach var="event" items="${events}">
    <div class="article">
        <h2><span>${event.title}</span></h2>
        <p class="infopost">Posté le 
            <span class="date">
                <c:choose>
                    <c:when test="${event.modifiedDate != null}">
                        ${event.modifiedDate}
                    </c:when>
                    <c:otherwise>
                        ${event.createdDate}
                    </c:otherwise>
                </c:choose>
            </span> 
            par <a href="#">${event.account.username}</a> 
            <c:choose>
                <c:when test="${sessionScope.current_account != null && sessionScope.current_account.username == event.account.username}">
                    &nbsp;&nbsp;&bull;&nbsp;&nbsp;Faire <a href="javascript: editEvent(${event.idEvent})">Edition</a> 
                </c:when>
            </c:choose>
            <a href="#" class="com">Comments 
                <span>11</span></a></p>
        <div class="clr"></div>
        <div class="img"><img src="images/event/${event.image}" width="630" height="221" alt="" class="fl" /></div>
        <div class="post_content">
            <p>${event.content}</p>
            <p class="spec"><a href="#" class="rm">Savoir plus &raquo;</a></p>
        </div>
        <div class="clr"></div>
    </div>
</c:forEach>
<p class="pages"><small>Page ${currentPage} de ${numberOfPages}</small>
    <c:choose>
        <c:when test="${currentPage > 1}">
            <a href="javascript: nextPage(${currentPage - 1})">${currentPage - 1}</a>
        </c:when>
    </c:choose>
    <span>${currentPage}</span> 
    <c:choose>
        <c:when test="${currentPage < numberOfPages}">
            <a href="javascript: nextPage(${currentPage + 1})">${currentPage + 1}</a> 
        </c:when>
    </c:choose>
    <a href="#">&raquo;</a></p>

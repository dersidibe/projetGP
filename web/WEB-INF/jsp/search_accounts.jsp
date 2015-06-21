<%-- 
    Document   : search_accounts
    Created on : Jun 21, 2015, 8:43:14 PM
    Author     : lion
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2 align="center">Les anciens de l'IFI</h2><br><br>
<c:forEach var="account" items="${search_accounts}">
    <div class="article">
        <p class="infopost">
            <a href="#">Name : ${account.username}</a> 
            <a href="#">Promotion : ${account.promotion}</a> 
            <span class="date">Email: ${account.email}</span> 
            <a href="account/edit_account.htm?idAccount=${account.idAccount}" class="com">Edit</a>
        </p>
        <div class="clr"></div>
        <div class="img"><img src="images/event/${account.image}" width="630" height="221" alt="" class="fl" /></div>
        <div class="post_content">
        </div>
        <div class="clr"></div>
    </div>
</c:forEach>
<p class="pages"><small>Page 1 de 2</small> <span>1</span>
    <a href="#">2</a> 
    <a href="#">2</a> 
    <a href="#">2</a> 
    <a href="#">2</a> 
    <a href="#">&raquo;</a></p>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="article">
    <h2><span>Login</span></h2>
    <div class="clr"></div>
    <form:form action="welcome.htm" method="post" commandName="account">
        Username :
        <form:input path="username"></form:input>
        Password :
        <form:password path="password"></form:password>
            <input type="submit" value="Login"/>
    </form:form>
</div>
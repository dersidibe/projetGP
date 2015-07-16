<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    function validateLoginForm() {
        if ($("#login_username").val() === null || $("#login_username").val() === "") {
            return false;
        }
        if ($("#login_pwd").val() === null || $("#login_pwd").val() === "") {
            return false;
        }
        return true;
    }
</script>
<div class="article">
    <h2><span>Login</span></h2>
    <div class="clr"></div>
    <form:form id="login_form" action="welcome.htm" method="post" 
               commandName="account" onsubmit="return validateLoginForm()">
        Username :
        <form:input id="login_username" path="username"></form:input>
            Password :
        <form:password id="login_pwd" path="password"></form:password>
            <input type="submit" value="Login"/>
    </form:form>
</div>
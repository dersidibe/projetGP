<%-- 
    Document   : redirect_index
    Created on : Jun 10, 2015, 7:48:10 PM
    Author     : lion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect(request.getContextPath() + "/index.htm"); %>

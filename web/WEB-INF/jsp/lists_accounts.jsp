<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<script>
    function search()
    {
        var searchInfo = $("#editbox_search").val();
        if (searchInfo === null || searchInfo === "")
            searchInfo = "";
        $.ajax({url: "account/search_accounts.htm?searchInfo=" + searchInfo, success: function (result) {
                $(".mainbar").html(result);
            }});
        return;
    }

    function nextPage(page) {
        $.ajax({url: "account/next_page.htm?page=" + page, success: function (result) {
                $(".mainbar").html(result);
            }});
        return;
    }
    
    function editAccount(idAccount) {
        $.ajax({url: "account/edit_account.htm?idAccount=" + idAccount, success: function (result) {
                $(".mainbar").html(result);
            }});
        return;
    }
</script>
    <c:forEach var="account" items="${subAccounts}">
        <div class="article">
            <p class="infopost">
                <a href="#">Name : ${account.username}</a> 
                <a href="#">Promotion : ${account.promotion}</a> 
                <span class="date">Email: ${account.email} ${account.image}</span> 
                <a href="javascript: editAccount(${account.idAccount})" class="com">Edit</a>
            </p>
            <div class="clr"></div>
            <div class="img"><img src="images/account/${account.image}" width="630" height="221" alt="" class="fl" /></div>
            <div class="post_content">
            </div>
            <div class="clr"></div>
        </div>
    </c:forEach>
    <p class="pages"><small>Page ${currentPage} de ${numberPages}</small>
        <c:forEach var="i" begin="1" end="${numberPages}" step="1">
            <c:choose>
                <c:when test="${i == currentPage}">
                    <span>${i}</span>
                </c:when>
                <c:otherwise>
                    <a class="nextPage" HREF="javascript:nextPage(${i-1})">${i}</a> 
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <a href="#">&raquo;</a>
    </p>
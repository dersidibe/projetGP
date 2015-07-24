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

    function searchDetail()
    {
        var searchInfoNom = $("#editbox_search_nom").val();
        var searchInfoPromotion = $("#editbox_search_promotion").val();
        var searchInfoMail = $("#editbox_search_email").val();
        var url = "account/searchDetail.htm";
        if (searchInfoNom === null || searchInfoNom === "")
            url = url + "?nom=default";
        else
            url = url + "?nom=" + searchInfoNom;
        if (searchInfoPromotion === null || searchInfoPromotion === "")
            url = url + "&promotion=0";
        else
            url = url + "&promotion=" + searchInfoPromotion;
        if (searchInfoMail === null || searchInfoMail === "")
            url = url + "&mail=default";
        else
            url = url + "&mail=" + searchInfoMail;
        $.ajax({url: url, success: function (result) {
                $("#results").html(result);
            }});
        return;
    }

    function nextPage(page) {
        $.ajax({url: "account/next_page.htm?page=" + page, success: function (result) {
                $("#results").html(result);
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
<h2 align="center">Faire la recherche</h2>
<div class="searchform">
    <div id="formsearch" name="formsearch" style="float: left; margin-right:10px">
        <p>Nom</p>
        <span style="width: 170px">
            <input name="editbox_search" class="editbox_search" id="editbox_search_nom"  value="" type="text" />
        </span>
        <input name="button_search" src="images/search.gif" class="button_search" type="image" maxlength="10" onclick="javascript: searchDetail();"/>
    </div>
    <div id="formsearch" name="formsearch" style="float: left; margin-right:10px">
        <p>Promotion</p>
        <span style="width: 170px">
            <input name="editbox_search" class="editbox_search" id="editbox_search_promotion" value="" type="text" />
        </span>
        <input name="button_search" src="images/search.gif" class="button_search" type="image" onclick="javascript: searchDetail();"/>
    </div>
    <div id="formsearch" name="formsearch" style="float: right">
        <p>Email</p>
        <span style="width: 170px">
            <input name="editbox_search" class="editbox_search" id="editbox_search_email" value="" type="text" />
        </span>
        <input name="button_search" src="images/search.gif" class="button_search" type="image" onclick="javascript: searchDetail();"/>
    </div>
</div> <br><br><br><br><br><br><br>

<div id="results">
<h2 align="center">Les anciens de l'IFI</h2>
<c:forEach var="account" items="${subAccounts}">
    <div class="article">
        <p class="infopost">
            <a href="#">Name : ${account.username}</a> 
            <a href="#">Promotion : ${account.promotion}</a> 
            <span class="date">Email: ${account.email}</span> 
            <a href="javascript: editAccount(${account.idAccount})" class="com">Edit</a>
        </p>
        <div class="img"><img src="images/account/${account.image}" width="100" height="100" alt="" class="fl" /></div>
        <div class="clr"></div>
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
<p class="spec"><a href="account/exportToExcel.htm" class="rm">Export to Excel &raquo;</a></p>
</div>
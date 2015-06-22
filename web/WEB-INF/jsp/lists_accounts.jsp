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
</script>
<div class="mainbar">
    <h2 align="center">Les anciens de l'IFI</h2><br><br>
    <c:forEach var="account" items="${subAccounts}">
        <div class="article">
            <p class="infopost">
                <a href="#">Name : ${account.username}</a> 
                <a href="#">Promotion : ${account.promotion}</a> 
                <span class="date">Email: ${account.email}</span> 
                <a href="edit_account.htm?idAccount=${account.idAccount}" class="com">Edit</a>
            </p>
            <div class="clr"></div>
            <div class="img"><img src="images/event/${account.image}" width="630" height="221" alt="" class="fl" /></div>
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
</div>
<div class="sidebar">
    <div class="searchform">
        <div id="formsearch">
            <span>
                <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80px" value="" type="text" />
            </span>
            <input name="button_search" src="images/search.gif" class="button_search" type="image" onclick="javascript:search();" />
        </div>
    </div>
    <div class="gadget">
        <h2 class="star"><span>Bienvenue</span></h2>
        <div class="clr"></div>
        <ul class="ex_menu">
            <li>
                <c:choose>
                    <c:when test="${sessionScope.current_account == null}">
                        <table>
                            <tr>
                                <td>
                                    <!--<a href="<%=request.getContextPath()%>/login.htm">Login</a>-->
                                    <a href="javascript: login();">Login</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <!--<a href="<%=request.getContextPath()%>/account/signup.htm">S'incrire</a>-->
                                    <a href="javascript: register()">S'incrire</a>
                                </td>
                            </tr>
                        </table>
                    </c:when>
                    <c:when test="${sessionScope.current_account != null}">
                        <table>
                            <tr>
                                <td>
                                    Salut: 
                                    <a href="<%=request.getContextPath()%>/account/edit_account.htm">${sessionScope.current_account.username}</a> <br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="<%=request.getContextPath()%>/event/create_event.htm">Créer événement</a> <br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="<%=request.getContextPath()%>/offer/create_offer.htm">Créer offre</a> <br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="<%=request.getContextPath()%>/logout.htm">Logout</a>
                                </td>
                            </tr>
                        </table>
                    </c:when>
                </c:choose> 
                <span> </span>
            </li>
        </ul>
    </div>
    <div class="clr"></div>
    <div class="gadget">
        <h2 class="star"><span>Les nouvaux membres</span></h2>
        <div class="clr"></div>
        <ul class="ex_menu">
            <c:choose>
                <c:when test="${accounts != null}">
                    <c:forEach var="account" items="${accounts}">
                        <li><a href="http://www.dreamtemplate.com/">${account.username}</a><br>
                            Promotion: ${account.promotion} Nationalité:${account.nationality}
                        </li>
                    </c:forEach>
                </c:when>
            </c:choose> 
        </ul>
    </div>
    <div class="gadget">
        <h2 class="star"><span>Les nouveaux événements</span></h2>
        <div class="clr"></div>
        <ul class="ex_menu">
            <c:forEach var="event" items="${events}">
                <li><a href="http://www.dreamtemplate.com/">${event.title}</a><br>
                    ${event.content}...
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="gadget">
        <h2 class="star"><span>Les nouveaux offres</span></h2>
        <div class="clr"></div>
        <ul class="ex_menu">
            <c:forEach var="offer" items="${offers}">
                <li><a href="http://www.dreamtemplate.com/">${offer.title}</a><br>
                    ${offer.content}...
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="clr"></div>
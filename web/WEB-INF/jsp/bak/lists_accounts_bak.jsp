<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les anciens l'IFI</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="../css/coin-slider.css" />
        <script type="text/javascript" src="../js/cufon-yui.js"></script>
        <script type="text/javascript" src="../js/cufon-aller.js"></script>
        <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
        <script type="text/javascript" src="../js/coin-slider.min.js"></script>
    </head>
    <script>
        function search()
        {
            var searchInfo = $("#editbox_search").val();
            if (searchInfo === null || searchInfo === "")
                searchInfo = "";
            $.ajax({url: "search_accounts.htm?searchInfo=" + searchInfo, success: function (result) {
                    $(".mainbar").html(result);
                }});
            return;
        }

        function nextPage(page) {
            $.ajax({url: "next_page.htm?page=" + page, success: function (result) {
                    $(".mainbar").html(result);
                }});
            return;
        }
    </script>
    <body>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="menu_nav">
                        <ul>
                            <li><a href="index.htm"><span>Accueil</span></a></li>
                            <li class="active"><a href="lists_accounts.htm"><span>Annuaire</span></a></li>
                            <li><a href="about.htm"><span>Événements</span></a></li>
                            <li><a href="blog.htm"><span>Offres</span></a></li>
                            <li><a href="contact.htm"><span>Nous écrire</span></a></li>
                        </ul>
                    </div>
                    <div class="logo">
                        <h1><a href="<%=request.getContextPath()%>/index.htm"><span>Les anciens l'IFI</a></h1>
                    </div>
                    <div class="clr"></div>
                    <div class="slider">
                        <div id="coin-slider"> 
                            <a href="#"><img src="images/slide1.jpg" width="900" height="271" alt="" /> </a> 
                            <a href="#"><img src="images/slide2.jpg" width="900" height="271" alt="" /> </a> 
                            <a href="#"><img src="images/slide3.jpg" width="900" height="271" alt="" /> </a> 
                        </div>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="content">
                <div class="content_resize">
                    <div class="mainbar">
                        <h2 align="center">Les anciens de l'IFI</h2><br><br>
                        <c:forEach var="account" items="${accounts}">
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
                            <%--<form:form id="formsearch" name="formsearch" method="post" action="lists_accounts.htm">--%>
                            <div id="formsearch">
                                <span>
                                    <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80px" value="" type="text" />
                                </span>
                                <input name="button_search" src="../images/search.gif" class="button_search" type="image" onclick="javascript:search();" />
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
                                                        <a href="<%=request.getContextPath()%>/login.htm">Login</a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/account/signup.htm">S'incrire</a>
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
                </div>
            </div>
            <div class="fbg">
                <div class="fbg_resize">
                    <div class="col c1">
                        <h2><span>Image</span> de l'IFI</h2>
                        <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> 
                    </div>
                    <div class="col c2">
                        <h2><span>Les</span> partenaires</h2>
                        <a href="#"><img src="images/partners/ird.png" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/partners/la_rochelle.png" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/partners/lyon.png" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/partners/ummisco.png" width="75" height="75" alt="" class="gal" /></a> 
                    </div>
                    <div class="col c3">
                        <h2><span>Nous contacter</span> </h2>
                        <p></p>
                        <p class="contact_info"> <span>Address:</span> 144 Xuan Thuy Street, Cau Giay District, Hanoi.<br />
                            <span>Telephone:</span> +84 (04) 37450173<br />
                            <span>Fax:</span> +84 (04) 37957937<br />
                            <span>E-mail:</span> <a href="#">duongpb.p19@ifi.edu.vn</a> 
                            <span>E-mail:</span> <a href="#">sylvestre@ifi.edu.vn</a> 
                        </p>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="footer">
                <div class="footer_resize">
                    <p class="lf">&copy; Copyright <a href="#">IFI</a>.</p>
                    <p class="rf">Design by Dream <a href="#">IFI</a></p>
                    <div style="clear:both;"></div>
                </div>
            </div>
        </div>
    </body>
</html>





<div class="sidebar">
    <div class="searchform">
        <div id="formsearch">
            <span>
                <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80px" value="" type="text" />
            </span>
            <input name="button_search" src="images/search.gif" class="button_search" type="image" onclick="javascript:search();" />
        </div>
    </div>
</div>
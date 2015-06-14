<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SunlightParticles | Contact</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-aller.js"></script>
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script type="text/javascript" src="js/coin-slider.min.js"></script>
    </head>
    <body>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="menu_nav">
                        <ul>
                            <li class="active"><a href="<%=request.getContextPath()%>/index.htm"><span>Accueille</span></a></li>
                        <li><a href="support.htm"><span>Annuaire</span></a></li>
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
                        <div id="coin-slider"> <a href="#"><img src="images/slide1.jpg" width="940" height="271" alt="" /> </a> <a href="#"><img src="images/slide2.jpg" width="940" height="271" alt="" /> </a> <a href="#"><img src="images/slide3.jpg" width="940" height="271" alt="" /> </a> </div>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="content">
                <div class="content_resize">
                    <div class="mainbar">
                        <div class="article">
                        </div>
                        <div class="article">
                            <h2><span>Login</span></h2>
                            <div class="clr"></div>
                            <form:form action="welcome.htm" method="post" commandName="account">
                                Username <br>
                                    <form:input path="username"></form:input><br>
                                            Password <br>
                                            <form:password path="password"></form:password> <br>
                                                    <input type="submit" value="Login"/>
                                            </form:form>
                                            </div>
                                            </div>
                                            <div class="sidebar">
                                                <div class="searchform">
                                                    <form id="formsearch" name="formsearch" method="post" action="#">
                                                        <span>
                                                            <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80" value="Search our ste:" type="text" />
                                                        </span>
                                                        <input name="button_search" src="images/search.gif" class="button_search" type="image" />
                                                    </form>
                                                </div>
                                                <div class="clr"></div>
                                                <div class="gadget">
                                                    <h2 class="star"><span>Les nouvaux membres</span></h2>
                                                    <div class="clr"></div>
                                                    <ul class="ex_menu">
                                                        <c:forEach var="account" items="${accounts}">
                                                            <li><a href="#">${account.username}</a><br>
                                                                    Promotion: ${account.promotion} Nationalité:${account.nationality}
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                                <div class="gadget">
                                                    <h2 class="star"><span>Les nouveaux événements</span></h2>
                                                    <div class="clr"></div>
                                                    <ul class="ex_menu">
                                                        <c:forEach var="event" items="${events}">
                                                            <li><a href="#">${event.title}</a><br>
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
                                                        <h2><span>Les</span> univerisités</h2>
                                                        <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> 
                                                        <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> 
                                                        <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> 
                                                        <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> 
                                                        <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> 
                                                        <a href="#"><img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> 
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
                                            </html>
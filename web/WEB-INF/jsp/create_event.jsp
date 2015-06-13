<%-- 
    Document   : create_event
    Created on : Jun 10, 2015, 2:10:19 PM
    Author     : lion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les anciens l'IFI</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <link href="../js/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="../css/coin-slider.css" />
        <script type="text/javascript" src="../js/cufon-yui.js"></script>
        <script type="text/javascript" src="../js/cufon-aller.js"></script>
        <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
        <script type="text/javascript" src="../js/coin-slider.min.js"></script>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script src="../js/jquery-ui.min.js"></script>        
        <script>
            var $j = jQuery.noConflict();
            $j(document).ready(function () {
                $j(".datepicker").datepicker();
            });
        </script>
    </head>
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
                    <h1><a href="<%=request.getContextPath()%>/index.htm"><span>Les anciens l'IFI</span> <small>Le temp passé</small></a></h1>
                </div>
                <div class="clr"></div>
                <div class="slider">
                    <div id="coin-slider"> 
                        <a href="#"><img src="../images/slide1.jpg" width="900" height="271" alt="" /> </a> 
                        <a href="#"><img src="../images/slide2.jpg" width="900" height="271" alt="" /> </a> 
                        <a href="#"><img src="../images/slide3.jpg" width="900" height="271" alt="" /> </a> 
                    </div>
                </div>
                <div class="clr"></div>
            </div>
        </div>
        <div class="content">
            <div class="content_resize">
                <div class="mainbar">
                    <div class="article">
                        <h2><span>Créer </span> un événement</h2>
                        <div class="clr"></div>
                        <form:form action="do_creation_event.htm" method="post" commandName="event">
                            <table>
                                <tr>
                                    <td>Titre:</td>
                                    <td><form:input path="title"/></td>
                                </tr>
                                <tr>
                                    <td>Mode:</td>
                                    <td><form:radiobutton path="mode" value="1"/>Only one
                                        <form:radiobutton path="mode" value="0"/>Public</td>
                                </tr>
                                <tr>
                                    <td>Statut:</td>
                                    <td><form:radiobutton path="status" value="1"/>Active
                                        <form:radiobutton path="status" value="0"/>Inactive</td>
                                </tr>
                                <tr>
                                    <td>Contenu:</td>
                                    <td><form:textarea path="content"></form:textarea></td>
                                    </tr>
                                    <tr>
                                        <td>Date de début du événement:</td>
                                        <td><form:input path="startDate" class="datepicker" value=""/></td>
                                </tr>
                                <tr>
                                    <td>Date de fin du événement:</td>
                                    <td><form:input path="endDate" class="datepicker" value=""/></td>
                                </tr>                                
                                <tr>
                                    <td><input type="submit" value="Créer"/></td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                </div>
                <div class="sidebar">
                    <div class="searchform">
                        <form id="formsearch" name="formsearch" method="post" action="#">
                            <span>
                                <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80" value="Search our ste:" type="text" />
                            </span>
                            <input name="button_search" src="../images/search.gif" class="button_search" type="image" />
                        </form>
                    </div>
                    <div class="gadget">
                        <h2 class="star"><span>Bienvenue</span></h2>
                        <div class="clr"></div>
                        <ul class="ex_menu">
                            <li>
                                <c:choose>
                                    <c:when test="${sessionScope.current_account == null}">
                                        <a href="<%=request.getContextPath()%>/login.htm">Login</a>
                                        <a href="<%=request.getContextPath()%>/signup.htm">Sign up</a>
                                    </c:when>
                                    <c:when test="${sessionScope.current_account != null}">
                                        Salut: <a href="#">${sessionScope.current_account.username}</a> <br>
                                        <a href="<%=request.getContextPath()%>/event/create_event.htm">Create event</a> <br>
                                        <a class='iframe' href="<%=request.getContextPath()%>/login.htm">Contact Us</a><br>
                                        <a href="<%=request.getContextPath()%>/logout.htm">Logout</a>
                                    </c:when>
                                </c:choose> 
                                <span> </span>
                            </li>
                        </ul>
                    </div>
                    <div class="clr"></div>
                </div>
                <div class="clr"></div>
            </div>
        </div>
        <div class="fbg">
            <div class="fbg_resize">
                <div class="col c1">
                    <h2><span>Image</span> Gallery</h2>
                    <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> </div>
                <div class="col c2">
                    <h2><span>Services</span> Overview</h2>
                    <p>Curabitur sed urna id nunc pulvinar semper. Nunc sit amet tortor sit amet lacus sagittis posuere cursus vitae nunc.Etiam venenatis, turpis at eleifend porta, nisl nulla bibendum justo.</p>
                    <ul class="fbg_ul">
                        <li><a href="#">Lorem ipsum dolor labore et dolore.</a></li>
                        <li><a href="#">Excepteur officia deserunt.</a></li>
                        <li><a href="#">Integer tellus ipsum tempor sed.</a></li>
                    </ul>
                </div>
                <div class="col c3">
                    <h2><span>Contact</span> Us</h2>
                    <p>Nullam quam lorem, tristique non vestibulum nec, consectetur in risus. Aliquam a quam vel leo gravida gravida eu porttitor dui.</p>
                    <p class="contact_info"> <span>Address:</span> 1458 TemplateAccess, USA<br />
                        <span>Telephone:</span> +123-1234-5678<br />
                        <span>FAX:</span> +458-4578<br />
                        <span>Others:</span> +301 - 0125 - 01258<br />
                        <span>E-mail:</span> <a href="#">mail@yoursitename.com</a> </p>
                </div>
                <div class="clr"></div>
            </div>
        </div>
        <div class="footer">
            <div class="footer_resize">
                <p class="lf">&copy; Copyright <a href="#">MyWebSite</a>.</p>
                <p class="rf">Design by Dream <a href="http://www.dreamtemplate.com/">Web Templates</a></p>
                <div style="clear:both;"></div>
            </div>
        </div>
    </div>
    <div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div>
</body>
</html>

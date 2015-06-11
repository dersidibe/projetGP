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
        <link rel="stylesheet" type="text/css" href="../css/coin-slider.css" />
        <script type="text/javascript" src="../js/cufon-yui.js"></script>
        <script type="text/javascript" src="../js/cufon-aller.js"></script>
        <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
        <script type="text/javascript" src="../js/coin-slider.min.js"></script>
        <link rel="stylesheet" href="http://www.formmail-maker.com/var/demo/jquery-popup-form/colorbox.css" />
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>-->
        <script src="http://www.formmail-maker.com/var/demo/jquery-popup-form/jquery.colorbox-min.js"></script>
    </head>
</head>
<body>
    <div class="main">
        <div class="header">
            <div class="header_resize">
                <div class="menu_nav">
                    <ul>
                        <li><a href="index.html"><span>Home Page</span></a></li>
                        <li><a href="support.html"><span>Support</span></a></li>
                        <li><a href="about.html"><span>About Us</span></a></li>
                        <li><a href="blog.html"><span>Blog</span></a></li>
                        <li class="active"><a href="contact.html"><span>Contact Us</span></a></li>
                    </ul>
                </div>
                <div class="logo">
                    <h1><a href="index.html"><span>Sunlight</span>Particles <small>Company Slogan Here</small></a></h1>
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
                        <h2><span>Create </span> an event</h2>
                        <div class="clr"></div>
                        <form:form action="do_creation_event.htm" method="post" commandName="event">
                            <ol>
                                <li>
                                    Name:
                                    <form:input path="title"/>
                                </li>
                                <li>
                                    Mode:
                                    <form:input path="mode"/>
                                </li>
                                <li>
                                    Status:
                                    <form:input path="status"/>
                                </li>
                                <li>
                                    Your Message
                                    <form:textarea path="content"></form:textarea>
                                    </li>
                                    <li>
                                        <input type="submit" value="create"/>
                                    </li>
                                </ol>
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

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les anciens l'IFI</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-aller.js"></script>
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script type="text/javascript" src="js/coin-slider.min.js"></script>
        <link rel="stylesheet" href="http://www.formmail-maker.com/var/demo/jquery-popup-form/colorbox.css" />
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>-->
        <script src="http://www.formmail-maker.com/var/demo/jquery-popup-form/jquery.colorbox-min.js"></script>
    </head>
    <style>
         #cboxOverlay{ background:#666666; }
    </style>
    <script>
        $(document).ready(function () {
            $(".iframe").colorbox({iframe: true, fastIframe: false, width: "450px", height: "480px", transition: "fade", scrolling: false});
        });
    </script>
    <body>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="menu_nav">
                        <ul>
                            <li class="active"><a href="index.htm"><span>Home Page</span></a></li>
                            <li><a href="support.htm"><span>Support</span></a></li>
                            <li><a href="about.htm"><span>About Us</span></a></li>
                            <li><a href="blog.htm"><span>Blog</span></a></li>
                            <li><a href="contact.htm"><span>Contact Us</span></a></li>
                        </ul>
                    </div>
                    <div class="logo">
                        <h1><a href="index.html"><span>Les anciens l'IFI<small>Le temp passé</small></a></h1>
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
                        <c:forEach var="event" items="${events}">
                            <div class="article">
                                <h2><span>${event.title}</span></h2>
                                <p class="infopost">Posted on <span class="date">11 sep 2018</span> by <a href="#">${event.account.username}</a> &nbsp;&nbsp;&bull;&nbsp;&nbsp; Filed under <a href="#">templates</a>, <a href="#">internet</a> <a href="#" class="com">Comments <span>11</span></a></p>
                                <div class="clr"></div>
                                <div class="img"><img src="images/img1.jpg" width="630" height="221" alt="" class="fl" /></div>
                                <div class="post_content">
                                    <p>${event.content}</p>
                                    <p class="spec"><a href="#" class="rm">Read more &raquo;</a></p>
                                </div>
                                <div class="clr"></div>
                            </div>
                        </c:forEach>
                        <p class="pages"><small>Page 1 of 2</small> <span>1</span> <a href="#">2</a> <a href="#">&raquo;</a></p>
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
                                            <a href="<%=request.getContextPath()%>/account/signup.htm">Sign up</a>
                                        </c:when>
                                        <c:when test="${sessionScope.username != null}">
                                            Salut: <a href="#">${sessionScope.username.getUsername}</a> <br>
                                            <a href="">Créer un évent</a> <br>
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
                        <div class="gadget">
                            <h2 class="star"><span>Les nouvaux membres</span></h2>
                            <div class="clr"></div>
                            <ul class="ex_menu">
                                <c:forEach var="account" items="${accounts}">
                                    <li><a href="http://www.dreamtemplate.com/">${account.username}</a><br>
                                        Promotion: ${account.promotion} Nation:${account.nationality}
                                    </li>
                                </c:forEach>
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
        <div id="signup" style="display: none; position: fixed; opacity: 1; z-index: 11000; left: 50%; margin-left: -202px; top: 200px;">
            <div id="signup-ct">
                <div id="signup-header">
                    <h2>Create a new account</h2>
                    <p>It's simple, and free.</p>
                    <a href="#" class="modal_close"></a>
                </div>

                <form action="">

                    <div class="txt-fld">
                        <label for="">Username</label>
                        <input type="text" name="" class="good_input" id="">

                    </div>
                    <div class="txt-fld">
                        <label for="">Email address</label>
                        <input type="text" name="" id="">
                    </div>
                    <div class="txt-fld">
                        <label for="">Password</label>
                        <input type="text" name="" id="">

                    </div>
                    <div class="btn-fld">
                        <button type="submit">Sign Up »</button>
                    </div>
                </form>
            </div>
        </div>








    </body>
</html>

<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Gestion des anciens de l'IFI</title>
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
         <form:form modelAttribute="account" method="post" commandName="account" action="login.html">
                                        <form:input path="username"/>
                                        <form:password path="password"/>
                                    </form:form>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="menu_nav">
                        <ul>
                            <li class="active"><a href="index.html"><span>Home Page</span></a></li>
                            <li><a href="support.html"><span>Support</span></a></li>
                            <li><a href="about.html"><span>About Us</span></a></li>
                            <li><a href="blog.html"><span>Blog</span></a></li>
                            <li><a href="contact.html"><span>Contact Us</span></a></li>
                        </ul>
                    </div>
                    <div class="logo">
                        <h1><a href="index.html"><span>Les anciens</span> de l'IFI<small>Mot thoi đe nho</small></a></h1>
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
                            <h2><span>Excellent Solution</span> For Your Business</h2>
                            <p class="infopost">Posted on <span class="date">11 sep 2018</span> by <a href="#">Admin</a> &nbsp;&nbsp;&bull;&nbsp;&nbsp; Filed under <a href="#">templates</a>, <a href="#">internet</a> <a href="#" class="com">Comments <span>11</span></a></p>
                            <div class="clr"></div>
                            <div class="img"><img src="images/img1.jpg" width="630" height="221" alt="" class="fl" /></div>
                            <div class="post_content">
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. <a href="#">Suspendisse bibendum. Cras id urna.</a> Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec placerat bibendum, dui pede condimentum odio, ac blandit ante orci ut diam. Cras fringilla magna. Phasellus suscipit, leo a pharetra condimentum, lorem tellus eleifend magna, eget fringilla velit magna id neque. Curabitur vel urna. In tristique orci porttitor ipsum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo.</p>
                                <p><strong>Aenean consequat porttitor adipiscing. Nam pellentesque justo ut tortor congue lobortis. Donec venenatis sagittis fringilla.</strong> Etiam nec libero magna, et dictum velit. Proin mauris mauris, mattis eu elementum eget, commodo in nulla. Mauris posuere venenatis pretium. Maecenas a dui sed lorem aliquam dictum. Nunc urna leo, imperdiet eu bibendum ac, pretium ac massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla facilisi. Quisque condimentum luctus ullamcorper.</p>
                                <p class="spec"><a href="#" class="rm">Read more &raquo;</a></p>
                            </div>
                            <div class="clr"></div>
                        </div>
                        <div class="article">
                            <h2><span>We'll Make Sure Template</span> Works For You</h2>
                            <p class="infopost">Posted on <span class="date">29 aug 2016</span> by <a href="#">Admin</a> &nbsp;&nbsp;&bull;&nbsp;&nbsp; Filed under <a href="#">templates</a>, <a href="#">internet</a> <a href="#" class="com">Comments <span>7</span></a></p>
                            <div class="clr"></div>
                            <div class="img"><img src="images/img2.jpg" width="630" height="221" alt="" class="fl" /></div>
                            <div class="post_content">
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. <a href="#">Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo.</a> Donec mattis, purus nec placerat bibendum, dui pede condimentum odio, ac blandit ante orci ut diam. Cras fringilla magna. Phasellus suscipit, leo a pharetra condimentum, lorem tellus eleifend magna, eget fringilla velit magna id neque. Curabitur vel urna. In tristique orci porttitor ipsum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam.</p>
                                <p><strong>Aenean consequat porttitor adipiscing. Nam pellentesque justo ut tortor congue lobortis. Donec venenatis sagittis fringilla.</strong> Etiam nec libero magna, et dictum velit. Proin mauris mauris, mattis eu elementum eget, commodo in nulla. Mauris posuere venenatis pretium. Maecenas a dui sed lorem aliquam dictum. Nunc urna leo, imperdiet eu bibendum ac, pretium ac massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla facilisi. Quisque condimentum luctus ullamcorper.</p>
                                <p class="spec"><a href="#" class="rm">Read more &raquo;</a></p>
                            </div>
                            <div class="clr"></div>
                        </div>
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
                        <div class="clr"></div>
                        <div class="gadget">
                            <h2 class="star"><span>New</span> Events</h2>
                            <div class="clr"></div>
                            <ul class="sb_menu">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">TemplateInfo</a></li>
                                <li><a href="#">Style Demo</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Archives</a></li>
                                <li><a href="#">Web Templates</a></li>
                            </ul>
                        </div>
                        <div class="gadget">
                            <h2 class="star"><span>Offers</span></h2>
                            <div class="clr"></div>
                            <ul class="ex_menu">
                                <li>
                                    <a href="http://www.dreamtemplate.com/">DreamTemplate</a><br/>
                                    Over 6,000+ Premium Web Templates
                                </li>
                            </ul>
                        </div>
                        <div class="gadget">
                            <h2 class="star"><span>Login</span></h2>
                            <div class="clr"></div>
                            <ul class="ex_menu">
                                <li>
                                    <form:form method="post" action="login.html">
                                        <form:input path="username"/>
                                        <form:password path="password"/>
                                    </form:form>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="fbg">
                <div class="fbg_resize">
                    <div class="col c1">
                        <h2><span>Images</span> l'IFI</h2>
                        <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> 
                    </div>
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
                        <p>Viện tin học pháp ngữ</p>
                        <p>Institution Fancophonie International</p>
                        <p class="contact_info"> <span>Address:</span> 144 Xuân Thủy, Cầu Giấy, Hà Nội<br />
                            <span>Telephone:</span> +123-1234-5678<br />
                            <span>FAX:</span> +458-4578<br />
                            <span>Others:</span> +301 - 0125 - 01258<br />
                            <span>E-mail:</span> <a href="#">pbduong.p19@ifi.edu.vn</a></br>
                            <span>E-mail:</span><a href="#">sidibe.p19@ifi.edu.vn</a> </p>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="footer">
                <div class="footer_resize">
                    <p class="lf">&copy; Copyright <a href="#">L'IFI</a>.</p>
                    <p class="rf">Design by : <a href="http://www.dreamtemplate.com/">Der-Duong</a></p>
                    <div style="clear:both;"></div>
                </div>
            </div>
        </div>
        <div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>


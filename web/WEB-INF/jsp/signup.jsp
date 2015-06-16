<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SunlightParticles | Contact</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="../css/coin-slider.css" />
        <script type="text/javascript" src="../js/cufon-yui.js"></script>
        <script type="text/javascript" src="../js/cufon-aller.js"></script>
        <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
        <script type="text/javascript" src="../js/coin-slider.min.js"></script>
        <link href="../js/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script src="../js/jquery-ui.min.js"></script>

        <style>
            .required {
                color:red;
            }
        </style>
        <script>
            var $j = jQuery.noConflict();
            $j(document).ready(function () {
                $j("#datepicker1").datepicker();
                $j("#datepicker2").datepicker();
                $j("#datepicker3").datepicker();
            });

            function imgchange(f) {
                var filePath = $('#file').val();
                var reader = new FileReader();
                reader.onload = function (e) {
                    $('#name_img').attr('value', filePath);
                };
                reader.readAsDataURL(f.files[0]);
            }

            $(document).ready(function () {
                var element = document.getElementById("success");
                if (element !== null)
                {
                    alert("Événement est crée avec réussi!");
                    return;
                }

                var element = document.getElementById("failure");
                if (element !== null)
                {
                    alert("Échec!");
                    return;
                }
            });
            
            function validateForm() {
                var lastname = document.getElementById("lastname").value;
                if (lastname === null || lastname === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("Nom est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_lastname");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                var firstname = document.getElementById("firstname").value;
                if (firstname === null || firstname === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("Prenom est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_firstname");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                
                var username = document.getElementById("username").value;
                if (username === null || username === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("username est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_username");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                
                var password = document.getElementById("password").value;
                if (password === null || password === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("password est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_password");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                
                var email = document.getElementById("email").value;
                if (status1 === null || status1 === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("email est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_email");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                
                var sexM = document.getElementById("sexM").value;
                var sexF = document.getElementById("sexF").value;
                if ((sexM === null || sexM === "") && (sexF === null || sexF === "")) {
                    var para = document.createElement("span");
                    var node = document.createTextNode("Choisir un.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_sex");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                
                var status1 = document.getElementById("status1").value;
                var status2 = document.getElementById("status1").value;
                if ((status1 === null || status1 === "") && (status2 === null || status2 === "")) {
                    var para = document.createElement("span");
                    var node = document.createTextNode("Choisir un.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_status");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="menu_nav">
                        <ul>
                            <li><a href="index.htm"><span>Home Page</span></a></li>
                            <li><a href="support.htm"><span>Support</span></a></li>
                            <li><a href="about.htm"><span>About Us</span></a></li>
                            <li><a href="blog.htm"><span>Blog</span></a></li>
                            <li><a href="contact.htm"><span>Contact Us</span></a></li>
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
                        </div>
                        <div class="article">
                            <h2><span>Sign Up</span></h2>
                            <div class="clr"></div>

                            <form:form action="register.htm" method="post" commandName="account" onsubmit="return validateForm()">
                                <table border="0">

                                    <tr>
                                        <td class="required">Nom:</td>
                                        <td><form:input path="lastName" id="lastname"/></td>
                                        <td><span id="empty_lastname" style="color:red"></span></td>
                                    </tr>
                                    <tr>
                                        <td class="required">Prénom:</td>
                                        <td><form:input path="firstName" id="firstname"/></td>
                                        <td><span id="empty_firstname" style="color:red"></span></td>
                                    </tr>

                                    <tr>
                                        <td class="required">Nom d'utilisateur:</td>
                                        <td><form:input path="username" id="username"/></td>
                                        <td><span id="empty_username" style="color:red"></span></td>
                                    </tr>

                                    <tr>
                                        <td class="required">Mot de passe:</td>
                                        <td><form:password path="password" id="password"/></td>
                                        <td><span id="empty_password" style="color:red"></span></td>
                                    </tr>
                                    <tr>
                                        <td class="required" >E-mail:</td>
                                        <td><form:input path="email" id="email"/></td>
                                        <td><span id="empty_email" style="color:red"></span></td>
                                    </tr>
                                    <tr>
                                        <td>Nationalité:</td>
                                        <td><form:input path="nationality" /></td>
                                    </tr>
                                    <tr>
                                        <td>Profession:</td>
                                        <td><form:input path="occupation" /></td>
                                    </tr>                                    
                                    <tr>
                                        <td>Birthday (mm/dd/yyyy):</td>
                                        <td><form:input path="birthday" id="datepicker1" /></td>
                                    </tr>                                    
                                    <tr>
                                        <td align="left"><b><label for="file">Image:</label></b></td>
                                        <td><input type="file" name="file" id="file" onchange="imgchange(this)"></td>
                                        <td><form:hidden path="image" id="name_img" value=""/></td>
                                    </tr>
                                    <tr>
                                        <td>Sex:</td>
                                        <td>
                                            <form:radiobutton path="sex" value="M" id="sexM"/>M
                                            <form:radiobutton path="sex" value="F" id="sexF"/>F 
                                        </td>
                                        <td><span id="empty_sex" style="color:red"></span></td>
                                    </tr> 
                                    <tr>
                                        <td>Quel est votre status?</td>
                                        <td>
                                            <form:radiobutton path="type" value="1" id="status1"/>Ancien étudiant
                                            <form:radiobutton path="type" value="2" id="status2"/>Ancien travailleur
                                            <td><span id="empty_status" style="color:red"></span></td>
                                        </td>
                                    </tr>                                         

                                    <tr>
                                        <td><b>Si vous êtes ancien étudiant</b></td>
                                    </tr>     
                                    <tr>
                                        <td>Promotion: </td>
                                        <td>
                                            <form:select path="promotion">
                                                <form:option value="" label="...." />
                                                <form:options items="${promo}" />
                                            </form:select>
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td><b>Si vous êtes ancien travailleur</b></td>
                                    </tr>
                                    <tr>
                                        <td>Date de début de la collaboration:</td>
                                        <td><form:input path="jobStartTime" id="datepicker2" value=""/></td>
                                    </tr>
                                    <tr>
                                        <td>Date de fin de la collaboration:</td>
                                        <td><form:input path="jobEndTime" id="datepicker3" value=""/></td>
                                    </tr>                                
                                    <tr>
                                        <td ><input type="submit" value="Valider" /></td>
                                        <c:choose>
                                            <c:when test="${result == null}">
                                                <p id="failure"></p>
                                            </c:when>
                                            <c:when test="${result == 0}">
                                            </c:when>
                                            <c:when test="${result != null && result > 0}">
                                                <p id="success"></p>
                                            </c:when>
                                        </c:choose> 
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
                                <input name="button_search" src="images/search.gif" class="button_search" type="image" />
                            </form>
                        </div>
                        <div class="clr"></div>
                        <div class="gadget">
                            <h2 class="star"><span>Sidebar</span> Menu</h2>
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
                            <h2 class="star"><span>Sponsors</span></h2>
                            <div class="clr"></div>
                            <ul class="ex_menu">
                                <li><a href="http://www.dreamtemplate.com/">DreamTemplate</a><br />
                                    Over 6,000+ Premium Web Templates</li>
                                <li><a href="http://www.templatesold.com/">TemplateSOLD</a><br />
                                    Premium WordPress &amp; Joomla Themes</li>
                                <li><a href="http://www.imhosted.com/">ImHosted.com</a><br />
                                    Affordable Web Hosting Provider</li>
                                <li><a href="http://www.megastockphotos.com/">MegaStockPhotos</a><br />
                                    Unlimited Amazing Stock Photos</li>
                                <li><a href="http://www.evrsoft.com/">Evrsoft</a><br />
                                    Website Builder Software &amp; Tools</li>
                                <li><a href="http://www.csshub.com/">CSS Hub</a><br />
                                    Premium CSS Templates</li>
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
        <div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>
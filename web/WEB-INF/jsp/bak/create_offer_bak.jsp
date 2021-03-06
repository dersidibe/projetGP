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
    </head>
    <script>
        function validateForm() {
            var title = document.getElementById("offer_title").value;
            if (title === null || title === "") {
                var para = document.createElement("span");
                var node = document.createTextNode("Titre est vide.");
                para.appendChild(node);
                var element = document.getElementById("empty_title");
                if (element.textContent === null || element.textContent === "")
                    element.appendChild(para);
                return false;
            }
            var content = document.getElementById("offer_content").value;
            if (content === null || content === "") {
                var para = document.createElement("span");
                var node = document.createTextNode("Contenu est vide.");
                para.appendChild(node);
                var element = document.getElementById("empty_content");
                if (element.textContent === null || element.textContent === "")
                    element.appendChild(para);
                return false;
            }
            return true;
        }

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
                alert("Créer un offre avec réussi!");
                return;
            }

            var element = document.getElementById("failure");
            if (element !== null)
            {
                alert("Créer un offre avec échec!");
                return;
            }
        });
    </script>
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
                    <div class="article">
                        <h2><span>Créer </span> un offre</h2>
                        <div class="clr"></div>
                        <form:form  name="create_offer" action="do_creation_offer.htm" method="post" commandName="offer" onsubmit="return validateForm()">
                            <table>
                                <tr>
                                    <td>
                                        Titre:
                                    </td>
                                    <td>
                                        <form:input path="title" id="offer_title"/>
                                    </td>
                                    <td>
                                        <span id="empty_title" style="color:red"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Mode:
                                    </td>
                                    <td>
                                        <form:radiobutton path="mode" value="1"/>Only one
                                        <form:radiobutton path="mode" value="0"/>Public
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Contenu:
                                    </td>
                                    <td>
                                        <form:textarea path="content" id="offer_content"></form:textarea>
                                        </td>
                                        <td>
                                            <span id="empty_content" style="color:red"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="left"><b><label for="file">Image:</label></b></td>
                                        <td><input type="file" name="file" id="file" onchange="imgchange(this)"></td>
                                        <td><form:hidden path="image" id="name_img" value=""/></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="submit" value="Créer"/>
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
                                    </td>
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
                                        <a href="<%=request.getContextPath()%>/signup.htm">S'incrire</a>
                                    </c:when>
                                    <c:when test="${sessionScope.current_account != null}">
                                        Salut : <a href="#">${sessionScope.current_account.username}</a> <br>
                                        <a href="<%=request.getContextPath()%>/event/create_event.htm">Créer événement</a> <br>
                                        <a href="<%=request.getContextPath()%>/offer/create_offer.htm"">Créer offre</a><br>
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
</body>
</html>

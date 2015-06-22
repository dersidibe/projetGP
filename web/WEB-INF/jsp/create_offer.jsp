<%-- 
    Document   : create_event
    Created on : Jun 10, 2015, 2:10:19 PM
    Author     : lion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <link href="js/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
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

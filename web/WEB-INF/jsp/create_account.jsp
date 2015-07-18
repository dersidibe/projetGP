<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link href="js/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>

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
            var filePath = $('#file').val().split('\\').pop();
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
                var node = document.createTextNode("Username est vide.");
                para.appendChild(node);
                var element = document.getElementById("empty_username");
                if (element.textContent === null || element.textContent === "")
                    element.appendChild(para);
                return false;
            }

            var password = document.getElementById("password").value;
            if (password === null || password === "") {
                var para = document.createElement("span");
                var node = document.createTextNode("Password est vide.");
                para.appendChild(node);
                var element = document.getElementById("empty_password");
                if (element.textContent === null || element.textContent === "")
                    element.appendChild(para);
                return false;
            }
            
            var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
            var email = document.getElementById("email").value;
            if (!re.test(email))
            {
                var para = document.createElement("span");
                var node = document.createTextNode("Email est invalide.");
                para.appendChild(node);
                var element = document.getElementById("empty_email");
                if (element.textContent === null || element.textContent === "")
                    element.appendChild(para);
                return false;
            }

            var sexM = document.getElementById("sexM");
            var sexF = document.getElementById("sexF");
            if ((sexM.checked === false && sexF.checked === false)) {
                var para = document.createElement("span");
                var node = document.createTextNode("Choisir un.");
                para.appendChild(node);
                var element = document.getElementById("empty_sex");
                if (element.textContent === null || element.textContent === "")
                    element.appendChild(para);
                return false;
            }

            var status1 = document.getElementById("status1");
            var status2 = document.getElementById("status2");
            if ((status1.checked === false && status2.checked === false)) {
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
<div class="article">
    <h2><span>Sign Up</span></h2>
    <div class="clr"></div>
    <form:form action="account/register.htm" method="post" commandName="account" onsubmit="return validateForm()">
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
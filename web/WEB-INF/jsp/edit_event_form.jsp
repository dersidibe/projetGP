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
        <link href="js/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script>

            function validateForm() {
                var title = document.getElementById("event_title").value;
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
                var start_date = document.getElementById("start_datepicker").value;
                if (start_date === null || start_date === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("Start date est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_startDate");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }
                var end_date = document.getElementById("end_datepicker").value;
                if (end_date === null || end_date === "") {
                    var para = document.createElement("span");
                    var node = document.createTextNode("End date est vide.");
                    para.appendChild(node);
                    var element = document.getElementById("empty_endDate");
                    if (element.textContent === null || element.textContent === "")
                        element.appendChild(para);
                    return false;
                }

                var startDate = new Date($('#start_datepicker').val()); // or Date.parse(...)
                var endDate = new Date($('#end_datepicker').val()); // or Date.parse(...)
                if (endDate < startDate)
                {
                    alert("Date de debut superieur date de fin");
                    return false;
                }
                return true;
            }

            var $j = jQuery.noConflict();
            $j(document).ready(function () {
                $j("#start_datepicker").datepicker();
                $j("#end_datepicker").datepicker();
            }
            );
            function imgchange(f) {
                var filePath = $('#file').val().split('\\').pop();
                alert(filePath);
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
        </script>
    </head>
</head>
<div class="article">
    <h2><span>Modifier </span> un événement</h2>
    <div class="clr"></div>
    <form:form onsubmit="return validateForm()" action="event/edit_event.htm?eventId=${eventId}" method="post" commandName="current_event" >
        <table>
            <tr>
                <td>Titre:</td>
                <td><form:input path="title" id="event_title"/></td>
                <td><span id="empty_title" style="color:red"></span></td>
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
                <td><form:textarea path="content" id="offer_content"></form:textarea></td>
                    <td><span id="empty_content" style="color:red"></span></td>
                </tr>
                <tr>
                    <td align="left"><b><label for="file">Image:</label></b></td>
                    <td><input type="file" name="file" id="file" onchange="imgchange(this)"></td>
                    <td><form:hidden path="image" id="name_img" value=""/></td>
            </tr>
            <tr>
                <td>Date de début du événement:</td>
                <td><form:input path="startDate" id="start_datepicker" value=""/></td>
                <td><span id="empty_startDate" style="color:red"></span></td>
            </tr>
            <tr>
                <td>Date de fin du événement:</td>
                <td><form:input path="endDate" id="end_datepicker" value=""/></td>
                <td><span id="empty_endDate" style="color:red"></span></td>
            </tr>                                
            <tr>
                <td><input type="submit" value="Modifier"/>
                    <c:choose>
                        <c:when test="${result == false}">
                            <p id="failure"></p>
                        </c:when>
                        <c:when test="${result == 0}">
                        </c:when>
                        <c:when test="${result == true}">
                            <p id="success"></p>
                        </c:when>
                    </c:choose> 
                </td>
            </tr>
        </table>
    </form:form>
</div>

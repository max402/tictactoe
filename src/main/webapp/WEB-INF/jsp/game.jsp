<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>

<h1 id="status">${status}</h1>

<div id="gameField">
    <div class="cell" id="A1"><c:out value="${map['A1']}"/></div>
    <div class="cell" id="A2"><c:out value="${map['A2']}"/></div>
    <div class="cell" id="A3"><c:out value="${map['A3']}"/></div>
    <div class="cell" id="B1"><c:out value="${map['B1']}"/></div>
    <div class="cell" id="B2"><c:out value="${map['B2']}"/></div>
    <div class="cell" id="B3"><c:out value="${map['B3']}"/></div>
    <div class="cell" id="C1"><c:out value="${map['C1']}"/></div>
    <div class="cell" id="C2"><c:out value="${map['C2']}"/></div>
    <div class="cell" id="C3"><c:out value="${map['C3']}"/></div>
</div>
<br>
<form id="form" method="post">
    <input type="hidden" id="selected" name="selected">
    <input type="submit" value="Close" name="close"/>
</form>


<script>
    window.addEventListener("DOMContentLoaded", function () {
        var cells = document.getElementsByClassName("cell");
        //var status = document.getElementById("status");
        for(var i = 0; i < cells.length; i++) {
            var c = cells.item(i);
            if(c.innerHTML == '') {
                c.addEventListener("click", function () {
                    document.getElementById("selected").value = this.id;
                    document.getElementById("form").submit();
                });
            }
        }
    });
</script>

<style>
    .cell {
        height: 100px;
        width: 100px;
        border: solid 1px black;
        float: left;
    }
    #gameField {
        height: 400px;
        width: 400px;
    }
</style>
</body>
</html>

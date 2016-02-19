<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand"><a>LaksmiMed</a></div>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/main"/>">Главная</a></li>
                <li><a href="<c:url value="/about"/>">О сайте</a></li>
                <li><a href="<c:url value="/help"/>">Помощь</a></li>
            </ul>
            <ul class="nav navbar-right">
                <li><a href="<c:url value="/logout"/>">Выйти</a></li>
            </ul>
        </div>
    </nav>
    <div class="row">
        <h2>${doctor.fullName}</h2>
    </div>
    <div class="row">
        <h2>${doctor.jobPost}</h2>
    </div>
    <div class="row">
        <h2>${doctor.jobPlace}</h2>
    </div>
    <div class="row">
        <h2>${doctor.phoneNumber}</h2>
    </div>
    <div class="row">
        <h2>${doctor.email}</h2>
    </div>
</div>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</html>

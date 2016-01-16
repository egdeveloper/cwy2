<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: egdeveloper
  Date: 22.11.15
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand"><a>LaksmiMed</a></div>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/"/>">Главная</a></li>
                <li><a href="<c:url value="/patientInfoEditor"/>">Добавить пациента</a></li>
                <li><a href="<c:url value="/about"/>">О сайте</a></li>
                <li><a href="<c:url value="/help"/>">Помощь</a></li>
            </ul>
        </div>
    </nav>
    <!--
    <div class="well pull-left" style="min-width: 340px; margin-top: 10px; margin-left: 10px; margin-right: 10px; padding: 8px 0">
        <ul class="nav nav-list">
            <li class="nav-header">
                Личная страница
            </li>
            <li class="active"><a href="<!--c:url value="/" />">На главную</a></li>
            <li><a href="#">Открыть страницу</a></li>
            <li class="nav-header">Пациенты</li>
            <li><a href="<!--c:url value="/patientInfoEditor"/>">Добавить пациента</a></li>
            <li class="divider"></li>
            <li><a href="#">
                Справка
            </a></li>
        </ul>
    </div>
    -->
    <h2>ФИО: ${doctorAccount.fullName}</h2>
    <h2>Должность: ${doctorAccount.jobPost}</h2>
    <h2>Место работы: ${doctorAccount.jobPlace}</h2>
</div>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</html>

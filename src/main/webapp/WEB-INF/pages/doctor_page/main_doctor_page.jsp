<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }

        body > .footer-container {
            padding: 60px 15px 0;
        }
        .footer-container .text-muted {
            margin: 20px 0;
        }
        .footer > .footer-container {
            padding-right: 15px;
            padding-left: 15px;
        }

        code {
            font-size: 80%;
        }
    </style>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">LaksmiMed</div>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/main"/>">Главная</a></li>
                <li><a href="<c:url value="/about"/>">О сайте</a></li>
                <li><a href="<c:url value="/help"/>">Помощь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/personalPage"/>">Личная страница</a></li>
                <li><a href="<c:url value="/logout"/>">Выйти</a></li>
            </ul>
        </div>
    </nav>
    <div class="row">
        <div class="col-sm-6">
            <button class="btn btn-primary" onclick="location.href='<c:url value="/patientInfoEditor"/>'">Добавить пациента</button>
            <button class="btn btn-primary">Открыть страницу пациента</button>
            <button class="btn btn-primary">Удалить пациента</button>
        </div>
    </div>
    <br/>
    <div class="row">
        <table class="table table-striped table-bordered" cellpadding="0" width="100%">
            <thead>
            <tr>
                <td>№</td>
                <td>ФИО</td>
                <td>Пол</td>
                <td>Дата рождения</td>
                <td>Номер карты</td>
                <td>Адрес проживания</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="patient" items="${doctor.patients}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td><a href="<c:url value="/patients/${patient.id}"/>">${patient.fullName}</a></td>
                    <td>${patient.gender.gender2String()}</td>
                    <td>${patient.birthdate}</td>
                    <td>${patient.cardNumber}</td>
                    <td>${patient.postIndex}, ${patient.region}, ${patient.city}, ${patient.address}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<footer class="footer">
    <div class="footer-container">
        <p class="text-muted">©Ярных Роман <a href="mailto:egdeveloper@mail.ru">egdeveloper@mail.ru</a></p>
    </div>
</footer>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</html>

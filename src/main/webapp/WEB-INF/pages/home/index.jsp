<%--
  Created by IntelliJ IDEA.
  User: egdeveloper
  Date: 22.11.15
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<c:url var="login_action" value="/login"/>
<div class="container">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <div class="navbar-brand">LaksmiMed</div>
      </div>
      <ul class="nav navbar-nav">
        <li><a href="<c:url value="/"/>">Главная</a></li>
        <li><a href="<c:url value="/about"/>">О сайте</a></li>
        <li><a href="<c:url value="/help"/>">Помощь</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/registerNewDoctor"/>">Регистрация</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Войти</a>
          <div class="dropdown-menu" style="padding:15px; padding-bottom:0px;">
            <form:form class="form" method="post" action="${login_action}" modelAttribute="loginAuth">
              <form:input style="margin-bottom: 15px;" path="login" id="loginInput" placeholder="Имя пользователя"/>
              <form:password style="margin-bottom: 15px;" path="password" id="passwordInput" placeholder="Пароль"/><br>
              <!--button class="btn btn-sm btn-default" type="submit">Войти</button-->
              <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Войти">
            </form:form>
          </div>
        </li>
      </ul>
    </div>
  </nav>
</div>
<div class="jumbotron">
  <div class="container">
    <h1>Добро пожаловать!</h1>
    <p>LaksmiMed - сервис, предоставляющий Вам  широкий набор инструментов для работы с медицинскими картами пациентов
      и статистической обработки медицинских данных для постановки диагноза и проведения исследований
    </p>
    <button class="btn btn-primary btn-default" onclick="location.href='<c:url value="/about"/>'">Узнайте больше!</button>
  </div>
</div>
<footer class="footer">
  <div class="footer-container">
    <p class="text-muted">©2015-2016 Ярных Роман <a href="mailto:egdeveloper@mail.ru">egdeveloper@mail.ru</a>.
    Проект размещен в свободном доступе на github: <a href="https://github.com/egdeveloper/LaksmiMed">https://github.com/egdeveloper/LaksmiMed</a>
    </p>
  </div>
</footer>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>

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
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
  <style>
    .nav-tabs {
      margin-bottom: 15px;
    }
    .sign-with {
      margin-top: 25px;
      padding: 20px;
    }
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
<body style="padding-top: 50px;">
<c:url var="registerAction" value="/register"/>
<c:url var="login_action" value="/login"/>
<div class="container">
  <nav class="navbar navbar-inverse navbar-fixed-top">
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
        <!--li><a href="<c:url value="/registerNewDoctor"/>">Регистрация</a></li>
        <!--
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Войти</a>
          <div class="dropdown-menu" style="padding:15px; padding-bottom:0px;">
            <!--form:form class="form" method="post" action="${login_action}" modelAttribute="loginAuth">
              <!--form:input style="margin-bottom: 15px;" path="login" id="loginInput" placeholder="Имя пользователя"/>
              <!--form:password style="margin-bottom: 15px;" path="password" id="passwordInput" placeholder="Пароль"/><br>
              <button class="btn btn-sm btn-default" type="submit">Войти</button>
              <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Войти">
            <--/form:form>
          </div>
        </li>
        -->
        <li><a href="#" data-toggle="modal" data-target="#login-modal">Войти</a></li>
      </ul>
    </div>
  </nav>
  <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-md">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Вход в систему LaksmiMed</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div style="padding-right: 30px; padding-left: 5px">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#login" data-toggle="tab">Войти</a></li>
                <li><a href="#signup" data-toggle="tab">Регистрация</a></li>
              </ul>
              <div class="tab-content">
                <div class="tab-pane active" id="login">
                  <form:form id="login-form" role="form" class="form-horizontal" method="post" action="${login_action}" modelAttribute="loginAuth">
                    <div class="form-group">
                      <label class="col-sm-2 control-label">Логин</label>
                      <div class="col-sm-10">
                        <div class="input-group">
                          <span class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                          </span>
                          <form:input class="form-control" placeholder="Логин" path="login"/>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label">Пароль</label>
                      <div class="col-sm-10">
                        <div class="input-group">
                          <span class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                          </span>
                          <form:password class="form-control" id="exampleInputPassword1" placeholder="Пароль" path="password"/>
                        </div>
                      </div>
                    </div>
                    <div class="row pull-right">
                      <button type="submit" class="btn btn-primary btn-sm">Войти</button>
                    </div>
                  </form:form>
                </div>
                <div class="tab-pane" id="signup">
                  <form:form id="signup-form" role="form" cssClass="form-horizontal" method="post" action="${registerAction}" modelAttribute="signupData">
                    <div class="form-group">
                      <label class="col-sm-4 control-label">ФИО</label>
                      <div class="col-sm-8">
                        <form:input cssClass="form-control" path="fullName" placeholder="ФИО"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Должность</label>
                      <div class="col-sm-8">
                        <form:input cssClass="form-control" path="jobPost" id="jobPost" placeholder="Должность"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Место работы</label>
                      <div class="col-sm-8">
                        <form:input cssClass="form-control" path="jobPlace" id="jobPlace" placeholder="Место работы"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Телефон</label>
                      <div class="col-sm-8">
                        <form:input cssClass="form-control" path="phoneNumber" id="phoneNumber" placeholder="Телефон"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Электронная почта</label>
                      <div class="col-sm-8">
                        <form:input cssClass="form-control" path="email" id="email" placeholder="Электронная почта"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Логин</label>
                      <div class="col-sm-8">
                        <form:input cssClass="form-control" path="login" id="login" placeholder="Логин"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Пароль</label>
                      <div class="col-sm-8">
                        <form:password cssClass="form-control" path="password" id="password" placeholder="Пароль"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Подтверждение пароля</label>
                      <div class="col-sm-8">
                        <form:password cssClass="form-control" path="confirmPassword" id="confirmPassword" placeholder="Подтверждение пароля"/>
                      </div>
                    </div>
                    <div class="row pull-right">
                      <button type="submit" class="btn btn-primary">Регистрация</button>
                    </div>
                  </form:form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
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
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript">

</script>
</body>
</html>
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
<!--
<div class="container">
  <div class="container" style="margin-top:30px">
    <div class="col-md-4 col-md-offset-4">
      <div class="panel panel-default">
        <div class="panel-heading"><h3><strong>Войти</strong></h3></div>
        <div class="panel-body">
          <!--form:form role="form" method="post" action="${login_action}" modelAttribute="loginAuth">
            <div class="form-group">
              <label for="login">Логин</label>
              <!--form:input path="login" id="login"/>
            </div>
            <div class="form-group">
              <label for="password">Пароль</label>
              <!--form:password path="password" id="password"/>
            </div>
            <button class="btn btn-sm btn-default" type="submit">Войти</button>
          <!--/form:form>
        </div>
      </div>
    </div>
  </div>
</div>
-->
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>

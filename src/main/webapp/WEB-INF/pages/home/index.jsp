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
  <link rel="stylesheet" href="<c:url value="/resources/css/home_stylesheet.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.css"/>"/>
  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

</head>
<body>
<div id="hmenu">
  <ul>
    <li><a href="<c:url value="/registerNewDoctor"/>">Регистрация</a></li>
    <li><a href="<c:url value="/about"/>">О сайте</a></li>
    <li><a href="<c:url value="/help"/>">Помощь</a></li>
  </ul>
</div>
<c:url var="login_action" value="/login"/>

<div class="container" style="margin-top:30px">
  <div class="col-md-4 col-md-offset-4">
    <div class="panel panel-default">
      <div class="panel-heading"><h3><strong>Войти</strong></h3></div>
      <div class="panel-body">
        <form:form role="form" method="post" action="${login_action}" modelAttribute="loginAuth">
          <div class="form-group">
            <label for="login">Логин <span style="color:red"><form:errors path="login" cssClass="errors"/></span></label>
            <form:input path="login" id="login"/>
          </div>
          <div class="form-group">
            <label for="password">Пароль <span style="color:red"><form:errors path="password" cssClass="errors"/></span></label>
            <form:password path="password" id="password"/>
          </div>
          <button class="btn btn-sm btn-default" type="submit">Войти</button>
        </form:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>

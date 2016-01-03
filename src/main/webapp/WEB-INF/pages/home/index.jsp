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
  <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home_stylesheet.css"/>">
  <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>

</head>
<body>
<div id="hmenu">
  <ul>
    <li><a href="<c:url value="/register_new_doctor"/>">Регистрация</a></li>
    <li><a href="<c:url value="/about"/>">О сайте</a></li>
    <li><a href="<c:url value="/help"/>">Помощь</a></li>
  </ul>
</div>
<c:url var="login_action" value="/login"/>

<div class="col-md-12">
  <form:form method="post" action="${login_action}" modelAttribute="loginAuth">
    <table>
      <tr class="form-group">
        <td><span style="color:red"><form:errors path="login" cssClass="errors"/></span></td>
        <td><label for="login">Логин</label></td>
        <td><form:input path="login" id="login"/></td>
      </tr>
      <tr class="form-group">
        <td><span style="color:red"><form:errors path="password" cssClass="errors"/></span></td>
        <td><label for="password">Пароль</label></td>
        <td><form:password path="password" id="password"/></td>
      </tr>
      <tr class="form-group">
        <td colspan="3" align="right">
          <input class="btn btn-lg btn-primary btn-block" type="submit" value="Войти"/>
        </td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>

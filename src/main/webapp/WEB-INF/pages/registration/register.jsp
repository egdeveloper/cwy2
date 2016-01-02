<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
  <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>
  <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<c:url var="register_action" value="/register"/>
<div class="container">
  <form:form method="post" action="${register_action}" modelAttribute="doctorAccount">
    <table align="center">
      <tr><td>ФИО <span style="color:red"><form:errors path="fullName" cssClass="errors"/></span></td></tr>
      <tr><td><form:input path="fullName"/></td></tr>
      <tr><td>Должность </td></tr>
      <tr><td><form:input path="jobPost" id="jobPost"/></td></tr>
      <tr><td>Место работы </td></tr>
      <tr><td><form:input path="jobPlace" id="jobPlace"/></td></tr>
      <tr><td>Телефон </td></tr>
      <tr><td><form:input path="phoneNumber" id="phoneNumber"/></td></tr>
      <tr><td>Электронная почта</td></tr>
      <tr><td><form:input path="email" id="email"/></td></tr>
      <tr><td>Логин <span style="color:red"><form:errors path="login" cssClass="errors"/></span></td></tr>
      <tr><td><form:input path="login" id="login"/></td></tr>
      <tr><td>Пароль</td></tr>
      <tr><td><form:password path="password" id="password"/></td></tr>
      <tr>
        <td colspan="3" align="center">
          <input type="submit" value="Регистрация"/>
        </td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>

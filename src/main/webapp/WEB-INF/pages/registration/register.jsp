<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.css"/>"/>
  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
<c:url var="register_action" value="/register"/>
<div class="container">
  <fieldset>
    <legend>Регистрация учетной записи доктора</legend>
    <form:form cssClass="form-horizontal" method="post" action="${register_action}" modelAttribute="signupData">
        <div class="row">
          <div class="form-group col-lg-4">
            <label>ФИО <span style="color:red"><form:errors path="fullName" cssClass="errors"/></span></label>
            <form:input cssClass="form-control" path="fullName" placeholder="ФИО"/>
          </div>
        </div>
        <br/>
        <div class="row">
          <div class="form-group col-lg-4">
            <label>Должность</label>
            <form:input cssClass="form-control input-lg" path="jobPost" id="jobPost" placeholder="Должность"/>
          </div>
        </div>
        <br/>
        <div class="row">
          <div class="form-group col-lg-4">
            <label>Место работы</label>
            <form:input cssClass="form-control input-lg" path="jobPlace" id="jobPlace" placeholder="Место работы"/>
          </div>
        </div>
        <br/>
        <div class="row center-block">
          <div class="form-group col-lg-4">
            <label>Телефон</label>
            <form:input cssClass="form-control input-lg" path="phoneNumber" id="phoneNumber" placeholder="Телефон"/>
          </div>
        </div>
       <br/>
        <div class="row">
          <div class="form-group col-lg-4">
            <label>Электронная почта <span style="color:red"><form:errors path="email" cssClass="errors"/></span></label>
            <form:input cssClass="form-control input-lg" path="email" id="email" placeholder="Электронная почта"/>
          </div>
        </div>
        <br/>
        <div class="row">
          <div class="form-group col-lg-4">
            <label>Логин  <span style="color:red"><form:errors path="login" cssClass="errors"/></span></label>
            <form:input cssClass="form-control input-lg" path="login" id="login" placeholder="Логин"/>
          </div>
        </div>
        <br/>
        <div class="row">
          <div class="form-group col-lg-4">
            <label>Пароль <span style="color:red"><form:errors path="password" cssClass="errors"/></span></label>
            <form:password cssClass="form-control input-lg" path="password" id="password" placeholder="Пароль"/>
          </div>
        </div>
        <br/>
        <div class="row">
            <div class="form-group col-lg-4">
                <label>Подтверждение пароля <span style="color:red"><form:errors path="confirmPassword" cssClass="errors"/></span></label>
                <form:password cssClass="form-control input-lg" path="confirmPassword" id="confirmPassword" placeholder="Пароль"/>
            </div>
        </div>
        <br/>
        <div class="row">
          <button type="submit" class="btn btn-primary">Регистрация</button>
        </div>
    </form:form>
  </fieldset>
</div>
</body>
</html>
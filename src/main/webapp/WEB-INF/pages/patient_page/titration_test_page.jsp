<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
</head>
<body>
<c:url var="addTitrationTest" value="/addTitrationTest"/>
<div class="container">
  <fieldset>
    <legend>Общий анализ крови</legend>
    <form:form cssClass="form-horizontal" method="post" action="${addTitrationTest}" modelAttribute="titrationTest">
      <div class="row">
        <div class="form-group">
          <label class="control-label">Дата</label>
          <form:input cssClass="form-control" path="testDate"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Описание</label>
          <form:input cssClass="form-control" path="description"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Оксалат</label>
          <form:input cssClass="form-control" path="oxalate"/>
        </div>
      </div>
      <div class="row">
        <button type="submit" class="btn btn-primary">Сохранить анализы</button>
      </div>
    </form:form>
  </fieldset>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>


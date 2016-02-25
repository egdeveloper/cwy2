<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css"/>">
</head>
<body>
<c:url var="addUreaStoneTest" value="/addUreaStoneTest"/>
<div class="container">
  <fieldset>
    <legend>Мочевой камень</legend>
    <form:form cssClass="form-horizontal" method="post" action="${addUreaStoneTest}" modelAttribute="ureaStoneTest">
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
          <label class="control-label">Размер камня</label>
          <form:input cssClass="form-control" path="size"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Плотность камня</label>
          <form:input cssClass="form-control" path="density"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Локализация камня</label>
          <form:input cssClass="form-control" path="location"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Вид камня</label>
          <form:input cssClass="form-control" path="form"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Твердость камня</label>
          <form:input cssClass="form-control" path="hardness"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Доп. информация</label>
          <form:input cssClass="form-control" path="addInfo"/>
        </div>
      </div>
      <div class="row">
        <button type="submit" class="btn btn-primary">Сохранить анализы</button>
      </div>
    </form:form>
  </fieldset>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>


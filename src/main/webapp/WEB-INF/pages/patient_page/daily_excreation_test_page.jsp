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
<c:url var="addDailyExcreationTest" value="/addDailyExcreationTest"/>
<div class="container">
  <fieldset>
    <legend>Суточная экскреция</legend>
    <form:form cssClass="form-horizontal" method="post" action="${addDailyExcreationTest}" modelAttribute="dailyExcreationTest">
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
          <label class="control-label">Креатинин</label>
          <form:input cssClass="form-control" path="creatinine"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Мочевина</label>
          <form:input cssClass="form-control" path="urea"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Мочевая кислота</label>
          <form:input cssClass="form-control" path="ureaAcid"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Кальций</label>
          <form:input cssClass="form-control" path="calcium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Калий</label>
          <form:input cssClass="form-control" path="potassium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Магний</label>
          <form:input cssClass="form-control" path="magnesium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Натрий</label>
          <form:input cssClass="form-control" path="sodium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Оксид Фосфора</label>
          <form:input cssClass="form-control" path="phosphorOxide"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Хлор</label>
          <form:input cssClass="form-control" path="chlorine"/>
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


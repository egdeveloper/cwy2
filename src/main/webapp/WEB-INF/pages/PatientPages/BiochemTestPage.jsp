<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/datepicker/css/datepicker.css"/>"/>
</head>
<body>
  <c:url var="addBiochemTest" value="/addBiochemTest"/>
  <div class="container">
    <fieldset>
      <legend>Биохимический анализ крови</legend>
      <form:form cssClass="form-horizontal" method="post" action="${addBiochemTest}" modelAttribute="biochemTest">
        <div class="row">
          <div class="form-group">
            <label class="control-label">Дата</label>
            <form:input cssClass="form-control dateField" path="testDate"/>
          </div>
        </div> <!-- testDate -->
        <div class="row">
          <div class="form-group">
            <label class="control-label">Описание</label>
            <form:input cssClass="form-control" path="description"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Общий белок</label>
            <form:input cssClass="form-control" path="commonProtein"/>
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
            <label class="control-label">Креатинин</label>
            <form:input cssClass="form-control" path="creatinine"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Общий билирубин</label>
            <form:input cssClass="form-control" path="commonBiliRuby"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Связанный билирубин</label>
            <form:input cssClass="form-control" path="linkedBiliRuby"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Холестерин</label>
            <form:input cssClass="form-control" path="cholesterol"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Триглицериды</label>
            <form:input cssClass="form-control" path="TAG"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Липопр. выс. кон.</label>
            <form:input cssClass="form-control" path="HDL"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Липопр. низ. кон.</label>
            <form:input cssClass="form-control" path="LDL"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Коэф. атер.</label>
            <form:input cssClass="form-control" path="cholesterolRatio"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Аланинаминотрасфераза</label>
            <form:input cssClass="form-control" path="ALT"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Аспартатаминотрансфераза</label>
            <form:input cssClass="form-control" path="AST"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Щелочная фосфотаза</label>
            <form:input cssClass="form-control" path="ALKP"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Креатинфосфокиназа</label>
            <form:input cssClass="form-control" path="CK"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Креатинфосфокиназа МВ</label>
            <form:input cssClass="form-control" path="CKMB"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Лактатдкгидрогеназа</label>
            <form:input cssClass="form-control" path="LDH"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">ГГТ</label>
            <form:input cssClass="form-control" path="GGT"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Амилаза</label>
            <form:input cssClass="form-control" path="amylase"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Пакриатическая амилаза</label>
            <form:input cssClass="form-control" path="pancrAmylase"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Глюкоза</label>
            <form:input cssClass="form-control" path="glucose"/>
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
            <label class="control-label">С-реактивный белок</label>
            <form:input cssClass="form-control" path="CRP"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Ревматоидный фактор</label>
            <form:input cssClass="form-control" path="RF"/>
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
            <label class="control-label">Натрий</label>
            <form:input cssClass="form-control" path="sodium"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Хлор</label>
            <form:input cssClass="form-control" path="chlorine"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Общий кальций</label>
            <form:input cssClass="form-control" path="commonCalcium"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Ионизированный кальций</label>
            <form:input cssClass="form-control" path="ionCalcium"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Фосфор</label>
            <form:input cssClass="form-control" path="phosphor"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Железо</label>
            <form:input cssClass="form-control" path="ferrum"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group">
            <label class="control-label">Ферритин</label>
            <form:input cssClass="form-control" path="ferritin"/>
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
  <script type="text/javascript" src="<c:url value="/resources/bootstrap-datepicker/datepicker/js/bootstrap-datepicker.js"/>"
  <script type="text/javascript">
    $(document).ready(function(){
      $(".dateField").datepicker({
        format : "dd.mm.yyyy",
        autoclose: true,
        locale: 'ru'
      });
    });
  </script>
</body>
</html>

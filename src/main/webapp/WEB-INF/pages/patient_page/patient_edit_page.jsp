<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
</head>
<c:url var="editAction" value="/editPatientInfo"/>
<body>
<div class="container">
  <form:form cssClass="form" cssStyle="margin-left: 10px; margin-top: 10px;" role="form" method="post" action="${editAction}" modelAttribute="patientInfo">
    <div class="form-group">
      <label class="col-lg-3 control-label">ФИО</label>
      <form:input cssClass="form-control" path="fullName" id="fullNameInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Пол</label>
      <form:select cssClass="form-control" path="gender">
        <form:option value="MALE">мужской</form:option>
        <form:option value="FEMALE">женский</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Дата рождения</label>
      <form:input cssClass="form-control" path="birthdate" id="birthdateInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Номер карты</label>
      <form:input path="cardNumber" id="cardNumberInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Паспорт</label>
      <form:input path="passport" id="passportInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Номер телефона</label>
      <form:input path="phoneNumber" id="phoneNumberInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Страна</label>
      <form:input path="country" id="countryInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Почтовый индекс</label>
      <form:input path="postIndex" id="postIndexInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Регион</label>
      <form:input path="region" id="regionInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Населенный пункт</label>
      <form:input path="city" id="cityInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Адрес</label>
      <form:input path="address" id="addressInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Email</label>
      <form:input path="email" id="emailInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Резус-фактор</label>
      <form:select cssClass="form-control" path="rh">
        <form:option value="POSITIVE">Rh+</form:option>
        <form:option value="NEGATIVE">Rh-</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="control-label">Группа крови</label>
      <form:select cssClass="form-control" path="bloodGroup">
        <form:option value="I">I</form:option>
        <form:option value="II">II</form:option>
        <form:option value="III">III</form:option>
        <form:option value="IV">IV</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="control-label">Группа здоровья</label>
      <form:select cssClass="form-control" path="disability">
        <form:option value="NONE">нет</form:option>
        <form:option value="I">I</form:option>
        <form:option value="II">II</form:option>
        <form:option value="III">III</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="control-label">ИНН</label>
      <form:input cssClass="form-control" path="TIN" id="TINInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Медицинская карта</label>
      <form:input cssClass="form-control" path="OMICard" id="OMICardInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Место работы</label>
      <form:input cssClass="form-control" path="jobPlace" id="jobPlaceInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Профессия</label>
      <form:input cssClass="form-control" path="occupation" id="occupationInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Должность</label>
      <form:input cssClass="form-control" path="jobPost" id="jobPostInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Условия работы</label>
      <form:input cssClass="form-control" path="jobConditions" id="jobConditionsInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Жалобы при поступлении</label>
      <form:input cssClass="form-control" path="complaints" id="complainsInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Лечение до поступления</label>
      <form:input cssClass="form-control" path="premedication" id="premedicationInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Сопутствующее заболевания</label>
      <form:input cssClass="form-control" path="associatedDisease" id="associatedDiseaseInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Назначения до поступления</label>
      <form:input cssClass="form-control" path="preMedicalSupplies" id="preMedicalSuppliesInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Вредные привычки</label>
      <form:input cssClass="form-control" path="badHabits" id="badHabitsInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Описание камня до поступления</label>
      <form:input cssClass="form-control" path="preUreaStoneDescription" id="preUreaStoneDescriptionInput"/>
    </div>
    <div class="form-group">
      <label class="control-label">Длительность заболевания</label>
      <form:input cssClass="form-control" path="diseaseDuration" id="diseaseDurationInput"/>
    </div>
    <button type="submit" class="btn btn-primary">Сохранить</button>
  </form:form>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>

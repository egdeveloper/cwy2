<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/datepicker/css/datepicker.css"/>"/>
    <style>
      .error{
        color: red;
      }
    </style>
</head>
<c:url var="createPatientEntry" value="/createPatientEntry"/>
<body style="padding-top: 70px;">
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <div class="navbar-brand">LaksmiMed</div>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<c:url value="/main"/>">Главная</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Сайт <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/about"/>">О сайте</a></li>
          <li><a href="<c:url value="/help"/>">Помощь</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Статистика <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/beforeTreatmentStatVisualization"/>">До лечения</a></li>
          <li><a href="<c:url value="/indicatorDeviationsStatPage"/>">Отклонения от нормы</a></li>
          <li><a href="<c:url value="/indicatorDeviationsForStoneTypeStatPage"/>">По типу камня</a></li>
        </ul>
      </li>
      <li><a href="<c:url value="/patientList"/>">Пациенты</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/logout"/>">Выйти</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  <form:form id="createPatientEntryForm" cssClass="form" cssStyle="margin-left: 10px; margin-top: 10px;" role="form" method="post" action="${createPatientEntry}" modelAttribute="patientEntry">
    <div class="form-group">
      <label class="col-lg-3 control-label">ФИО <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="fullName" id="fullNameInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Пол <span style="color: red">*</span></label>
      <form:select cssClass="form-control" path="gender">
        <form:option value="MALE">мужской</form:option>
        <form:option value="FEMALE">женский</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Дата рождения <span style="color: red">*</span></label>
      <form:input cssClass="form-control dateField" path="birthdate" id="birthdateInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Номер карты <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="cardNumber" id="cardNumberInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Паспорт <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="passport" id="passportInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Номер телефона <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="phoneNumber" id="phoneNumberInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Страна <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="country" id="countryInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Почтовый индекс <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="postIndex" id="postIndexInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Регион <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="region" id="regionInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Населенный пункт <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="city" id="cityInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Адрес <span style="color: red">*</span></label>
      <form:input cssClass="form-control" path="address" id="addressInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Email</label>
      <form:input cssClass="form-control" path="email" id="emailInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Состояние пациента</label>
      <form:select cssClass="form-control" path="patientState">
        <form:option value="HEALTHY">здоров</form:option>
        <form:option value="FAIR">стабилен</form:option>
        <form:option value="SERIOUS">болен</form:option>
        <form:option value="CRITICAL">серьезно болен</form:option>
        <form:option value="UNDERTERMINED">неопределенное</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Резус-фактор</label>
      <form:select cssClass="form-control" path="rh">
        <form:option value="POSITIVE">Rh+</form:option>
        <form:option value="NEGATIVE">Rh-</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Группа крови</label>
      <form:select cssClass="form-control" path="bloodGroup">
        <form:option value="I">I</form:option>
        <form:option value="II">II</form:option>
        <form:option value="III">III</form:option>
        <form:option value="IV">IV</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Группа здоровья</label>
      <form:select cssClass="form-control" path="disability">
        <form:option value="NONE">нет</form:option>
        <form:option value="I">I</form:option>
        <form:option value="II">II</form:option>
        <form:option value="III">III</form:option>
      </form:select>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">ИНН</label>
      <form:input cssClass="form-control" path="TIN" id="TINInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Страховой полис</label>
      <form:input cssClass="form-control" path="OMICard" id="omiCardInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Место работы</label>
      <form:input cssClass="form-control" path="jobPlace" id="jobPlaceInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Профессия</label>
      <form:input cssClass="form-control" path="occupation" id="occupationInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Должность</label>
      <form:input cssClass="form-control" path="jobPost" id="jobPostInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Условия работы</label>
      <form:input cssClass="form-control" path="jobConditions" id="jobConditionsInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Жалобы при поступлении</label>
      <form:input cssClass="form-control" path="complaints" id="complainsInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Лечение до поступления</label>
      <form:input cssClass="form-control" path="premedication" id="premedicationInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Сопутствующее заболевания</label>
      <form:input cssClass="form-control" path="associatedDisease" id="associatedDiseaseInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Назначения до поступления</label>
      <form:input cssClass="form-control" path="preMedicalSupplies" id="preMedicalSuppliesInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Вредные привычки</label>
      <form:input cssClass="form-control" path="badHabits" id="badHabitsInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Описание камня до поступления</label>
      <form:input cssClass="form-control" path="preUreaStoneDescription" id="preUreaStoneDescriptionInput"/>
    </div>
    <div class="form-group">
      <label class="col-lg-3 control-label">Длительность заболевания</label>
      <form:input cssClass="form-control" path="diseaseDuration" id="diseaseDurationInput"/>
    </div>
    <button id="createPatientEntryButton" type="button" class="btn btn-primary">Сохранить</button>
  </form:form>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/jquery-mask/jquery.mask.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap-datepicker/datepicker/js/bootstrap-datepicker.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/typehead/typehead.js"/>"></script>
<script>

  createPatientEntryForm = $("#createPatientEntryForm");

  $(document).ready(function(){
    $(".dateField").datepicker({
      format : "dd.mm.yyyy",
      autoclose: true,
      locale: 'ru'
    });
    createPatientEntryForm.validate({
      rules: {
        fullName: {
          required: true
        },
        birthdate: {
          required: true
        },
        cardNumber: {
          required: true
        },
        passport: {
          required: true
        },
        phoneNumber: {
          required: true
        },
        country: {
          required: true
        },
        postIndex: {
          required: true
        },
        region: {
          required: true
        },
        city: {
          required: true
        },
        address: {
          required: true
        },
        email: {
          email: true
        }
      },
      focusCleanup: true,
      onkeyup: false,
      messages: {
        fullName: {
          required: "Введите ФИО пациента!"
        },
        birthdate: {
          required: "Введите дату рождения!"
        },
        cardNumber: {
          required: "Введите номер карты!"
        },
        passport: {
          required: "Введите паспортные данные!"
        },
        phoneNumber: {
          required: "Введите номер телефона!"
        },
        country: {
          required: "Введите страну проживания!"
        },
        postIndex: {
          required: "Введите почтовый индекс!"
        },
        region: {
          required: "Введите регион проживания!"
        },
        city: {
          required: "Введите населенный пункт!"
        },
        address: {
          required: "Введите адрес проживания!"
        },
        email: {
          email: "Электронная почта задана неправильно!"
        }
      }
    });
    $("#phoneNumberInput").mask("+7-(999)-999-99-99", {placeholder: "+7-(___)-___-__-__"});
  });

  $("#createPatientEntryButton").click(function(){
    if(createPatientEntryForm.valid()){
      createPatientEntryForm.submit();
    }
  });
  var states = ["Адыгея Респ",
    "Алтай Респ",
    "Алтайский край",
    "Амурская обл",
    "Архангельская обл",
    "Астраханская обл",
    "Башкортостан Респ",
    "Белгородская обл",
    "Брянская обл",
    "Бурятия Респ",
    "Владимирская обл",
    "Волгоградская обл",
    "Вологодская обл",
    "Воронежская обл",
    "Дагестан Респ",
    "Еврейская Аобл",
    "Забайкальский край",
    "Ивановская обл",
    "Ингушетия Респ",
    "Иркутская обл",
    "Кабардино-Балкарская Респ",
    "Калининградская обл",
    "Калмыкия Респ",
    "Калужская обл",
    "Камчатский край",
    "Карачаево-Черкесская Респ",
    "Карелия Респ",
    "Кемеровская обл",
    "Кировская обл",
    "Коми Респ",
    "Костромская обл",
    "Краснодарский край",
    "Красноярский край",
    "Курганская обл",
    "Курская обл",
    "Ленинградская обл",
    "Липецкая обл",
    "Магаданская обл",
    "Марий Эл Респ",
    "Мордовия Респ",
    "Москва г",
    "Московская обл",
    "Мурманская обл",
    "Ненецкий АО",
    "Нижегородская обл",
    "Новгородская обл",
    "Новосибирская обл",
    "Омская обл",
    "Оренбургская обл",
    "Орловская обл",
    "Пензенская обл",
    "Пермский край",
    "Приморский край",
    "Псковская обл",
    "Ростовская обл",
    "Рязанская обл",
    "Самарская обл",
    "Санкт-Петербург г",
    "Саратовская обл",
    "Саха /Якутия/ Респ",
    "Сахалинская обл",
    "Свердловская обл",
    "Северная Осетия - Алания Респ",
    "Смоленская обл",
    "Ставропольский край",
    "Тамбовская обл",
    "Татарстан Респ",
    "Тверская обл",
    "Томская обл",
    "Тульская обл",
    "Тыва Респ",
    "Тюменская обл",
    "Удмуртская Респ",
    "Ульяновская обл",
    "Хабаровский край",
    "Хакасия Респ",
    "Ханты-Мансийский Автономный округ - Югра АО",
    "Челябинская обл",
    "Чеченская Респ",
    "Чувашская Респ",
    "Чукотский АО",
    "Ямало-Ненецкий АО",
    "Ярославская обл"
  ];
</script>
</body>
</html>

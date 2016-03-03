<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/datepicker/css/datepicker.css"/>"/>
    <script type="text/javascript" src="<c:url value="/resources/js/plotly.js"/>"></script>
</head>
<body style="padding-top: 60px;">
<c:url var="updatePatientEntry" value="/updatePatientEntry"/>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">LaksmiMed</div>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/main"/>">Главная</a></li>
                <li><a href="<c:url value="/about"/>">О сайте</a></li>
                <li><a href="<c:url value="/help"/>">Помощь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/personalPage"/>">Личная страница</a></li>
                <li><a href="<c:url value="/logout"/>">Выйти</a></li>
            </ul>
        </div>
    </nav>
    <ul class="nav nav-tabs" role="tablist" style="margin-top:20px">
        <li class="active"><a href="#mainPatientInfo" data-toggle="tab">Основные сведения о пациенте</a></li>
        <li><a href="#medicalPatientInfo" data-toggle="tab">Медицинские сведения о пациенте</a></li>
        <li><a href="#medicalTests" data-toggle="tab">Медицинские анализы</a></li>
        <li><a href="#testDynamics" data-toggle="tab">Динамика показателей</a></li>
    </ul>
    <form:form id="patientInfoForm" cssClass="form-horizontal" role="form" modelAttribute="patient" action="${updatePatientEntry}">
        <div class="tab-content" style="width: 100%; padding-top: 20px; padding-bottom: 20px;">
            <div class="tab-pane active" id="mainPatientInfo" style="margin-top:10px;">
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">ФИО: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="fullName"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Дата рождения: </label>
                    <div class="col-sm-10">
                        <form:input id="birthdateInput" cssClass="form-control patientInfoField dateField" readonly="true" cssStyle="background-color: #ffffff" path="birthdate"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Пол: </label>
                    <div class="col-sm-10">
                        <form:select cssClass="form-control" path="gender" >
                            <form:option value="MALE">мужской</form:option>
                            <form:option value="FEMALE">женский</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Номер карты: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="cardNumber"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Email: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="email"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Телефон: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="phoneNumber"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Почтовый индекс: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="postIndex"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Страна: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="country"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Регион: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="region"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Населенный пункт: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="city"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Адрес проживания: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="address"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Паспортные данные: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="passport"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Страховой полис: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="OMICard"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">ИНН: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="TIN"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Профессиональная специальность: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="occupation"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Должность: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="jobPost"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Место работы: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="jobPlace"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Условия работы: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="jobConditions"/>
                    </div>
                </div>
                <div class="row pull-right" style="margin-top: 20px;">
                    <button id="updatePatientInfoButton" class="btn btn-success" type="button">Обновить</button>
                    <button id="cancelButton" class="btn btn-warning" type="button">Отмена</button>
                </div>
            </div>
            <div class="tab-pane" id="medicalPatientInfo" style="margin-top:10px">
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Резус-фактор: </label>
                    <div class="col-sm-10">
                        <form:select cssClass="form-control" path="rh">
                            <form:option value="POSITIVE">Rh+</form:option>
                            <form:option value="NEGATIVE">Rh-</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Группа крови: </label>
                    <div class="col-sm-10">
                        <form:select cssClass="form-control" path="bloodGroup">
                            <form:option value="I">I</form:option>
                            <form:option value="II">II</form:option>
                            <form:option value="III">III</form:option>
                            <form:option value="IV">IV</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Группа здоровья: </label>
                    <div class="col-sm-10">
                        <form:select cssClass="form-control" path="disability">
                            <form:option value="NONE">нет</form:option>
                            <form:option value="I">I</form:option>
                            <form:option value="II">II</form:option>
                            <form:option value="III">III</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Жалобы при поступлении: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="complaints"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Сопутствующее заболевания: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="associatedDisease"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Вредные привычки: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="badHabits"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Описание камня до поступления: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="preUreaStoneDescription"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Длительность заболевания: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="diseaseDuration"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Лечение до поступления: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="premedication"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Назначения до поступления: </label>
                    <div class="col-sm-10">
                        <form:input cssClass="form-control patientInfoField" readonly="true" cssStyle="background-color: #ffffff" path="preMedicalSupplies"/>
                    </div>
                </div>
            </div>
            <div class="tab-pane" id="medicalTests" style="margin-top: 10px">
                <div class="row">

                </div>
                <div class="row">
                    <table class="table table-striped table-bordered" cellpadding="0" width="100%">
                        <thead>
                            <tr>
                                <td>№</td>
                                <td>Тип анализа</td>
                                <td>Дата проведения</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="test" items="${patient.retrieveAllPatientTests()}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${test.retrieveName()}</td>
                                    <td>${test.testDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addCommonBloodTest"/>">
                        <button class="col-md-5 btn btn-primary">Общий анализ крови</button>
                    </form>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addBiochemTest"/>">
                        <button class="col-md-5 btn btn-primary">Биохимический анализ</button>
                    </form>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addCommonUreaTest"/>">
                        <button class="col-md-5 btn btn-primary">Общий анализ мочи</button>
                    </form>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addDailyExcreationTest"/>">
                        <button class="col-md-5 btn btn-primary">Суточная экскреция</button>
                    </form>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addTitrationTest"/>">
                        <button class="col-md-5 btn btn-primary">Титриметрия</button>
                    </form>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addUreaColorTest"/>">
                        <button class="col-md-5 btn btn-primary">Хроматография</button>
                    </form>
                </div>
                <div class="form-group row">
                    <form method="get" action="<c:url value="/addUreaStoneTest"/>">
                        <button class="col-md-5 btn btn-primary">Мочевой камень</button>
                    </form>
                </div>
            </div>
            <div class="tab-pane" id="testDynamics" style="margin-top: 10px;">
                <div class="row">
                    <form>
                        <div class="col-md-5">
                            <select id="medicalTestTypeSelection" class="form-control">
                                <option disabled>Выберите тип анализа</option>
                                <option value="bioChemTest">Биохимический анализ крови</option>
                                <option value="commonBloodTest">Общий анализ крови</option>
                                <option value="commonUreaTest">Общий анализ мочи</option>
                                <option value="dailyExcreationTest">Суточная экскреция</option>
                                <option value="titrationTest">Титриметрия</option>
                                <option value="ureaColorTest">Хроматография</option>
                                <option value="ureaStoneTest">Мочевой камень</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <button id="retrieveTestDynamicsButton" class="btn btn-success" type="button">Получить динамику</button>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <div id="testDynamicsCharts" style="padding-top: 30px;">

                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap-datepicker/datepicker/js/bootstrap-datepicker.js"/>"></script>
<script type="text/javascript">

    $(document).ready(function(){
        $(".dateField").datepicker({
            format : "dd.mm.yyyy",
            autoclose: true,
            locale: 'ru'
        });
    });

    function retrieveTestDynamics(patientId, callback){
        $.getJSON("/indicatorsDynamics/" + patientId.toString(), callback);
    }

    function visualizeTestDynamics(testType, testData){
        $("#testDynamicsCharts").empty();
        var testIndicators = testData[testType];
        var i = 1;
        Object.keys(testIndicators).map(function(indicatorKey){
            if($.isEmptyObject(testIndicators[indicatorKey]))
                return;
            var timePoints = Object.keys(testIndicators[indicatorKey]).map(function(timeKey){
                return timeKey + " 00:00:00";
            });
            var valuePoints = Object.keys(testIndicators[indicatorKey]).map(function(timeKey){
                return testIndicators[indicatorKey][timeKey];
            });
            var chartData = [{
                x: timePoints,
                y: valuePoints,
                type: 'scatter'
            }];
            var containerID = testType.toString() + "Indicator" + i.toString();
            var containerTags = '<div class="panel panel-default" style="margin-bottom: 40px;"><div class="panel-heading">'
                    + indicatorKey + '</div>'
                    + '<div class="panel-body"><div id="' + containerID + '"></div></div></div>';
            var layout = {
                title: indicatorKey,
                xaxis: {title: "Дата проведения"},
                yaxis: {title: indicatorKey}
            };
            $("#testDynamicsCharts").append(containerTags);
            Plotly.newPlot(containerID, chartData, layout);
            i++;
        });
    }

    var patientInfoUpdated = false;
    var patientInfoFields = document.getElementsByClassName("patientInfoField");
    $("#updatePatientInfoButton").click(function(){
        if(!patientInfoUpdated){
            document.getElementById("updatePatientInfoButton").innerHTML = "Сохранить";
            for(var i = 0; i < patientInfoFields.length; i++){
                patientInfoFields[i].readOnly = false;
            }
            patientInfoUpdated = true;
        }
        else{
            $("#patientInfoForm").submit();
            document.getElementById("updatePatientInfoButton").innerHTML = "Обновить";
            for(var i = 0; i < patientInfoFields.length; i++){
                patientInfoFields[i].readOnly = true;
            }
            patientInfoUpdated = false;
        }
    });

    $("#retrieveTestDynamicsButton").click(function(){
        var testSelection = document.getElementById("medicalTestTypeSelection");
        var testType = testSelection.options[testSelection.selectedIndex].getAttribute("value");
        retrieveTestDynamics(${patient.id}, function(data){
            visualizeTestDynamics(testType, data);
        });
    });
</script>
</html>

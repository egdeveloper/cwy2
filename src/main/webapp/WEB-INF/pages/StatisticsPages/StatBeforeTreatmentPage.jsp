<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: egdeveloper
  Date: 29.02.16
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <script type="text/javascript" src="<c:url value="/resources/js/plotly.js"/>"></script>
</head>
<body style="padding-top: 70px;">
    <div class="container">
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
                    <li><a href="<c:url value="/beforeTreatmentStatVisualization"/>">Статистика</a></li>
                    <li><a href="<c:url value="/patientList"/>">Пациенты</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/personalPage"/>">Личная страница</a></li>
                    <li><a href="<c:url value="/logout"/>">Выйти</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Статистика пациентов по признаку "Продолжительность заболевания"
                </div>
                <div class="panel-body">
                    <div id="durationStatBar" style="position: relative; width: 400px; height: 400px;"></div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Статистика пациентов по признаку "Пол"
                </div>
                <div class="panel-body">
                    <div id="genderStatBar" style="position: relative; width: 400px; height: 400px;"></div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Статистика пациентов по признаку "Возраст"
                </div>
                <div class="panel-body">
                    <div id="ageStatBar" style="position: relative; width: 400px; height: 400px;"></div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Статистика пациентов по признаку "Регион проживания"
                </div>
                <div class="panel-body">
                    <div id="regionStatBar" style="position: relative; width: 400px; height: 400px;"></div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Статистика пациентов по признаку "Вредные привычки"
                </div>
                <div class="panel-body">
                    <div id="badHabitsStatBar" style="position: relative; width: 400px; height: 400px;"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/pathFactory.js"/>"></script>
    <script>
        String.prototype.isEmpty = function() {
            return (this.length === 0 || !this.trim());
        };
        function requestForBeforeTreatmentStat(requestURL, callback){
            $.getJSON(requestURL, callback);
        }
        function visualizeBeforeTreatmentStatData(statData){
            var volume = statData.volume;
            var genderData = [{
                x: Object.keys(statData.gender),
                y: Object.keys(statData.gender).map(function(key){
                    return statData.gender[key] / volume * 100
                }),
                type: 'bar'
            }];
            var durationData = [{
                x: Object.keys(statData.duration).map(function(key){
                    if(parseInt(key) >= 5)
                        return key.toString() + " лет";
                    if(parseInt(key) == 1)
                        return key.toString() + " год";
                    if(key.isEmpty() || parseInt(key) == 0)
                        return "не было";
                    return key.toString() + " года";
                }),
                y: Object.keys(statData.duration).map(function(key){
                    return statData.duration[key] / volume * 100;
                }),
                type: 'bar'
            }];
            var ageData = [{
                x: Object.keys(statData.age).map(function(key){
                    return key.toString() + "-" + (parseInt(key) + 9).toString();
                }),
                y: Object.keys(statData.duration).map(function(key){
                    return statData.duration[key] / volume * 100;
                }),
                type: 'bar'
            }];
            var regionData = [{
                x: Object.keys(statData.region),
                y: Object.keys(statData.region).map(function(key){
                    return statData.region[key] / volume * 100;
                }),
                type: 'bar'
            }];
            var badHabitsData = [{
                x: Object.keys(statData.badHabits).map(function(key){
                    if(key.isEmpty() == true)
                        return "нет";
                    else
                        return key;
                }),
                y: Object.keys(statData.badHabits).map(function(key){
                    return statData.badHabits[key] / volume * 100;
                }),
                type: 'bar'
            }];
            Plotly.newPlot('genderStatBar', genderData, {title: 'Пол пациента'});
            Plotly.newPlot('durationStatBar', durationData, {title: 'Продолжительность заболевания'});
            Plotly.newPlot('ageStatBar', ageData, {title: 'Возраст пациента'});
            Plotly.newPlot('regionStatBar', regionData, {title: 'Регион проживания'});
            Plotly.newPlot('badHabitsStatBar', badHabitsData, {title: 'Вредные привычки'});
        }
        $(document).ready(function(){
            requestForBeforeTreatmentStat(retrievePath("/beforeTreatmentStat"), visualizeBeforeTreatmentStatData);
        });
    </script>
</body>
</html>

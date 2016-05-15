<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика отклонений показателей</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <script type="text/javascript" src="<c:url value="/resources/js/plotly.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/canvasjs/canvasjs.min.js"/>"></script>
</head>
<body style="padding-top: 80px;">
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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Статистика <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/beforeTreatmentStatVisualization"/>">До лечения</a></li>
                        <li><a href="<c:url value="/indicatorDeviationsStatPage"/>">Отклонения от нормы</a></li>
                        <li><a href="<c:url value="/indicatorDeviationsForStoneTypeStatPage"/>">По типу камня</a></li>
                        <li><a href="<c:url value="/stoneComponentsStatPage"/>">Компоненты мочевых камней</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/patientList"/>">Пациенты</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/personalPage"/>">Личная страница</a></li>
                <li><a href="<c:url value="/logout"/>">Выйти</a></li>
            </ul>
        </div>
    </nav>
    <div class="row">
        <div class="col-md-4">
            <select id="testSelection" class="form-control">
                <option disabled selected>Выберите тип анализа</option>
                <option value="bioChemTest">Биохимический анализ крови</option>
                <option value="commonBloodTest">Общий анализ крови</option>
                <option value="commonUreaTest">Общий анализ мочи</option>
                <option value="dailyExcreationTest">Суточная экскреция</option>
                <option value="titrationTest">Титриметрия</option>
                <option value="ureaColorTest">Хроматография</option>
                <option value="stoneInVivoTest">Камень In Vivo</option>
                <option value="stoneInVitroTest">Камень In Vitro</option>
            </select>
        </div>
        <div class="col-md-4">
            <select id="treatmentNumberSelection" class="form-control">
                <option disabled selected>Выберите стадию лечения</option>
                <option value="NONE">не было</option>
                <option value="I">лечение 1</option>
                <option value="II">лечение 2</option>
                <option value="III">лечение 3</option>
                <option value="IV">лечение 4</option>
                <option value="V">лечение 5</option>
                <option value="VI">лечение 6</option>
                <option value="VII">лечение 7</option>
                <option value="VIII">лечение 8</option>
                <option value="IX">лечение 9</option>
                <option value="X">лечение 10</option>
                <option value="XI">лечение 11</option>
                <option value="XII">лечение 12</option>
            </select>
        </div>
        <div class="col-md-4">
            <button id="updateStatButton" class="btn btn-success" type="button">Обновить статистику</button>
        </div>
    </div>
    <div class="row" id="statInfoAlert" style="margin-top: 20px;"></div>
    <div id="indicatorDeviationsBar" style="margin-top: 40px; width: 100%; height: 100%;"></div>
    <div id="indicatorDeviationsTable" style="margin-top: 20px; margin-bottom: 40px; width: 100%;"></div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootbox/bootbox.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/pathFactory.js"/>"></script>
<script>
    var testSelected = "";
    function visualizeDeviationsStat(statData){
        $("#statInfoAlert").empty();
        $("#indicatorDeviationsBar").empty();
        $("#indicatorDeviationsTable").empty();
        var testStat = statData[testSelected];
        var name = testStat["name"];
        var volume = testStat["volume"];
        if(volume > 0){
            var indicators = testStat["indicators"];
            var table = "<table class='table table-bordered table-striped'>" +
                    "<thead>" +
                    "<tr>" +
                    "<th>Показатель</th>" +
                    "<th>Доля отклонений</th>" +
                    "<th>Объем выборки</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>";
            Object.keys(indicators).forEach(function(key){
                if(indicators[key].volume > 0) {
                    table = table.concat("<tr>" +
                            "<td>" + key + "</td>" +
                            "<td>" + (indicators[key].deviations / indicators[key].volume) * 100 + "%</td>" +
                            "<td>" + indicators[key].volume + "</td>" +
                            "</tr>");
                }
            });
            table.concat("</tbody></table>");
            $("#indicatorDeviationsTable").append(table);

            var indicatorsKeys = Object.keys(indicators).filter(function(key){
                return indicators[key].volume > 0;
            });
            var indicatorsStat = indicatorsKeys.map(function(key){
                return {y: (indicators[key].deviations / indicators[key].volume) * 100, label: key};
            });
            var chart = new CanvasJS.Chart("indicatorDeviationsBar", {
                title:{
                    text: name + " - статистика отклонений показателей",
                    fontSize: 20,
                    margin: 10
                },
                height: volume * 25,
                axisX:{
                    interval: 1,
                    gridThickness: 0,
                    labelFontSize: 14,
                    labelFontStyle: "normal",
                    labelFontWeight: "normal",
                    labelFontFamily: "Lucida Sans Unicode"

                },
                axisY2:{
                    interlacedColor: "rgba(1,77,101,.2)",
                    gridColor: "rgba(1,77,101,.1)",
                    labelFontSize: 14,
                    labelFontStyle: "normal",
                    labelFontWeight: "normal",
                    labelFontFamily: "Lucida Sans Unicode",
                    maximum: 100.0
                },
                data: [
                    {
                        type: "bar",
                        name: "Показатели",
                        axisYType: "secondary",
                        color: "#014D65",
                        dataPoints: indicatorsStat
                    }

                ]
            });
            $("#indicatorDeviationsBar").css({"height" : volume * 25});
            chart.render();
        }
        else{
            $("#statInfoAlert").append(
                    "<div class='alert alert-warning'>"
                    + "Статистика по заданному типу анализа пуста!"
                    + "</div>");
        }
    }
    $("#updateStatButton").click(function(){
       if($("#testSelection").val() != null && $("#treatmentNumberSelection").val() != null){
           testSelected = $("#testSelection").val();
           $.getJSON(retrievePath("/indicatorDeviations/" + $("#treatmentNumberSelection").val()), visualizeDeviationsStat);
       }
       else{

           bootbox.alert("Выберите тип обследования или стадию лечения!");
       }
    });
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика отклонений показателей по типу мочевого камня</title>
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
        <div class="col-md-3">
            <select id="testSelection" class="form-control">
                <option disabled selected>Выберите тип анализа</option>
                <option value="dailyExcreationTest">Суточная экскреция</option>
                <option value="ureaColorTest">Хроматография</option>
                <option value="titrationTest">Титриметрия</option>
            </select>
        </div>
        <div class="col-md-3">
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
        <div class="col-md-2">
            <button id="updateStatButton" class="btn btn-success" type="button">Обновить статистику</button>
        </div>
        <div class="col-md-2">
            <div class="radio">
                <label><input id="oneHistOption" type="radio" name="visPar" value="oneHist">Одна гистограмма</label>
            </div>
        </div>
        <div class="col-md-2">
            <div class="radio">
                <label><input id="sepHistOption" type="radio" name="visPar" value="sepHist">Отдельно</label>
            </div>
        </div>
    </div>
    <div class="row" id="statInfoAlert" style="margin-top: 20px;"></div>
    <div id="barContainer" style="margin-bottom: 40px;"></div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootbox/bootbox.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/pathFactory.js"/>"></script>
<script>
    String.prototype.capitalizeFirstLetter = function(){
      return this.charAt(0).toUpperCase() + this.slice(1);
    };
    var testSelected = "";
    function visualizeDeviationsStat(stoneData){
        $("#statInfoAlert").empty();
        $("#barContainer").empty();
        var deviationsStat = {};
        var volume = 0;
        var stoneCount = 0;
        Object.keys(stoneData).forEach(function(stone){
            var self = this;
            var test = stoneData[stone][testSelected];
            if(test["volume"] > 0){
                stoneCount++;
                deviationsStat[stone] = {};
                volume = volume < test["volume"] ? test["volume"] : volume;
                var indicatorsStat = Object.keys(test["indicators"]).map(function(indicator){
                    return {y: (test["indicators"][indicator].deviations / test["indicators"][indicator].volume) * 100, label: indicator};
                }).filter(function(dataPoint){
                    return dataPoint.y > 0;
                });
                deviationsStat[stone]["stoneType"] = stoneData[stone]["stoneType"];
                deviationsStat[stone]["indicatorsStat"] = indicatorsStat;
            }
        });
        var colors = {
            OXALATES: "rgba(106, 43, 194, .9)",
            URATES: "rgba(212, 113, 21, .9)",
            PHOSPHATES: "rgba(11, 184, 28, .9)",
            OXALATES_URATES: "rgba(212, 11, 57, .9)",
            OXALATES_PHOSPHATES: "rgba(6, 174, 204, .9)",
            URATES_PHOSPHATES: "rgba(167, 39, 176, .9)",
            OXALATES_URATES_PHOSPHATES: "rgba(16, 147, 199, .9)"
        };
        if(volume > 0) {
            if($("input[name=visPar]").filter(":checked").val() == "oneHist"){
                var barData = {
                    title: {
                        text: $("#testSelection option:selected").text() + " - статистика отклонений показателей",
                        fontSize: 35,
                        margin: 20
                    },
                    dataPointWidth: 25,
                    height: volume * 30 * stoneCount,
                    legend:{
                        horizontalAlign: "right",
                        verticalAlign: "center",
                        fontSize: 18
                    },
                    axisX: {
                        //labelMaxWidth: 400,
                        labelAutoFit: true,
                        labelFontSize: 14,
                        interval: 1,
                        gridThickness: 0,
                        labelFontStyle: "normal",
                        labelFontWeight: "normal",
                        labelFontFamily: "Lucida Sans Unicode"

                    },
                    axisY: {
                        labelFontSize: 14,
                        labelFontStyle: "normal",
                        labelFontWeight: "normal",
                        labelFontFamily: "Lucida Sans Unicode",
                        maximum: 100.0
                    }
                };
                barData["data"] = Object.keys(deviationsStat).map(function(stone){
                    return {
                        type: "bar",
                        showInLegend: true,
                        legendText: deviationsStat[stone]["stoneType"],
                        color: colors[stone],
                        dataPoints: deviationsStat[stone]["indicatorsStat"]
                    }
                });
                $("#barContainer").append("<div id='indicatorDeviationsBar' style='margin-top: 40px; margin-bottom: 40px; width: 100%; height: 100%;'></div>");
                var chart = new CanvasJS.Chart("indicatorDeviationsBar", barData);
                $("#indicatorDeviationsBar").css({"height": volume * 25});
                chart.render();
            }
            else if($("input[name=visPar]").filter(":checked").val() == "sepHist"){
                Object.keys(deviationsStat).forEach(function(stone){
                    var graphID = stone + "DeviationsStat";
                    var graphTags = "<div style='margin-top: 40px; width: 100%;' id='" + graphID + "'></div>";
                    var barData = {
                        title: {
                            text: deviationsStat[stone]["stoneType"].capitalizeFirstLetter() + " - " + $("#testSelection option:selected").text(),
                            fontSize: 20,
                            margin: 10
                        },
                        dataPointWidth: 40,
                        height: stoneData[stone][testSelected]["volume"] * 45,
                        legend:{
                            horizontalAlign: "right",
                            verticalAlign: "center",
                            fontSize: 14
                        },
                        axisX: {
                            //labelMaxWidth: 400,
                            labelAutoFit: true,
                            labelFontSize: 14,
                            interval: 1,
                            gridThickness: 0,
                            labelFontStyle: "normal",
                            labelFontWeight: "normal",
                            labelFontFamily: "Lucida Sans Unicode"

                        },
                        axisY: {
                            labelFontSize: 14,
                            labelFontStyle: "normal",
                            labelFontWeight: "normal",
                            labelFontFamily: "Lucida Sans Unicode",
                            maximum: 100.0
                        },
                        data: {
                            type: "bar",
                            showInLegend: true,
                            legendText: deviationsStat[stone]["stoneType"],
                            color: colors[stone],
                            dataPoints: deviationsStat[stone]["indicatorsStat"]
                        }
                    };
                    $("#barContainer").append(graphTags);
                    var chart = new CanvasJS.Chart(graphID, barData);
                    $(graphID).css({"height": stoneData[stone][testSelected][volume] * 25});
                    chart.render();
                });
            }
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
            $.getJSON(retrievePath("/indicatorDeviationsForStoneType/" + $("#testSelection").val() + "/" + $("#treatmentNumberSelection").val()), visualizeDeviationsStat);
        }
        else{
            bootbox.alert("Выберите тип обследования или стадию лечения!");
        }
    });
</script>
</body>
</html>

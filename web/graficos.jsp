<%-- 
    Document   : graficos
    Created on : 26/05/2019, 16:06:40
    Author     : Thaís
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Grafícos</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/ionicons/css/ionicons.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/typicons/src/font/typicons.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="bootstrap/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="bootstrap/vendors/css/vendor.bundle.addons.css">

        <link rel="stylesheet" href="bootstrap/css/shared/style.css">
        <link rel="stylesheet" href="bootstrap/css/demo_1/style.css">
        <link rel="shortcut icon" href="bootstrap/images/favicon.png" />
    </head>
    <body>
        <%if (session.getAttribute("userLogado") == null) {
                response.sendRedirect("entrar.jsp");
            }%>
        <c:if test="${listaPais == null}">
            <jsp:include page="/buscaInfo" flush="true"/>
        </c:if>

        <%@include file="barraMenu.jsp" %>

        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="p-4 border-bottom bg-light">
                                <h4 class="card-title mb-0">Restaurante por Cidade</h4>
                            </div>
                            <div class="card-body">
                                <div class="d-flex justify-content-between align-items-center pb-4">
                                    <h4 class="card-title mb-0">Restaurantes</h4>
                                    <div id="bar-traffic-legend"></div>
                                </div>
                                <p class="mb-4">Por cidade</p>
                                <canvas id="pie-chart3" style="height:250px"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="p-4 pr-5 border-bottom bg-light d-flex justify-content-between">
                                <h4 class="card-title mb-0">Restaurante por País</h4>
                            </div>
                            <div class="card-body d-flex">
                                <canvas class="my-auto" id="pie-chart" height="130"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="p-4 pr-5 border-bottom bg-light d-flex justify-content-between">
                                <h4 class="card-title mb-0">Restaurante por País</h4>
                                <div id="doughnut-chart-legend" class="mr-4"></div>
                            </div>
                            <div class="card-body d-flex flex-column">
                                <canvas class="my-auto" id="pie-chart2" height="200"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <footer class="footer">
                <div class="container-fluid clearfix">
                    <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2019 <a href="index.html" target="_blank">Núcleo de Informatica Campus Urutaí</a>. Todos direitos reservados.</span>
                    <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Sistemas de Informação <i class="mdi mdi-heart text-danger"></i>
                    </span>
                </div>
            </footer>
            <!-- partial -->
        </div>
        <!-- plugins:js -->
        <script src="bootstrap/vendors/js/vendor.bundle.base.js"></script>
        <script src="bootstrap/vendors/js/vendor.bundle.addons.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page-->
        <!-- End plugin js for this page-->
        <!-- inject:js -->
        <script src="bootstrap/js/shared/off-canvas.js"></script>
        <script src="bootstrap/js/shared/misc.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="bootstrap/js/shared/chart.js"></script>
        <!-- End custom js for this page-->



        <script type="text/javascript">

            var pieChartCanvas = $("#pie-chart").get(0).getContext("2d");
            var pieChart = new Chart(pieChartCanvas, {
                type: 'pie',
                data: {
                    datasets: [{
                            data: [${listaPais.get(0).quant},${listaPais.get(1).quant},${listaPais.get(2).quant},${listaPais.get(3).quant},${listaPais.get(4).quant}],
                            backgroundColor: [
                                ChartColor[0],
                                ChartColor[1],
                                ChartColor[2],
                                ChartColor[3],
                                ChartColor[7]
                            ],
                            borderColor: [
                                ChartColor[0],
                                ChartColor[1],
                                ChartColor[2],
                                ChartColor[3],
                                ChartColor[7]
                            ],
                        }],
                    labels: [
                        '${listaPais.get(0).pais}',
                        '${listaPais.get(1).pais}',
                        '${listaPais.get(2).pais}',
                        '${listaPais.get(3).pais}',
                        '${listaPais.get(4).pais}',
                    ]
                },
                options: {
                    responsive: true,
                    animation: {
                        animateScale: true,
                        animateRotate: true
                    },
                    legend: {
                        display: false
                    },
                    legendCallback: function (chart) {
                        var text = [];
                        text.push('<div class="chartjs-legend"><ul>');
                        for (var i = 0; i < chart.data.datasets[0].data.length; i++) {
                            text.push('<li><span style="background-color:' + chart.data.datasets[0].backgroundColor[i] + '">');
                            text.push('</span>');
                            if (chart.data.labels[i]) {
                                text.push(chart.data.labels[i]);
                            }
                            text.push('</li>');
                        }
                        text.push('</div></ul>');
                        return text.join("");
                    }
                }
            });
            document.getElementById('pie-chart').innerHTML = pieChart.generateLegend();






            var doughnutChartCanvas = $("#pie-chart2").get(0).getContext("2d");
            var doughnutPieData = {
                datasets: [{
                        data: [${listaPais.get(0).quant},${listaPais.get(1).quant},${listaPais.get(2).quant},${listaPais.get(3).quant},${listaPais.get(4).quant}],
                        backgroundColor: [
                            ChartColor[0],
                            ChartColor[1],
                            ChartColor[2],
                            ChartColor[3],
                            ChartColor[7]
                        ],
                        borderColor: [
                            ChartColor[0],
                            ChartColor[1],
                            ChartColor[2],
                            ChartColor[3],
                            ChartColor[7]
                        ],
                    }],
                labels: [
                    '${listaPais.get(0).pais}',
                    '${listaPais.get(1).pais}',
                    '${listaPais.get(2).pais}',
                    '${listaPais.get(3).pais}',
                    '${listaPais.get(4).pais}',
                ]
            };
            var doughnutPieOptions = {
                cutoutPercentage: 75,
                animationEasing: "easeOutBounce",
                animateRotate: true,
                animateScale: false,
                responsive: true,
                maintainAspectRatio: true,
                showScale: true,
                legend: false,
                legendCallback: function (chart) {
                    var text = [];
                    text.push('<div class="chartjs-legend"><ul>');
                    for (var i = 0; i < chart.data.datasets[0].data.length; i++) {
                        text.push('<li><span style="background-color:' + chart.data.datasets[0].backgroundColor[i] + '">');
                        text.push('</span>');
                        if (chart.data.labels[i]) {
                            text.push(chart.data.labels[i]);
                        }
                        text.push('</li>');
                    }
                    text.push('</div></ul>');
                    return text.join("");
                },
                layout: {
                    padding: {
                        left: 0,
                        right: 0,
                        top: 0,
                        bottom: 0
                    }
                }
            };
            var doughnutChart = new Chart(doughnutChartCanvas, {
                type: 'doughnut',
                data: doughnutPieData,
                options: doughnutPieOptions
            });
            document.getElementById('pie-chart2').innerHTML = doughnutChart.generateLegend();






            var barChartCanvas = $("#pie-chart3").get(0).getContext("2d");
            var barChart = new Chart(barChartCanvas, {
                type: 'bar',
                data: {
                    labels: ["${listaCidade.get(0).cidade}", "${listaCidade.get(1).cidade}", "${listaCidade.get(2).cidade}", "${listaCidade.get(3).cidade}", "${listaCidade.get(4).cidade}", "${listaCidade.get(5).cidade}", "${listaCidade.get(6).cidade}", "${listaCidade.get(7).cidade}", "${listaCidade.get(8).cidade}", "${listaCidade.get(9).cidade}"],
                    datasets: [{
                            label: 'Restaurantes',
                            data: [${listaCidade.get(0).quant},${listaCidade.get(1).quant},${listaCidade.get(2).quant}, ${listaCidade.get(3).quant}, ${listaCidade.get(4).quant}, ${listaCidade.get(5).quant}, ${listaCidade.get(6).quant}, ${listaCidade.get(7).quant}, ${listaCidade.get(8).quant},${listaCidade.get(9).quant}],
                            backgroundColor: ChartColor[0],
                            borderColor: ChartColor[0],
                            borderWidth: 0
                        }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: true,
                    layout: {
                        padding: {
                            left: 0,
                            right: 0,
                            top: 0,
                            bottom: 0
                        }
                    },
                    scales: {
                        xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Cidades do Brasil',
                                    fontSize: 12,
                                    lineHeight: 2
                                },
                                ticks: {
                                    fontColor: '#bfccda',
                                    stepSize: 50,
                                    min: 0,
                                    max: 150,
                                    autoSkip: true,
                                    autoSkipPadding: 15,
                                    maxRotation: 0,
                                    maxTicksLimit: 10
                                },
                                gridLines: {
                                    display: false,
                                    drawBorder: false,
                                    color: 'transparent',
                                    zeroLineColor: '#eeeeee'
                                }
                            }],
                        yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Quantidade por Cidade',
                                    fontSize: 12,
                                    lineHeight: 2
                                },
                                ticks: {
                                    display: true,
                                    autoSkip: false,
                                    maxRotation: 0,
                                    fontColor: '#bfccda',
                                    stepSize: 50,
                                    min: 0,
                                    max: 150
                                },
                                gridLines: {
                                    drawBorder: false
                                }
                            }]
                    },
                    legend: {
                        display: false
                    },
                    legendCallback: function (chart) {
                        var text = [];
                        text.push('<div class="chartjs-legend"><ul>');
                        for (var i = 0; i < chart.data.datasets.length; i++) {
                            console.log(chart.data.datasets[i]); // see what's inside the obj.
                            text.push('<li>');
                            text.push('<span style="background-color:' + chart.data.datasets[i].backgroundColor + '">' + '</span>');
                            text.push(chart.data.datasets[i].label);
                            text.push('</li>');
                        }
                        text.push('</ul></div>');
                        return text.join("");
                    },
                    elements: {
                        point: {
                            radius: 0
                        }
                    }
                }
            });
            document.getElementById('pie-chart3').innerHTML = barChart.generateLegend();






        </script>



    </body>
</html>

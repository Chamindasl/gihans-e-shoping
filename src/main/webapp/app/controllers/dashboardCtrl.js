'use strict';
app.controller("DashboardCtrl", ['$scope', '$http', '$location', '$routeParams',
  function ($scope, $http, $location, $routeParams) {

    $(function () {
      $('#monthly-signin-buying-chart').highcharts({
        chart: {
          plotBackgroundColor: null,
          plotBorderWidth: null,
          plotShadow: false,
          type: 'pie'
        },
        title: {
          text: 'Hits vs Signins vs Signups vs Buyings'
        },
        tooltip: {
          pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
          pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
              enabled: true,
              format: '<b>{point.name}</b>: {point.percentage:.1f} %',
              style: {
                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
              }
            }
          }
        },
        series: [{
            name: "Brands",
            colorByPoint: true,
            data: [{
                name: "Hits",
                y: 56.33
              }, {
                name: "Signins",
                y: 24.03,
                sliced: true,
                selected: true
              }, {
                name: "Signups",
                y: 10.38
              }, {
                name: "Buyings",
                y: 4.77
              }, {
                name: "Returns",
                y: 0.91
              }]
          }]
      });
    });

    $(function () {
      $('#monthly-buying-chart').highcharts({
        chart: {
          type: 'column'
        },
        title: {
          text: 'Monthly User Signup'
        },
        xAxis: {
          categories: [
            'Jan',
            'Feb',
            'Mar',
            'Apr',
            'May',
            'Jun',
            'Jul',
            'Aug',
            'Sep',
            'Oct',
            'Nov',
            'Dec'
          ],
          crosshair: true
        },
        yAxis: {
          min: 0,
          title: {
            text: 'No of Users'
          }
        },
        tooltip: {
          headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
          pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                  '<td style="padding:0"><b>{point.y:.1f} Rs</b></td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
        },
        plotOptions: {
          column: {
            pointPadding: 0.2,
            borderWidth: 0
          }
        },
        series: [{
            name: 'Colombo',
            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]

          }, {
            name: 'kurunegala',
            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]

          }, {
            name: 'Kandy',
            data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]

          }, {
            name: 'Galle',
            data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]

          }]
      });
    });

    $(function () {
      $('#this-year-monthly-sales-chart').highcharts({
        chart: {
          type: 'column'
        },
        title: {
          text: 'Monthly Sales'
        },
        xAxis: {
          categories: [
            'Jan',
            'Feb',
            'Mar',
            'Apr',
            'May',
            'Jun',
            'Jul',
            'Aug',
            'Sep',
            'Oct',
            'Nov',
            'Dec'
          ],
          crosshair: true
        },
        yAxis: {
          min: 0,
          title: {
            text: 'Sales (Rs)'
          }
        },
        tooltip: {
          headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
          pointFormat: '<tr><td style="color:{series.color};padding:0"></td>' +
                  '<td style="padding:0"><b>Rs. {point.y:.1f}</b></td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
        },
        plotOptions: {
          column: {
            pointPadding: 0.2,
            borderWidth: 0
          }
        },
        series: [{
            name: '1',
            data: [10]
          }]
      });
    });

    $(function () {
      $('#five-years-monthly-sales-chart').highcharts({
        title: {
          text: 'Sales Comparison',
          x: -20 //center
        },
        subtitle: {
          text: '-',
          x: -20
        },
        xAxis: {
          categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
          title: {
            text: 'Sales (Rs)'
          },
          plotLines: [{
              value: 0,
              width: 1,
              color: '#808080'
            }]
        },
        tooltip: {
          valueSuffix: 'Rs'
        },
        legend: {
          layout: 'vertical',
          align: 'right',
          verticalAlign: 'middle',
          borderWidth: 0
        },
        series: []
      });
    });

    $scope.getSalesData = function () {
      $http.get('http://localhost:8080/gihans-e-shoping/rest/report/sales').
              success(function (data, status, headers, config) {
                var chart1 = $('#this-year-monthly-sales-chart').highcharts();
                chart1.series[0].setData(data[data.length - 1].values);
                chart1.series[0].update({name: data[data.length - 1].year}, false);
                chart1.redraw();

                var chart2 = $('#five-years-monthly-sales-chart').highcharts();
                for (var i = 0; i < data.length; i++) {
                  var visi = (i + 3 > data.length);
                  chart2.addSeries({
                    name: data[i].year,
                    data: data[i].values,
                    visible: visi
                  }, false);
                }
                chart2.redraw();
              }).
              error(function (data, status, headers, config) {
                // log error
              });
    };

    $scope.init = function () {
      $scope.getSalesData();
    };

    $scope.init();

  }]);

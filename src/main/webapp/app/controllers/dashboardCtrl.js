'use strict';
app.controller("DashboardCtrl", ['$scope', '$http', '$location', '$routeParams',
  function ($scope, $http, $location, $routeParams) {

    $scope.adminLogin = function (user) {
//      $http.get('http://localhost:8080/gihans-e-shoping/rest/item/get?id=' + item).
//              success(function (data, status, headers, config) {
//                $scope.item = data;
//              }).
//              error(function (data, status, headers, config) {
//                // log error
//              });
    };

    $scope.init = function () {
    };

    $scope.init();
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
                  '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
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

  }]);

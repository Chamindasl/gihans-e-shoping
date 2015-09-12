'use strict';
app.controller("DashboardCtrl", ['$scope', '$http', '$location', '$routeParams',
  function ($scope, $http, $location, $routeParams) {

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
                  '<td style="padding:0"><b>Rs. {point.y:,.2f}</b></td></tr>',
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
        series: []
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
          valuePrefix: 'Rs '
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
                chart1.addSeries({
                    name: data[data.length - 1].year + "<br/>Total (Rs) " + data[data.length - 1].total,
                    data: data[data.length - 1].values
                  }, false);
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

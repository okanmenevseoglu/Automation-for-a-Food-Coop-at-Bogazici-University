/**
 * Created by okanm on 22.05.2016.
 */
var sale = angular.module('app.sale', []);

sale.config(function ($stateProvider) {
    $stateProvider.state('sale', {
        url: '/sale',
        views: {
            'main': {
                templateUrl: 'app/sale/sale.tpl.html',
                controller: 'SaleCtrl'
            }
        }
    })
});

sale.controller('SaleCtrl', ['$scope', function ($scope) {
}]);

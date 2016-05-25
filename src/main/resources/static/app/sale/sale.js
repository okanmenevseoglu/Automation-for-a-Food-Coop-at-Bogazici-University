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

sale.service('SaleService', ['$http', 'baseUrl', function ($http, baseUrl) {
    var productsUrl = baseUrl + '/products';

    // Product Requests

    this.getProducts = function () {
        return $http.get(productsUrl);
    };

    this.getProduct = function (productId) {
        return $http.get(productsUrl + '/' + productId);
    };

    this.addProduct = function (productData) {
        return $http.post(productsUrl + '/add', productData);
    };

    this.updateProduct = function (productId, newProductData) {
        return $http.put(productsUrl + '/update/' + productId, newProductData);
    };

    this.deleteProduct = function (productId) {
        return $http.delete(productsUrl + '/delete/' + productId);
    };


    var salesUrl = baseUrl + '/sales';

    // Sale Requests

    this.getSales = function () {
        return $http.get(salesUrl);
    };

    this.getSale = function (saleId) {
        return $http.get(salesUrl + '/' + saleId);
    };

    this.addSale = function (saleData) {
        return $http.post(salesUrl + '/add', saleData);
    };

    this.updateSale = function (saleId, newSaleData) {
        return $http.put(salesUrl + '/update/' + saleId, newSaleData);
    };

    this.deleteSale = function (saleId) {
        return $http.delete(salesUrl + '/delete/' + saleId);
    };

    // Members
    this.getMembers = function () {
        return $http.get(baseUrl + '/members');
    };
}]);

sale.controller('SaleCtrl', ['$scope', '$rootScope', '$cookies', '$timeout', 'SaleService', 'Notification', function ($scope, $rootScope, $cookies, $timeout, SaleService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Get Producers
    $scope.products = {};

    SaleService.getProducts()
        .then(function (response) {
            $scope.products = response.data;
        });

    $scope.members = {};

    SaleService.getMembers()
        .then(function (response) {
            $scope.members = response.data;
        });
}]);

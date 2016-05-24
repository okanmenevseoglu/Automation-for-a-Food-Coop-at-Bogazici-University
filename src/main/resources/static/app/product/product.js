/**
 * Created by okanm on 15.05.2016.
 */
var product = angular.module('app.product', []);

product.config(function ($stateProvider) {
    $stateProvider.state('products', {
        url: '/products',
        views: {
            'main': {
                templateUrl: 'app/product/products.tpl.html',
                controller: 'ProductCtrl'
            }
        }
    })
        .state('product', {
            url: '/product',
            views: {
                'main': {
                    templateUrl: 'app/product/product.tpl.html',
                    controller: 'ProductCtrl'
                }
            }
        })
        .state('products/add', {
            url: '/products/add',
            views: {
                'main': {
                    templateUrl: 'app/product/product.add.tpl.html',
                    controller: 'ProductCtrl'
                }
            }
        })
});

product.service('ProductService', ['$http', 'baseUrl', function ($http, baseUrl) {
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

    // Unit Type Requests
    this.getUnitTypes = function () {
        return $http.get(baseUrl + '/unitTypes');
    };

    // Package Type Requests
    this.getPackageTypes = function () {
        return $http.get(baseUrl + '/packageTypes');
    };

    // Producer Requests
    this.getProducers = function () {
        return $http.get(baseUrl + '/producers');
    };

    // Product Category Requests
    this.getProductCategories = function () {
        return $http.get(baseUrl + '/productCategories');
    };
}]);

product.controller('ProductCtrl', ['$scope', '$rootScope', '$cookies', '$timeout', 'ProductService', 'Notification', function ($scope, $rootScope, $cookies, $timeout, ProductService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Get Producers
    $scope.products = {};

    ProductService.getProducts()
        .then(function (response) {
            $scope.products = response.data;
        });

    // Products Data
    $scope.productData = {
        name: null,
        description: null,
        price: 0,
        stock: 0,
        photoUrl: null,
        starRate: 0,
        unit: 0,
        unitType: null,
        packageType: null,
        productCategory: null,
        producer: null
    };

    // Unit Type Controller
    $scope.unitTypes = null;

    ProductService.getUnitTypes()
        .then(function (response) {
            $scope.unitTypes = response.data;
        });

    // Package Type Controller
    ProductService.getPackageTypes()
        .then(function (response) {
            $scope.packageTypes = response.data;
        });

    // Producer Controller
    ProductService.getProducers()
        .then(function (response) {
            $scope.producers = response.data;
        });

    // Product Category Controller
    ProductService.getProductCategories()
        .then(function (response) {
            $scope.productCategories = response.data;
        });

    // Add Product
    $scope.submitProductForm = function (valid) {
        console.log($scope.productData);
        if (valid) {
            ProductService.addProduct($scope.productData)
                .success(function () {
                    Notification.success("Ürün Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Ürün Eklenemedi!");
                });
        }
    };

    $scope.setProductId = function (productId) {
        $rootScope.productId = productId;
    };

    if ($rootScope.productId != undefined)
        ProductService.getProduct($rootScope.productId)
            .then(function (response) {
                $scope.product = response.data;
            });

    // Delete Product
    $scope.deleteProduct = function (producerId) {
        ProductService.deleteProduct(producerId)
            .success(function () {
                Notification.success("Silme Başarılı!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Silme Başarısız!");
            });
    };
}]);

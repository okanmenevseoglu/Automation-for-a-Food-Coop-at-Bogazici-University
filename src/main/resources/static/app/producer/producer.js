/**
 * Created by okanm on 17.05.2016.
 */
var producer = angular.module('app.producer', []);

producer.config(function ($stateProvider) {
    $stateProvider
        .state('producers', {
            url: '/producers',
            views: {
                'main': {
                    templateUrl: 'app/producer/producers.tpl.html',
                    controller: 'ProducerCtrl'
                }
            }
        })
        .state('producers/add', {
            url: '/producers/add',
            views: {
                'main': {
                    templateUrl: 'app/producer/producer.add.tpl.html',
                    controller: 'ProducerAddCtrl'
                }
            }
        })
        .state('producer', {
            url: '/producer',
            views: {
                'main': {
                    templateUrl: 'app/producer/producer.tpl.html',
                    controller: 'ProducerCtrl'
                }
            }
        })
});

producer.service('ProducerService', ['$http', 'baseUrl', function ($http, baseUrl) {
    var producersUrl = baseUrl + '/producers';

    this.getProducers = function () {
        return $http.get(producersUrl);
    };

    this.getProducer = function (producerId) {
        return $http.get(producersUrl + '/' + producerId);
    };

    this.addProducer = function (producerData) {
        return $http.post(producersUrl + '/add', producerData);
    };

    this.updateProducer = function (producerId, newProducerData) {
        return $http.put(producersUrl + '/update/' + producerId, newProducerData);
    };

    this.deleteProducer = function (producerId) {
        return $http.delete(producersUrl + '/delete/' + producerId);
    };
}]);

producer.controller('ProducerAddCtrl', ['$scope', '$timeout', 'ProducerService', 'Notification', function ($scope, $timeout, ProducerService, Notification) {

    // Add Producers
    $scope.producerData = {
        firstName: null,
        lastName: null,
        companyName: null,
        description: null,
        phone: null,
        email: null,
        address: null,
        city: null,
        latitude: null,
        longitude: null
    };

    // Init Google Maps
    var map = new GMaps({
        el: '#addProducerMap',
        lat: 41.087227,
        lng: 29.043997,
        zoom: 11
    });

    $scope.$watch('producerData.city', function () {
        GMaps.geocode({
            address: $('#inputCity').val(),
            callback: function (results, status) {
                if (status == 'OK') {
                    var latlng = results[0].geometry.location;
                    $scope.producerData.latitude = latlng.lat();
                    $scope.producerData.longitude = latlng.lng();
                    map.setCenter(latlng.lat(), latlng.lng());
                    map.addMarker({
                        lat: latlng.lat(),
                        lng: latlng.lng()
                    });
                }
            }
        });
    });

    $scope.submitProducerForm = function (valid) {
        console.log($scope.producerData);
        if (valid) {
            ProducerService.addProducer($scope.producerData)
                .success(function () {
                    Notification.success("Kayıt Başarılı!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Kayıt Başarısız!");
                });
        }
    };
}]);

producer.controller('ProducerCtrl', ['$scope', '$rootScope', '$cookies', '$timeout', 'ProducerService', 'Notification', function ($scope, $rootScope, $cookies, $timeout, ProducerService, Notification) {
    $scope.memberType = $cookies.get("memberType");
    
    // Init Google Maps
    $scope.viewMap = function (latitude, longitude) {
        var viewProducerMap = new GMaps({
            el: '#viewProducerMap',
            lat: latitude,
            lng: longitude,
            zoom: 11
        });

        viewProducerMap.addMarker({
            lat: latitude,
            lng: longitude
        });
    };

    // Get Producers
    $scope.producers = {};

    ProducerService.getProducers()
        .then(function (response) {
            $scope.producers = response.data;
        });

    // Get Producer
    $scope.producer = {
        latitude: 41.087227,
        longitude: 29.043997
    };


    $scope.setProducerId = function (producerId) {
        $rootScope.producerId = producerId;
    };

    if ($rootScope.producerId != undefined)
        ProducerService.getProducer($rootScope.producerId)
            .then(function (response) {
                $scope.producer = response.data;
            });

    // Delete Producer
    $scope.deleteProducer = function (producerId) {
        ProducerService.deleteProducer(producerId)
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

/**
 * Created by okanm on 24.04.2016.
 */
var other = angular.module('app.other', []);

other.config(function ($stateProvider) {
    $stateProvider.state('bulletins', {
        url: '/bulletins',
        views: {
            'main': {
                templateUrl: 'app/other/bulletins.tpl.html',
                controller: 'BulletinCtrl'
            }
        }
    })
        .state('bulletins/add', {
            url: '/bulletins/add',
            views: {
                'main': {
                    templateUrl: 'app/other/bulletin.add.tpl.html',
                    controller: 'BulletinCtrl'
                }
            }
        })
        .state('faqs', {
            url: '/faqs',
            views: {
                'main': {
                    templateUrl: 'app/other/faq.tpl.html',
                    controller: 'FaqCtrl'
                }
            }
        })
        .state('faqs/add', {
            url: '/faqs/add',
            views: {
                'main': {
                    templateUrl: 'app/other/faq.add.tpl.html',
                    controller: 'FaqCtrl'
                }
            }
        })
        .state('faqs/edit', {
            url: '/faqs/edit',
            views: {
                'main': {
                    templateUrl: 'app/other/faq.edit.tpl.html',
                    controller: 'FaqCtrl'
                }
            }
        })
        .state('aboutUs', {
            url: '/aboutUs',
            views: {
                'main': {
                    templateUrl: 'app/other/aboutUs.tpl.html'
                }
            }
        })
        .state('contact', {
            url: '/contact',
            views: {
                'main': {
                    templateUrl: 'app/other/contact.tpl.html',
                    controller: 'ContactCtrl'
                }
            }
        })
        .state('profile', {
            url: '/profile',
            views: {
                'main': {
                    templateUrl: 'app/other/profilePage.tpl.html',
                    controller: 'ProfileCtrl'
                }
            }
        });
});

// Bulletin Operations

other.service("BulletinService", ['$http', 'baseUrl', function ($http, baseUrl) {

    var bulletinsURL = baseUrl + '/bulletins';

    this.getBulletins = function () {
        return $http.get(bulletinsURL);
    };

    this.addBulletin = function (bulletinData) {
        return $http.post(bulletinsURL + "/add", bulletinData);
    };

    this.deleteBulletin = function (bulletinNo) {
        return $http.delete(bulletinsURL + "/delete/" + bulletinNo);
    };
}]);

other.controller('BulletinCtrl', ['$scope', '$cookies', '$timeout', 'BulletinService', 'Notification', function ($scope, $cookies, $timeout, BulletinService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Get Bulletins
    BulletinService.getBulletins()
        .then(function (response) {
            $scope.bulletins = response.data;
        });

    // Add Bulletin
    $scope.bulletinData = {
        name: null,
        date: null
    };

    $scope.submitBulletinForm = function (valid) {
        if (valid) {
            BulletinService.addBulletin($scope.bulletinData)
                .success(function () {
                    Notification.success("Kayıt Başarılı!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.success("Kayıt Başarısız!");
                });
        }
    };

    // Delete Bulletin
    $scope.deleteBulletinData = function (bulletinId) {
        BulletinService.deleteBulletin(bulletinId)
            .success(function () {
                Notification.success("Silme Başarılı!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.success("Silme Başarısız!");
            });
    }
}]);

// Faq Operations

other.service("FaqService", ['$http', 'baseUrl', function ($http, baseUrl) {

    var faqUrl = baseUrl + '/faqs';

    this.getFaqs = function () {
        return $http.get(faqUrl);
    };

    this.addFaq = function (faqData) {
        return $http.post(faqUrl + '/add', faqData);
    };

    this.deleteFaq = function (faqNo) {
        return $http.delete(faqUrl + '/delete/' + faqNo);
    };
}]);

other.controller('FaqCtrl', ['$scope', '$cookies', '$timeout', 'FaqService', 'Notification', function ($scope, $cookies, $timeout, FaqService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Get Faqs
    FaqService.getFaqs()
        .then(function (response) {
            $scope.faqs = response.data;
        });

    // Add Faq
    $scope.faqData = null;

    $scope.submitFaqForm = function (valid) {
        if (valid) {
            FaqService.addFaq($scope.faqData)
                .success(function () {
                    Notification.success("Kayıt Başarılı!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500)
                })
                .error(function () {
                    Notification.error("Kayıt Başarısız!");
                });
        }
    };

    // Delete Faq
    $scope.deleteFaqData = function (faqNo) {
        FaqService.deleteFaq(faqNo)
            .success(function () {
                Notification.success("Silme Başarılı!");
                $timeout(function () {
                    window.location.reload()
                }, 500)
            })
            .error(function () {
                Notification.error("Silme Başarısız!");
            });
    };
}]);

other.controller('ContactCtrl', function () {

    // Init Google Maps
    var map = new GMaps({
        el: '#contactMap',
        lat: 41.087227,
        lng: 29.043997,
        zoom: 16
    });

    map.addMarker({
        lat: 41.087227,
        lng: 29.043997
    });
});

// Profile Operations

other.controller('ProfileCtrl', ['$scope', '$cookies', function ($scope, $cookies) {
    $scope.loggedMember = {
        firstName: $cookies.get("firstName"),
        lastName: $cookies.get("lastName"),
        email: $cookies.get("email"),
        gender: $cookies.get("gender"),
        idNumber: $cookies.get("idNumber"),
        address: $cookies.get("address"),
        city: $cookies.get("city"),
        postalCode: $cookies.get("postalCode"),
        phoneNumber: $cookies.get("phoneNumber"),
        registerTime: $cookies.get("registerTime")
    };
}]);
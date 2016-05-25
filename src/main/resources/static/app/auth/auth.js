/**
 * Created by okanm on 22.04.2016.
 */
var register = angular.module('app.auth', ['ui.router']);

register.config(function ($stateProvider) {
    $stateProvider.state('register', {
        url: '/register',
        views: {
            'main': {
                templateUrl: 'app/auth/register.tpl.html',
                controller: 'RegisterCtrl'
            }
        }
    })
        .state('login', {
            url: '/login',
            views: {
                'main': {
                    templateUrl: 'app/auth/login.tpl.html',
                    controller: 'LoginCtrl'
                }
            }
        })
        .state('logout', {
            url: '/logout',
            views: {
                'main': {
                    templateUrl: 'app/auth/logout.tpl.html',
                    controller: 'LogoutCtrl'
                }
            }
        })
        .state('howToRegister', {
            url: '/howToRegister',
            views: {
                'main': {
                    templateUrl: 'app/auth/howToRegister.tpl.html',
                    controller: 'AuthCtrl'
                }
            }
        })
});

register.service('AuthService', ['$http', 'baseUrl', function ($http, baseUrl) {

    var membersUrl = baseUrl + '/members';

    this.register = function (memberData) {
        return $http.post(membersUrl + '/register', memberData);
    };

    this.getMemberType = function (name) {
        return $http.get(baseUrl + '/memberTypes/byName/' + name);
    };

    this.getMemberByEmail = function (memberId) {
        return $http.get(membersUrl + '/byEmail/' + memberId + '/');
    };

    this.login = function (credentials) {
        var header = credentials ? {
            Authorization: 'Basic '
            + btoa(credentials.username + ':' + credentials.password)
        } : {};
        return $http.get(membersUrl + '/user', {headers: header});
    };

    this.logout = function () {
        return $http.post('http://localhost:8080/logout', null);
    };
}]);

register.controller('RegisterCtrl', ['$scope', '$timeout', 'AuthService', 'Notification', function ($scope, $timeout, AuthService, Notification) {

    AuthService.getMemberType('ROLE_MEMBER')
        .then(function (response) {
            $scope.memberType = response.data;
        });

    $scope.memberData = {
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        gender: '',
        idNumber: '',
        address: '',
        city: '',
        postalCode: '',
        phoneNumber: '',
        memberType: {}
    };

    $scope.submitForm = function (valid) {
        if (valid) {
            $scope.memberData.memberType.id = $scope.memberType.id;
            AuthService.register($scope.memberData)
                .success(function () {
                    Notification.success('Kayıt Başarılı!');
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error('Kayıt Başarısız!');
                });
        }
    };
}]);

register.controller('LoginCtrl', ['$scope', '$state', '$cookies', '$timeout', 'AuthService', 'Notification', function ($scope, $state, $cookies, $timeout, AuthService, Notification) {

    $scope.credentials = {
        username: '',
        password: ''
    };

    $scope.onLogin = function () {
        AuthService.login($scope.credentials).success(function () {
            AuthService.getMemberByEmail($scope.credentials.username)
                .then(function (response) {
                    Notification.success('Giriş Başarılı!');
                    $cookies.put('id', response.data.id);
                    $cookies.put('firstName', response.data.firstName);
                    $cookies.put('lastName', response.data.lastName);
                    $cookies.put('email', response.data.email);
                    $cookies.put('gender', response.data.gender);
                    $cookies.put('idNumber', response.data.idNumber);
                    $cookies.put('address', response.data.address);
                    $cookies.put('city', response.data.city);
                    $cookies.put('postalCode', response.data.postalCode);
                    $cookies.put('phoneNumber', response.data.phoneNumber);
                    $cookies.put('memberType', response.data.memberType.name);
                    $cookies.put('registerTime', response.data.registerTime);
                    $cookies.put('authenticated', true);
                    $timeout(function () {
                        window.location.reload();
                        $state.go('home', {}, {reload: true});
                    }, 500);
                });
        })
            .error(function () {
                Notification.success('Giriş Başarısız!');
                $cookies.put('authenticated', false);
                $timeout(function () {
                    window.location.reload();
                }, 500);
            })
    };
}]);

register.controller('AuthCtrl', ['$scope', '$cookies', function ($scope, $cookies) {
    $scope.memberType = $cookies.get('memberType');
    $scope.authenticated = $cookies.get('authenticated');


}]);

register.controller('LogoutCtrl', ['$scope', '$state', '$cookies', '$timeout', function ($scope, $state, $cookies, $timeout) {
    (function () {
        $cookies.remove('id');
        $cookies.remove('firstName');
        $cookies.remove('lastName');
        $cookies.remove('email');
        $cookies.remove('gender');
        $cookies.remove('idNumber');
        $cookies.remove('address');
        $cookies.remove('city');
        $cookies.remove('postalCode');
        $cookies.remove('phoneNumber');
        $cookies.remove('memberType');
        $cookies.remove('registerTime');
        $cookies.remove('authenticated');
        $timeout(function () {
            window.location.reload();
            $state.go('home', {}, {reload: true});
        }, 500);
    })();
}]);
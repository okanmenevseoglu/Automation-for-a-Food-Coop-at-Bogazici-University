/**
 * Created by okanm on 22.04.2016.
 */
var home = angular.module("app.home", []);

home.config(function ($stateProvider) {
    $stateProvider.state("home", {
        url: '/home',
        views: {
            'main': {
                templateUrl: 'app/home/home.tpl.html',
                controller: 'HomeCtrl'
            }
        }
    });
});

home.controller('HomeCtrl', function ($scope) {
});

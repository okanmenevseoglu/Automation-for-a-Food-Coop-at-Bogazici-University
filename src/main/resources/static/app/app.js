/**
 * Created by okanm on 20.04.2016.
 */
var app = angular.module('app', [
    'app.auth',
    'app.config',
    'app.home',
    'app.admin',
    'app.other',
    'app.post',
    'app.producer',
    'app.product',
    'app.sale',
    'app.work',
    'ui.router',
    'ui-notification',
    'ngCookies'
]);


app.config(function ($urlRouterProvider, $httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $urlRouterProvider.otherwise("/home");
});

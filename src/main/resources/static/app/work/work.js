/**
 * Created by okanm on 17.05.2016.
 */
var work = angular.module('app.work', []);

work.config(function ($stateProvider) {
    $stateProvider.state('works', {
        url: '/works',
        views: {
            'main': {
                templateUrl: 'app/work/volunteerWorks.tpl.html',
                controller: 'WorkCtrl'
            }
        }
    })
        .state('workAdd', {
            url: '/volunteerWorks/add',
            views: {
                'main': {
                    templateUrl: 'app/work/volunteerWork.add.tpl.html',
                    controller: 'WorkCtrl'
                }
            }
        })
});

// Work Operations

work.service('WorkService', ['$http', 'baseUrl', function ($http, baseUrl) {

    var volunteerWorksUrl = baseUrl + '/works';

    this.getWorks = function () {
        return $http.get(volunteerWorksUrl);
    };

    this.getWorkTypes = function () {
        return $http.get(baseUrl + '/workTypes');
    };

    this.addWork = function (volunteerWorkData) {
        return $http.post(volunteerWorksUrl + '/add', volunteerWorkData);
    };

    this.deleteWork = function (workId) {
        return $http.delete(volunteerWorksUrl + '/delete/' + workId);
    };
}]);

work.controller('WorkCtrl', ['$scope', '$cookies', '$timeout', 'WorkService', 'Notification', function ($scope, $cookies, $timeout, WorkService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Get All Works
    WorkService.getWorks()
        .then(function (response) {
            $scope.works = response.data;
        });

    // Get Work Types
    WorkService.getWorkTypes()
        .then(function (response) {
            $scope.workTypes = response.data;
        });

    // Add Work
    $scope.workData = {
        member: {
            id: $cookies.get("id")
        }
    };

    $scope.submitWorkForm = function (valid) {
        if (valid) {
            WorkService.addWork($scope.workData)
                .success(function () {
                    Notification.success("İş Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("İş Eklenemedi!")
                });
        }
    };

    // Delete a Work
    $scope.deleteWork = function (workId) {
        WorkService.deleteWork(workId)
            .success(function () {
                Notification.success("İş Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("İş Silinemedi!")
            });
    };
}]);
/**
 * Created by okanm on 22.04.2016.
 */
var post = angular.module('app.post', []);

post.config(function ($stateProvider) {
    $stateProvider.state('news', {
        url: '/news',
        views: {
            'main': {
                templateUrl: 'app/post/news.tpl.html',
                controller: 'NewsCtrl'
            }
        }
    })
        .state('news/add', {
            url: '/news/add',
            views: {
                'main': {
                    templateUrl: 'app/post/news.add.tpl.html',
                    controller: 'NewsCtrl'
                }
            }
        })
        .state('writings', {
            url: '/writings',
            views: {
                'main': {
                    templateUrl: 'app/post/writings.tpl.html',
                    controller: 'WritingsCtrl'
                }
            }
        })
        .state('writings/add', {
            url: '/writings/add',
            views: {
                'main': {
                    templateUrl: 'app/post/writings.add.tpl.html',
                    controller: 'WritingsCtrl'
                }
            }
        })
        .state('events', {
            url: '/events',
            views: {
                'main': {
                    templateUrl: 'app/post/events.tpl.html',
                    controller: 'EventsCtrl'
                }
            }
        })
        .state('events/add', {
            url: '/events/add',
            views: {
                'main': {
                    templateUrl: 'app/post/events.add.tpl.html',
                    controller: 'EventsCtrl'
                }
            }
        })
});

// Event Operations

post.service('EventsService', ['$http', 'baseUrl', function ($http, baseUrl) {
    var eventsUrl = baseUrl + '/posts';

    this.getEvents = function () {
        return $http.get(eventsUrl + '/getByPostTypeName/Etkinlikler');
    };

    this.addEvents = function (eventsData) {
        return $http.post(eventsUrl + '/add', eventsData);
    };

    this.getPostTypeByName = function () {
        return $http.get(baseUrl + '/postTypes/getByName/Etkinlikler')
    };

    this.deleteEvents = function (eventNo) {
        return $http.delete(eventsUrl + '/delete/' + eventNo);
    };
}]);

post.controller('EventsCtrl', ['$scope', '$cookies', '$timeout', 'EventsService', 'Notification', function ($scope, $cookies, $timeout, EventsService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Show More
    $scope.numLimit = 750;
    $scope.readMore = function (writingLength) {
        $scope.numLimit = writingLength;
    };

    $scope.events = '';
    var pagesShown = 1;
    var pageSize = 3;

    $scope.paginationLimit = function () {
        return pageSize * pagesShown;
    };

    $scope.hasMoreItemsToShow = function () {
        return pagesShown < ($scope.events.length / pageSize);
    };

    $scope.showMoreItems = function () {
        pagesShown = pagesShown + 1;
    };

    // Get PostType
    EventsService.getPostTypeByName()
        .then(function (response) {
            $scope.postTypeData = response.data;
        });

    // Get All Events
    EventsService.getEvents()
        .then(function (response) {
            $scope.events = response.data;
        });

    // Add Events
    $scope.eventsData = {
        title: '',
        content: '',
        dateOfOccurrence: '',
        member: {
            id: $cookies.get("id")
        },
        postType: {
            id: ''
        }
    };

    $scope.submitEventsForm = function (valid, postTypeNo) {
        $scope.eventsData.postType.id = postTypeNo;
        if (valid) {
            EventsService.addEvents($scope.eventsData)
                .success(function () {
                    Notification.success("Kayıt Başarılı!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Kayıt Başarısız!")
                });
        }
    };

    // Delete an Event
    $scope.deleteEventData = function (eventNo) {
        EventsService.deleteEvents(eventNo)
            .success(function () {
                Notification.success("Silme Başarılı!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Silme Başarısız!")
            });
    }
}]);

// News Operations

post.service('NewsService', ['$http', 'baseUrl', function ($http, baseUrl) {

    var newsUrl = baseUrl + '/posts';

    this.getNews = function () {
        return $http.get(newsUrl + '/getByPostTypeName/Haberler');
    };

    this.addNews = function (newsData) {
        return $http.post(newsUrl + '/add', newsData);
    };

    this.getPostTypeByName = function () {
        return $http.get(baseUrl + '/postTypes/getByName/Haberler')
    };

    this.deleteNews = function (newsNo) {
        return $http.delete(newsUrl + '/delete/' + newsNo);
    };
}]);

post.controller('NewsCtrl', ['$scope', '$cookies', '$timeout', 'NewsService', 'Notification', function ($scope, $cookies, $timeout, NewsService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Show More
    $scope.numLimit = 750;
    $scope.readMore = function (writingLength) {
        $scope.numLimit = writingLength;
    };

    $scope.news = '';
    var pagesShown = 1;
    var pageSize = 3;

    $scope.paginationLimit = function () {
        return pageSize * pagesShown;
    };

    $scope.hasMoreItemsToShow = function () {
        return pagesShown < ($scope.news.length / pageSize);
    };

    $scope.showMoreItems = function () {
        pagesShown = pagesShown + 1;
    };

    // Get News
    NewsService.getNews()
        .then(function (response) {
            $scope.news = response.data;
        });

    // Get PostType
    NewsService.getPostTypeByName()
        .then(function (response) {
            $scope.postTypeData = response.data;
        });

    // Add News

    $scope.newsData = {
        title: '',
        content: '',
        member: {
            id: $cookies.get("id")
        },
        postType: {
            id: ''
        }
    };

    $scope.submitNewsForm = function (valid, postTypeNo) {
        $scope.newsData.postType.id = postTypeNo;
        if (valid) {
            NewsService.addNews($scope.newsData)
                .success(function () {
                    Notification.success("Kayıt Başarılı!");
                    $timeout(function () {
                        window.location.reload()
                    }, 1000);
                })
                .error(function () {
                    Notification.error("Kayıt Başarısız!")
                });
        }
    };

    // Delete News
    $scope.deleteNewsData = function (newsNo) {
        NewsService.deleteNews(newsNo)
            .success(function () {
                Notification.success("Silme Başarılı!");
                $timeout(function () {
                    window.location.reload()
                }, 1000);
            })
            .error(function () {
                Notification.error("Silme Başarısız!")
            });
    }
}]);

// Writing Operations

post.service('WritingsService', ['$http', 'baseUrl', function ($http, baseUrl) {
    var writingsUrl = baseUrl + '/posts';

    this.getWritings = function () {
        return $http.get(writingsUrl + '/getByPostTypeName/Yazılar');
    };

    this.addWriting = function (writingData) {
        return $http.post(writingsUrl + '/add', writingData);
    };

    this.getPostTypeByName = function () {
        return $http.get(baseUrl + '/postTypes/getByName/Yazılar')
    };

    this.deleteWriting = function (writingNo) {
        return $http.delete(writingsUrl + '/delete/' + writingNo);
    };
}]);

post.controller('WritingsCtrl', ['$scope', '$cookies', '$timeout', 'WritingsService', 'Notification', function ($scope, $cookies, $timeout, WritingsService, Notification) {
    $scope.memberType = $cookies.get("memberType");
    
    // Show More
    $scope.numLimit = 750;
    $scope.readMore = function (writingLength) {
        $scope.numLimit = writingLength;
    };

    $scope.writings = '';
    var pagesShown = 1;
    var pageSize = 3;

    $scope.paginationLimit = function () {
        return pageSize * pagesShown;
    };

    $scope.hasMoreItemsToShow = function () {
        return pagesShown < ($scope.writings.length / pageSize);
    };

    $scope.showMoreItems = function () {
        pagesShown = pagesShown + 1;
    };

    // Get Writings
    WritingsService.getWritings()
        .then(function (response) {
            $scope.writings = response.data;
        });

    // Get PostType
    WritingsService.getPostTypeByName()
        .then(function (response) {
            $scope.postTypeData = response.data;
        });

    // Add Writings
    $scope.writingData = {
        title: '',
        content: '',
        member: {
            id: $cookies.get("id")
        },
        postType: {
            id: ''
        }
    };

    $scope.submitWritingForm = function (valid, postTypeNo) {
        $scope.writingData.postType.id = postTypeNo;
        if (valid) {
            WritingsService.addWriting($scope.writingData)
                .success(function () {
                    Notification.success("Kayıt Başarılı!");
                    $timeout(function () {
                        window.location.reload()
                    }, 1000);
                })
                .error(function () {
                    Notification.error("Kayıt Başarısız!")
                });
        }
    };

    // Delete Writing
    $scope.deleteWritingData = function (writingNo) {
        WritingsService.deleteWriting(writingNo)
            .success(function () {
                Notification.success("Silme Başarılı!");
                $timeout(function () {
                    window.location.reload()
                }, 1000);
            })
            .error(function () {
                Notification.error("Silme Başarısız!")
            });
    }
}]);

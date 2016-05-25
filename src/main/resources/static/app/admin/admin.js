/**
 * Created by okanm on 18.05.2016.
 */
var admin = angular.module('app.admin', []);

admin.config(function ($stateProvider) {

    $stateProvider.state('admin', {
        url: '/admin',
        views: {
            'main': {
                templateUrl: 'app/admin/admin.tpl.html',
                controller: 'AdminCtrl'
            }
        }
    })
        .state('members', {
            url: '/members',
            views: {
                'main': {
                    templateUrl: 'app/admin/members.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
        .state('memberTypes', {
            url: '/memberTypes',
            views: {
                'main': {
                    templateUrl: 'app/admin/memberTypes.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
        .state('packageTypes', {
            url: '/packageTypes',
            views: {
                'main': {
                    templateUrl: 'app/admin/packageTypes.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
        .state('paymentTypes', {
            url: '/paymentTypes',
            views: {
                'main': {
                    templateUrl: 'app/admin/paymentTypes.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
        .state('productCategories', {
            url: '/productCategories',
            views: {
                'main': {
                    templateUrl: 'app/admin/productCategories.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
        .state('unitTypes', {
            url: '/unitTypes',
            views: {
                'main': {
                    templateUrl: 'app/admin/unitTypes.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
        .state('workTypes', {
            url: '/workTypes',
            views: {
                'main': {
                    templateUrl: 'app/admin/workTypes.tpl.html',
                    controller: 'AdminCtrl'
                }
            }
        })
});

// Admin Operations

admin.service('AdminService', ['$http', 'baseUrl', function ($http, baseUrl) {
    // Member Services

    this.getMembers = function () {
        return $http.get(baseUrl + '/members');
    };

    this.deleteMember = function (memberId) {
        return $http.delete(baseUrl + '/members/delete/' + memberId);
    };

    // Member Type Services
    this.getMemberTypes = function () {
        return $http.get(baseUrl + '/memberTypes');
    };

    this.addMemberType = function (memberTypeData) {
        return $http.post(baseUrl + '/memberTypes/add', memberTypeData);
    };

    this.deleteMemberType = function (memberTypeId) {
        return $http.delete(baseUrl + '/memberTypes/delete/' + memberTypeId);
    };

    // Package Type Services

    this.getPackageTypes = function () {
        return $http.get(baseUrl + '/packageTypes');
    };

    this.addPackageType = function (packageTypeData) {
        return $http.post(baseUrl + '/packageTypes/add', packageTypeData);
    };

    this.deletePackageType = function (packageTypeId) {
        return $http.delete(baseUrl + '/packageTypes/delete/' + packageTypeId);
    };

    // Payment Type Services

    this.getPaymentTypes = function () {
        return $http.get(baseUrl + '/paymentTypes');
    };

    this.addPaymentType = function (paymentTypeData) {
        return $http.post(baseUrl + '/paymentTypes/add', paymentTypeData);
    };

    this.deletePaymentType = function (paymentTypeId) {
        return $http.delete(baseUrl + '/paymentTypes/delete/' + paymentTypeId);
    };

    // Product Category Services

    this.getProductCategories = function () {
        return $http.get(baseUrl + '/productCategories');
    };

    this.addProductCategory = function (productCategoryData) {
        return $http.post(baseUrl + '/productCategories/add', productCategoryData);
    };

    this.deleteProductCategory = function (productCategoryId) {
        return $http.delete(baseUrl + '/productCategories/delete/byId/' + productCategoryId);
    };

    // Unit Type Services

    this.getUnitTypes = function () {
        return $http.get(baseUrl + '/unitTypes');
    };

    this.addUnitType = function (unitTypeData) {
        return $http.post(baseUrl + '/unitTypes/add', unitTypeData);
    };

    this.deleteUnitType = function (unitTypeId) {
        return $http.delete(baseUrl + '/unitTypes/delete/' + unitTypeId);
    };

    // Work Type Services

    this.getWorkTypes = function () {
        return $http.get(baseUrl + '/workTypes');
    };

    this.addWorkType = function (workTypeData) {
        return $http.post(baseUrl + '/workTypes/add', workTypeData);
    };

    this.deleteWorkType = function (workTypeId) {
        return $http.delete(baseUrl + '/workTypes/delete/' + workTypeId);
    };
}]);

admin.controller('AdminCtrl', ['$scope', '$cookies', '$timeout', 'AdminService', 'Notification', function ($scope, $cookies, $timeout, AdminService, Notification) {
    $scope.memberType = $cookies.get("memberType");

    // Member Operations
    $scope.members = {};

    // Get Members
    AdminService.getMembers()
        .then(function (response) {
            $scope.members = response.data;
        });

    // Delete Member
    $scope.deleteMember = function (memberId) {
        AdminService.deleteMember(memberId)
            .success(function () {
                Notification.success("Üye Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Üye Silinemedi!");
            });
    };

    // Member Type Operations
    $scope.memberTypeData = {};

    // Get Member Types
    AdminService.getMemberTypes()
        .then(function (response) {
            $scope.memberTypes = response.data;
        });

    // Add Member Types
    $scope.submitMemberTypeForm = function (valid) {
        if (valid) {
            AdminService.addMemberType($scope.memberTypeData)
                .success(function () {
                    Notification.success("Üye Türü Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Üye Türü Eklenemedi!");
                });
        }
    };

    // Delete Member Type
    $scope.deleteMemberType = function (memberTypesId) {
        AdminService.deleteMemberType(memberTypesId)
            .success(function () {
                Notification.success("Üye Türü Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Üye Türü Silinemedi!");
            });
    };

    // Unit Type Operations
    $scope.unitTypeData = {};

    // Get Unit Types
    AdminService.getUnitTypes()
        .then(function (response) {
            $scope.unitTypes = response.data;
        });

    // Add Unit Types
    $scope.submitUnitTypeForm = function (valid) {
        if (valid) {
            AdminService.addUnitType($scope.unitTypeData)
                .success(function () {
                    Notification.success("Ürün Birimi Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Ürün Birimi Eklenemedi!");
                });
        }
    };

    // Delete Unit Type
    $scope.deleteUnitType = function (unitTypeId) {
        AdminService.deleteUnitType(unitTypeId)
            .success(function () {
                Notification.success("Ürün Birimi Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Ürün Birimi Silinemedi!");
            });
    };

    // Package Type Operations
    $scope.packageTypeData = {};

    // Get Package Types
    AdminService.getPackageTypes()
        .then(function (response) {
            $scope.packageTypes = response.data;
        });

    // Add Package Types
    $scope.submitPackageTypeForm = function (valid) {
        if (valid) {
            AdminService.addPackageType($scope.packageTypeData)
                .success(function () {
                    Notification.success("Paketleme Türü Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Paketleme Türü Eklenemedi!");
                });
        }
    };

    // Delete Package Type
    $scope.deletePackageType = function (packageTypeId) {
        AdminService.deletePackageType(packageTypeId)
            .success(function () {
                Notification.success("Paketleme Türü Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Paketleme Türü Silinemedi!");
            });
    };

    // Payment Type Operations
    $scope.paymentTypeData = {};

    // Get Payment Types
    AdminService.getPaymentTypes()
        .then(function (response) {
            $scope.paymentTypes = response.data;
        });

    // Add Payment Type
    $scope.submitPaymentTypeForm = function (valid) {
        if (valid) {
            AdminService.addPaymentType($scope.paymentTypeData)
                .success(function () {
                    Notification.success("Ödeme Türü Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Ödeme Türü Eklenemedi!");
                });
        }
    };

    // Delete Payment Type
    $scope.deletePaymentType = function (paymentTypesNo) {
        AdminService.deletePaymentType(paymentTypesNo)
            .success(function () {
                Notification.success("Ödeme Türü Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Ödeme Türü Silinemedi!");
            });
    };

    // Product Category Operations
    $scope.productCategoryData = {};

    // Get Product Categories
    AdminService.getProductCategories()
        .then(function (response) {
            $scope.productCategories = response.data;
        });

    // Add Product Category
    $scope.submitProductCategoryForm = function (valid) {
        if (valid) {
            AdminService.addProductCategory($scope.productCategoryData)
                .success(function () {
                    Notification.success("Ürün Kategorisi Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("Ürün Kategorisi Eklenemedi!");
                });
        }
    };

    // Delete Product Category
    $scope.deleteProductCategory = function (productCategoriesId) {
        AdminService.deleteProductCategory(productCategoriesId)
            .success(function () {
                Notification.success("Ürün Kategorisi Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("Ürün Kategorisi Silinemedi!");
            });
    };

    // Work Type Operations
    $scope.workTypeData = {};

    // Get Work Types
    AdminService.getWorkTypes()
        .then(function (response) {
            $scope.workTypes = response.data;
        });

    // Add Work Type
    $scope.submitWorkTypeForm = function (valid) {
        if (valid) {
            AdminService.addWorkType($scope.workTypeData)
                .success(function () {
                    Notification.success("İş Tipi Eklendi!");
                    $timeout(function () {
                        window.location.reload()
                    }, 500);
                })
                .error(function () {
                    Notification.error("İş Tipi Eklenemedi!");
                });
        }
    };

    // Delete Work Type
    $scope.deleteWorkType = function (workTypeId) {
        AdminService.deleteWorkType(workTypeId)
            .success(function () {
                Notification.success("İş Tipi Silindi!");
                $timeout(function () {
                    window.location.reload()
                }, 500);
            })
            .error(function () {
                Notification.error("İş Tipi Silinemedi!");
            });
    };
}]);
/**
 * Created by admin on 11-03-2015.
 */
var myapp1=angular.module('myApp1',[]);
myapp1.controller('addproductController',['$scope',function($scope) {
    $scope.clobj1 = {sid:0,pid:0,discount:0};
    $scope.addProduct = function () {
        console.log($scope.clobj1.sid);
        console.log($scope.clobj1.pid);
        console.log($scope.clobj1.discount);

    }

}]);

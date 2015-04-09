/**
 * Created by admin on 11-03-2015.
 */
var myapp=angular.module('myApp',[]);
myapp.controller('Controller',['$scope','$http',function($scope,$http) {
    $scope.clobj = {saleid: 0, salename: "", fromDate:new Date() , toDate:new Date() };
    $scope.addSale = function () {
        console.log($scope.clobj.saleid);
        console.log($scope.clobj.salename);
        console.log($scope.clobj.fromDate);
        console.log($scope.clobj.toDate);
        
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'AddSaleServlet',
            data:$scope.clobj
        }).success(function(data){
            $scope.adds=data;
        });
    }


        $scope.clobj1 = {sid:0,pid:0,discount:0};
        $scope.addProduct = function () {
            console.log($scope.clobj1.sid);
            console.log($scope.clobj1.pid);
            console.log($scope.clobj1.discount);
            $http({
                method:'POST',
                headers: {
                    'Content-Type' : 'application/x-www-form-urlencoded'
                },
                url: 'AddProduct',
                data:$scope.clobj1
            }).success(function(data){
                $scope.addp=data;
            });

        }

    $scope.clobj2 = {saleName:''};
    $scope.removeSale = function () {
        console.log($scope.clobj2.saleName);
        console.log("removesale");
        $http({
            method:'GET',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'RemoveSale',
            data:$scope.clobj2
        }).success(function(data){
            console.log(data);
            $scope.status=data;
        });
    }



    $scope.clobj3 = {pidr:0};
    $scope.removeProduct = function () {
        console.log($scope.clobj3.pidr);

            $http({
                method:'POST',
                headers: {
                    'Content-Type' : 'application/x-www-form-urlencoded'
                },
                url: 'RemoveProductbyId',
                data:$scope.clobj3
            }).success(function(data){
                $scope.removep=data;
            });
    }

    $scope.clobj4 = {pname:"",fDate:new Date(),tDate:new Date()};
    $scope.revenue = function () {
        console.log($scope.clobj4.pname);
        console.log($scope.clobj4.fDate);
        console.log($scope.clobj4.tDate);
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'GetRevenueByProductName',
            data:$scope.clobj4
        }).success(function(data){
            $scope.Revenue=data;
        });
    }
    $scope.clobj5 = {snamer:''};
    $scope.removesalebyname=function(){
        console.log($scope.clobj5.snamer);
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'RemoveSaleByName',
            data:$scope.clobj5
        }).success(function(data){
            $scope.Remove=data;
        });
    }


    $scope.feedback = {email:"", productname:"", textarea1:"",rating:0}
    $scope.createfeedback = function () {
        console.log("in feedback")
        console.log($scope.feedback.email);
        console.log($scope.feedback.productname);
        console.log($scope.feedback.textarea1);
        console.log($scope.feedback.rating);
        console.log($scope.feedback);
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'FeedbackServlet',
            data:$scope.feedback
        }).success(function(data){
            $scope.status=data;
        });


    }
    $scope.tracking = {product: "", price: 0.0, quantity: 0, status: "", deliverydate: ""}
    $scope.createtracking = function () {
        console.log("in tracking");
        console.log($scope.tracking);

    }
    $scope.trackinginformation={emailid:""}
    $scope.trackingInfo=function(){
        console.log("in feedback")
        console.log($scope.trackinginformation.emailid);

        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'GetTrackingResult',
            data:$scope.trackinginformation
        }).success(function(data){
            $scope.status=data;
        });



    }
    $scope.add={abc:''};
    $scope.addProd = function () {
        console.log($scope.add.abc);
        console.log("addproduct");
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'AddProductDetails',
            data:$scope.add
        }).success(function(ids ){
            console.log(ids);
            $scope.statusid=ids;

        }).error(function(data){console.log("Failure")});
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'AddProductDetails1',
            data:$scope.add
        }).success(function( products){
            console.log(products);
            $scope.statusprod=products;
        }).error(function(data){console.log("Failure")});
    }

    $scope.add={abc:''};
    $scope.addProd1= function () {
        console.log($scope.add.abc);
        console.log("addproduct");
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'AddProductDetails1',
            data:$scope.add
        }).success(function( products){
            console.log(products);
            $scope.statusprod=products;
        }).error(function(data){console.log("Failure")});
    }
    $scope.view={abcd:''};
    $scope.viewProduct=function(){
        console.log("View Product");
        $http({
            method:'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            },
            url: 'ViewProduct',
            data:$scope.view
        }).success(function(data){
            console.log(data);
            $scope.ViewProd=data;
        })
    }
}]);

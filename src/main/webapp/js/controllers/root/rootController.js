'use strict';

var angularSpringControllers = angular.module('angularSpringControllers.rootController', []);


var rootCtrl = function($scope, $state){
        console.log("Running rootCtrl function");
        $scope.title = "Angular Spring";
    };

angularSpringControllers.controller("rootController",["$scope", "$state", rootCtrl]);
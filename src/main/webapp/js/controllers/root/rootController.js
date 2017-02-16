'use strict';

var angularSpringControllers = angular.module('angularSpringControllers.rootController', []);


var rootCtrl = function($scope, $state, apiService){
        console.log("Running rootCtrl function");
        $scope.title = "Foursquare Project";
    };

angularSpringControllers.controller("rootController",["$scope", "$state", "apiService", rootCtrl]);
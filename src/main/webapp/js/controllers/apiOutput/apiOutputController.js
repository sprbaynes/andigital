'use strict';

var springAngularControllers = angular.module('springAngularControllers.apiOutputController', []);


var apiOutputCtrl = function($scope, $state/*, apiService*/){
        console.log("Running apiOutputCtrl function");

        $scope.apiOutput = {"hello":"world"};



         var getLocationsFN = function()
           {
              /*apiService.get({},
                  function(response)
                  {
                    $scope.apiOutput = response;
                  }

               )*/

               return null;
           };

        $scope.getLocationsFN = getLocationsFN;


        getLocationsFN();
    };

springAngularControllers.controller("apiOutputController",["$scope", "$state", "apiService",  apiOutputCtrl]);
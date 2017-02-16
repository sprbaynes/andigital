'use strict';

var angularSpringControllers = angular.module('angularSpringControllers.rootController', []);


var rootCtrl = function($scope, $state, apiService){
        console.log("Running rootCtrl function");
        $scope.title = "Foursquare";
        $scope.locations = null;
        $scope.locationsError = false;
        $scope.locationsErrorMessage = "";

        var locationsPromise = apiService.getLocations("London", 3);

        locationsPromise.then(
            function success(response) {
                $scope.locationsError = false;
                $scope.locationsErrorMessage = "";

                console.log(JSON.stringify(response.data));
                $scope.locations = response.data.locations;
        }, function error(response) {
                console.error(response.data.meta, response.data);
                $scope.locationsError = true;
                $scope.locationsErrorMessage = "Failed to retrieve locations";
        });


        /*Venues*/

        $scope.venues = null;
        $scope.venuesError = false;
        $scope.venuesErrorMessage = "";

        var venuesPromise = apiService.getVenues("Coffee", 51.50853, -0.12574);

        venuesPromise.then(
            function success(response) {
                $scope.venuesError = false;
                $scope.venuesErrorMessage = "";

                console.log(JSON.stringify(response.data));
                $scope.venues = response.data.locations;
        }, function error(response) {
            $scope.venuesError = true;
            console.error(response.data.meta, response.data);
            $scope.venuesErrorMessage = "Failed to retrieve venues";
        })

    };

angularSpringControllers.controller("rootController",["$scope", "$state", "apiService", rootCtrl]);
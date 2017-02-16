'use strict';

var foursquareControllers = angular.module('angularSpringControllers.searchFormController', []);


var searchFormCtrl = function($scope, $state, apiService, searchState){
        console.log("Running searchFormCtrl function");
         $scope.searchState = searchState;

         var getLocationsFN = function(query, resultsNum)
           {

               var success = function(response) {
                   console.log("Locations response OK: %s locations returned", response.data.locations.length);
                   $scope.searchState.locations = response.data.locations;
               };

               var error = function(response){
                       console.error(response.data.meta, response.data);
                       $scope.searchState.locations = [];
               };

               apiService.getLocations(query,resultsNum).then(success, error);
           };

        var lat = searchState.selectedLocationObj.lat;
        var lng = searchState.selectedLocationObj.lng;

        var getVenuesFN = function(query, lat, lng)
        {
            console.log(" query %s lat %s lng %s", query, lat, lng);

            if(query && lat && lng)
            {
                var success = function(response){
                    console.log("Venues response OK: %s venues returned", response.data.venues.length);
                    searchState.venues = response.data.venues;

                };

                var error = function (response) {
                    console.error(response.data.meta, response.data);
                    searchState.venues = [];
                    searchState.venueMarkers = [];
                };

                apiService.getVenues(query, lat,lng).then(success, error);
            }
        };

         $scope.getLocations = getLocationsFN;
         $scope.getVenues = getVenuesFN;

    };

foursquareControllers.controller("searchFormController",["$scope", "$state", "apiService", "searchState",searchFormCtrl]);
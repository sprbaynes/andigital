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

        /*var populateVenueMarkers = function()
        {
            console.log("populating venue markers");
            searchState.venueMarkers = [];

            for( var i = 0; i < searchState.venues.length; i++)
            {
                console.log("lat %s, lng %s",searchState.venues[i].location.lat, searchState.venues[i].location.lng);
                searchState.venueMarkers[i] = {markerId: i+1, latitude: searchState.venues[i].location.lat , longitude: searchState.venues[i].location.lng};
            }
        }
*/

        var getVenuesFN = function(query, lat, lng)
        {
            console.log(" query %s lat %s lng %s", query, lat, lng);

            if(query && lat && lng)
            {
                var success = function(response){
                    /*$scope.venuesError = false;
                     $scope.venuesErrorMessage = "";
                     $scope.venues = response.data.locations;*/
                    console.log("Venues response OK: %s venues returned", response.data.venues.length);
                    searchState.venues = response.data.venues;
                    //populateVenueMarkers();
                };

                var error = function (response) {
                    /*$scope.venuesError = true;
                     $scope.venuesErrorMessage = "Failed to retrieve venues";*/
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
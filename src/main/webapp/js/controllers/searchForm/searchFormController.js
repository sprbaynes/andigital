'use strict';

var foursquareControllers = angular.module('angularSpringControllers.searchFormController', []);


var searchFormCtrl = function($scope, $state, apiService, searchState){
        console.log("Running searchFormCtrl function");
         $scope.searchState = searchState;

         var getLocationsFN = function(query, resultsNum)
           {

               var success = function(response) {
                   console.log(JSON.stringify(response.data));
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

 /*       var getVenuesFN = function(query, lat, lng)
        {
            console.log(" query %s lat %s lng %s", query, lat, lng);
            apiService.getVenues(query, lat,lng).then(
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

                get( {queryString:query, lat: lat, lng:lng},
                function(response){

                    var resCode = response.meta.code;

                    if(typeof resCode !== "undefined" && resCode === 200 )
                    {
                      console.log("response is fine");
                      searchState.venues = response.response.venues;
                      populateVenueMarkers();
                    }
                    else{
                      console.log("response is not fine");
                      searchState.venues = [];
                      searchState.venueMarkers = [];
                    }
                });
        }*/

         $scope.getLocations = getLocationsFN;
         /*$scope.getVenues = getVenuesFN;*/

    };

foursquareControllers.controller("searchFormController",["$scope", "$state", "apiService", "searchState",searchFormCtrl]);
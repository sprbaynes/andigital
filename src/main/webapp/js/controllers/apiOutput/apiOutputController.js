'use strict';

var springAngularControllers = angular.module('angularSpringControllers.apiOutputController', []);


var apiOutputCtrl = function($scope,searchState/*, apiService*/){
    $scope.getLocationObj = function(displayName)
    {
        var resultLocation = null;
        for(var i = 0; i < searchState.locations.length; i++)
        {
            console.log(searchState.locations[i].displayName);
            if(displayName === searchState.locations[i].displayName)
            {
                resultLocation = searchState.locations[i];
            }
        }

        return resultLocation;
    }

    var populateSearchState = function(){
        var selectedLocationObj = $scope.getLocationObj(searchState.selectedLocation);

        if(selectedLocationObj != null)
        {
            searchState.selectedLocationObj = selectedLocationObj;

            $scope.homeMarker = { latitude: selectedLocationObj.lat , longitude: selectedLocationObj.lng};
            $scope.map = { center: { latitude: selectedLocationObj.lat , longitude: selectedLocationObj.lng}, zoom: 14 };
        }
    }

    populateSearchState();

    $scope.$watch('searchState.selectedLocation', function()
    {
        populateSearchState();
    });

    $scope.searchState = searchState;
    };

springAngularControllers.controller("apiOutputController",["$scope", "searchState",  apiOutputCtrl]);

var springAngularServices = angular.module('springAngularServices.apiService', ['ngResource']);

var apiService = function($http){

    this.getLocations = function (query, results) {
        return $http.get("/api/v1/locations", {params: {query: query, results: results }});
    }

    this.getVenues = function(query, lat,lng){
        return $http.get("/api/v1/locations", {params:{query:query, latitude:lat, longitude: lng}});
    }

};

springAngularServices.service('apiService', apiService);


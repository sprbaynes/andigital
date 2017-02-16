
var foursquareServices = angular.module('springAngularServices.searchState', []);

foursquareServices.factory('searchState', function(){

    return {
        venueQuery:"",
        selectedLocation:"London, Greater London, United Kingdom",
        selectedLocationObj: {
            "name":"London",
            "displayName": "London, Greater London, United Kingdom",
            "lat":"51.50853",
            "lng":"-0.12574"

        },
        locations:
            [
                {
                    "name":"London",
                    "displayName": "London, Greater London, United Kingdom",
                    "lat":"51.50853",
                    "lng":"-0.12574"

                }
            ],
        venues:[],
        venueMarkers:[]
    };
});
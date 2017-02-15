
var springAngularServices = angular.module('springAngularServices.apiService', ['ngResource']);

springAngularServices.factory('apiService', ['$resource',
  function($resource){
    console.log("apiService Received call");
    return $resource('/api', {}, {
      query: {method:'GET', params:{}, isArray:false}
    });
  }]);
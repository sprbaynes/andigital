'use strict';

// Declare app level module which depends on views, and components
console.log("Running app.js");

var angularSpringApp = angular.module('angularSpringApp',
        [
            'ngResource',
            'ui.router',
            'ui.bootstrap',
            'angularSpringControllers.rootController',
            'angularSpringControllers.searchFormController',
            'angularSpringControllers.apiOutputController',
            'springAngularServices.apiService',
            'springAngularServices.searchState'
        ]
    );


angularSpringApp.config(
  function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');
    $urlRouterProvider.when('', '/');
    $stateProvider.state('root', {
      url: '/',
      views: {
          'root': {
              templateUrl: 'js/controllers/root/root.html',
              controller: 'rootController',
              controllerAs: 'ctrl'
          },
          'searchForm@root':{
              templateUrl: 'js/controllers/searchForm/searchForm.html',
              controller: 'searchFormController',
              controllerAs: 'ctrl'
          },
          'apiOutput@root':{
              templateUrl: 'js/controllers/apiOutput/apiOutput.html',
              controller: 'apiOutputController',
              controllerAs: 'ctrl'
          }
      }

  });
});



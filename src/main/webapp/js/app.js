'use strict';

// Declare app level module which depends on views, and components
console.log("Running app.js");

var angularSpringApp = angular.module('angularSpringApp',
        [
            'ngResource',
            'ui.router',
            'ui.bootstrap',
            'angularSpringControllers.rootController',
            'springAngularServices.apiService'
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
          }
      }

  });
});



'use strict';

// Declare app level module which depends on views, and components
console.log("Running app.js");

var angularSpringApp = angular.module('angularSpringApp',
        [
            'ngResource',
            'ui.router',
            'ui.bootstrap',
            'angularSpringControllers.rootController',
        ]
    );


angularSpringApp.config(
  function($stateProvider, $urlRouterProvider) {

    console.log("in app config");

    $urlRouterProvider.otherwise('/home');
    $urlRouterProvider.when('', '/home');
    $stateProvider.state('root', {
      url: '',
      views: {
          'root': {
              templateUrl: 'js/controllers/root/root.html',
              controller: 'rootController',
              controllerAs: 'ctrl'
          }
      }

  });
});



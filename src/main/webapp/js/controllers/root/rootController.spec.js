'use strict';

describe('rootController', function() {

    // Load the module that contains the `phoneList` component before each test
    beforeEach(module('angularSpringApp'));

    // Test the controller
    describe('$scope.title', function() {
        var $controller;

        beforeEach(inject(function(_$controller_) {
            $controller = _$controller_;
        }));

        it('sets the title to "Angular Spring"', function() {
            var $scope = {};
            var controller = $controller('rootController', { $scope: $scope });

            $scope.title;
            expect($scope.title).toEqual("Angular Spring");
        });

    });

});

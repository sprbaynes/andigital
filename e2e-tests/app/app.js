describe('Foursquare Project', function() {

    it('should redirect `` to `/', function () {
        browser.get('');
        expect(browser.getLocationAbsUrl()).toBe('/');
    });
});
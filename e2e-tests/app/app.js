describe('Angular Spring Application', function() {

    it('should redirect `/` to `/#/home', function () {
        browser.get('/');
        expect(browser.getLocationAbsUrl()).toBe('/home');
    });
});
'use strict';

// Angular E2E Testing Guide:
// https://docs.angularjs.org/guide/e2e-testing

describe('Home page', function(){

    beforeEach(function() {
        browser.get('/');
    });

    it('should have the title Angular Spring App',function(){
        var title = browser.getTitle();
        expect(title).toBe("Angular Spring App");
    });

    it('should have a navbar with the header "Angular Spring Project"', function(){
        var header = element(by.css(".navbar-header .navbar-brand")).getText();
        expect(header).toBe("Angular Spring Project");
    });

    it('should have a header with the value "Angular Spring Project"', function(){
        var h1Elements = element.all(by.tagName("h1"));
        expect(h1Elements.count()).toBe(1);

        var header = h1Elements.first();
        expect(header.getText()).toBe("Angular Spring Project");
    });

    it('should have a paragraph with describing the app', function(){
        var pElements = element.all(by.css('p.app-description'));
        expect(pElements.count()).toBe(1);

        var paragraph = pElements.first();
        expect(paragraph.getText()).toBe("This is a basic SPA making use of the Angular and Spring");
    });

    it('should not show the browser out of date warning in non IE browsers', function(){
        var browseHappyElements = element.all(by.css(".browsehappy"));
        expect(browseHappyElements.count()).toBe(0);
    })

});


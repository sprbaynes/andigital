'use strict';

// Angular E2E Testing Guide:
// https://docs.angularjs.org/guide/e2e-testing

describe('Home page', function(){

    beforeEach(function() {
        browser.get('/');
    });

    it('should have the title ',function(){
        var title = browser.getTitle();
        expect(title).toBe("Foursquare Project");
    });

    it('should have a navbar with the header "Foursquare Project"', function(){
        var header = element(by.css(".navbar-header .navbar-brand")).getText();
        expect(header).toBe("Foursquare Project");
    });

    it('should have a header with the value "Foursquare Project"', function(){
        var h1Elements = element.all(by.tagName("h1"));
        expect(h1Elements.count()).toBe(1);

        var header = h1Elements.first();
        expect(header.getText()).toBe("Foursquare Project");
    });

    it('should have a paragraph with describing the app', function(){
        var pElements = element.all(by.css('p.app-description'));
        expect(pElements.count()).toBe(1);

        var paragraph = pElements.first();
        expect(paragraph.getText()).toBe("This is an SPA making use of Angular and Spring");
    });

});


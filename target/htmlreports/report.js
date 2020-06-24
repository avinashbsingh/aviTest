$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/test.feature");
formatter.feature({
  "line": 2,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "launche Chrome browser",
  "description": "",
  "id": "title-of-your-feature;launche-chrome-browser",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@First"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "google link was give",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Search anything there",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Click on the first link",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "respected page opens",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "click on the",
  "keyword": "And "
});
formatter.match({
  "location": "firstwebSteps.google_link_was_give()"
});
formatter.result({
  "duration": 2049563700,
  "status": "passed"
});
formatter.match({
  "location": "firstwebSteps.search_anything_there()"
});
formatter.result({
  "duration": 1426012000,
  "status": "passed"
});
formatter.match({
  "location": "firstwebSteps.click_on_the_first_link()"
});
formatter.result({
  "duration": 2156066600,
  "status": "passed"
});
formatter.match({
  "location": "firstwebSteps.respected_page_opens()"
});
formatter.result({
  "duration": 299534600,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 14,
  "name": "launche Chrome browser",
  "description": "",
  "id": "title-of-your-feature;launche-chrome-browser",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Second"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "google link was give",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Search anything there",
  "keyword": "And "
});
formatter.match({
  "location": "firstwebSteps.google_link_was_give()"
});
formatter.result({
  "duration": 641748100,
  "status": "passed"
});
formatter.match({
  "location": "firstwebSteps.search_anything_there()"
});
formatter.result({
  "duration": 981022100,
  "status": "passed"
});
});
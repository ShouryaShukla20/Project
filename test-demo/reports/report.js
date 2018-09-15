$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/testFeature.feature");
formatter.feature({
  "name": "GiveDetails",
  "description": "\tAs a user\n\tI want to create account\n\tSo I have to enter details and accept terms and Condition",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful submission",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@mytag"
    }
  ]
});
formatter.step({
  "name": "I am on LoanApplicationPage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs3.i_am_on_LoanApplicationPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have entered firstname into the form",
  "rows": [
    {
      "cells": [
        "Akshay"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs3.i_have_entered_firstname_into_the_form(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have entered lastname into the form",
  "rows": [
    {
      "cells": [
        "Sachan"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs3.i_have_entered_lastname_into_the_form(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I press submit",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs3.i_press_add()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the success HTML page should be opened and verified",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs3.the_success_HTML_page_should_be_opened_and_verified()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/testFeature2.feature");
formatter.feature({
  "name": "GiveDetails",
  "description": "\tAs a user\n\tI want to create account\n\tSo I have to enter details and accept terms and Condition",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Successful submission2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am on LoanApplicationPagee",
  "keyword": "Given "
});
formatter.step({
  "name": "I have entered \"\u003cfirstname\u003e\" into the form",
  "keyword": "And "
});
formatter.step({
  "name": "I have also entered \"\u003clastname\u003e\" into the form",
  "keyword": "And "
});
formatter.step({
  "name": "I press submitt",
  "keyword": "When "
});
formatter.step({
  "name": "the success HTML page should be opened and verifiedd",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname"
      ]
    },
    {
      "cells": [
        "Akshay",
        "Sachan"
      ]
    },
    {
      "cells": [
        "Rohit",
        "Sharma"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Successful submission2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am on LoanApplicationPagee",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs4.i_am_on_LoanApplicationPagee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have entered \"Akshay\" into the form",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs4.i_have_entered_into_the_form(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have also entered \"Sachan\" into the form",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs4.i_have_also_entered_into_the_form(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I press submitt",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs4.i_press_submitt()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the success HTML page should be opened and verifiedd",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs4.the_success_HTML_page_should_be_opened_and_verifiedd()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Successful submission2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am on LoanApplicationPagee",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs4.i_am_on_LoanApplicationPagee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have entered \"Rohit\" into the form",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs4.i_have_entered_into_the_form(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have also entered \"Sharma\" into the form",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs4.i_have_also_entered_into_the_form(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I press submitt",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs4.i_press_submitt()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the success HTML page should be opened and verifiedd",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs4.the_success_HTML_page_should_be_opened_and_verifiedd()"
});
formatter.result({
  "status": "passed"
});
});
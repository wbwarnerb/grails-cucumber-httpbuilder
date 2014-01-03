Feature: using googles search api
  As a google user
  I want to search google via their api
  to validate the search result without a browser

Scenario: query of a single term via googles search api
  Given I query google via their api
  Then a result is returned

Scenario Outline: query of multiple terms via googles api
  Given I query googe for "<query>"
  Then google will return a result with "<query>"

  Examples:
  |query|
  |cucumber|
  |sloth   |
  |migraine|
  |grails  |
  |~!@#$%^&*()  |

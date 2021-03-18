Feature: Calculator
..
@mytag
Scenario: Add two numbers
Given I have 50
And I also have 50
When I press add
Then the result should show 100
 
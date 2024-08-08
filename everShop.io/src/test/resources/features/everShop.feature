#language: en
@testfeature
  Feature: E-commerce Checkout Process
    As a registered user
    I want to be able to complete a purchase
    So that I can successfully buy the products that I have already selected.

  #Checkout Process
    @createAccount
    Scenario: User successfully completes the checkout process
      Given the user opens the home page of everShop
      And the user clicks on the sign button
      And The user validates that the title "Login" should be displayed
      Then the user clicks on create an account
      And the user validates the title "Create A New Account"
      Then the user completes the account registration form using the details
        | fullName        | email                     | password  |
        | Andres Michilot | testAutomation2@gmail.com | everShop1 |
      And the user clicks on sign up button
      #Colocar validacion que se creo la cuenta correctamente

    @checkoutProcess

Feature: Formular

  Scenario: Kontrola radiobutton
    Given Uzivatel je na strance s formularem
    When Uzivatel klikne na radiobutton male
    And Uzivatel klikne na radiobutton female
    Then Uzivatel vidi zaskrtnuto female
    And Uzivatel vidi odskrtnuto male
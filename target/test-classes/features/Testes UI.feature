@TestesUI
Feature: Testes de UI para JSONPlaceholder

  Scenario: Validar o Id 6 da tela do JSONPlaceholder
    Given que eu acesso a tela do JSONPlaceholder
    And eu clico no menu Guide
    When eu seleciono o link albums 1 photos
    And eu salvo o json exibido
    Then eu valido os dados do objeto id 6
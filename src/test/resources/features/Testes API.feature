@TestesAPI
Feature: Testes de API para JSONPlaceholder

  Scenario: Validar o envio de um GET na api de comments com alias odio sit
    Given que eu tenha o request de consulta para api comments pelo "name" "alias odio sit"
    When eu realizo um GET para api de comments
    Then eu devo receber o statusCode 200
    And eu devo receber o email preenchido com "Lew@alysha.tv"

  Scenario: Validar o envio de um POST para api de users
    Given que eu tenha o request vazio para a api de users
    When eu realizo um POST para api de users
    Then eu devo receber o statusCode 201
    And eu devo receber o id preenchido com "11"

  Scenario: Validar o envio de um PUT para api de users
    Given que eu tenha o request com alteração no id "5" da api de users
    When eu realizo um PUT para api de users
    Then eu devo receber o statusCode 200

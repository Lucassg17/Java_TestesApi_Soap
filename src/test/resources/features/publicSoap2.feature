#language: pt

Funcionalidade: Testando metodos Post da Public SOAP APIs

  @Teste007 @%PublicSoap2
  Cenario: Realizando um Post - List of Countries by Name
    Dado que envio uma requisicao Post para List of Countries by Name
    Entao recebo um response correto com a lista de paises por nome
      |planilha                 |aba              |
      |MassaDadosTestesSoap.xlsx|ListCountriesName|

  @Teste008 @%PublicSoap2
  Cenario: Realizando um Post - Captial City for a Country
    Dado que envio uma requisicao Post para Captial City for a Country
      |planilha                 |aba                   |
      |MassaDadosTestesSoap.xlsx|CaptialCityForACountry|
    Entao recebo como retorno a capital do pais corretamente

  @Teste009 @%PublicSoap2
  Cenario: Realizando um Post - Currency for a Country
    Dado que envio uma requisicao Post para Currency for a Country
      |planilha                 |aba                |
      |MassaDadosTestesSoap.xlsx|CurrencyForACountry|
    Entao recebo como retorno a moeda do pais corretamente

  @Teste010 @%PublicSoap2
  Cenario: Realizando um Post - Flag for a Country
    Dado que envio uma requisicao Post para Flag for a Country
      |planilha                 |aba            |
      |MassaDadosTestesSoap.xlsx|FlagForACountry|
    Entao recebo como retorno de um link para uma imagem da bandeira do pais corretamente

  @Teste011 @%PublicSoap2
  Cenario: Realizando um Post - International Phone Code for a Country Copy
    Dado que envio uma requisicao Post para International Phone Code for a Country Copy
      |planilha                 |aba                          |
      |MassaDadosTestesSoap.xlsx|InternationalPhoneCodeCountry|
    Entao recebo como retorno o codigo de telefone internacional do pais

  @Teste012 @%PublicSoap2
  Cenario: Realizando um Post - List of Currencies by Name
    Dado que envio uma requisicao Post para List of Currencies by Name
    Entao recebo um response correto com a lista de moedas por nome
      |planilha                 |aba                   |
      |MassaDadosTestesSoap.xlsx|ListOfCurrenciesByName|
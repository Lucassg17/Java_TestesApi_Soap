#language: pt

Funcionalidade: Testando metodos Post da Public SOAP APIs

  @Teste013 @%PublicSoap3
  Cenario: Realizando um Post - List of Languages by Name
    Dado que envio uma requisicao Post para List of Languages by Name
    Entao recebo um response correto com a lista de idiomas por nome
      |planilha                 |aba                 |
      |MassaDadosTestesSoap.xlsx|ListOfLanguageByName|

  @Teste014 @%PublicSoap3
  Cenario: Realizando um Post - Is Valid ISBN13 Number
    Dado que envio uma requisicao Post para Is Valid ISBN13 Number
      |planilha                 |aba                |
      |MassaDadosTestesSoap.xlsx|IsValidISBN13Number|
    Entao recebo um response valido

  @Teste015 @%PublicSoap3
  Cenario: Realizando um Post - Is Valid ISBN10 Number
    Dado que envio uma request Post para Is Valid ISBN10 Number
      |planilha                 |aba                |
      |MassaDadosTestesSoap.xlsx|IsValidISBN10Number|
    Entao recebo um response valido como retorno

  @Teste016 @%PublicSoap3
  Cenario: Realizando um Post - Celsius to Farenheit Conversion
    Dado que envio uma request Post para Celsius to Farenheit Conversion
      |planilha                 |aba                         |
      |MassaDadosTestesSoap.xlsx|CelsiusToFarenheitConversion|
    Entao recebo um response valido da conversao de Celsius para Farenheit

  @Teste017 @%PublicSoap3
  Cenario: Realizando um Post - Farenheit to Celsius Conversion
    Dado que envio uma request Post para Farenheit to Celsius Conversion
      |planilha                 |aba                         |
      |MassaDadosTestesSoap.xlsx|FarenheitToCelsiusConversion|
    Entao recebo um response valido da conversao de Farenheit para Celsius
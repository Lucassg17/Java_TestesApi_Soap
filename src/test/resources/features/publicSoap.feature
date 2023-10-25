#language: pt

Funcionalidade: Testando metodos Post da Public SOAP APIs

  @Teste001 @%PublicSoap
  Cenario: Realizando um Post - Number to Words
    Dado que envio uma requisicao Post para NumberToWords
      |planilha                 |aba              |
      |MassaDadosTestesSoap.xlsx|TestNumberToWords|
    Entao recebo um response correto

  @Teste002 @%PublicSoap
  Cenario: Realizando um Post - Number to Dollars
    Dado que envio uma requisicao Post para NumberToDollars
      |planilha                 |aba                |
      |MassaDadosTestesSoap.xlsx|TestNumberToDollars|
    Entao meu response retorna conforme solicitado

  @Teste005 @%PublicSoap
  Cenario: Realizando um Post - Divide
    Dado que envio uma requisicao Post para Divide
      |planilha                 |aba   |
      |MassaDadosTestesSoap.xlsx|Divide|
    Entao meu response retorna com o calculo de divisao correto

  @Teste005 @%PublicSoap
  Cenario: Realizando um Post - Multiply
    Dado que envio uma requisicao Post para Multiply
      |planilha                 |aba     |
      |MassaDadosTestesSoap.xlsx|Multiply|
    Entao meu response retorna com o calculo da multiplicacao corretamente

  @Teste005 @%PublicSoap
  Cenario: Realizando um Post - Subtract
    Dado que envio uma requisicao Post para Subtract
      |planilha                 |aba     |
      |MassaDadosTestesSoap.xlsx|Subtract|
    Entao recebo como retorno o calculo da subtracao corretamente

  @Teste006 @%PublicSoap
  Cenario: Realizando um Post - List of Continents by Name
    Dado que envio uma requisicao Post para List of Continents by Name
    Entao meu response retorna com a lista de Continentes por Nome corretamente
      |planilha                 |aba               |
      |MassaDadosTestesSoap.xlsx|ListContinentsName|
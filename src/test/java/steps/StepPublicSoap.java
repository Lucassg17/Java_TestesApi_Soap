package steps;

import AtribXml.AtributosXml;
import Utils.ArquivoTxt;
import Utils.Excel;
import dados.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import metodos.MetodosSoap;
import org.junit.Assert;

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepPublicSoap {
    private static List<Map<String, String>> list;
    public static int linhas;
    private static final List<DadosResponseNumberToWords> valoresColunaWords_NumberToWords = new ArrayList<>();
    private static final List<DadosResponseNumberToDollars> valoresColunaDollars_NumberToDollars = new ArrayList<>();
    private static final List<DadosResponseDivide> valoresColunaResult_Divide = new ArrayList<>();
    private static final List<DadosResponseMultiply> valoresColunaResult_Multiply = new ArrayList<>();
    private static final List<DadosResponseSubtract> valoresColunaResult_Subtract = new ArrayList<>();
    private static final List<DadosResponseListContinents> valoresTabela_ListOfContinents = new ArrayList<>();

    //////////////////////////////////////////////////////////////////////////////////
    private static final List<String> valoresColunaNumbers_NumberToWords = new ArrayList<>();
    private static final List<String> valoresColunaNumbers_NumberToDollars = new ArrayList<>();
    private static final List<String> valoresColunaIntA_Divide = new ArrayList<>();
    private static final List<String> valoresColunaIntB_Divide = new ArrayList<>();
    private static final List<String> valoresColunaIntA_Multiply = new ArrayList<>();
    private static final List<String> valoresColunaIntB_Multiply = new ArrayList<>();
    private static final List<String> valoresColunaIntA_Subtract = new ArrayList<>();
    private static final List<String> valoresColunaIntB_Subtract = new ArrayList<>();

    //////////////////////////////////////////////////////////////////////////////////
    private static final List<Response> resultNumberToWords = new ArrayList<>();
    private static final List<Response> resultNumberToDollars = new ArrayList<>();
    private static final List<Response> resultDivide = new ArrayList<>();
    private static final List<Response> resultMultiply = new ArrayList<>();
    private static final List<Response> resultSubtract = new ArrayList<>();
    private static final List<Response> resultListOfContinents = new ArrayList<>();

    ///////////////Realizando um Post - Number to Words
    @Dado("que envio uma requisicao Post para NumberToWords")
    public void queEnvioUmaRequisicaoPostParaNumberToWords(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosDeMassaNumberToWords(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresColunaNumbers_NumberToWords.add(ArquivoTxt.lerArquivo(
                    "NUMBERS_" + i, "Dados_Excel-criarMassaNumberToWords.txt"));
        }

        for (String valoresColunaNumbersNumberToWord : valoresColunaNumbers_NumberToWords) {
            resultNumberToWords.add(MetodosSoap.criaRequisicaoEmNumberToWords(valoresColunaNumbersNumberToWord));
        }
    }

    @Entao("recebo um response correto")
    public void receboUmResponseCorreto() throws Exception {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaWords_NumberToWords.add(new DadosResponseNumberToWords(
                    ArquivoTxt.lerArquivo("WORDS_" + i, "Dados_Excel-criarMassaNumberToWords.txt")));
        }

        for (int i = 0; i < valoresColunaWords_NumberToWords.size(); i++){
            resultNumberToWords.get(i).then().log().all();
            if (resultNumberToWords.get(i).xmlPath().getString(AtributosXml.numberToWordsResult).
                    contains(valoresColunaWords_NumberToWords.get(i).getNumberToWordsResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Number to Dollars

    @Dado("que envio uma requisicao Post para NumberToDollars")
    public void queEnvioUmaRequisicaoPostParaNumberToDollars(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosDeMassaNumberToDollars(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresColunaNumbers_NumberToDollars.add(ArquivoTxt.lerArquivo(
                    "NUMBERS_" + i, "Dados_Excel-criarMassaNumberToDollars.txt"));
        }

        for (String valoresColunaNumbersNumberToDollar : valoresColunaNumbers_NumberToDollars) {
            resultNumberToDollars.add(MetodosSoap.criarRequisicaoEmNumberToDollars(valoresColunaNumbersNumberToDollar));
        }
    }


    @Entao("meu response retorna conforme solicitado")
    public void meuResponseRetornaConformeSolicitado() throws Exception {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaDollars_NumberToDollars.add(new DadosResponseNumberToDollars(
                    ArquivoTxt.lerArquivo("DOLLARS_" + i, "Dados_Excel-criarMassaNumberToDollars.txt")));
        }

        for (int i = 0; i < valoresColunaDollars_NumberToDollars.size(); i++){
            resultNumberToDollars.get(i).then().log().all();
            if (resultNumberToDollars.get(i).xmlPath().getString(AtributosXml.numberToDollarsResult).
                    contains(valoresColunaDollars_NumberToDollars.get(i).getNumberToDollarsResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Divide

    @Dado("que envio uma requisicao Post para Divide")
    public void queEnvioUmaRequisicaoPostParaDivide(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosDeMassaDivisao(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresColunaIntA_Divide.add(ArquivoTxt.lerArquivo(
                    "IntA_" + i, "Dados_Excel-criarMassaDivide.txt"));

            valoresColunaIntB_Divide.add(ArquivoTxt.lerArquivo(
                    "IntB_" + i, "Dados_Excel-criarMassaDivide.txt"));
        }

        for (int i = 0; i < valoresColunaIntA_Divide.size(); i++) {
            resultDivide.add(MetodosSoap.criarRequisicaoEmDivide(valoresColunaIntA_Divide.get(i), valoresColunaIntB_Divide.get(i)));
        }
    }

    @Entao("meu response retorna com o calculo de divisao correto")
    public void meuResponseRetornaComOCalculoDeDivisaoCorreto() throws Exception {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaResult_Divide.add(new DadosResponseDivide(
                    ArquivoTxt.lerArquivo("RESULT_" + i, "Dados_Excel-criarMassaDivide.txt")));
        }

        for (int i = 0; i < valoresColunaResult_Divide.size(); i++){
            resultDivide.get(i).then().log().all();
            if (resultDivide.get(i).xmlPath().getString(AtributosXml.divideResult).
                    contains(valoresColunaResult_Divide.get(i).getDivideResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Multiply

    @Dado("que envio uma requisicao Post para Multiply")
    public void queEnvioUmaRequisicaoPostParaMultiply(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosDeMassaMultiplicacao(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaIntA_Multiply.add(ArquivoTxt.lerArquivo(
                    "IntA_" + i, "Dados_Excel-criarMassaMultiply.txt"));

            valoresColunaIntB_Multiply.add(ArquivoTxt.lerArquivo(
                    "IntB_" + i, "Dados_Excel-criarMassaMultiply.txt"));
        }

        for (int i = 0; i < valoresColunaIntA_Multiply.size(); i++) {
            resultMultiply.add(MetodosSoap.criarRequisicaoEmMultiply(valoresColunaIntA_Multiply.get(i), valoresColunaIntB_Multiply.get(i)));
        }
    }

    @Entao("meu response retorna com o calculo da multiplicacao corretamente")
    public void meuResponseRetornaComOCalculoDaMultiplicacaoCorretamente() {
        for (int i = 1; i <= linhas; i++){
            valoresColunaResult_Multiply.add(new DadosResponseMultiply(
                    ArquivoTxt.lerArquivo("RESULT_" + i, "Dados_Excel-criarMassaMultiply.txt")));
        }

        for (int i = 0; i < valoresColunaResult_Multiply.size(); i++){
            resultMultiply.get(i).then().log().all();
            if (resultMultiply.get(i).xmlPath().getString(AtributosXml.multiplyResult).
                    contains(valoresColunaResult_Multiply.get(i).getMultiplyResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Subtract

    @Dado("que envio uma requisicao Post para Subtract")
    public void queEnvioUmaRequisicaoPostParaSubtract(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosDeMassaSubtracao(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaIntA_Subtract.add(ArquivoTxt.lerArquivo(
                    "IntA_" + i, "Dados_Excel-criarMassaSubtract.txt"));

            valoresColunaIntB_Subtract.add(ArquivoTxt.lerArquivo(
                    "IntB_" + i, "Dados_Excel-criarMassaSubtract.txt"));
        }

        for (int i = 0; i < valoresColunaIntA_Subtract.size(); i++) {
            resultSubtract.add(MetodosSoap.criarRequisicaoEmSubtract(valoresColunaIntA_Subtract.get(i), valoresColunaIntB_Subtract.get(i)));
        }
    }

    @Entao("recebo como retorno o calculo da subtracao corretamente")
    public void receboComoRetornoOCalculoDaSubtracaoCorretamente() {
        for (int i = 1; i <= linhas; i++){
            valoresColunaResult_Subtract.add(new DadosResponseSubtract(
                    ArquivoTxt.lerArquivo("RESULT_" + i, "Dados_Excel-criarMassaSubtract.txt")));
        }

        for (int i = 0; i < valoresColunaResult_Subtract.size(); i++){
            resultSubtract.get(i).then().log().all();
            if (resultSubtract.get(i).xmlPath().getString(AtributosXml.subtractResult).
                    contains(valoresColunaResult_Subtract.get(i).getSubtractResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - List of Continents by Name

    @Dado("que envio uma requisicao Post para List of Continents by Name")
    public void queEnvioUmaRequisicaoPostParaListOfContinentsByName() throws SOAPException, TransformerException {
        resultListOfContinents.add(MetodosSoap.criarRequisicaoEmListOfContinentsByName());
    }

    @Entao("meu response retorna com a lista de Continentes por Nome corretamente")
    public void meuResponseRetornaComAListaDeContinentesPorNomeCorretamente(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosDeMassaListaDeContinentes(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresTabela_ListOfContinents.add(new DadosResponseListContinents(
                    ArquivoTxt.lerArquivo("SNAME_" + i, "Dados_Excel-criarMassaListContinents.txt")));
        }

        for (int i = 0; i < valoresTabela_ListOfContinents.size(); i++) {
            if (resultListOfContinents.get(0).xmlPath().getString(AtributosXml.sName).
                    contains(valoresTabela_ListOfContinents.get(0).getsName())) {
                Assert.assertTrue(true);
            }
        }
    }
}

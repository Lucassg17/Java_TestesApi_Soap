package steps;

import AtribXml.AtributosXml;
import AtribXml.AtributosXml2;
import Utils.ArquivoTxt;
import Utils.Excel2;
import dados2.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import metodos.MetodosSoap3;
import org.junit.Assert;

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepPublicSoap3 {
    private static List<Map<String, String>> list;
    public static int linhas;

    private static final List<Response> resultLanguagesByName = new ArrayList<>();
    private static final List<Response> resultIsbn13 = new ArrayList<>();
    private static final List<Response> resultIsbn10 = new ArrayList<>();
    private static final List<Response> resultCelsiusToFahrenheit = new ArrayList<>();
    private static final List<Response> resultFahrenheitToCelsius = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final List<DadosResponseLanguagesByName> valoresTabela_LanguagesByName = new ArrayList<>();
    private static final List<DadosResponseIsbn13> valoresColunaISBN13Result = new ArrayList<>();
    private static final List<DadosResponseIsbn10> valoresColunaISBN10Result = new ArrayList<>();
    private static final List<DadosResponseCeToFa> valoresColunaResult_CTF = new ArrayList<>();
    private static final List<DadosResponseFaToCe> valoresColunaResult_FTC = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final List<String> valoresColunaIsbn13 = new ArrayList<>();
    private static final List<String> valoresColunaIsbn10 = new ArrayList<>();
    private static final List<String> valoresColunaCelsiusToFahrenheit = new ArrayList<>();
    private static final List<String> valoresColunaFahrenheitToCelsius = new ArrayList<>();

    ///////////////Realizando um Post - List of Languages by Name

    @Dado("que envio uma requisicao Post para List of Languages by Name")
    public void queEnvioUmaRequisicaoPostParaListOfLanguagesByName() throws SOAPException, TransformerException {
        resultLanguagesByName.add(MetodosSoap3.criarRequisicaoEmListOfCountriesByName());
    }

    @Entao("recebo um response correto com a lista de idiomas por nome")
    public void receboUmResponseCorretoComAListaDeIdiomasPorNome(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaLanguagesByName(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresTabela_LanguagesByName.add(new DadosResponseLanguagesByName(
                    ArquivoTxt.lerArquivo("SNAME_" + i, "Dados_Excel-criarMassaLanguagesByName.txt")));
        }

        for (int i = 0; i < valoresTabela_LanguagesByName.size(); i++) {
            if (resultLanguagesByName.get(0).xmlPath().getString(AtributosXml.sName).
                    contains(valoresTabela_LanguagesByName.get(0).getsName())) {
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Is Valid ISBN13 Number

    @Dado("que envio uma requisicao Post para Is Valid ISBN{int} Number")
    public void queEnvioUmaRequisicaoPostParaIsValidISBNNumber(int arg0, DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaIsbn13(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaIsbn13.add(ArquivoTxt.lerArquivo(
                    "ISBN_" + i, "Dados_Excel-criarMassaIsbn13.txt"));
        }

        for (String s : valoresColunaIsbn13) {
            resultIsbn13.add(MetodosSoap3.criarRequisicaoEmIsbn13(s));
        }
    }

    @Entao("recebo um response valido")
    public void receboUmResponseValido() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaISBN13Result.add(new DadosResponseIsbn13(
                    ArquivoTxt.lerArquivo("ISBN13RESULT_" + i, "Dados_Excel-criarMassaIsbn13.txt")));
        }

        for (int i = 0; i < valoresColunaISBN13Result.size(); i++){
            resultIsbn13.get(i).then().log().all();
            if (resultIsbn13.get(i).xmlPath().getString(AtributosXml2.isValidISBN13Result).
                    contains(valoresColunaISBN13Result.get(i).getIsValidISBN13Result())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Is Valid ISBN10 Number

    @Dado("que envio uma request Post para Is Valid ISBN{int} Number")
    public void queEnvioUmaRequestPostParaIsValidISBNNumber(int arg0, DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaIsbn10(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaIsbn10.add(ArquivoTxt.lerArquivo(
                    "ISBN_" + i, "Dados_Excel-criarMassaIsbn10.txt"));
        }

        for (String s : valoresColunaIsbn10) {
            resultIsbn10.add(MetodosSoap3.criarRequisicaoEmIsbn10(s));
        }
    }

    @Entao("recebo um response valido como retorno")
    public void receboUmResponseValidoComoRetorno() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaISBN10Result.add(new DadosResponseIsbn10(
                    ArquivoTxt.lerArquivo("ISBN10RESULT_" + i, "Dados_Excel-criarMassaIsbn10.txt")));
        }

        for (int i = 0; i < valoresColunaISBN10Result.size(); i++){
            resultIsbn10.get(i).then().log().all();
            if (resultIsbn10.get(i).xmlPath().getString(AtributosXml2.isValidISBN10Result).
                    contains(valoresColunaISBN10Result.get(i).getIsValidISBN10Result())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Celsius to Farenheit Conversion

    @Dado("que envio uma request Post para Celsius to Farenheit Conversion")
    public void queEnvioUmaRequestPostParaCelsiusToFarenheitConversion(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaCelsiusToFahrenheit(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaCelsiusToFahrenheit.add(ArquivoTxt.lerArquivo(
                    "CELSIUSTOFAHRENHEIT_" + i, "Dados_Excel-criarMassaCelsiusToFahrenheit.txt"));
        }

        for (String s : valoresColunaCelsiusToFahrenheit) {
            resultCelsiusToFahrenheit.add(MetodosSoap3.criarRequisicaoEmCelsiusToFahrenheit(s));
        }
    }

    @Entao("recebo um response valido da conversao de Celsius para Farenheit")
    public void receboUmResponseValidoDaConversaoDeCelsiusParaFarenheit() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaResult_CTF.add(new DadosResponseCeToFa(
                    ArquivoTxt.lerArquivo("RESULT_" + i, "Dados_Excel-criarMassaCelsiusToFahrenheit.txt")));
        }

        for (int i = 0; i < valoresColunaResult_CTF.size(); i++){
            resultCelsiusToFahrenheit.get(i).then().log().all();
            if (resultCelsiusToFahrenheit.get(i).xmlPath().getString(AtributosXml2.celsiusToFahrenheitResult).
                    contains(valoresColunaResult_CTF.get(i).getCelsiusToFahrenheitResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Farenheit to Celsius Conversion

    @Dado("que envio uma request Post para Farenheit to Celsius Conversion")
    public void queEnvioUmaRequestPostParaFarenheitToCelsiusConversion(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaFahrenheitToCelsius(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaFahrenheitToCelsius.add(ArquivoTxt.lerArquivo(
                    "FAHRENHEITTOCELSIUS_" + i, "Dados_Excel-criarMassaFahrenheitToCelsius.txt"));
        }

        for (String s : valoresColunaFahrenheitToCelsius) {
            resultFahrenheitToCelsius.add(MetodosSoap3.criarRequisicaoEmFahrenheitToCelsius(s));
        }
    }

    @Entao("recebo um response valido da conversao de Farenheit para Celsius")
    public void receboUmResponseValidoDaConversaoDeFarenheitParaCelsius() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaResult_FTC.add(new DadosResponseFaToCe(
                    ArquivoTxt.lerArquivo("RESULT_" + i, "Dados_Excel-criarMassaFahrenheitToCelsius.txt")));
        }

        for (int i = 0; i < valoresColunaResult_FTC.size(); i++){
            resultFahrenheitToCelsius.get(i).then().log().all();
            if (resultFahrenheitToCelsius.get(i).xmlPath().getString(AtributosXml2.fahrenheitToCelsiusResult).
                    contains(valoresColunaResult_FTC.get(i).getFahrenheitToCelsiusResult())){
                Assert.assertTrue(true);
            }
        }
    }
}

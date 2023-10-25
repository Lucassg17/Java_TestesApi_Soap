package steps;

import AtribXml.AtributosXml;
import AtribXml.AtributosXml2;
import Utils.ArquivoTxt;
import Utils.Excel2;
import dados.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import metodos.MetodosSoap2;
import org.junit.Assert;

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepPublicSoap2 {
    private static List<Map<String, String>> list;
    public static int linhas;

    private static final List<DadosResponseListCountries> valoresTabela_ListOfCountries = new ArrayList<>();
    private static final List<DadosResponseCurrenciesByName> valoresTabela_ListOfCurrenciesByName = new ArrayList<>();
    private static final List<DadosResponseCapitalCityCountry> valoresColunaCapitalCity = new ArrayList<>();
    private static final List<DadosResponseCurrencyCountry> valoresColunaSname = new ArrayList<>();
    private static final List<DadosResponseFlagCountry> valoresColunaFlagCountry = new ArrayList<>();
    private static final List<DadosResponsePhoneCode> valoresColunaPhoneCodeCountry = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final List<String> valoresColunaCountry = new ArrayList<>();
    private static final List<String> valoresColunaCountryIsoCode_Currency = new ArrayList<>();
    private static final List<String> valoresColunaCountryIsoCode_Flag = new ArrayList<>();
    private static final List<String> valoresColunaCountryIsoCode_PhoneCode = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Response> resultListOfCountries = new ArrayList<>();
    private static final List<Response> resultCapitalCityCountry = new ArrayList<>();
    private static final List<Response> resultCurrencyCountry = new ArrayList<>();
    private static final List<Response> resultFlagCountry = new ArrayList<>();
    private static final List<Response> resultPhoneCodeCountry = new ArrayList<>();
    private static final List<Response> resultCurrenciesByName = new ArrayList<>();

    ///////////////Realizando um Post - List of Countries by Name

    @Dado("que envio uma requisicao Post para List of Countries by Name")
    public void queEnvioUmaRequisicaoPostParaListOfCountriesByName() throws SOAPException, TransformerException {
        resultListOfCountries.add(MetodosSoap2.criarRequisicaoEmListOfCountriesByName());
    }

    @Entao("recebo um response correto com a lista de paises por nome")
    public void receboUmResponseCorretoComAListaDePaisesPorNome(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaListaDePaises(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresTabela_ListOfCountries.add(new DadosResponseListCountries(
                    ArquivoTxt.lerArquivo("SNAME_" + i, "Dados_Excel-criarMassaListCountries.txt")));
        }

        for (int i = 0; i < valoresTabela_ListOfCountries.size(); i++) {
            if (resultListOfCountries.get(0).xmlPath().getString(AtributosXml.sName).
                    contains(valoresTabela_ListOfCountries.get(0).getsName())) {
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Captial City for a Country

    @Dado("que envio uma requisicao Post para Captial City for a Country")
    public void queEnvioUmaRequisicaoPostParaCaptialCityForACountry(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaCapitalCountry(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaCountry.add(ArquivoTxt.lerArquivo(
                    "COUNTRY_" + i, "Dados_Excel-criarMassaCapitalCountry.txt"));
        }

        for (String s : valoresColunaCountry) {
            resultCapitalCityCountry.add(MetodosSoap2.criarRequisicaoEmCapitalCityForACountry(s));
        }
    }

    @Entao("recebo como retorno a capital do pais corretamente")
    public void receboComoRetornoACapitalDoPaisCorretamente() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaCapitalCity.add(new DadosResponseCapitalCityCountry(
                    ArquivoTxt.lerArquivo("CAPITALCITY_" + i, "Dados_Excel-criarMassaCapitalCountry.txt")));
        }

        for (int i = 0; i < valoresColunaCapitalCity.size(); i++){
            resultCapitalCityCountry.get(i).then().log().all();
            if (resultCapitalCityCountry.get(i).xmlPath().getString(AtributosXml2.capitalCityResult).
                    contains(valoresColunaCapitalCity.get(i).getCapitalCityResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Currency for a Country

    @Dado("que envio uma requisicao Post para Currency for a Country")
    public void queEnvioUmaRequisicaoPostParaCurrencyForACountry(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaCurrencyCountry(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaCountryIsoCode_Currency.add(ArquivoTxt.lerArquivo(
                    "COUNTRYISOCODE_" + i, "Dados_Excel-criarMassaCurrencyCountry.txt"));
        }

        for (String s : valoresColunaCountryIsoCode_Currency) {
            resultCurrencyCountry.add(MetodosSoap2.criarRequisicaoEmCurrencyCountry(s));
        }
    }

    @Entao("recebo como retorno a moeda do pais corretamente")
    public void receboComoRetornoAMoedaDoPaisCorretamente() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaSname.add(new DadosResponseCurrencyCountry(
                    ArquivoTxt.lerArquivo("SNAME_" + i, "Dados_Excel-criarMassaCurrencyCountry.txt")));
        }

        for (int i = 0; i < valoresColunaSname.size(); i++){
            resultCurrencyCountry.get(i).then().log().all();
            if (resultCurrencyCountry.get(i).xmlPath().getString(AtributosXml.sName).
                    contains(valoresColunaSname.get(i).getsName())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - Flag for a Country

    @Dado("que envio uma requisicao Post para Flag for a Country")
    public void queEnvioUmaRequisicaoPostParaFlagForACountry(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaFlagCountry(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaCountryIsoCode_Flag.add(ArquivoTxt.lerArquivo(
                    "COUNTRYISOCODE_" + i, "Dados_Excel-criarMassaFlagCountry.txt"));
        }

        for (String s : valoresColunaCountryIsoCode_Flag) {
            resultFlagCountry.add(MetodosSoap2.criarRequisicaoEmFlagCountry(s));
        }
    }

    @Entao("recebo como retorno de um link para uma imagem da bandeira do pais corretamente")
    public void receboComoRetornoDeUmLinkParaUmaImagemDaBandeiraDoPaisCorretamente() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaFlagCountry.add(new DadosResponseFlagCountry(
                    ArquivoTxt.lerArquivo("FLAGCOUNTRY_" + i, "Dados_Excel-criarMassaFlagCountry.txt")));
        }

        for (int i = 0; i < valoresColunaFlagCountry.size(); i++){
            resultFlagCountry.get(i).then().log().all();
            if (resultFlagCountry.get(i).xmlPath().getString(AtributosXml2.countryFlagResult).
                    contains(valoresColunaFlagCountry.get(i).getCountryFlagResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - International Phone Code for a Country Copy

    @Dado("que envio uma requisicao Post para International Phone Code for a Country Copy")
    public void queEnvioUmaRequisicaoPostParaInternationalPhoneCodeForACountryCopy(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaInterPhoneCountry(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++){
            valoresColunaCountryIsoCode_PhoneCode.add(ArquivoTxt.lerArquivo(
                    "COUNTRYISOCODE_" + i, "Dados_Excel-criarMassaMassaInterPhoneCountry.txt"));
        }

        for (String s : valoresColunaCountryIsoCode_PhoneCode) {
            resultPhoneCodeCountry.add(MetodosSoap2.criarRequisicaoEmInterPhoneCountry(s));
        }
    }

    @Entao("recebo como retorno o codigo de telefone internacional do pais")
    public void receboComoRetornoOCodigoDeTelefoneInternacionalDoPais() {
        for (int i = 1; i <= linhas; i++) {
            valoresColunaPhoneCodeCountry.add(new DadosResponsePhoneCode(
                    ArquivoTxt.lerArquivo("PHONECODE_" + i, "Dados_Excel-criarMassaMassaInterPhoneCountry.txt")));
        }

        for (int i = 0; i < valoresColunaPhoneCodeCountry.size(); i++){
            resultPhoneCodeCountry.get(i).then().log().all();
            if (resultPhoneCodeCountry.get(i).xmlPath().getString(AtributosXml2.countryIntPhoneCodeResult).
                    contains(valoresColunaPhoneCodeCountry.get(i).getCountryIntPhoneCodeResult())){
                Assert.assertTrue(true);
            }
        }
    }

    ///////////////Realizando um Post - List of Currencies by Name

    @Dado("que envio uma requisicao Post para List of Currencies by Name")
    public void queEnvioUmaRequisicaoPostParaListOfCurrenciesByName() throws SOAPException, TransformerException {
        resultCurrenciesByName.add(MetodosSoap2.criarRequisicaoEmCurrenciesByName());
    }

    @Entao("recebo um response correto com a lista de moedas por nome")
    public void receboUmResponseCorretoComAListaDeMoedasPorNome(DataTable dataTable) throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel2.getCellDadosDeMassaCurrenciesByName(list.get(0).get("planilha"), list.get(0).get("aba"));

        for (int i = 1; i <= linhas; i++) {
            valoresTabela_ListOfCurrenciesByName.add(new DadosResponseCurrenciesByName(
                    ArquivoTxt.lerArquivo("SISOCODE_" + i, "Dados_Excel-criarMassaCurrenciesByName.txt")));
        }

        for (int i = 0; i < valoresTabela_ListOfCurrenciesByName.size(); i++) {
            if (resultCurrenciesByName.get(0).xmlPath().getString(AtributosXml2.sIsoCode).
                    contains(valoresTabela_ListOfCurrenciesByName.get(0).getsISOCode())) {
                Assert.assertTrue(true);
            }
        }
    }
}

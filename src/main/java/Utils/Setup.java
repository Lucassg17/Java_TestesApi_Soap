package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Setup {
    private String caminho;
    private String nameSpacePrefix;
    private String nameSpaceURI;
    private String urlNumberConversion;
    private String nameSpaceURICalculator;
    private String urlCaculator;
    private String urlCountryInfoService;
    private String nameSpaceURICountryInfo;
    private String urlIsbnService;
    private String nameSpaceURIIsbn;
    private String urlTemp;
    private String nameSpaceURITemp;
    private Properties prop;

    public String getUrlTemp() {
        return urlTemp;
    }

    public String getNameSpaceURITemp() {
        return nameSpaceURITemp;
    }

    public String getNameSpaceURIIsbn() {
        return nameSpaceURIIsbn;
    }
    public String getUrlIsbnService(){
        return urlIsbnService;
    }
    public String getNameSpaceURICountryInfo(){return nameSpaceURICountryInfo;}
    public String getUrlCountryInfoService(){
        return urlCountryInfoService;
    }
    public String getUrlCaculator(){
        return urlCaculator;
    }
    public String getNameSpaceURICalculator() {
        return nameSpaceURICalculator;
    }
    public String getCaminho() {
        return caminho;
    }
    public String getUrlNumberConversion(){
        return urlNumberConversion;
    }
    public String getNameSpacePrefix() {
        return nameSpacePrefix;
    }
    public String getNameSpaceURI() {
        return nameSpaceURI;
    }

    public Setup() {
        int i = 0;
        ArrayList<String> geral = new ArrayList<>(
                Arrays.asList(
                        "caminho",
                        "nameSpacePrefix",
                        "nameSpaceURI",
                        "nameSpaceURICalculator",
                        "urlNumberConversion",
                        "urlCaculator",
                        "urlCountryInfoService",
                        "nameSpaceURICountryInfo",
                        "urlIsbnService",
                        "nameSpaceURIIsbn",
                        "urlTemp",
                        "nameSpaceURITemp"

                ));
        prop = new Properties();
        try {
            prop.load(Files.newInputStream(Paths.get("src/test/resources/geral.properties")));
            caminho = prop.getProperty(geral.get(i++), "C:\\Users\\Lucas Gomes\\RestAssured\\MassaDados_TestesSoap");
            nameSpacePrefix = prop.getProperty(geral.get(i++), "web");
            nameSpaceURI = prop.getProperty(geral.get(i++), "http://www.dataaccess.com/webservicesserver/");
            nameSpaceURICalculator = prop.getProperty(geral.get(i++), "http://tempuri.org/");
            urlNumberConversion = prop.getProperty(geral.get(i++), "https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
            urlCaculator = prop.getProperty(geral.get(i++), "http://www.dneonline.com/calculator.asmx");
            urlCountryInfoService = prop.getProperty(geral.get(i++), "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
            nameSpaceURICountryInfo = prop.getProperty(geral.get(i++), "http://www.oorsprong.org/websamples.countryinfo");
            urlIsbnService = prop.getProperty(geral.get(i++), "http://webservices.daehosting.com/services/isbnservice.wso");
            nameSpaceURIIsbn = prop.getProperty(geral.get(i++), "http://webservices.daehosting.com/ISBN");
            urlTemp = prop.getProperty(geral.get(i++), "https://www.w3schools.com/xml/tempconvert.asmx");
            nameSpaceURITemp = prop.getProperty(geral.get(i++), "https://www.w3schools.com/xml/");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

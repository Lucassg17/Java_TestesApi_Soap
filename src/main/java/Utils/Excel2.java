package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.PrintWriter;

public class Excel2 {
    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;

    private enum massa {
        SNAME
    }

    private enum massaCapitalCountry {
        COUNTRY,
        CAPITALCITY
    }
    private enum massaCurrencyCountry {
        COUNTRYISOCODE,
        SNAME
    }

    private enum massaFlagCountry {
        COUNTRYISOCODE,
        FLAGCOUNTRY
    }

    private enum massaPhoneCodeCountry {
        COUNTRYISOCODE,
        PHONECODE
    }

    private enum massaCurrenciesByName{
        SISOCODE
    }

    private enum massaIsbn13 {
        ISBN,
        ISBN13RESULT
    }

    private enum massaIsbn10 {
        ISBN,
        ISBN10RESULT
    }

    private enum massaCelsiusToFahrenheit {
        CELSIUSTOFAHRENHEIT,
        RESULT
    }

    private enum massaFahrenheitToCelsius {
        FAHRENHEITTOCELSIUS,
        RESULT
    }

    public static int getCellDadosDeMassaCurrenciesByName(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaCurrenciesByName");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "SISOCODE", formatter.formatCellValue(row.getCell(massaCurrenciesByName.SISOCODE.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaListaDePaises(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaListCountries");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "SNAME", formatter.formatCellValue(row.getCell(massa.SNAME.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaLanguagesByName(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaLanguagesByName");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "SNAME", formatter.formatCellValue(row.getCell(massa.SNAME.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaCapitalCountry(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaCapitalCountry");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "COUNTRY", formatter.formatCellValue(row.getCell(massaCapitalCountry.COUNTRY.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "CAPITALCITY", formatter.formatCellValue(row.getCell(massaCapitalCountry.CAPITALCITY.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaCurrencyCountry(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaCurrencyCountry");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "COUNTRYISOCODE", formatter.formatCellValue(row.getCell(massaCurrencyCountry.COUNTRYISOCODE.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "SNAME", formatter.formatCellValue(row.getCell(massaCurrencyCountry.SNAME.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaFlagCountry(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaFlagCountry");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "COUNTRYISOCODE", formatter.formatCellValue(row.getCell(massaFlagCountry.COUNTRYISOCODE.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "FLAGCOUNTRY", formatter.formatCellValue(row.getCell(massaFlagCountry.FLAGCOUNTRY.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaInterPhoneCountry(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaMassaInterPhoneCountry");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "COUNTRYISOCODE", formatter.formatCellValue(row.getCell(massaPhoneCodeCountry.COUNTRYISOCODE.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "PHONECODE", formatter.formatCellValue(row.getCell(massaPhoneCodeCountry.PHONECODE.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaIsbn13(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaIsbn13");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "ISBN", formatter.formatCellValue(row.getCell(massaIsbn13.ISBN.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "ISBN13RESULT", formatter.formatCellValue(row.getCell(massaIsbn13.ISBN13RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaIsbn10(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaIsbn10");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "ISBN", formatter.formatCellValue(row.getCell(massaIsbn10.ISBN.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "ISBN10RESULT", formatter.formatCellValue(row.getCell(massaIsbn10.ISBN10RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaCelsiusToFahrenheit(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaCelsiusToFahrenheit");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "CELSIUSTOFAHRENHEIT", formatter.formatCellValue(row.getCell(massaCelsiusToFahrenheit.CELSIUSTOFAHRENHEIT.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "RESULT", formatter.formatCellValue(row.getCell(massaCelsiusToFahrenheit.RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaFahrenheitToCelsius(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaFahrenheitToCelsius");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "FAHRENHEITTOCELSIUS", formatter.formatCellValue(row.getCell(massaFahrenheitToCelsius.FAHRENHEITTOCELSIUS.ordinal())), arq);
            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "RESULT", formatter.formatCellValue(row.getCell(massaFahrenheitToCelsius.RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }
}

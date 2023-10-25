package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Excel {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;

    private enum massaWords {
        NUMBERS,
        WORDS
    }
    private enum massaDollars {
        NUMBERS,
        DOLLARS
    }

    private enum massaCalculator {
        IntA,
        IntB,
        RESULT
    }

    private enum massaListaContinentes {
        SNAME
    }

    public static int getCellDadosDeMassaNumberToWords(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaNumberToWords");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }
            ArquivoTxt.escreverTexto(Integer.toString(i), "NUMBERS", formatter.formatCellValue(row.getCell(massaWords.NUMBERS.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "WORDS", formatter.formatCellValue(row.getCell(massaWords.WORDS.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaNumberToDollars(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaNumberToDollars");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }
            ArquivoTxt.escreverTexto(Integer.toString(i), "NUMBERS", formatter.formatCellValue(row.getCell(massaDollars.NUMBERS.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "DOLLARS", formatter.formatCellValue(row.getCell(massaDollars.DOLLARS.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaDivisao(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaDivide");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }
            ArquivoTxt.escreverTexto(Integer.toString(i), "IntA", formatter.formatCellValue(row.getCell(massaCalculator.IntA.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "IntB", formatter.formatCellValue(row.getCell(massaCalculator.IntB.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "RESULT", formatter.formatCellValue(row.getCell(massaCalculator.RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaMultiplicacao(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaMultiply");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }
            ArquivoTxt.escreverTexto(Integer.toString(i), "IntA", formatter.formatCellValue(row.getCell(massaCalculator.IntA.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "IntB", formatter.formatCellValue(row.getCell(massaCalculator.IntB.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "RESULT", formatter.formatCellValue(row.getCell(massaCalculator.RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaSubtracao(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaSubtract");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }
            ArquivoTxt.escreverTexto(Integer.toString(i), "IntA", formatter.formatCellValue(row.getCell(massaCalculator.IntA.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "IntB", formatter.formatCellValue(row.getCell(massaCalculator.IntB.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "RESULT", formatter.formatCellValue(row.getCell(massaCalculator.RESULT.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellDadosDeMassaListaDeContinentes(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(Hooks.SETUP.getCaminho() + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(Hooks.SETUP.getCaminho(), "Dados_Excel-criarMassaListContinents");

        for(int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null) {
                wb.close();
                fi.close();
                return 0;
            }

            ArquivoTxt.escreverTextoPadraoDaTabela(Integer.toString(i), "SNAME", formatter.formatCellValue(row.getCell(massaListaContinentes.SNAME.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);

        wb.close();
        fi.close();

        return rowCount;
    }

}

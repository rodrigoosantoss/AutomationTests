package util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileManipulator {

    /**
     * This method returns the sum of a specific column on a xls file
     * and the number of the occorrences on thar column.<br><br>
     * To invoke this method you need to pass as parameter (String) the file name with extension
     * and the column number that contains the values to sum.
     * @param fileNameWithExtension String
     * @param columnNumber int
     * @return double total sum value
     */
    public static Map<String, Object> getTotalValueFromColumnXLSFile(String fileNameWithExtension, int columnNumber){

        try {
            if(!fileNameWithExtension.contains(".xls")){
                throw new RuntimeException("Arquivo de formato inválido para a invocação do método.");
            }

            FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads\\" + fileNameWithExtension));
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
            formatSymbols.setDecimalSeparator(',');
            formatSymbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.##", formatSymbols);


            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

            Cell cell = null;
            double valorTotal = 0;
            int numeroRegistros = sheet.getLastRowNum();

            for (Row row : sheet){
                cell = row.getCell(columnNumber);
                if(formulaEvaluator.evaluateInCell(cell).getCellType() == CellType.NUMERIC){
                    valorTotal += cell.getNumericCellValue();
                }
            }
            Map<String, Object> mappedObjects = new HashMap<>();
            mappedObjects.put("numeroRegistros", numeroRegistros);
            mappedObjects.put("valorTotalRegistros", decimalFormat.format(valorTotal));
            clearDownloadDirectory();
            return mappedObjects;

        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method checks if the "Download" folder has any content.
     * @return boolean
     */
    public static boolean isDownloadFolderNotEmpty(){

        File downloadFolder = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Downloads");

        for(File file : Objects.requireNonNull(downloadFolder.listFiles())){
            if (file.isDirectory()){
                isDownloadFolderNotEmpty();
            }

            if (file.isFile()){
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks the directory "Download" in a 'static way' inside the project, if it conaints any file with the
     * extesion file passed as parameter.
     * <br><br><strong>Warning: do not use "." (dot) before the extension as String.<strong/>
     * @param fileExtension  String
     * @return fileName+extension - String
     */
    public static String getDownloadFileName(String fileExtension){

        final File folder = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads");
        switch (fileExtension){
            case "pdf":
                if ( isDownloadFolderNotEmpty() ){
                    return search(".*\\.pdf", folder);
                }
                break;
            case "CSV":
                if ( isDownloadFolderNotEmpty() ){
                    return search(".*\\.csv", folder);
                }
                break;
            case "xls":
                if ( isDownloadFolderNotEmpty() ){
                    return search(".*\\.xls", folder);
                }
                break;
            default:
                System.err.println("Opção não mapeada, verifique a documentação do método.");
        }

        return null;
    }

    public static String search(final String pattern, final File folder) {
        for (final File f : Objects.requireNonNull(folder.listFiles())) {
            if (f.isDirectory()) {
                search(pattern, f);
            }
            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    return f.getName();
                }
            }
        }
        return null;
    }

    public static boolean isTextInPDF(String textToFind, String fileName){
        try (PDDocument document = PDDocument.load(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Downloads\\"+fileName))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String[] lines = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    if (line.contains(textToFind)){
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void clearDownloadDirectory() {
        try{
            File directory = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Downloads");
            File[] files = directory.listFiles();
            if (files == null){
                System.err.println("Pasta de Download não possui nenhum arquivo para limpar.");
            }
            for (File file : Objects.requireNonNull(files)) {
                if (!file.delete()) {
                    System.err.println("Falha ao limpar pasta de Download do Projeto.");
                }else{
                    System.out.println("Arquivo na pasta downloads removido com sucesso.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

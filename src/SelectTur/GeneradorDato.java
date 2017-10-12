package SelectTur;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class GeneradorDato {

    //todo arreglar paquete

    private static Random rand = new Random();

    public static double random() {
        return rand.nextDouble();
    }

    static int random(int n) {
        return rand.nextInt(n);
    }

    static void writeXLS(ArrayList<String[]> connectionLog, ArrayList<String[]> infoLog, String description) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm");
        Date date = new Date();

        String fileName = "Results_"+dateFormat.format(date)+"_" + description + ".xls";

        Workbook workbook = new HSSFWorkbook();
        Sheet connectionSheet = workbook.createSheet("Configuration");
        Sheet infoSheet = workbook.createSheet("Results");

        //for data of experiments
        for (int rowNum = 0; rowNum < connectionLog.size(); ++rowNum) {
            String[] data = connectionLog.get(rowNum);
            Row row = connectionSheet.createRow(rowNum);

            for (int cellNum = 0; cellNum < data.length; ++cellNum) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(data[cellNum]);
            }
        }

        //for info of experiments
        for (int rowNum = 0; rowNum < infoLog.size(); ++rowNum) {
            String[] info = infoLog.get(rowNum);
            Row row = infoSheet.createRow(rowNum);

            for (int cellNum = 0; cellNum < info.length; ++cellNum) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(info[cellNum]);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(fileName);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

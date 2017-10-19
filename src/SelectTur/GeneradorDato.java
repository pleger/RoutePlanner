package SelectTur;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
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

    static void writeXLS(Bitacora bitacora, HashMap<String,String> configuracion, String description) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm");
        Date date = new Date();

        String fileName = "Results_"+dateFormat.format(date)+"_" + description + ".xls";

        Workbook workbook = new HSSFWorkbook();
        String periodos = configuracion.get("Periodo");
        String numeroAgentes = configuracion.get("NumeroAgentes");

        Sheet configuracionSheet = workbook.createSheet("Configuration");
        Sheet resultSheet = workbook.createSheet("Results");

        Row row1 = configuracionSheet.createRow(0);
        row1.createCell(0).setCellValue("Periodo");
        row1.createCell(1).setCellValue(periodos);

        Row row2 = configuracionSheet.createRow(0);
        row2.createCell(0).setCellValue("Numero de Agentes");
        row2.createCell(1).setCellValue(numeroAgentes);


        //for info of experiments
        for (int rowNum = 0; rowNum < bitacora.size(); ++rowNum) {
            int touristaID = bitacora.obtenerTourista(rowNum);
            int dia = bitacora.obtenerDia(rowNum);
            double presupuesto = bitacora.obtenerPresupuesto(rowNum);
            double satisfaccion = bitacora.obtenerSatisfaccion(rowNum);
            Provincia provincia = bitacora.obtenerProvidencia(rowNum);
            boolean[] atractivos = bitacora.obtenerAtractivos(rowNum);

            Row rowResult = resultSheet.createRow(rowNum);
            rowResult.createCell(0).setCellValue(touristaID);
            rowResult.createCell(1).setCellValue(atractivos[0]);
            rowResult.createCell(2).setCellValue(atractivos[1]);
            rowResult.createCell(3).setCellValue(atractivos[2]);

            rowResult.createCell(4).setCellValue(dia);
            rowResult.createCell(5).setCellValue(presupuesto);
            rowResult.createCell(6).setCellValue(satisfaccion);
            rowResult.createCell(7).setCellValue(provincia.toString());
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

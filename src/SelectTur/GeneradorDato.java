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


class GeneradorDato {

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

        Row row2 = configuracionSheet.createRow(1);
        row2.createCell(0).setCellValue("Numero de Agentes");
        row2.createCell(1).setCellValue(numeroAgentes);

        Row rowResultHeader = resultSheet.createRow(0);
        rowResultHeader.createCell(0).setCellValue("ID TURISTA");
        rowResultHeader.createCell(1).setCellValue("Preferencia 1");
        rowResultHeader.createCell(2).setCellValue("Preferencia 2");
        rowResultHeader.createCell(3).setCellValue("Preferencia 3");
        rowResultHeader.createCell(4).setCellValue("Periodo");
        rowResultHeader.createCell(5).setCellValue("Satisfaccion");
        rowResultHeader.createCell(5).setCellValue("Presupuesto");
        rowResultHeader.createCell(6).setCellValue("Provincia");
        rowResultHeader.createCell(7).setCellValue("Activo");

        //for info of experiments
        for (int rowNum = 0; rowNum < bitacora.size(); ++rowNum) {
            int touristaID = bitacora.obtenerTourista(rowNum);
            int dia = bitacora.obtenerDia(rowNum);

            double presupuesto = bitacora.obtenerPresupuesto(rowNum);
            double satisfaccion = bitacora.obtenerSatisfaccion(rowNum);
            int provincia = bitacora.obtenerProvincia(rowNum);
            boolean[] preferencias = bitacora.obtenerAtractivos(rowNum);
            boolean activo = bitacora.obtenerActivo(rowNum);

            Row rowResult = resultSheet.createRow(rowNum + 1);
            rowResult.createCell(0).setCellValue(touristaID);
            rowResult.createCell(1).setCellValue(preferencias[0]);
            rowResult.createCell(2).setCellValue(preferencias[1]);
            rowResult.createCell(3).setCellValue(preferencias[2]);

            rowResult.createCell(4).setCellValue(dia);
            rowResult.createCell(5).setCellValue(presupuesto);
            rowResult.createCell(6).setCellValue(satisfaccion);
            rowResult.createCell(7).setCellValue(ProvinciaFactory.getNombre(provincia));
            rowResult.createCell(8).setCellValue(activo);
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

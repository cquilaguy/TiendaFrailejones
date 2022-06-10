package tiendafrailejones.utils;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alan
 */
public class ExportToExcel {

 
    public static void export(DefaultTableModel defaultTableModel) {
        FileOutputStream excelFos = null;
        XSSFWorkbook excelJTableExport = null;
        BufferedOutputStream excelBos = null;
        try {
            JFileChooser excelFileChooser = null;
            if (DetectOS.IS_WINDOWS) {
                excelFileChooser = new JFileChooser("C:\\");
            }else if (DetectOS.IS_UNIX) {
                excelFileChooser = new JFileChooser("/home/");
            }

            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
            excelFileChooser.setFileFilter(fnef);
            int chooser = excelFileChooser.showSaveDialog(null);

            if (chooser == JFileChooser.APPROVE_OPTION) {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Jtable Export");

                // Fill headers
                for (int i = 0; i < 1; i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        System.out.print(defaultTableModel.getColumnName(j) + "");
                        excelCell.setCellValue(defaultTableModel.getColumnName(j));
                    }
                }

                // Fill others files
                for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i + 1);
                    for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(defaultTableModel.getValueAt(i, j).toString());
                    }
                }
                excelFos = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBos = new BufferedOutputStream(excelFos);
                excelJTableExport.write(excelBos);
                JOptionPane.showMessageDialog(null, "Exported Successfully");
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                if (excelFos != null) {
                    excelFos.close();
                }
                if (excelBos != null) {
                    excelBos.close();
                }
                if (excelJTableExport != null) {
                    excelJTableExport.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}

package ma.sir.pmp.zynerator.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import ma.sir.pmp.zynerator.dto.BaseDto;
import ma.sir.pmp.zynerator.export.ColumnModel;
import ma.sir.pmp.zynerator.export.ExportModel;
import ma.sir.pmp.zynerator.export.ReportBuilder;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.security.util.FieldUtils;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExportUtil {

    private static final String DD_SLASH_MM_YYYY = "dd/MM/yyyy";
    private static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
    private static final String GET = "get";
    private static final String IS = "is";
    private static final String EMPTY = "";
    private static final String OUI = "OUI";
    private static final String NON = "NON";


    public static String exportedList(ExportModel exportModel, String path) throws Exception {
        String fileName = "";
        if (exportModel != null && exportModel.getList() != null) {

            if (exportModel.getFileType().equalsIgnoreCase("pdf")) {

                fileName = exportPdf(exportModel, path);
            } else if (exportModel.getFileType().equalsIgnoreCase("xls")) {
                fileName = exportXLS(exportModel, path);
            }
        }
        return fileName;
    }

    private static String exportPdf(ExportModel exportModel, String path) throws Exception {

        String fileName = getUniqueID() + ".pdf";

        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.init();

        PdfPTable table = reportBuilder.createTable(exportModel.getTitle(), exportModel.getColumnModels());
        Font fontRow = new Font(Font.FontFamily.UNDEFINED, 11, Font.NORMAL, BaseColor.BLACK);

        for (Object object : exportModel.getList()) {
            int i = 0;
            while (i < exportModel.getColumnModels().size()) {
                String column = exportModel.getColumnModels().get(i).getName();
                Object obj = FieldUtils.getFieldValue(object, formaColumnName(column));
                if (obj == null) {
                    String capitaliseFormaColumnName = capitaliseFormaColumnName(column);
                    if (RefelexivityUtil.methodExists(object.getClass(), GET + capitaliseFormaColumnName)) {
                        Method m = object.getClass().getMethod(GET + capitaliseFormaColumnName);
                        obj = m.invoke(object);
                    } else if (RefelexivityUtil.methodExists(object.getClass(), IS + capitaliseFormaColumnName)) {
                        Method m = object.getClass().getMethod(IS + capitaliseFormaColumnName);
                        obj = m.invoke(object);
                    }
                }
                table.addCell(new Phrase(formatValueObject(obj, column, exportModel.getColumnModels().get(i).getFormat()), fontRow));
                i++;
            }
        }
        reportBuilder.getDocument().add(table);
        fileName = path + fileName;
        reportBuilder.generateReport(reportBuilder.getStream(), fileName);

        return fileName;
    }

    private static String exportXLS(ExportModel exportModel, String path) throws Exception {

        String fileName = getUniqueID() + ".xls";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        CellStyle style = createCellStyle(wb, "Arial", HorizontalAlignment.CENTER, (short) 13, true);

        CellStyle style3 = createCellStyle(wb, "Arial", HorizontalAlignment.CENTER, (short) 10, true);

        CellStyle columnStyle = createColumnCellStyle(wb, "Arial", HorizontalAlignment.CENTER, (short) 12, true);

        CellStyle style2 = createCellStyle(wb, "Arial", HorizontalAlignment.LEFT, (short) 12, false);

        int idx = 1;

        HSSFRow row = sheet.createRow(idx);
        HSSFCell cell = row.createCell(3);
        cell.setCellStyle(style);
        idx++;
        cell.setCellValue(exportModel.getTitle());

        row = sheet.createRow(idx);
        cell = row.createCell(0);
        cell.setCellStyle(style3);
        idx++;
        cell.setCellValue("Exporté le : " + DateUtil.dateTimeToString(LocalDateTime.now()));

        int idy = 0;
        idx = 4;
        row = sheet.createRow(idx);
        for (ColumnModel columnModel : exportModel.getColumnModels()) {
            sheet.setColumnWidth(idy, 25 * 256);
            cell = row.createCell(idy);
            cell.setCellValue(columnModel.getLabel());
            cell.setCellStyle(columnStyle);
            idy++;
        }
        idx++;

        for (Object object : exportModel.getList()) {
            int i = 0;
            idy = 0;
            row = sheet.createRow(idx);
            while (i < exportModel.getColumnModels().size()) {
                String column = exportModel.getColumnModels().get(i).getName();
                Object obj = FieldUtils.getFieldValue(object, formaColumnName(column));
                if (obj == null) {
                    if (RefelexivityUtil.methodExists(object.getClass(), "get" + capitaliseFormaColumnName(column))) {
                        Method m = object.getClass().getMethod("get" + capitaliseFormaColumnName(column));
                        obj = m.invoke(object);
                    } else if (RefelexivityUtil.methodExists(object.getClass(), "is" + capitaliseFormaColumnName(column))) {
                        Method m = object.getClass().getMethod("is" + capitaliseFormaColumnName(column));
                        obj = m.invoke(object);
                    }
                }
                cell = row.createCell(idy);
                String value = formatValueObject(obj, column, exportModel.getColumnModels().get(i).getFormat());
                cell.setCellValue(value);
                cell.setCellStyle(style2);
                i++;
                idy++;
            }
            idx++;
        }

        fileName = path + fileName;
        FileOutputStream fileOut = new FileOutputStream(fileName);
        wb.write(fileOut);
        fileOut.close();

        return fileName;

    }

    private static String capitaliseFormaColumnName(String columnName) {
        return capitalize(formaColumnName(columnName));
    }

    private static String formaColumnName(String columnName) {
        String[] tab = columnName.split("\\.");
        if (tab != null && tab.length > 0)
            return tab[0];
        return columnName;
    }

    private static String formatValueObject(Object object, String columnName, String format) throws Exception {
        if (object != null) {
            if (object instanceof Boolean) {
                boolean b = Boolean.valueOf(object.toString());
                return b ? OUI : NON;
            } else if (object instanceof Enum) {
                Object obj = object.getClass().getMethod("getDisplayText").invoke(object);
                return String.valueOf(obj);
            } else {
                if (object instanceof BaseDto) {
                    Object obj = getMethodByColumn(object, columnName);
                    if (obj != null && (obj instanceof LocalDate || obj instanceof LocalDateTime) && StringUtil.isNotEmpty(format)) {
                        String value = EMPTY;
                        if (format.equalsIgnoreCase(DD_SLASH_MM_YYYY))
                            value = DateUtil.dateToString((LocalDate) obj);
                        else if (format.equalsIgnoreCase(DD_MM_YYYY_HH_MM))
                            value = DateUtil.dateTimeToString((LocalDateTime) obj);
                        return value != null ? value : EMPTY;
                    } else if (obj != null) {
                        return formatValueObject(obj, columnName, format);
                    }
                } else if ((object instanceof LocalDate || object instanceof LocalDateTime) && StringUtil.isNotEmpty(format)) {
                    String value = EMPTY;
                    if (format.equalsIgnoreCase(DD_SLASH_MM_YYYY))
                        value = DateUtil.dateToString((LocalDate) object);
                    else if (format.equalsIgnoreCase(DD_MM_YYYY_HH_MM))
                        value = DateUtil.dateTimeToString((LocalDateTime) object);
                    return value != null ? value : EMPTY;
                } else {
                    return StringUtil.isNotEmpty(String.valueOf(object)) ? String.valueOf(object) : EMPTY;
                }
            }
        }
        return EMPTY;
    }

    private static Object getMethodByColumn(Object object, String columnName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] tab = columnName.split("\\.");
        if (tab != null && tab.length > 3) {
            Object obj = object.getClass().getMethod("get" + capitalize(tab[1])).invoke(object);
            if (obj != null) {
                obj = obj.getClass().getMethod("get" + capitalize(tab[2])).invoke(obj);
                if (obj != null) {
                    obj = obj.getClass().getMethod("get" + capitalize(tab[3])).invoke(obj);
                    return obj;
                }
            }

        } else if (tab != null && tab.length > 2) {
            Object obj = object.getClass().getMethod("get" + capitalize(tab[1])).invoke(object);
            if (obj != null) {
                obj = obj.getClass().getMethod("get" + capitalize(tab[2])).invoke(obj);
                return obj;
            }

        } else if (tab != null && tab.length > 1) {
            Object obj = object.getClass().getMethod("get" + capitalize(tab[1])).invoke(object);
            return obj;
        }
        return null;
    }

    private static String capitalize(String s_) {
        if (s_ != null && !s_.equals(""))
            return s_.substring(0, 1).toUpperCase() + s_.substring(1);
        return "";
    }

    private static CellStyle createCellStyle(HSSFWorkbook wb, String fontName, HorizontalAlignment alignment, short size, boolean bold) {
        CellStyle style = wb.createCellStyle();
        style.setAlignment(alignment);
        HSSFFont font = wb.createFont();
        font.setBold(bold);
        font.setFontHeightInPoints(size);
        font.setFontName(fontName);
        style.setFont(font);
        return style;
    }

    private static CellStyle createColumnCellStyle(HSSFWorkbook wb, String fontName, HorizontalAlignment alignment, short size, boolean bold) {
        CellStyle style = wb.createCellStyle();
        style.setAlignment(alignment);
        HSSFFont font = wb.createFont();
        font.setBold(bold);
        font.setFontHeightInPoints(size);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName(fontName);
        style.setFont(font);
        style.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    private static synchronized long getUniqueID() {
        return System.currentTimeMillis();
    }
}

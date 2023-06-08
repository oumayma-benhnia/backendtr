package ma.sir.pmp.zynerator.export;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ReportBuilder {

    private boolean headerOnlyFirstPage;
    private int pageNumberAlignment = Element.ALIGN_CENTER;
    private boolean pagination = true;
    private String headerImage;
    private boolean displayCreatedDate = true;
    private PdfPTable table;
    private Document document;
    private PdfWriter writer;
    private ByteArrayOutputStream stream;

    public ReportBuilder() {
        try {
            //headerImage = FileUtils.getInstance().getImageFromResourcePath("logo.gif");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {

        try {
            stream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4.rotate());

            writer = PdfWriter.getInstance(document, stream);

            document.open();

            PdfConfig pdfConfig = new PdfConfig();
            pdfConfig.setPagination(pagination);
            pdfConfig.setHeaderOnlyFirstPage(headerOnlyFirstPage);
            pdfConfig.setHeaderImage(headerImage);
            pdfConfig.onOpenDocument(writer, document);
            pdfConfig.onEndPage(writer, document);
            pdfConfig.onCloseDocument(writer, document);

            writer.setPageEvent(pdfConfig);
            if (displayCreatedDate)
                pdfConfig.addExportDate(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PdfPTable createTable(String title, List<ColumnModel> columns) throws DocumentException {

        if (columns != null && !columns.isEmpty()) {

            if (title != null && !title.isEmpty()) {
                Font fontTitle = new Font(FontFamily.UNDEFINED, 12, Font.BOLD, BaseColor.BLACK);
                Paragraph titleParagraph = new Paragraph(new Phrase(title, fontTitle));
                titleParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(titleParagraph);
                document.add(new Paragraph(" "));
            }
            PdfPTable table = new PdfPTable(columns.size());
            table.setWidthPercentage(100);
            PdfPCell cell;
            Font fontColumn = new Font(FontFamily.UNDEFINED, 11, Font.BOLD, BaseColor.WHITE);

            for (ColumnModel column : columns) {
                cell = new PdfPCell(new Phrase(column.getLabel(), fontColumn));
                cell.setPaddingBottom(5);
                cell.setBackgroundColor(BaseColor.GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);
            }

            return table;
        }

        return null;

    }

    public void generateReport(ByteArrayOutputStream stream, String fileName) {
        try {
            if (document != null)
                document.close();
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(stream.toByteArray());
            fos.close();
            stream.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public boolean isHeaderOnlyFirstPage() {
        return headerOnlyFirstPage;
    }

    public void setHeaderOnlyFirstPage(boolean headerOnlyFirstPage) {
        this.headerOnlyFirstPage = headerOnlyFirstPage;
    }

    public int getPageNumberAlignment() {
        return pageNumberAlignment;
    }

    public void setPageNumberAlignment(int pageNumberAlignment) {
        this.pageNumberAlignment = pageNumberAlignment;
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public boolean isDisplayCreatedDate() {
        return displayCreatedDate;
    }

    public void setDisplayCreatedDate(boolean displayCreatedDate) {
        this.displayCreatedDate = displayCreatedDate;
    }

    public PdfPTable getTable() {
        return table;
    }

    public void setTable(PdfPTable table) {
        this.table = table;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ByteArrayOutputStream getStream() {
        return stream;
    }

}
package ma.sir.pmp.zynerator.export;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.*;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.zynerator.util.Utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;

public class PdfConfig extends PdfPageEventHelper {

    private PdfTemplate total;
    private BaseFont baseFont;
    private float footerTextSize;
    private boolean headerOnlyFirstPage;
    private int pageNumberAlignment = Element.ALIGN_CENTER;
    private int totalPages;
    private boolean pagination;
    private String headerImage;

    public PdfConfig() {
        baseFont = load("fonts", "arial.ttf");
        footerTextSize = 10f;
        totalPages = 0;
    }

    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        total.reset();
        total.beginText();
        total.setFontAndSize(baseFont, footerTextSize);
        total.setTextMatrix(0, 0);
        total.showText(String.valueOf(writer.getPageNumber() - 1));
        total.endText();
        totalPages = writer.getPageNumber() - 1;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            if (pagination) {
                // Add pages number
                PdfContentByte cb = writer.getDirectContent();
                cb.saveState();
                String text = String.format("%s / ", writer.getPageNumber());

                float textBase = document.bottom() - 20;
                float textSize = baseFont.getWidthPoint(text, footerTextSize);

                cb.beginText();
                cb.setFontAndSize(baseFont, footerTextSize);
                if (Element.ALIGN_CENTER == pageNumberAlignment) {
                    cb.setTextMatrix((document.right() / 2), textBase);
                    cb.showText(text);
                    cb.endText();
                    cb.addTemplate(total, (document.right() / 2) + textSize, textBase);
                } else if (Element.ALIGN_LEFT == pageNumberAlignment) {
                    cb.setTextMatrix(document.left(), textBase);
                    cb.showText(text);
                    cb.endText();
                    cb.addTemplate(total, document.left() + textSize, textBase);
                } else {
                    float adjust = baseFont.getWidthPoint("0", footerTextSize);
                    cb.setTextMatrix(document.right() - textSize - adjust, textBase);
                    cb.showText(text);
                    cb.endText();
                    cb.addTemplate(total, document.right() - adjust, textBase);
                }
                cb.restoreState();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(100, 100);
        total.setBoundingBox(new Rectangle(-20, -20, 100, 100));
        try {
            addHeaderImage(writer, document);
            document.add(new Paragraph(" "));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        super.onStartPage(writer, document);
        totalPages++;
        try {
            if (!headerOnlyFirstPage) {
                addHeaderImage(writer, document);
                document.add(new Paragraph(" "));
            }
            document.add(new Paragraph(" "));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addHeaderImage(PdfWriter writer, Document document) throws Exception {
        if (headerImage != null && !headerImage.isEmpty()) {
            Image image1 = Image.getInstance(headerImage);

            image1.scalePercent(60);

            PdfPTable header = new PdfPTable(1);

            header.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
            header.setLockedWidth(true);
            header.setWidthPercentage(100);
            header.getDefaultCell().setBorder(Rectangle.NO_BORDER);

            PdfPCell logocell = new PdfPCell(image1, false);
            logocell.setFixedHeight(72);
            logocell.setBorder(Rectangle.NO_BORDER);
            header.addCell(logocell);
            header.writeSelectedRows(0, -1, document.left(), document.top() + 25, writer.getDirectContent());
        }
    }

    public void addExportDate(Document document) throws Exception {
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        PdfPTable footer = new PdfPTable(1);
        footer.setWidthPercentage(100);
        Font font = new Font(FontFamily.UNDEFINED, 7, Font.NORMAL, BaseColor.BLACK);
        PdfPCell cell = new PdfPCell(new Phrase("Exporté le : " + DateUtil.dateTimeToString(LocalDateTime.now()), font));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        footer.addCell(cell);
        document.add(footer);
    }

    private BaseFont load(String location, String fontname) {
        try {

            InputStream is = new FileInputStream(Utils.getResourceFromcClassPath(location + System.getProperty("file.separator") + fontname).getFile());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            while (true) {
                int size = is.read(buf);
                if (size < 0)
                    break;
                out.write(buf, 0, size);
            }
            is.close();
            buf = out.toByteArray();
            return BaseFont.createFont(fontname, BaseFont.CP1252, true, true, buf, null);
        } catch (Exception ex) {
            return null;
        }
    }

    public PdfTemplate getTotal() {
        return total;
    }

    public void setTotal(PdfTemplate total) {
        this.total = total;
    }

    public BaseFont getBaseFont() {
        return baseFont;
    }

    public void setBaseFont(BaseFont baseFont) {
        this.baseFont = baseFont;
    }

    public float getFooterTextSize() {
        return footerTextSize;
    }

    public void setFooterTextSize(float footerTextSize) {
        this.footerTextSize = footerTextSize;
    }

    public int getPageNumberAlignment() {
        return pageNumberAlignment;
    }

    public void setPageNumberAlignment(int pageNumberAlignment) {
        this.pageNumberAlignment = pageNumberAlignment;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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

    public boolean isHeaderOnlyFirstPage() {
        return headerOnlyFirstPage;
    }

    public void setHeaderOnlyFirstPage(boolean headerOnlyFirstPage) {
        this.headerOnlyFirstPage = headerOnlyFirstPage;
    }

}
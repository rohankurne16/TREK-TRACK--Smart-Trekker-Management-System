package com.Jdbcproject.DAO;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ExportDAO {

    public boolean export() throws ClassNotFoundException, SQLException, DocumentException, FileNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1", "root", "root");

        PreparedStatement ps = con.prepareStatement("select * from trekker");
        ResultSet rs = ps.executeQuery();

        String filePath = "D:\\FileHandling\\Trekdata.pdf";

        // Create PDF document
        Document document = new Document(PageSize.A4, 36, 36, 90, 50); // margins
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Header & Footer event
        writer.setPageEvent(new HeaderFooter());

        document.open();

        // Title styling
        Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD, new Color(255, 255, 255));
        PdfPTable titleTable = new PdfPTable(1);
        PdfPCell titleCell = new PdfPCell(new Phrase("🌄 Trekker Data Report", titleFont));
        titleCell.setBackgroundColor(new Color(0, 102, 204));
        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleCell.setPadding(15f);
        titleCell.setBorder(Rectangle.NO_BORDER);
        titleTable.addCell(titleCell);
        document.add(titleTable);

        document.add(new Paragraph("\n")); // spacing

        // Table setup
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        table.setWidths(new float[]{1.2f, 2.5f, 2.5f, 3.0f, 2.5f, 3.0f, 2.5f});

        // Header styling
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD, Color.WHITE);
        String[] headers = {"ID", "Name", "City", "Address", "Contact", "Email", "Password"};
        for (String h : headers) {
            PdfPCell headerCell = new PdfPCell(new Phrase(h, headerFont));
            headerCell.setBackgroundColor(new Color(0, 51, 102));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(8f);
            table.addCell(headerCell);
        }

        // Row font
        Font rowFont = new Font(Font.HELVETICA, 11, Font.NORMAL, Color.BLACK);
        boolean hasData = false;
        boolean alternate = false;

        // Table rows with alternate color
        while (rs.next()) {
            hasData = true;
            Color rowColor = alternate ? new Color(230, 240, 255) : Color.WHITE;
            alternate = !alternate;

            String[] rowData = {
                String.valueOf(rs.getInt("id")),
                rs.getString("name"),
                rs.getString("city"),
                rs.getString("address"),
                rs.getString("contact"),
                rs.getString("email"),
                rs.getString("pass")
            };

            for (String cellData : rowData) {
                PdfPCell cell = new PdfPCell(new Phrase(cellData, rowFont));
                cell.setBackgroundColor(rowColor);
                cell.setPadding(7f);
                table.addCell(cell);
            }
        }

        document.add(table);
        document.close();
        con.close();

        System.out.println("✅ Decorated Trekdata.pdf created successfully at: " + filePath);
        return hasData;
    }
}


// =======================
// Header and Footer Class
// =======================
class HeaderFooter extends PdfPageEventHelper {

    Font footerFont = new Font(Font.HELVETICA, 9, Font.ITALIC, Color.GRAY);

    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("Generated on: " + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()), footerFont);

        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,
                footer,
                document.leftMargin(),
                document.bottom() - 10, 0);

        Phrase page = new Phrase("Page " + writer.getPageNumber(), footerFont);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,
                page,
                document.getPageSize().getWidth() - document.rightMargin(),
                document.bottom() - 10, 0);
    }
}

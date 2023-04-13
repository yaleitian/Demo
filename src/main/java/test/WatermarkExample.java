package test;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WatermarkExample {
    public static void main(String[] args) throws Exception {
        // Open the Word document
        XWPFDocument doc = new XWPFDocument(new FileInputStream("input.docx"));

        // Get the document's body element
        XWPFParagraph body = doc.createParagraph();
        body.setAlignment(ParagraphAlignment.CENTER);

        // Create the watermark text
        XWPFRun watermark = body.createRun();
        watermark.setText("SAMPLE WATERMARK");
        watermark.setFontFamily("Arial");
        watermark.setFontSize(72);
        watermark.setColor("000000");
        watermark.setBold(true);

        // Set the watermark text to be rotated and semi-transparent
        CTShd ctshd = watermark.getCTR().addNewRPr().addNewShd();
        ctshd.setFill("FFFFFF");
        ctshd.setVal( STShd.CLEAR);
        //ctshd.setRot(45);
        //ctshd.setXpgW(5000);
        //ctshd.setYpgW(5000);
        //ctshd.setAlpha(100);

        // Save the modified document
        FileOutputStream out = new FileOutputStream("output.docx");
        doc.write(out);
        out.close();
    }
}


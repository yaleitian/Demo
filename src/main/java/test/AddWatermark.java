package test;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddWatermark {

    public static void main(String[] args) throws IOException {

        XWPFDocument document = new XWPFDocument();

        // 创建段落
        XWPFParagraph p = document.createParagraph();

        // 在段落中添加文本框
        XWPFRun r = p.createRun();
        r.setText("Watermark Text");

        // 设置文本框字体颜色
        r.setColor("C0C0C0"); // 灰色

        // 设置文本框字体大小
        r.setFontSize(100); // 大小为100磅

        // 设置文本框透明度
        r.setEmbossed(true);
        r.setTextPosition(10); // 设置文本框的位置

        // 将文档写入文件
        FileOutputStream out = new FileOutputStream("document.docx");
        document.write(out);
        out.close();
        document.close();
    }
}

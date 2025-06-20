package main;

import document.*;
import factory.*;

public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocFactory();
        DocumentFactory pdfFactory = new PdfDocFactory();
        DocumentFactory excelFactory = new ExcelDocFactory();

        Document d1 = wordFactory.createDocument();
        Document d2 = excelFactory.createDocument();
        Document d3 = pdfFactory.createDocument();

        Document [] documents = {d1, d2, d3};

        for(Document doc : documents) {
            doc.open();
            doc.print();
            doc.close();
        }
    }
}

package document;

public class PdfDocument implements Document{
    public void open() {
        System.out.println("PDF Document Opened");
    }
    public void print() {
        System.out.println("Printing PDF Document...");
    }
    public void close() {
        System.out.println("Closing PDF Document...");
    }
}

package document;

public class ExcelDocument implements Document{
    public void open() {
        System.out.println("Excel Document Opened");
    }
    public void print() {
        System.out.println("Printing Excel Document...");
    }
    public void close() {
        System.out.println("Closing Excel Document...");
    }
}

package document;

public class WordDocument implements Document{
    public void open() {
        System.out.println("Word Document Opened");
    }
    public void print() {
        System.out.println("Printing Word Document...");
    }
    public void close() {
        System.out.println("Closing Word Document...");
    }
}

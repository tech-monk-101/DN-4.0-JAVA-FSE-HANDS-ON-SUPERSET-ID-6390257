package factory;
import document.*;

public class ExcelDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

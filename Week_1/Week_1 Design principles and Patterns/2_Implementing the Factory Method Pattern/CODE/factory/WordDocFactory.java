package factory;
import document.*;

public class WordDocFactory extends DocumentFactory{
    public Document createDocument() {
        return new WordDocument();
    }
}

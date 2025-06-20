public class Product {
    private int productID; //UNIQUE
    private String productName;
    private String category;

    //CONSTRUCTOR
    public Product(int id, String name, String category) {
        this.productID = id;
        this.productName = name;
        this.category = category;
    }

    //GETTERS
    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    //PRINT METHOD
    @Override
    public String toString() {
        return String.format("Product[ID=%d, Name='%s', Category='%s']", productID, productName, category);
    }
}


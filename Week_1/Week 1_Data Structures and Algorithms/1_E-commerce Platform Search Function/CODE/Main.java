import java.util.*;

public class Main {

    //SUB CLASS CONTAINING METHODS FOR PRODUCT SEARCH
    private static class productSearch {
        //LINEAR SEARCH USING PRODUCT ID
        private static Product linearSearch(ArrayList<Product> p, int ID) {
            for(Product i : p) {
                if(i.getProductID() == ID) return i;
            }
            return null;
        }

        //BINARY SEARCH USING PRODUCT ID
        private static Product binarySearch(ArrayList<Product> p, int ID) {
            int b = 0, e = p.size() - 1;
            while(b <= e) {
                int mid = b + (e - b) / 2;
                if(p.get(mid).getProductID() < ID) b = mid + 1;
                else if(p.get(mid).getProductID() > ID) e = mid - 1;
                else return p.get(mid);
            }
            return null;
        }
    }

    // TESTING
    public static void main(String[] args) {

        //DEFINING SOME PRODUCTS
        Product p1 = new Product(3, "Keyboard", "Electronics");
        Product p2 = new Product(1, "Notebook", "Stationery");
        Product p3 = new Product(5, "Chair", "Furniture");
        Product p4 = new Product(2, "Pen", "Stationery");
        Product p5 = new Product(4, "Monitor", "Electronics");

        //CREATING A DATABASE WITH FIRST 3 PRODUCTS
        ArrayList<Product> list = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Database db = new Database(list);

        //INSERTING TWO PRODUCTS INTO DATABASE
        db.insertProduct(p4);
        db.insertProduct(p5);

        //DISPLAYING DATABASE
        db.printDatabase();

        int prodId = 4; //SEARCHING FOR PRODUCT WITH productID = 4

        //LINEAR SEARCH DEMO
        ArrayList<Product>arr_unsorted = db.getDb();
        Product target1 = productSearch.linearSearch(arr_unsorted, prodId); 
        System.out.println("\n ||LINEAR SEARCH||");   
        if(target1 != null)
            System.out.println(target1);
        else 
            System.out.println("Product Not Found");
        
        //BINARY SEARCH DEMO
        ArrayList<Product>arr_sorted = db.getSortedDb();
        Product target2 = productSearch.binarySearch(arr_sorted, prodId); 
        System.out.println("\n ||BINARY SEARCH||");   
        if(target2 != null) 
            System.out.println(target2);
        else 
            System.out.println("Product Not Found");
    }
}
 
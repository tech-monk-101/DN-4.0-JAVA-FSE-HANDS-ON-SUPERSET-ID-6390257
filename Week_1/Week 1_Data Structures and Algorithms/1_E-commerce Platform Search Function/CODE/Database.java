import java.util.*;

//CUSTOM COMPARATOR FOR PRODUCT OBJECT
class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product x, Product y) {
        return Integer.compare(x.getProductID(), y.getProductID());
    }
}

public class Database {
    private ArrayList<Product>store;
    private ArrayList<Product>sorted_store;

    //CREATING EMPTY DATABASE
    public Database() {
        store = new ArrayList<>();
        sorted_store = new ArrayList<>();
    }

    //CREATING DATABASE WITH LIST OF PRODUCTS
    public Database(ArrayList<Product>p) {
        store = new ArrayList<>(p);
        sorted_store = new ArrayList<>(p);
        Collections.sort(sorted_store, new ProductComparator());
    }

    //INSERTING A PRODUCT INTO DATABASE
    public void insertProduct(Product p) {
        store.add(p);
        int ind = 0;
        int n = sorted_store.size();
        while(ind < n) {
            if(sorted_store.get(ind).getProductID() < p.getProductID()) 
                ind++;
            else
                break;
        }
        sorted_store.add(ind, p);
    }

    //DELETING A PRODUCT FROM DATABASE (UNUSED)
    public void deleteProduct(int id) {
        // DELETING FROM UNSORTED
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getProductID() == id) {
                store.remove(i);
                break;
            }
        }

        // DELETING FROM SORTED
        for (int i = 0; i < sorted_store.size(); i++) {
            if (sorted_store.get(i).getProductID() == id) {
                sorted_store.remove(i);
                break;
            }
        }
    }


    //GETTING THE SORTED LIST OF PRODUCT
    public ArrayList<Product> getSortedDb() {
        return sorted_store;
    }

    //GETTING THE UNSORTED LIST OF PRODUCTS
    public ArrayList<Product> getDb() {
        return store;
    }

    //PRINTING DATABASE
    public void printDatabase() {
        System.out.println("-----------------------------------------------");
        System.out.println("|*| PRODUCT DATABASE |*|\n");
        System.out.println("||UNSORTED||");
        for (Product p : store) {
            System.out.println("  " + p);
        }

        System.out.println("\n||SORTED||");
        for (Product p : sorted_store) {
            System.out.println("  " + p);
        }
        System.out.println("-----------------------------------------------");
    }
}

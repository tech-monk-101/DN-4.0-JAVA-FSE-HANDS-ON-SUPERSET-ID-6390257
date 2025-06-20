public class Main {
    //TESTING SINGLETON LOGGER CLASS
    public static void main(String[] args) {
        System.out.println("SINGLETON PATTERN EXAMPLE");
        Logger l1 = Logger.getInstance(); //Reference l1
        Logger l2 = Logger.getInstance(); //Reference l2
        Logger.check(l1, l2); //Checks if both are same instance
    }
}

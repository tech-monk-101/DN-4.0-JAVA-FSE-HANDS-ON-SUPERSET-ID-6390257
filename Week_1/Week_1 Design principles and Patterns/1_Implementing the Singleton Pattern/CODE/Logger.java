public class Logger {
    //PRIVATE STATIC INSTANCE OF ITSELF (Declared final so that there can only be one)
    private static final Logger instance = new Logger();

    //PRIVATE CONSTRUCTOR TO CREATE INSTANCE (Private to ensure no external code can create another instance)
    private Logger() {
        System.out.println("Single Logger Instance Initialized");
    }

    //METHOD TO RETURN THE ONE AND ONLY CREATED FACTORY INSTANCE
    public static Logger getInstance() {
        return instance;
    }

    //CHECK IF THE REFERENCES POINT TO SAME INSTANCE (For Testing)
    public static void check(Logger a, Logger b) {
        if(a.equals(b)) 
            System.out.println("Both References are same Instances");
        else
            System.out.println("Both References are different Instances (SINGLETON PATTERN FAILED)");
    }
}

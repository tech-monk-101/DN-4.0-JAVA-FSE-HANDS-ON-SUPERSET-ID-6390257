public class MyClass {
    int ID;
    String status;
    public MyClass(int ID) {
        this.ID = ID;
        status = "Instantiated";
    }
    public String getStatus() {
        return status;
    }
    public int getID() {
        return ID;
    }
}

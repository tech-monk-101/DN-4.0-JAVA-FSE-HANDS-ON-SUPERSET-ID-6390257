public class MyService {
    private final ExternalApi API;

    public MyService(ExternalApi x) {
        this.API = x;
    }
    public void fetchData() {
        API.getData();
    }
}

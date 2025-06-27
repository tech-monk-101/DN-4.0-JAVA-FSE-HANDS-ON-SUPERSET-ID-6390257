public class MyService {
    private final ExternalApi API;
    public MyService(ExternalApi x) {
        API = x;
    }
    public String fetchData() {
        return API.getData();
    }
}

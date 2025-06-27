import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyClassTest {
    private MyClass object;
    @Before
    public void create() {
        object = new MyClass(5);
    }
    @After
    public void delete() {
        object = null;
    }
    @Test
    public void testObject() {
        String status = object.getStatus();
        int ID = object.getID();
        assertEquals("Instantiated", status);
        assertEquals(5, ID);
    }
}

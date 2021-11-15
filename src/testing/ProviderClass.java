package testing;

public class ProviderClass {

    @Before
    public static void beforeTest() {
        System.out.println("Before test");
    }

    @After
    public static void afterTest() {
        System.out.println("After test");
    }

    @Test
    public boolean isProviderClass() {
        return true;
    }

    @Test
    public boolean isArray() {
        return false;
    }

    @Test
    public boolean isInterface() {
        return false;
    }

    @Test
    public boolean isPrimitive() {
        return false;
    }

    public void print() {
        System.out.println(toString());
    }

}

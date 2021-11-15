package testing;

public class ProviderClass {

    @Before
    public static void beforeTests() {
        System.out.println("Before tests");
    }

    @After
    public static void afterTests() {
        System.out.println("After tests");
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

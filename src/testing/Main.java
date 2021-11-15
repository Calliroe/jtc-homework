package testing;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        RunTests.run(ProviderClass.class);
        System.out.println();
        RunTests.run(Package.getPackage("testing"));
    }
}

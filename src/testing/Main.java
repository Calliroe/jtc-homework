package testing;

public class Main {

    public static void main(String[] args) {
        RunTests.run(CalculatorTest.class);
        System.out.println();
        RunTests.run(ClassLoader.getSystemClassLoader().getDefinedPackage("testing"));
    }
}

package testing;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Before
    public void beforeTests() {
        System.out.println("Before tests");
    }

    @After
    public void afterTests() {
        System.out.println("After tests");
    }

    @Test
    public void sum_twoIntNumbers_shouldReturnTrueResult() {
        int result = Calculator.sum(20, 10);
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void subtraction_twoIntNumbers_shouldReturnTrueResult() {
        int result = Calculator.subtraction(20, 10);

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void multiplication_twoIntNumbers_shouldReturnTrueResult() {
        int result = Calculator.multiplication(20, 10);

        assertThat(result).isEqualTo(200);
    }

    @Test
    public void division_twoIntNumbers_shouldReturnTrueResult() {
        int result = Calculator.division(20, 10);

        assertThat(result).isEqualTo(2);
    }

}

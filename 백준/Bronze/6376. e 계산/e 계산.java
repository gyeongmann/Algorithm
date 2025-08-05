import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        System.out.println("n e");
        System.out.println("- -----------");

        BigDecimal e = BigDecimal.ZERO;
        for (int i = 0; i <= 9; i++) {
            e = e.add(BigDecimal.ONE.divide(factorial(i), 25, RoundingMode.HALF_UP));

            if (i < 2) {
                System.out.printf("%d %.0f%n", i, e);
            } else if (i == 2) {
                System.out.printf("%d %.1f%n", i, e);
            } else {
                System.out.printf("%d %.9f%n", i, e.setScale(9, RoundingMode.HALF_UP));
            }
        }
    }

    static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}

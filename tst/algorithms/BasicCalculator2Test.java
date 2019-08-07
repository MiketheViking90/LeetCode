package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasicCalculator2Test {

    BasicCalculator2 bc2 = new BasicCalculator2();

    @Test
    public void testCalculatePlusMinus() {
        String expr = "1-2+3-4+5-9";
        int val = bc2.calculatePlusMinus(expr);
        System.out.println(val);
    }
}
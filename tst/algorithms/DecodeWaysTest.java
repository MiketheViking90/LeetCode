package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DecodeWaysTest {

    DecodeWays dw = new DecodeWays();

    @Test
    public void testNumDecodings() {
        dw.numDecodings("12");
    }
}
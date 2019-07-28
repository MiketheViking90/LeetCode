package algorithms;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

public class EncodeAndDecodeStringsTest {

    EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();

    @Test
    public void testEncode() {
        List<String> strings = Lists.newArrayList("");
        String enc = codec.encode(strings);
        System.out.println(enc);
    }

    @Test
    public void testDecode() {
        String enc = codec.encode(Lists.newArrayList(""));
        List<String> dec = codec.decode(enc);
        System.out.println(dec);
    }

}
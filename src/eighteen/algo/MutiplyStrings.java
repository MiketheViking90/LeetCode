package eighteen.algo;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MutiplyStrings {

    public String multiplyStrings(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        int carry = 0;
        List<String> prods = new ArrayList<>();
        for (int i = aLen-1; i >= 0; i--) {
            int aDigit = a.charAt(i) - '0';
            String prod = "";
            for (int j = bLen - 1; j >= 0; j--) {
                int bDigit = b.charAt(j) - '0';
                int ab = aDigit * bDigit + carry;
                prod = (ab % 10) + prod;

                if (ab > 10) {
                    carry = (ab / 10);
                }
            }
            if (carry > 0) {
                prod = (carry + prod);
                carry = 0;
            }
            int pow = aLen-1-i;
            for (int k = 0; k < pow; k++) {
                prod += "0";
            }
            prods.add(prod);
        }

        for (String p : prods) {
            System.out.println(p);
        }

        int len = prods.get(prods.size()-1).length();
        for (int i = 0; i < len; i++) {

        }
        return "";
    }

    public static void main(String[] args) {
        MutiplyStrings ms = new MutiplyStrings();
        String p = ms.multiplyStrings("173", "49");
        System.out.println(p);

        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.of(2019, Month.MAY, 21, 12, 59, 59), ZoneId.of("America/Los_Angeles"));
        System.out.println(zdt);
    }
}

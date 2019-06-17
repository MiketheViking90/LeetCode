package algorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashingPractice {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String url = "www.facebook.com/siliwen/photos/128idfjhuiwhejfoiDJife2390j2ejf0";
        byte[] md5Hash = md.digest(url.getBytes());
        String b64Hash = Base64.getEncoder().encodeToString(md5Hash);
        System.out.println(b64Hash);
        System.out.println(b64Hash.length());
    }
}

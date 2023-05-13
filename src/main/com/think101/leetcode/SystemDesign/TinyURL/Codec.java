package main.com.think101.leetcode.SystemDesign.TinyURL;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    long id = 0L;
    Map<String, String> longToShortUrl = new HashMap<>();
    Map<String, String> shortToLongUrl = new HashMap<>();
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShortUrl.containsKey(longUrl)) return longToShortUrl.get(longUrl);

        id++;
        long t = id;
        StringBuilder sb = new StringBuilder();
        while(t > 0) {
            sb.append(charSet.charAt((int)(t % 62)));
            t = t / 62;
        }

        sb.reverse();
        String res = sb.toString();

        longToShortUrl.put(longUrl, res);
        shortToLongUrl.put(res, longUrl);

        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongUrl.get(shortUrl);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(codec.encode(url));
        System.out.println(codec.decode(codec.encode(url)));

        url = "https://leetcode.com/problems/design-tinyurl1";
        System.out.println(codec.encode(url));
        System.out.println(codec.decode(codec.encode(url)));

        url = "https://leetcode.com/problems/design-tinyurl2";
        System.out.println(codec.encode(url));
        System.out.println(codec.decode(codec.encode(url)));
    }
}

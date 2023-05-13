package main.com.think101.leetcode.SystemDesign.TinyURL;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Codec {
    private static final AtomicLong id = new AtomicLong(10000);
    private static final Map<String, String> longToShortUrl = new HashMap<>();
    private static final Map<String, String> shortToLongUrl = new HashMap<>();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String BASE_URL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShortUrl.containsKey(longUrl)) return longToShortUrl.get(longUrl);

        long t = id.incrementAndGet();
        StringBuilder sb = new StringBuilder();
        while(t > 0) {
            sb.append(ALPHABET.charAt((int)(t % 62)));
            t = t / 62;
        }

        sb.reverse();
        String res = sb.toString();

        longToShortUrl.put(longUrl, BASE_URL + res);
        shortToLongUrl.put(BASE_URL + res, longUrl);

        return BASE_URL + res;
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

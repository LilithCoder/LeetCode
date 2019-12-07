package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class sol_535 {
    // using hashCode and HashMap
    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encodedUrl = Integer.toString(longUrl.hashCode());
        map.put(encodedUrl, longUrl);
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

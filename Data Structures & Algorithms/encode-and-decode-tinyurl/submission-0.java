public class Solution {
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    private final Map<String, String> keyToUrlMap = new HashMap<>();
    private final Map<String, String> urlToKeyMap = new HashMap<>();
    private int id = 1;

    private String idToBase62(int id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(ALPHABET.charAt(id % 62));
            id /= 62;
        }
        return sb.reverse().toString();
    }

    public String encode(String longUrl) {
        if (urlToKeyMap.containsKey(longUrl)) {
            return BASE_URL + urlToKeyMap.get(longUrl);
        }

        String key = idToBase62(id++);
        keyToUrlMap.put(key, longUrl);
        urlToKeyMap.put(longUrl, key);
        
        return BASE_URL + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, "");
        return keyToUrlMap.get(key);
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {
    private Map<String, String> urlMap;
    private Random random;
    private static final int SHORT_URL_LENGTH = 6;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public URLShortener() {
        urlMap = new HashMap<>();
        random = new Random();
    }

    public String shortenURL(String longURL) {
        if (!isValidURL(longURL)) {
            throw new IllegalArgumentException("Invalid URL");
        }
        
        if (urlMap.containsValue(longURL)) {
            for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                if (entry.getValue().equals(longURL)) {
                    return entry.getKey();
                }
            }
        }

        String shortURL = generateShortURL();
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        String longURL = urlMap.get(shortURL);
        if (longURL == null) {
            throw new IllegalArgumentException("Short URL not found");
        }
        return longURL;
    }

    private boolean isValidURL(String url) {
        // Simple URL validation
        return url != null && url.length() > 0 && url.startsWith("http");
    }

    private String generateShortURL() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String longURL = "https://www.youtube.com";
        String shortURL = shortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);
        String expandedURL = shortener.expandURL(shortURL);
        System.out.println("Expanded URL: " + expandedURL);
    }
}

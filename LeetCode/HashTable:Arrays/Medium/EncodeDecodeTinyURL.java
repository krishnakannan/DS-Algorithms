public class Codec {

    Map<String, String> urlMap = new HashMap<>();
    public static Integer counter = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = "";
        try{
            int length = longUrl.length();
            int val = 0;
			for (int i = 0; i < length; i++) {
				val += (int)longUrl.charAt(i);
			}
			encoded = counter + "c" + val;
			counter++;
			urlMap.put(encoded, longUrl);
        } catch (Exception use) {
            
        }
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
package Configuration;

public class Configuration {

    private Configuration() {}


    public static String baseUrl() {
        String url = System.getProperty("BASE_URL", System.getenv("BASE_URL"));
        return (url == null || url.isBlank()) ? "http://localhost/opencart/" : ensureSlash(url);
    }

    public static String browser() {
        String b = System.getProperty("BROWSER", System.getenv("BROWSER"));
        return (b == null || b.isBlank()) ? "chrome" : b.toLowerCase();
    }


    public static boolean headless() {
        String h = System.getProperty("HEADLESS", System.getenv("HEADLESS"));
        return h != null && (h.equalsIgnoreCase("true") || h.equals("1"));
    }

    private static String ensureSlash(String url) {
        return url.endsWith("/") ? url : url + "/";
    }
}





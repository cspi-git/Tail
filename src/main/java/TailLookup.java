import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;

public class TailLookup extends Tail {
    private String basic = "https://hanaui-tails.vercel.app/api/1.0/information?ip=";
    private String whois = "https://hanaui-tails.vercel.app/api/1.0/whois?ip=";
    APIParser parser = new APIParser();

    @Override
    public void AddLog(String log) {
        super.AddLog(log);
    }

    public String GET(String urlparam, String ip) throws Exception {
        // Code: https://www.baeldung.com/java-http-request
        URL url = new URL(urlparam);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        if (content.toString() == "") {
            return "Error: No information found for '" + ip + "'!";
        }

        return content.toString();
    }

    public String basic(String ip) throws Exception {
        String url = basic + ip;
        String data = GET(url, ip);
        return parser.basic(data);
    }

    public String whois(String ip) throws Exception {
        String url = whois + ip;
        String data = GET(url, ip);
        return parser.whois(data);
    }
}

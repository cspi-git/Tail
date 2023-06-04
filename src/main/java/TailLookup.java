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
//        System.out.println("GET function start");
        // Code: https://www.baeldung.com/java-http-request
        URL url = new URL(urlparam);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

//        System.out.println("get function reading buffer");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

//        System.out.println("instancing stringbuffer as content");
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

//        System.out.println("get function checking if ip is valid");
        if (content.toString().contains("Invalid IP.")) {
            return "Error: Invalid IP '" + ip + "'!";
        }

//        System.out.println("get function checking if content is empty");
        if (content.toString().equals("")) {
            return "Error: No information found for '" + ip + "'!";
        }

//        System.out.println("get function end");

//        System.out.println(content.toString());

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
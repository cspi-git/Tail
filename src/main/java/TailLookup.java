import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;

public class TailLookup extends Tail {
    private String basic = "https://hanaui-tails.vercel.app/api/1.0/information?ip=";

    @Override
    public void AddLog(String log) {
        super.AddLog(log);
    }

    public String basic(String ip) throws Exception {
        if (ip.equals("")) {
            return "Error: IP input box is empty!";
        }

        // Code: https://www.baeldung.com/java-http-request
        URL url = new URL(basic + ip);
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

        APIParser parser = new APIParser();
        return parser.basic(content.toString());
    }
}

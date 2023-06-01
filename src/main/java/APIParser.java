import org.json.JSONException;
import org.json.JSONObject;

public class APIParser extends Tail {
    private String info;

    public String basic(String json) {
        String info = "";
        JSONObject object = new JSONObject(json);
        JSONObject data = object.getJSONObject("data");

        String continent = data.getString("continent");
        String country = data.getString("country");
        String timezone = data.getString("timezone");
        String organisation = data.getString("organisation");
        String type = data.getString("type");
        String continentcode = data.getString("continentcode");
        String proxy = data.getString("proxy");
        String provider = data.getString("provider");
        String asn = data.getString("asn");

        info += "Continent: " + continent + "\n";
        info += "Country: " + country + "\n";
        info += "Timezone: " + timezone + "\n";
        info += "Organisation: " + organisation + "\n";
        info += "Type: " + type + "\n";
        info += "Continent Code: " + continentcode + "\n";
        info += "Proxy: " + proxy + "\n";
        info += "Provider: " + provider + "\n";
        info += "ASN: " + asn + "\n";

        return info;
    }
}

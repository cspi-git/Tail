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

    public String whois(String json) {
        String info = "";
        JSONObject object = new JSONObject(json);
        JSONObject data = object.getJSONObject("data");

        String netRange = data.getString("netRange");
        String cidr = data.getString("cidr");
        String netName = data.getString("netName");
        String netHandle = data.getString("netHandle");
        String parent = data.getString("parent");
        String netType = data.getString("netType");
        String originAs = data.getString("originAs");
        String organization = data.getString("organization");
        String regDate = data.getString("regDate");
        String updated = data.getString("updated");
        String ref = data.getString("ref");
        String orgName = data.getString("orgName");
        String orgId = data.getString("orgId");
        String address = data.getString("address");
        String city = data.getString("city");
        String stateProv = data.getString("stateProv");
        String postalCode = data.getString("postalCode");
        String country = data.getString("country");
        String orgTechHandle = data.getString("orgTechHandle");
        String orgTechName = data.getString("orgTechName");
        String orgTechPhone = data.getString("orgTechPhone");
        String orgTechEmail = data.getString("orgTechEmail");
        String orgTechRef = data.getString("orgTechRef");

        info += "Net Range: " + netRange + "\n";
        info += "CIDR: " + cidr + "\n";
        info += "Net Name: " + netName + "\n";
        info += "Net Handle: " + netHandle + "\n";
        info += "Parent: " + parent + "\n";
        info += "Net Type: " + netType + "\n";
        info += "Origin AS: " + originAs + "\n";
        info += "Organization: " + organization + "\n";
        info += "Registration Date: " + regDate + "\n";
        info += "Updated: " + updated + "\n";
        info += "Reference: " + ref + "\n";
        info += "Org Name: " + orgName + "\n";
        info += "Org ID: " + orgId + "\n";
        info += "Address: " + address + "\n";
        info += "City: " + city + "\n";
        info += "State/Province: " + stateProv + "\n";
        info += "Postal Code: " + postalCode + "\n";
        info += "Country: " + country + "\n";
        info += "Org Tech Handle: " + orgTechHandle + "\n";
        info += "Org Tech Name: " + orgTechName + "\n";
        info += "Org Tech Phone: " + orgTechPhone + "\n";
        info += "Org Tech Email: " + orgTechEmail + "\n";
        info += "Org Tech Reference: " + orgTechRef + "\n";

        return info;
    }
}

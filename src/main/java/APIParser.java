import org.json.JSONException;
import org.json.JSONObject;

public class APIParser extends Tail {
    private String info;

    public String basic(String json) {
//        System.out.println("basic api parser start");
        String info = "";
        JSONObject object = new JSONObject(json);
        JSONObject data = object.getJSONObject("data");

//        String continent = data.getString("continent");
//        String country = data.getString("country");
//        String timezone = data.getString("timezone");
//        String organisation = data.getString("organisation");
//        String type = data.getString("type");
//        String continentcode = data.getString("continentcode");
//        String proxy = data.getString("proxy");
//        String provider = data.getString("provider");
//        String asn = data.getString("asn");

        if (data.has("continent")) {
            info += "Continent: " + data.getString("continent") + "\n";
        }

        if (data.has("country")) {
            info += "Country: " + data.getString("country") + "\n";
        }

        if (data.has("timezone")) {
            info += "Timezone: " + data.getString("timezone") + "\n";
        }

        if (data.has("organisation")) {
            info += "Organisation: " + data.getString("organisation") + "\n";
        }

        if (data.has("type")) {
            info += "Type: " + data.getString("type") + "\n";
        }

        if (data.has("continentcode")) {
            info += "Continent Code: " + data.getString("continentcode") + "\n";
        }

        if (data.has("proxy")) {
            info += "Proxy: " + data.getString("proxy") + "\n";
        }

        if (data.has("provider")) {
            info += "Provider: " + data.getString("provider") + "\n";
        }

        if (data.has("asn")) {
            info += "ASN: " + data.getString("asn") + "\n";
        }

//        System.out.println("basic api parser end");
        return info;
    }

    public String whois(String json) {
        String info = "";
        JSONObject object = new JSONObject(json);
        JSONObject data = object.getJSONObject("data");

        if (data.has("inetnum")) {
            info += "Inetnum: " + data.getString("inetnum") + "\n";
        }

        if (data.has("netname")) {
            info += "Netname: " + data.getString("netname") + "\n";
        }

        if (data.has("descr")) {
            info += "Description: " + data.getString("descr") + "\n";
        }

        if (data.has("country")) {
            info += "Country: " + data.getString("country") + "\n";
        }

        if (data.has("org")) {
            info += "Organisation: " + data.getString("org") + "\n";
        }

        if (data.has("adminC")) {
            info += "AdminC: " + data.getString("adminC") + "\n";
        }

        if (data.has("techC")) {
            info += "TechC: " + data.getString("techC") + "\n";
        }

        if (data.has("abuseC")) {
            info += "AbuseC: " + data.getString("abuseC") + "\n";
        }

        if (data.has("status")) {
            info += "Status: " + data.getString("status") + "\n";
        }

        if (data.has("lastModified")) {
            info += "LastModified: " + data.getString("lastModified") + "\n";
        }

        if (data.has("source")) {
            info += "Source: " + data.getString("source") + "\n";
        }

        if (data.has("irt")) {
            info += "Irt: " + data.getString("irt") + "\n";
        }

        if (data.has("address")) {
            info += "Address: " + data.getString("address") + "\n";
        }

        if (data.has("eMail")) {
            info += "Email: " + data.getString("eMail") + "\n";
        }

        if (data.has("abuseMailbox")) {
            info += "AbuseMailbox: " + data.getString("abuseMailbox") + "\n";
        }

        if (data.has("auth")) {
            info += "Auth: " + data.getString("auth") + "\n";
        }

        if (data.has("organisation")) {
            info += "Organisation: " + data.getString("organisation") + "\n";
        }

        if (data.has("orgName")) {
            info += "OrgName: " + data.getString("orgName") + "\n";
        }

        if (data.has("phone")) {
            info += "Phone: " + data.getString("phone") + "\n";
        }

        if (data.has("faxNo")) {
            info += "FaxNo: " + data.getString("faxNo") + "\n";
        }

        if (data.has("mntRef")) {
            info += "MntRef: " + data.getString("mntRef") + "\n";
        }

        if (data.has("role")) {
            info += "Role: " + data.getString("role") + "\n";
        }

        if (data.has("nicHdl")) {
            info += "NicHdl: " + data.getString("nicHdl") + "\n";
        }

        if (data.has("route")) {
            info += "Route: " + data.getString("route") + "\n";
        }

        if (data.has("origin")) {
            info += "Origin: " + data.getString("origin") + "\n";
        }

        if (data.has("mntLower")) {
            info += "MntLower: " + data.getString("mntLower") + "\n";
        }

//        System.out.println("whois api parser end");

        return info;
    }
}
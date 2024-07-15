import okhttp3.*;
import org.json.JSONObject;

public class DataHubClient {
    private static final String DATAHUB_URL = "http://datahub-instance/api/v1";

    public static void pushToDataHub(String data) {
        OkHttpClient client = new OkHttpClient();

        JSONObject json = new JSONObject();
        json.put("data", data); // Replace with the appropriate data structure

        RequestBody body = RequestBody.create(json.toString(), MediaType.get("application/json"));
        Request request = new Request.Builder()
            .url(DATAHUB_URL + "/entities")
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

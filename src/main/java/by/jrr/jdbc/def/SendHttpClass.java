package by.jrr.jdbc.def;

import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import org.apache.http.Header;
import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SendHttpClass {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();


    //Apache HttpClient
    private void sendGet(String cityName) throws Exception {
        HttpGet request = new HttpGet("https://api.github.com/users/Enotik-code/subscriptions");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity =  response.getEntity();
            if (entity != null) {
                JSONArray myObject = new JSONArray(EntityUtils.toString(entity));
                System.out.println(myObject);
                JSONObject myRepos = myObject.getJSONObject(2);
                JSONObject arrayFromMyRepos = myRepos.getJSONObject("owner");
                System.out.println(arrayFromMyRepos);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SendHttpClass obj = new SendHttpClass();
        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet("Лунинец");
    }
}

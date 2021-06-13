package by.jrr.jdbc.def;

import lombok.SneakyThrows;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        String json = "[{\n" +
                "   \"name\":\"Ronaldo\",\n" +
                "   \"nickname\":\"Sam\",\n" +
                "   \"id\":312,\n" +
                "   \"age\":21,\n" +
                "   \"height\":163,\n" +
                "   \"lastOverScore\":[\n" +
                "      4,\n" +
                "      1,\n" +
                "      6,\n" +
                "      6,\n" +
                "      2,\n" +
                "      1\n" +
                "   ]\n" +
                "}, {}]";
        JSONArray myObject = new JSONArray(json);

        JSONObject myJSon = myObject.getJSONObject(1);
        System.out.println(myJSon);
        //JSONArray myJS = myJSon.getJSONArray("lastOverScore");
        //System.out.println(myJS);
        //System.out.println(myJS.get(3));
    }
}

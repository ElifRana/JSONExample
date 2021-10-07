import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class JSONWriteExample {
    public static void main(String[] args) throws IOException {
        try {

            URL url = JSONWriteExample.class.getResource("Json.json");   //resource Json.json dosyasının url sini alıyorum
            String path = url.getPath();   //url den  get.path ile dosya yolunu alıyorum.
            FileReader reader = new FileReader(path);

            JSONParser jsonParser = new JSONParser();

            JSONObject json = (JSONObject) jsonParser.parse(reader);
            JSONArray content = (JSONArray) json.get("content");


            for (int i = 0; i < content.size(); i++) {
                JSONObject contents = (JSONObject) (content.get(i));
                JSONObject id = (JSONObject) contents.get("id");

                System.out.println(id.get(("userId")));

                String username = (String) contents.get("username");
                JSONObject provider = (JSONObject) contents.get("provider");

                System.out.println(provider.get("name"));
            }

            JSONObject pageable = (JSONObject) json.get("pageable");
            JSONObject sort = (JSONObject) pageable.get("sort");
            Boolean empty = (Boolean) sort.get("empty");
            System.out.println(empty);
            //a


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

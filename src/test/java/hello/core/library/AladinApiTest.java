package hello.core.library;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.junit.jupiter.api.Test;
import org.jsoup.Jsoup;

import java.io.IOException;

public class AladinApiTest {

    @Test
    void aladin(){
        new AladinAPI();

    }

    static class BasicInfo{
        String key;
        String queryType;
        Long categoryId;

        BasicInfo(String key, String queryType, Long id){
            this.key = "ttbyebin2lee1424001";
            this.queryType = "ItemEditorChoice";
            this.categoryId = 2952L;
        }
    }
    static class AladinAPI {


        public AladinAPI() {
            execute();
        }

        public void execute() {
            try {
                String url = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbyebin2lee1424001&QueryType=ItemEditorChoice&searchTarget=Book&MaxResults=9&CategoryId=2952&output=JS&Year=2023&Month=1&Week=1&Version=20131101";
                Connection connection = Jsoup.connect(url);
                String response = connection.ignoreContentType(true).execute().body();
                JSONObject json = new JSONObject(response);

                JSONArray items = json.getJSONArray("item");
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    String title = item.getString("title");
                    String author = item.getString("author");
                    String link = item.getString("link");
                    System.out.println("\n\nTitle: " + title + "\nAuthor: " + author + "\nlink: " + link);
                }
            } catch (IOException | JSONException e) {
                System.out.println("An error occurred while making the request: " + e.getMessage());
            }
        }
    }
}

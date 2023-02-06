package hello.core.library;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class BiryongsoApiTest {
    @Test
    void biryong() {
        new BiryongScraper();
    }

    static class BiryongScraper {
        BiryongScraper() {
            execute();

        }

        void execute() {

            String url = "http://bir.co.kr/bookclub/bookclub-info/vbooks/";
            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            List<Element> elements = doc.getElementsByClass("tabs-hd");
            for (Element element : elements) {
                if (element.text().contains("4")) {
                    System.out.println("element = " + element);
                    element.attr("class", "tabs-hd button selected");
                    break;
                }
            }

            List<Element> elements2 = doc.getElementsByClass("product-title");
            for (Element element : elements2) {
                System.out.println("element = " + element);
            }
        }
    }
}
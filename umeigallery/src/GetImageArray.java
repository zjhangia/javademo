import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class GetImageArray {
    private String image_url;
    private String temp;
    private final String init_string;
    int size = 2;
    private ArrayList<String> arrayList = new ArrayList<String>();
    public GetImageArray(String image_url) {
        this.image_url = image_url;
        init_string = image_url.replace(".htm","");
    }

    public ArrayList<String> getURLArray() {
        try {
            Document document = Jsoup.connect(image_url).get();
            temp = document.getElementsByClass("ImageBody")
                    .select("img").attr("src").toString();
            //System.out.println(temp);
            arrayList.add(temp);
            while(temp != null){
                image_url = init_string + "_" + size + ".htm";
                document = Jsoup.connect(image_url).get();
                temp = document.getElementsByClass("ImageBody").select("img").attr("src").toString();
                //System.out.println(temp);
                arrayList.add(temp);
                size ++;
            }
        } catch(HttpStatusException ex){
            //System.out.println(arrayList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}

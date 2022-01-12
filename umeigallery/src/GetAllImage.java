import java.util.ArrayList;

public class GetAllImage {
    ArrayList<String> arrayList;
    private String image_url;
    private String folder_name;

    public GetAllImage(String image_url, String folder_name){
        this.image_url = image_url;
        this.folder_name = folder_name;
        arrayList = new GetImageArray(image_url).getURLArray();
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
            new DownloadImage(arrayList.get(i), folder_name);
        }
    }

}

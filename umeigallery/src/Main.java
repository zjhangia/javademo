
public class Main {
    public static void main(String[] args){
        String image_url = "https://www.umei.cc/meinvtupian/rentiyishu/242744.htm";

        new GetAllImage(image_url, new GetFolderName(image_url).getName());

    }
}

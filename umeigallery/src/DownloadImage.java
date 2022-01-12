import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {
    private Thread thread;
    private String image_url;
    private String folder_name;
    String ImageDownload_Folders;
    public DownloadImage(String image_url, String folder_name) {
        this.image_url = image_url.replace("http", "https");
        this.folder_name = folder_name;
        ImageDownload_Folders = new CreateFolder("ImageDownload", folder_name).getPath();
        thread = new DownloadImageFromInternet();
        thread.start();

    }
    class DownloadImageFromInternet extends Thread {
        public void run() {
            super.run();
            int byteread = 0;
            float bytesum = 0;
            try {
                try {
                    URL url = new URL(image_url);
                    URLConnection conn = (URLConnection) url.openConnection();
                    InputStream inputStream = conn.getInputStream();
                    //String ImageDownload_Folders = new CreateFolder("ImageDownload", folder_name).getPath();
                    //System.out.println(ImageDownload_Folders);
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new FileWriter(ImageDownload_Folders + "log")
                    );
                    String image_name = new GetImageName(image_url).setFileName();
                    String image_full_path = ImageDownload_Folders + image_name;

                    FileOutputStream fileOutputStream = new FileOutputStream(image_full_path);
                    byte[] buff = new byte[1 << 10];
                    while ((byteread = inputStream.read(buff)) != -1) {
                        System.out.println((bytesum += byteread) / 1024 / 1024);
                        bufferedWriter.append(bytesum / 1024 / 1024 + "\n");
                        fileOutputStream.write(buff, 0, byteread);
                    }
                    bufferedWriter.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

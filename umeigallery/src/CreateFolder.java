import java.io.File;

public class CreateFolder {
    private String path;
    private String folderName;
    public CreateFolder(String path, String folderName) {
        this.path = path;
        this.folderName = folderName;
        File folder = new File(getPath());
        if(!folder.exists()) {
            folder.mkdirs();
        }
    }
    public String getPath() {
        return System.getenv("HOME") + "/" + path + folderName + "/";
    }
}


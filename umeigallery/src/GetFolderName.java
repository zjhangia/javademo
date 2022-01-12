public class GetFolderName {
    private String folderName;
    public GetFolderName(String folderName) {
        this.folderName = folderName;
    }
    public String getName(){
        folderName = folderName.substring(folderName.lastIndexOf("/")).replace(".htm","");
        return folderName;
    }
}

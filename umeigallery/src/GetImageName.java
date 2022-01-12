public class GetImageName {
    private String name;
    public GetImageName(String name) {
        this.name = name;
    }
    public String setFileName() {
        String fileShortName;
        fileShortName = name.substring(name.lastIndexOf("/")).replaceAll("/", "");
        return new ShortString(fileShortName).getResult();
    }
}

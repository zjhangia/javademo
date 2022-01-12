public class ShortString {
    private static String string;

    public ShortString(String string) {
        this.string = string;
    }

    public String getResult() {
        String result = null;
        int length = string.length();
        if(length < 12){
            result = string;
        }else{
            result = string.substring(length-12, length);
        }
        return result;
    }
}

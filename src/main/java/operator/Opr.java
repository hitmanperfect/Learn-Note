package operator;

public class Opr {
    public static void main(String[] args) {
	  System.out.println(isHomeCrash(null));
    }
    private static boolean isHomeCrash(String message) {
	  return (!StringUitl.isEmpty(message) && (message.contains("com.gala.video.app.epg.home") || message.contains("com.gala.video.lib.share.uikit")) || message.contains("com.gala.video.lib.share.uikit2"));
    }
}

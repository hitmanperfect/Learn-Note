package jjava.uri;

import java.net.URI;

public class URITest {
    public static void main(String[] args) {
	  String s = "http://www.java2s.com:8080/yourpath/fileName/html?stove=10&path=32&id=4#harvic";
	  URI uri = URI.create(s);
	  System.out.println("scheme:" + uri.getScheme());
	  System.out.println("special-part:" + uri.getSchemeSpecificPart());
	  System.out.println("raw-special-part:" + uri.getRawSchemeSpecificPart());
	  System.out.println("authority:" + uri.getAuthority());
	  System.out.println("host:" + uri.getHost());
	  System.out.println("port:" + uri.getPort());
	  System.out.println("path:" + uri.getPath());
	  System.out.println("path:" + uri.getRawPath());
	  System.out.println("raw-path:" + uri.getRawPath());
	  System.out.println("fragment:" + uri.getFragment());
	  System.out.println("raw-fragment:" + uri.getRawFragment());
	  System.out.println("query:" + uri.getQuery());

    }
}

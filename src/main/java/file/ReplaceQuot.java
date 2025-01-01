package file;

import dex.B;

import java.io.*;

public class ReplaceQuot {
    public static void main(String[] args) {
	  try {
		File f = new File("/Users/lzq/log/plugin_center_sp/_plugins_config.xml");
		FileReader reader = new FileReader(f);
		BufferedReader br = new BufferedReader(reader);
		String s = br.readLine();
		FileOutputStream fos = new FileOutputStream(
			  new File("/Users/lzq/log/plugin_center_sp/xx.xml"));
		while (s != null) {
		    fos.write(s.replaceAll("&quot;","\"").getBytes());
		    s = br.readLine();
		}
	  fos.flush();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
    }
}

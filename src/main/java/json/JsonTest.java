package json;

import com.oracle.javafx.jmx.json.JSONFactory;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JsonTest {
    public static void main(String[] args) {
        try {
            String path = "./src/json/a.json";
            File ff = new File(".");
            System.out.println(ff.getAbsolutePath());
            JSONObject object = JSONObject.fromObject(getJsonFromFile(path));
            Boolean support = object.getBoolean("supportHotfix");
            int option = object.getInt("option");
            Object objOption = object.get("option");
            String lala = object.optString("lalal","");
            System.out.println(lala == null);
//            System.out.println(option);
//            System.out.println(objOption);
//            System.out.println(support);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static String getJsonFromFile(String path){
        StringBuilder builder = new StringBuilder();
        try {
            File f = new File(path);
            FileReader reader = new FileReader(f);
            BufferedReader r = new BufferedReader(reader);
            String str;
            while ((str = r.readLine()) != null){
                builder.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

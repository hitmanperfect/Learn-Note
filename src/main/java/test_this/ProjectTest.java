package test_this;

public class ProjectTest {
    public static void main(String[] args) {
        String str =
	  "18\t45868\n" +
		    "24\t11936\n" +
		    "19\t122053\n" +
		    "25\t85\n" +
		    "28\t269605\n" +
		    "29\t2\n" +
		    "15\t1265\n" +
		    "21\t595\n" +
		    "16\t7444\n" +
		    "22\t315875\n" +
		    "17\t102\n" +
		    "23\t2963223";
        String[] strs = str.split("\n");
        int sum=0;
	  for (String s:strs) {
	      sum += Integer.parseInt(s.split("\t")[1]);
	  }
	  System.out.println(strs.length);
	  System.out.println(sum);
	  String s = "00:55:66:00:00:01,7C:B3:7B:10:92:6C,64:AE:F1:66:FF:B2,A8:A6:48:C2:A6:A9,A8:A6:48:97:E3:45,10:48:B1:2C:28:D7,1C:66:6D:F9:52:FC,5C:36:B8:85:B2:29,10:77:17:06:cc:ff,fc:a3:86:80:5f:6e,60:42:7f:d4:21:7a,28:35:45:f0:6e:bb,60:42:7F:F1:96:CF,A4:E6:15:01:78:B4,08:d0:b7:96:33:f0,08:D0:B7:AA:78:7E,08:BA:5F:93:61:5C,a8:82:00:49:a1:4b,A8:82:00:60:50:C8,72:7F:15:1B:CA:EC,64:AE:F1:31:87:E9,64:AE:F1:60:7B:05,00:63:B7:5A:00:00,00:95:69:91:7F:9F,A8:A6:48:2B:EA:A2,44:39:C4:BA:FC:58,A8:A6:48:F3:C4:1F,E8:2A:44:3F:E1:BD,C8:16:BD:F9:22:3E,78:45:61:0F:CB:6A,8C:9F:3B:42:04:89,00:00:00:00:00:01,00:30:1B:BA:02:DB,D0:53:49:88:1E:F8,D4:9E:3B:6D:49:E8,08:BA:5F:B4:EE:3F,B8:3D:4E:3B:10:33,24:31:84:B0:A7:B7,C8:28:32:AD:77:20,8C:5A:F8:E5:CC:58,C8:28:32:FD:7F:27,A8:82:00:54:13:20,A8:82:00:60:50:CB,A8:A6:48:C1:F7:3C,00:63:18:00:68:14,80:56:F2:01:FA:60,8C:9F:3B:42:04:8D,00:00:00:00:00:10,10:4F:A8:66:6F:94,44:E4:EE:38:31:28,10:4F:A8:FB:D0:AA";
	  System.out.println(s.split(",").length);
    }
}

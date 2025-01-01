package string;

public class JewelsInStone {
    public static void main(String[] args) {
	  String jewel = "aA";
	  String stones = "aAAbbbb";
	  System.out.println(numJewelsInStones(jewel,stones));
//	  System.out.println('a');
//	  for(char c:jewel.toCharArray()){
//		System.out.println(c-'a');
//	  }
    }
    public static int numJewelsInStones(String J, String S) {
	  if(J == null || J.isEmpty() || S == null || S.isEmpty()){
		return 0;
	  }
	  byte[] arr = new byte[58];//'z' - 'A' = 57;122-65 = 57
	  for(char c:J.toCharArray()){
		arr[c-'A'] = 1;
	  }
	  int count = 0;
	  for(char c:S.toCharArray()){
		if(arr[c-'A'] == 1){
		    count++;
		}
	  }
	  return count;
    }
}

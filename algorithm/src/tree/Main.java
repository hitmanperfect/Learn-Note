package tree;

import tree.zlevelorder.ZLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	  String line;
	  while ((line = in.readLine()) != null) {
		TreeNode root = stringToTreeNode(line);

//		List<Integer> ret = new ZLevel().doTraversal(root);
		List<List<Integer>> ret = new ZLevel().doTraversal(root);
//		String out = integerArrayListToString(ret);

		System.out.print(ret);
	  }
    }
    public static TreeNode stringToTreeNode(String input) {
	  input = input.trim();
	  input = input.substring(1, input.length() - 1);
	  if (input.length() == 0) {
		return null;
	  }

	  String[] parts = input.split(",");
	  String item = parts[0];
	  TreeNode root = new TreeNode(Integer.parseInt(item));
	  Queue<TreeNode> nodeQueue = new LinkedList<>();
	  nodeQueue.add(root);

	  int index = 1;
	  while(!nodeQueue.isEmpty()) {
		TreeNode node = nodeQueue.remove();

		if (index == parts.length) {
		    break;
		}

		item = parts[index++];
		item = item.trim();
		if (!item.equals("null")) {
		    int leftNumber = Integer.parseInt(item);
		    node.left = new TreeNode(leftNumber);
		    nodeQueue.add(node.left);
		}

		if (index == parts.length) {
		    break;
		}

		item = parts[index++];
		item = item.trim();
		if (!item.equals("null")) {
		    int rightNumber = Integer.parseInt(item);
		    node.right = new TreeNode(rightNumber);
		    nodeQueue.add(node.right);
		}
	  }
	  return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
	  if (length == 0) {
		return "[]";
	  }

	  String result = "";
	  for(int index = 0; index < length; index++) {
		Integer number = nums.get(index);
		result += Integer.toString(number) + ", ";
	  }
	  return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
	  return integerArrayListToString(nums, nums.size());
    }


}

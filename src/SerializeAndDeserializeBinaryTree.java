import java.util.LinkedList;
import java.util.Queue;


public class SerializeAndDeserializeBinaryTree {
	public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            boolean flag = false;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node == null){
                    q.offer(null);
                    q.offer(null);
                    sb.append("#").append(" ");
                }else{
                    flag = true;
                    sb.append(node.val).append(" ");
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(!flag){
                break;
            }
        }
        if(sb.charAt(sb.length() - 1) == '*'){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
	public static TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] str = data.split("\\s+");
        Queue<String> q = new LinkedList<String>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        root.left = des(1, str);
        root.right = des(2, str);
        return root;
    }
    
    public static TreeNode des(int index, String[] str){
        if(index >= str.length){
            return  null;
        }
        String s = str[index];
        if(s.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[index]));
        root.left = des(index * 2 + 1, str);
        root.right = des(index * 2 + 2, str);
        return root;
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		String data = serialize(n1);
		TreeNode n = deserialize(data);
	}
}

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
	class Trie{
        Trie[] children = new Trie[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board.length == 0 || words.length == 0){
            return res;
        }
        Trie root = new Trie();
        for(String word : words){
            Trie node  = root;
            char[] ch = word.toCharArray();
            for(int i = 0; i < ch.length; i++){
                if(node.children[(int)(ch[i] - 'a')] == null){
                    node.children[(int)(ch[i] - 'a')] = new Trie();
                }
                node = node.children[(int)(ch[i] - 'a')];
            }
            node.word = word;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                Trie n = root;
                if(n.children[(int)(c - 'a')] != null){
                    search(board, i, j, n.children[(int)(c - 'a')], res);
                }
            }
        }
        return res;
    }
    public void search(char[][] board, int i, int j, Trie root, List<String> res){
        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char old = board[i][j];
        board[i][j] = '*';
        if(root.word != null){
        	res.add(root.word);
        	root.word = null;
        }
        for(int[] dis : distance){
            int x = i + dis[0];
            int y = j + dis[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '*'){
                char c = board[x][y];
                if(root.children[(int)(c - 'a')] != null){
                	search(board, x, y, root.children[(int)(c - 'a')], res);
                }
            }
        }
        board[i][j] = old;
    }
    public static void main(String[] args) {
//		String[] b = {"oaan","etae","ihkr","iflv"};
//		char[][] board = new char[4][4];
//		for(int i = 0; i < 4; i++){
//			board[i] = b[i].toCharArray();
//		}
//		String[] words = {"oath","pea","eat","rain"};
//    	char[][] board = {{'a'}};
//    	String[] words = {"a"};
    	char[][] board = {{'a', 'b'}, {'c', 'd'}};
    	String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
		WordSearch2 ws = new WordSearch2();
		List<String> list = ws.findWords(board, words);
	}
}

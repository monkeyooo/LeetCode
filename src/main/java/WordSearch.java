package src.main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordSearch {

    List<String> fullArrange;

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
    public boolean exist(char[][] board, String word) {
        fullArrange = new ArrayList<>();
        backtrack(board, "", word);
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
        System.out.println(fullArrange.toString());
        return fullArrange.contains(word);
    }

    private void backtrack(char[][] board, String arrangeWord, String word) {
        if (arrangeWord.length() == word.length()) {
            fullArrange.add(arrangeWord);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                arrangeWord += String.valueOf(board[i][j]);
                backtrack(board, arrangeWord, word);
                arrangeWord = arrangeWord.substring(0, arrangeWord.length());
            }
        }
    }
}

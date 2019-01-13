package com.daleychao.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @author Daniel
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        System.out.print(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'2', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

    private static boolean isValidSudoku(char[][] board) {
        Map<String, Map<String, String>> vertical = new HashMap<>(board.length);
        Map<String, Map<String, String>> tiny = new HashMap<>(board.length);
        for (int i = 0; i < board.length; i++) {

            Map<String, String> horizontal = new HashMap<>(board.length);
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0) {
                    vertical.put(String.valueOf(j), new HashMap<>(board.length));
                }

                int x = i / 3, y = j / 3;
                if (!tiny.containsKey(x + ":" + y)) {
                    tiny.put(x + ":" + y, new HashMap<>(board.length));
                }
                if (".".equals(String.valueOf(board[i][j]))) {
                } else if (horizontal.containsKey(String.valueOf(board[i][j])) || vertical.get(String.valueOf(j)).containsKey(String.valueOf(board[i][j])) ||
                        tiny.get(x + ":" + y).containsKey(String.valueOf(board[i][j]))) {
                    return false;
                } else {
                    horizontal.put(String.valueOf(board[i][j]), "");
                    vertical.get(String.valueOf(j)).put(String.valueOf(board[i][j]), "");
                    tiny.get(x + ":" + y).put(String.valueOf(board[i][j]), "");
                }

            }
        }
        return true;
    }

    private static boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                for (int k = 8; k > j; k--) {
                    if (board[i][j] == board[i][k]) {
                        return false;
                    }
                }
                for (int k = 8; k > i; k--) {
                    if (board[i][j] == board[k][j]) {
                        return false;
                    }
                }
                for (int k = i + 1; k % 3 != 0; k++) {
                    for (int h = j / 3 * 3; h < j / 3 * 3 + 3; h++) {
                        if (board[i][j] == board[k][h]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku3(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] cube = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'] == 1) {
                        return false;
                    } else {
                        row[board[i][j] - '1'] = 1;
                    }
                }

                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1'] == 1) {
                        return false;
                    } else {
                        col[board[j][i] - '1'] = 1;
                    }
                }
                // 每一宫内行列的变化
                int cubeX = 3 * (i / 3) + j / 3;
                int cubeY = 3 * (i % 3) + j % 3;
                if (board[cubeX][cubeY] != '.') {
                    if (cube[board[cubeX][cubeY] - '1'] == 1) {
                        return false;
                    } else {
                        cube[board[cubeX][cubeY] - '1'] = 1;
                    }
                }
            }
        }
        return true;
    }
}

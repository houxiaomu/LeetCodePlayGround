package houxiaomu.leetcodeplayground.sudoku_solver;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Simon on 2016/8/3.
 */
public class Solution extends BaseSolution {
    class SnapShot {
        final char[][] board;
        final int row;
        final int col;
        final HashSet<Character> candidates;

        SnapShot(char[][] board, int row, int col, HashSet<Character> remainCandidates) {
            this.row = row;
            this.col = col;
            this.board = new char[9][9];
            for (int i = 0; i < 9; i++) {
                this.board[i] = Arrays.copyOf(board[i], 9);
            }
            candidates = new HashSet<>();
            candidates.addAll(remainCandidates);
        }
    }

    public void solveSudoku(char[][] board) {
        final int len = 9;
        final HashSet<Character> candidate = new HashSet<>();
        Stack<SnapShot> snapShots = new Stack<>();
        HashSet<Character> tmpCandidate = null;
        int tmpRow = 0, tmpCol = 0;

        while (true) {
            boolean done = true;
            boolean changed = false;
            boolean wrong = false;
            for (int col = 0; col < len; col++) {
                for (int row = 0; row < len; row++) {
                    int c = board[row][col];
                    candidate.clear();
                    fillCandidates(board, candidate, row, col);
                    if (c != board[row][col]) {
                        changed = true;
                    }

                    if (candidate.size() > 1) {
                        done = false;
                        if (tmpCandidate == null || candidate.size() <= tmpCandidate.size()) {
                            if (tmpCandidate == null) tmpCandidate = new HashSet<>();
                            tmpCandidate.clear();
                            tmpCandidate.addAll(candidate);
                            tmpRow = row;
                            tmpCol = col;
                        }
                    } else if (board[row][col] == '.') {
                        System.out.println("wrong board");
                        wrong = true;
                        break;
                    }
                }
            }

            if (wrong) {
                //wrong assume, restore to previous snapshot
                while (true) {
                    System.out.println("restore snapshot total " + snapShots.size());
                    SnapShot snapShot = snapShots.pop();
                    if (snapShot == null) {
                        //WRONG!!!
                        System.out.println("wrong!!!!");
                        break;
                    }
                    if (snapShot.candidates.size() > 0) {
                        for (int i = 0; i < 9; i++) {
                            board[i] = Arrays.copyOf(snapShot.board[i], 9);
                        }
                        char c = (char) snapShot.candidates.iterator().next();
                        snapShot.candidates.remove(c);
                        board[snapShot.row][snapShot.col] = c;
                        if (snapShot.candidates.size() > 0) {
                            snapShots.push(snapShot);
                        }
                        dump(board);
                        break;
                    }
                }
            } else if (done) {
                break;
            } else if (!changed) {
                //no obvious result, need to assume a result for a candidate
                dump(board);
                if (tmpCandidate.size() > 0) {
                    char c = (char) tmpCandidate.iterator().next();
                    tmpCandidate.remove(c);
                    board[tmpRow][tmpCol] = c;
                    if (tmpCandidate.size() >= 1) {
                        SnapShot snapshot = new SnapShot(board, tmpRow, tmpCol, tmpCandidate);
                        snapShots.push(snapshot);
                        System.out.println("take snapshot [" + tmpRow + "][" + tmpCol + "] char='" + c + "' remainCandidates=" + candidateToStr(tmpCandidate));
                    }
                }
                tmpCandidate = null;
            }
        }
        dump(board);
    }

    void fillCandidates(char[][] board, HashSet<Character> candidate, int row, int col) {
        char c = board[row][col];
        if (c >= '1' && c <= '9') {
            return;
        }

        for (int i = 0; i < 9; i++) {
            candidate.add((char) ('1' + i));
        }

        for (int i = 0; i < 9; i++) {
            c = board[row][i];
            if (c >= '1' && c <= '9') {
                candidate.remove(c);
            }
        }

        for (int i = 0; i < 9; i++) {
            c = board[i][col];
            if (c >= '1' && c <= '9') {
                candidate.remove(c);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c = board[i + row / 3 * 3][j + col / 3 * 3];
                if (c >= '1' && c <= '9') {
                    candidate.remove(c);
                }
            }
        }

        if (candidate.size() == 1) {
            board[row][col] = (char) candidate.iterator().next();
        }
    }

    void dump(char[][] board) {
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }

    String candidateToStr(HashSet<Character> candidate) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = candidate.iterator();
        while (iterator.hasNext()) {
            sb.append("'").append(iterator.next()).append("' ");
        }
        return sb.toString();
    }
}

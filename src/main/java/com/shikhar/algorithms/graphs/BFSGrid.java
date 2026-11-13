package main.java.com.shikhar.algorithms.graphs;

/*
    Better known as the Dungeon Problem as well.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSGrid {
    private int R; 
    private int C;
    private char[][] matrix;
    private Queue<Integer> rq;
    private Queue<Integer> cq;
    private boolean[][] visited;
    private int nodesLeftInLayer;
    private int nodesInNextLayer;

    public BFSGrid(char[][] matrix) {
        R = matrix.length; 
        C = matrix[0].length;
        matrix = new char[R][C];
        rq = new ArrayDeque<>();
        cq = new ArrayDeque<>();
        visited = new boolean[R][C];
        nodesLeftInLayer = 1;
        nodesInNextLayer = 0;
    }

    public int bfs(int sr, int sc) {
        int moveCount = 0;
        boolean reachedEnd = false;

        rq.add(sr);
        cq.add(sc);
        visited[sr][sc] = true;

        while(rq.size() > 0) {
            int r = rq.remove();
            int c = cq.remove();

            if(matrix[r][c] == 'E') {
                reachedEnd = true;
                break;
            }
            exploreNeighbours(r, c);
            nodesLeftInLayer--;
            if(nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }

        if(reachedEnd) {
            return moveCount;
        }

        return -1;
    }

    private void exploreNeighbours(int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];

            if(rr < 0 || cc < 0) continue;
            if(rr >= R || cc >= C) continue;
            if(visited[rr][cc]) continue;
            if(matrix[rr][cc] == '#') continue;

            rq.add(rr);
            cq.add(cc);
            visited[rr][cc] = true;
            nodesInNextLayer++;
        }
    }
}

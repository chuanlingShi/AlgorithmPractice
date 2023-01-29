package BFSandheap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    //tc: O(klogk)
    //sc: O(mn + k)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int row = 0;
        int col = 0;
        minHeap.offer(new Cell(row, col, matrix[row][col]));
        visited[row][col] = true;
        for (int i = 0; i < k -1; i++) {
            Cell cur = minHeap.poll();
            //generate right
            row = cur.row + 1;
            col = cur.column;
            if (row < rows && !visited[row][col]) {
                minHeap.offer(new Cell(row, col, matrix[row][col]));
                visited[row][col] = true;
            }
            //generate down
            row = cur.row;
            col = cur.column + 1;
            if (col < columns && !visited[row][col]) {
                minHeap.offer(new Cell(row, col, matrix[row][col]));
                visited[row][col] = true;
            }
        }
        return minHeap.poll().value;
    }

    static class Cell{
        int row;
        int column;
        int value;

        public Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

}



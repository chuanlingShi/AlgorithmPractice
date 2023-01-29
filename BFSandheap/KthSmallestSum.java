package BFSandheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSum {
    public int kSmallest(int[] a, int[] b, int k) {
        int rows = a.length;
        int cols = b.length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.sum == o2.sum) {
                    return 0;
                }
                return o1.sum < o2.sum ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[rows][cols];
        int curRow = 0;
        int curCol = 0;
        minHeap.offer(new Cell(curRow, curCol, a[curRow] + b[curCol]));
        for (int i  = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            curRow = cur.a + 1;
            curCol = cur.b;
            if (curRow < rows && !visited[curRow][curCol]) {
                minHeap.offer(new Cell(curRow, curCol, a[curRow]+b[curCol]));
                visited[curRow][curCol] = true;
            }
            curRow = cur.a;
            curCol = cur.b + 1;
            if (curCol < cols && !visited[curRow][curCol]) {
                minHeap.offer(new Cell(curRow, curCol, a[curRow]+b[curCol]));
                visited[curRow][curCol] = true;
            }
        }
        return minHeap.poll().sum;
    }

    static class Cell{
        int a;
        int b;
        int sum;

        public Cell(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        KthSmallestSum kthSmallestSum = new KthSmallestSum();
        int[] a = new int[] {1, 3, 5};
        int[] b = new int[] {4, 8};
        System.out.println(kthSmallestSum.kSmallest(a, b, 5));
    }
}

package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        for (int i = size/2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(parent, index);
                index = parent;
            }else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        while (index <= size/2 - 1) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int candidate = leftChildIndex;
            if (rightChildIndex < size - 1 && array[rightChildIndex] < array[leftChildIndex]) {
                candidate = rightChildIndex;
            }
            if (array[index] > array[candidate]) {
                swap(index, candidate);
                index = candidate;
            }else {
                break;
            }
        }
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("heap is empty");
        return array[0];
    }

    public int poll() {
        if (isEmpty()) throw new NoSuchElementException("heap is empty");
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (isFull()) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[size++] = ele;
        percolateUp(size - 1);
    }

    public int update(int index, int ele) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        int result = array[index];
        array[index] = ele;
        if (ele < result) {
            percolateUp(index);
        }else {
            percolateDown(index);
        }
        return result;
    }

    private void swap(int l,int r) {
        int tmp = array[l];
        l = r;
        r = tmp;
    }




}
